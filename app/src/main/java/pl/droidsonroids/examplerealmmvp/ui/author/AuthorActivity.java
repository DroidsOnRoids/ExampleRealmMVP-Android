package pl.droidsonroids.examplerealmmvp.ui.author;

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
import pl.droidsonroids.examplerealmmvp.ui.BaseActivity;
import pl.droidsonroids.examplerealmmvp.ui.adapter.BookGridAdapter;

public class AuthorActivity extends BaseActivity implements AuthorView {

    private static final String EXTRA_AUTHOR = "EXTRA_AUTHOR";

    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    @Inject AuthorPresenter mAuthorPresenter;
    private BookGridAdapter mAdapter;

    public static Intent getStartIntent(final Context context, final String author) {
        Intent intent = new Intent(context, AuthorActivity.class);
        intent.putExtra(EXTRA_AUTHOR, author);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        ButterKnife.bind(this);

        initList();
    }

    @Override
    protected Object getModule() {
        return new AuthorModule(getIntent().getExtras().getString(EXTRA_AUTHOR));
    }

    private void initList() {
        mAdapter = new BookGridAdapter();
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuthorPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuthorPresenter.clearView();
    }

    @Override
    protected void closeRealm() {
        mAuthorPresenter.closeRealm();
    }

    @Override
    public void showBooks(final RealmList<Book> books) {
        mAdapter.setBooks(books);
    }
}
