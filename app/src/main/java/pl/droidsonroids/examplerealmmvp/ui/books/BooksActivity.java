package pl.droidsonroids.examplerealmmvp.ui.books;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;
import javax.inject.Inject;
import pl.droidsonroids.examplerealmmvp.R;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.ui.BaseActivity;
import pl.droidsonroids.examplerealmmvp.ui.adapter.BookListAdapter;
import pl.droidsonroids.examplerealmmvp.ui.add.AddBookActivity;
import pl.droidsonroids.examplerealmmvp.ui.detail.DetailActivity;

public class BooksActivity extends BaseActivity implements BooksView, BookListAdapter.OnBookClickListener {

    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    @Bind(R.id.toolbar) Toolbar mToolbar;

    @Inject BooksPresenter mBooksPresenter;

    private BookListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolbar();
        initList();
    }
    @Override
    protected Object getModule() {
        return new BooksModule();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void initList() {
        mAdapter = new BookListAdapter();
        mAdapter.setOnBookClickListener(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBooksPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBooksPresenter.clearView();
    }

    @Override
    protected void closeRealm() {
        mBooksPresenter.closeRealm();
    }

    @Override
    public void showBooks(final RealmResults<Book> books) {
        mAdapter.setBooks(books);
    }

    @Override
    public void onBookClick(final int id) {
        mBooksPresenter.onBookClick(id);
    }

    @OnClick(R.id.fab)
    public void onAddNewBookClick() {
        mBooksPresenter.onAddNewBookClick();
    }

    @Override
    public void showBookDetailView(final int id) {
        startActivity(DetailActivity.getStartIntent(this, id));
    }

    @Override
    public void showAddNewBookView() {
        startActivity(new Intent(this, AddBookActivity.class));
    }
}
