package pl.droidsonroids.examplerealmmvp.ui.books;

import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class BooksPresenterImpl implements BooksPresenter {

    private final RealmService mRealmService;
    private BooksView mMyListView = new BooksView.EmptyMyListView();

    private boolean booksWereShown = false;

    public BooksPresenterImpl(final RealmService realmService) {
        mRealmService = realmService;
    }

    @Override
    public void setView(final Object view) {
        mMyListView = (BooksView) view;
        showBooksIfNeeded();
    }

    private void showBooksIfNeeded() {
        if(!booksWereShown) {
            mMyListView.showBooks(mRealmService.getAllBooks());
            booksWereShown = true;
        }
    }

    @Override
    public void clearView() {
        mMyListView = new BooksView.EmptyMyListView();
    }

    @Override
    public void closeRealm() {
        mRealmService.closeRealm();
    }

    @Override
    public void onBookClick(final int id) {
        mMyListView.showBookView(id);
    }
}
