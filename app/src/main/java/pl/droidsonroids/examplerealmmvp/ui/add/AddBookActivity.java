package pl.droidsonroids.examplerealmmvp.ui.add;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.inject.Inject;
import pl.droidsonroids.examplerealmmvp.BooksApplication;
import pl.droidsonroids.examplerealmmvp.R;
import pl.droidsonroids.examplerealmmvp.ui.BaseActivity;

public class AddBookActivity extends BaseActivity implements AddBookView {

    @Bind(R.id.layout_container) LinearLayout mLayoutContainer;
    @Bind(R.id.edit_title) EditText mEditTitle;
    @Bind(R.id.edit_author) EditText mEditAuthor;
    @Bind(R.id.edit_isbn) EditText mEditIsbn;
    @Bind(R.id.edit_publisher) EditText mEditPublisher;

    @Inject AddBookPresenter mAddBookPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        ButterKnife.bind(this);
    }

    @Override
    protected Object getModule() {
        return new AddBookModule();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAddBookPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAddBookPresenter.clearView();
    }

    @Override
    protected void closeRealm() {
        mAddBookPresenter.closeRealm();
    }

    @OnClick(R.id.button_add)
    public void onAddClick() {
        mAddBookPresenter.onAddClick(
                mEditTitle.getText().toString(),
                mEditAuthor.getText().toString(),
                mEditIsbn.getText().toString(),
                mEditPublisher.getText().toString());
    }

    @Override
    public void showAddBookError() {
        Snackbar.make(mLayoutContainer, R.string.add_new_book_error, Snackbar.LENGTH_SHORT).show();
    }
}
