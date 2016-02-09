package pl.droidsonroids.examplerealmmvp.ui.add;

import pl.droidsonroids.examplerealmmvp.ui.Presenter;

public interface AddBookPresenter extends Presenter {
    void onAddClick(String title, String author, String isbn, final String publisher);
}
