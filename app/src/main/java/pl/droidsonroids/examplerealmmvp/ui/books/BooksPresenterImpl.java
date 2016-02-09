package pl.droidsonroids.examplerealmmvp.ui.books;

import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class BooksPresenterImpl implements BooksPresenter {

    private final RealmService mRealmService;
    private ListView mMyListView = new ListView.EmptyMyListView();

    private boolean booksWereShown = false;

    public BooksPresenterImpl(final RealmService realmService) {
        mRealmService = realmService;
    }

    @Override
    public void setView(final Object view) {
        mMyListView = (ListView) view;
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
        mMyListView = new ListView.EmptyMyListView();
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
