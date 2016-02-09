package pl.droidsonroids.examplerealmmvp.ui.detail;

import pl.droidsonroids.examplerealmmvp.ui.Presenter;

public interface DetailPresenter extends Presenter {
    void onPublisherClick(String publisher);
    void onAuthorClick(String author);
}
