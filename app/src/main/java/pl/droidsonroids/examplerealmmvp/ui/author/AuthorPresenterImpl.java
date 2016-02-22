package pl.droidsonroids.examplerealmmvp.ui.author;

import io.realm.RealmList;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class AuthorPresenterImpl implements AuthorPresenter {

    private final RealmService mRealmService;
    private final String mAuthor;
    private AuthorView mAuthorView = new AuthorView.EmptyAuthorView();

    public AuthorPresenterImpl(final RealmService realmService, final String author) {
        mRealmService = realmService;
        mAuthor = author;
    }

    @Override
    public void setView(final AuthorView view) {
        mAuthorView = view;
        mAuthorView.showBooks(formatBooks(mRealmService.getAuthorBooks(mAuthor)));
    }

    private RealmList<Book> formatBooks(final RealmList<Book> publisherBooks) {
        return publisherBooks;
    }

    @Override
    public void clearView() {
        mAuthorView = new AuthorView.EmptyAuthorView();
    }

    @Override
    public void closeRealm() {
        mRealmService.closeRealm();
    }
}
