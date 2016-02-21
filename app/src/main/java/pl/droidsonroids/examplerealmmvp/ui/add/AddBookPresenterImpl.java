package pl.droidsonroids.examplerealmmvp.ui.add;

import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

public class AddBookPresenterImpl implements AddBookPresenter, RealmService.OnTransactionCallback {

    private final RealmService mRealmService;
    private AddBookView mAddBookView = new AddBookView.EmptyAddBookView();

    public AddBookPresenterImpl(final RealmService realmService) {
        mRealmService = realmService;
    }

    @Override
    public void setView(final AddBookView view) {
        mAddBookView = view;
    }

    @Override
    public void clearView() {
        mAddBookView = new AddBookView.EmptyAddBookView();
    }

    @Override
    public void closeRealm() {
        mRealmService.closeRealm();
    }

    @Override
    public void onAddClick(final String title, final String author, final String isbn, final String publisher) {
        mRealmService.addBookAsync(title, author, isbn, publisher, this);
    }

    @Override
    public void onRealmSuccess() {
        mAddBookView.finish();
    }

    @Override
    public void onRealmError(final Exception e) {
        e.printStackTrace();
        mAddBookView.showAddBookError();
    }
}
