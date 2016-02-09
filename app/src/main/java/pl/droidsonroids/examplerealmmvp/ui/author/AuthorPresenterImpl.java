package pl.droidsonroids.examplerealmmvp.ui.author;

import io.realm.RealmList;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class AuthorPresenterImpl implements AuthorPresenter {

    private final RealmService mRealmService;
    private final String mPublisher;
    private PublisherView mPublisherView = new PublisherView.EmptyPublisherView();

    public AuthorPresenterImpl(final RealmService realmService, final String publisher) {
        mRealmService = realmService;
        mPublisher = publisher;
    }

    @Override
    public void setView(final Object view) {
        mPublisherView = (PublisherView) view;
        mPublisherView.showBooks(formatBooks(mRealmService.getPublisherBooks(mPublisher)));
    }

    private RealmList<Book> formatBooks(final RealmList<Book> publisherBooks) {
        return publisherBooks;
    }

    @Override
    public void clearView() {
        mPublisherView = new PublisherView.EmptyPublisherView();
    }

    @Override
    public void closeRealm() {
        mRealmService.closeRealm();
    }
}
