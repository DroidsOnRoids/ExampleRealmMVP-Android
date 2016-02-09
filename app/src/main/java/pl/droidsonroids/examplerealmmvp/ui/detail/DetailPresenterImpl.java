package pl.droidsonroids.examplerealmmvp.ui.detail;

import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class DetailPresenterImpl implements DetailPresenter {

    private final RealmService mRealmService;
    private final int mBookId;
    private MyDetailView mMyDetailView = new MyDetailView.EmptyDetailView();

    public DetailPresenterImpl(final RealmService realmService, final int bookId) {
        mRealmService = realmService;
        mBookId = bookId;
    }

    @Override
    public void setView(final Object view) {
        mMyDetailView = (MyDetailView) view;
        mMyDetailView.showBookDetails(mRealmService.getBook(mBookId));
    }

    @Override
    public void clearView() {
        mMyDetailView = new MyDetailView.EmptyDetailView();
    }

    @Override
    public void closeRealm() {
        mRealmService.closeRealm();
    }

    @Override
    public void onPublisherClick() {
        mMyDetailView.showPublisherView(mBookId);
    }
}
