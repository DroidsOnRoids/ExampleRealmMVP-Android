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
import pl.droidsonroids.examplerealmmvp.MyApplication;
import pl.droidsonroids.examplerealmmvp.R;
import pl.droidsonroids.examplerealmmvp.model.Book;

public class DetailActivity extends AppCompatActivity implements MyDetailView{

    private static final String EXTRA_ID = "EXTRA_ID";

    @Bind(R.id.text_author) TextView mTextAuthor;
    @Bind(R.id.text_title) TextView mTextTitle;
    @Bind(R.id.text_publisher) TextView mTextPublisher;

    @Inject MyDetailPresenter mMyDetailPresenter;

    public static Intent getStartIntent(final Context context, final int isbn) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_ID, isbn);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_detail);
        ButterKnife.bind(this);
        MyApplication.injectModules(this, new MyDetailModule(getIntent().getExtras().getInt(EXTRA_ID)));
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
    public void showBookDetails(final Book book) {
        mTextAuthor.setText(String.format("%s %s", book.getAuthor().getName(), book.getAuthor().getLastname()));
        mTextTitle.setText(book.getTitle());
        mTextPublisher.setText(book.getPublishers().get(0).getName());
    }

    @Override
    public void showPublisherView(final int bookId) {

    }

    @OnClick(R.id.text_publisher)
    public void onPublisherClick() {
        mMyDetailPresenter.onPublisherClick();
    }
}
