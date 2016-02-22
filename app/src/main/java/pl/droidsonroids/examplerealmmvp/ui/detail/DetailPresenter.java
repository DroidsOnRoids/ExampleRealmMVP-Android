package pl.droidsonroids.examplerealmmvp.ui.detail;

import pl.droidsonroids.examplerealmmvp.ui.BasePresenter;

public interface DetailPresenter extends BasePresenter<DetailView> {
    void onPublisherClick(String publisher);
    void onAuthorClick(String author);
}
