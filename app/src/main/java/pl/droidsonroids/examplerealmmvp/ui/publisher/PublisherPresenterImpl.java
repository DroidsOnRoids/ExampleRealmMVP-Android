package pl.droidsonroids.examplerealmmvp.ui.publisher;

import io.realm.RealmList;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class PublisherPresenterImpl implements PublisherPresenter {

    private final RealmService mRealmService;
    private final String mPublisher;
    private PublisherView mPublisherView = new PublisherView.EmptyPublisherView();

    public PublisherPresenterImpl(final RealmService realmService, final String publisher) {
        mRealmService = realmService;
        mPublisher = publisher;
    }

    @Override
    public void setView(final PublisherView view) {
        mPublisherView = view;
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
