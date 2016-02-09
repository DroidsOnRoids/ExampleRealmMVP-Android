package pl.droidsonroids.examplerealmmvp.ui.publisher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmList;
import javax.inject.Inject;
import pl.droidsonroids.examplerealmmvp.BooksApplication;
import pl.droidsonroids.examplerealmmvp.R;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.ui.adapter.BookGridAdapter;

public class PublisherActivity extends AppCompatActivity implements PublisherView {

    private static final String EXTRA_PUBLISHER = "EXTRA_PUBLISHER";

    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    @Inject PublisherPresenter mPublisherPresenter;
    private BookGridAdapter mAdapter;

    public static Intent getStartIntent(final Context context, final String publisher) {
        Intent intent = new Intent(context, PublisherActivity.class);
        intent.putExtra(EXTRA_PUBLISHER, publisher);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher);
        ButterKnife.bind(this);
        BooksApplication.injectModules(this, new PublisherModule(getIntent().getExtras().getString(EXTRA_PUBLISHER)));

        initList();
    }

    private void initList() {
        mAdapter = new BookGridAdapter();
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPublisherPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPublisherPresenter.clearView();
    }

    @Override
    protected void onDestroy() {
        mPublisherPresenter.closeRealm();
        super.onDestroy();
    }

    @Override
    public void showBooks(final RealmList<Book> books) {
        mAdapter.setBooks(books);
    }
}
