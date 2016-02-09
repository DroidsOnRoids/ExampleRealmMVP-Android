package pl.droidsonroids.examplerealmmvp.ui.books;

import pl.droidsonroids.examplerealmmvp.ui.Presenter;

public interface BooksPresenter extends Presenter {
    void onBookClick(int id);
}
