package pl.droidsonroids.examplerealmmvp.ui;

public interface BasePresenter<T> {
    void setView(T view);
    void clearView();
    void closeRealm();
}
