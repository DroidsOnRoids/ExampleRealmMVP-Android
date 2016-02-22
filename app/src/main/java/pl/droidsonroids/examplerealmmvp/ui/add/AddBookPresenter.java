package pl.droidsonroids.examplerealmmvp.ui.add;

import pl.droidsonroids.examplerealmmvp.ui.BasePresenter;

public interface AddBookPresenter extends BasePresenter<AddBookView> {
    void onAddClick(String title, String author, String isbn, final String publisher);
}
