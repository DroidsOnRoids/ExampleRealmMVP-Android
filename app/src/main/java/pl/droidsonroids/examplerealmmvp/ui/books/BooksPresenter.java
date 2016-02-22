package pl.droidsonroids.examplerealmmvp.ui.books;

import pl.droidsonroids.examplerealmmvp.ui.BasePresenter;

public interface BooksPresenter extends BasePresenter<BooksView> {
    void onBookClick(int id);
    void onAddNewBookClick();
}
