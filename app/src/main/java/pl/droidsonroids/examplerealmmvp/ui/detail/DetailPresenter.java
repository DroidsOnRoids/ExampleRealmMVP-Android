package pl.droidsonroids.examplerealmmvp.ui.detail;

import pl.droidsonroids.examplerealmmvp.ui.BasePresenter;

public interface DetailPresenter extends BasePresenter {
    void onPublisherClick(String publisher);
    void onAuthorClick(String author);
}
