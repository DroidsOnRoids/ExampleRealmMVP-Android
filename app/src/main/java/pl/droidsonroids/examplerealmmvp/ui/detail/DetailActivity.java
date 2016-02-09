package pl.droidsonroids.examplerealmmvp.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.inject.Inject;
import pl.droidsonroids.examplerealmmvp.BooksApplication;
import pl.droidsonroids.examplerealmmvp.R;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.model.utils.BookDetailsUtils;
import pl.droidsonroids.examplerealmmvp.ui.BaseActivity;
import pl.droidsonroids.examplerealmmvp.ui.author.AuthorActivity;
import pl.droidsonroids.examplerealmmvp.ui.publisher.PublisherActivity;

public class DetailActivity extends BaseActivity implements DetailView {

    private static final String EXTRA_ID = "EXTRA_ID";

    @Bind(R.id.text_author) TextView mTextAuthor;
    @Bind(R.id.text_title) TextView mTextTitle;
    @Bind(R.id.text_publisher) TextView mTextPublisher;

    @Inject DetailPresenter mMyDetailPresenter;

    public static Intent getStartIntent(final Context context, final int isbn) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_ID, isbn);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected Object getModule() {
        return new DetailModule(getIntent().getExtras().getInt(EXTRA_ID));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMyDetailPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMyDetailPresenter.clearView();
    }

    @Override
    protected void closeRealm() {
        mMyDetailPresenter.closeRealm();
    }

    @Override
    public void showBookDetails(final Book book) {
        mTextAuthor.setText(BookDetailsUtils.getAuthorFullName(book));
        mTextTitle.setText(book.getTitle());
        mTextPublisher.setText(book.getPublisher().getName());
    }

    @Override
    public void showPublisherView(final String publisher) {
        startActivity(PublisherActivity.getStartIntent(this, publisher));
    }

    @Override
    public void showAuthorView(final String author) {
        startActivity(AuthorActivity.getStartIntent(this, author));
    }

    @OnClick(R.id.text_publisher)
    public void onPublisherClick() {
        mMyDetailPresenter.onPublisherClick(mTextPublisher.getText().toString());
    }

    @OnClick(R.id.text_author)
    public void onAuthorClick() {
        mMyDetailPresenter.onAuthorClick(mTextAuthor.getText().toString());
    }
}
