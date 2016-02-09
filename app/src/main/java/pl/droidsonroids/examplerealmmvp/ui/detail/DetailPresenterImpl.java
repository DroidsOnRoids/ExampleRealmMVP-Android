package pl.droidsonroids.examplerealmmvp.ui.detail;

import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class DetailPresenterImpl implements DetailPresenter {

    private final RealmService mRealmService;
    private final int mBookId;
    private DetailView mMyDetailView = new DetailView.EmptyDetailView();

    public DetailPresenterImpl(final RealmService realmService, final int bookId) {
        mRealmService = realmService;
        mBookId = bookId;
    }

    @Override
    public void setView(final Object view) {
        mMyDetailView = (DetailView) view;
        mMyDetailView.showBookDetails(mRealmService.getBook(mBookId));
    }

    @Override
    public void clearView() {
        mMyDetailView = new DetailView.EmptyDetailView();
    }

    @Override
    public void closeRealm() {
        mRealmService.closeRealm();
    }

    @Override
    public void onPublisherClick(final String publisher) {
        mMyDetailView.showPublisherView(publisher);
    }

    @Override
    public void onAuthorClick(final String author) {
        mMyDetailView.showAuthorView(author);
    }
}
