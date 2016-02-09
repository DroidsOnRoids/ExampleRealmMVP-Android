package pl.droidsonroids.examplerealmmvp.ui.add;

public interface AddBookView {
    void finish();
    void showAddBookError();

    class EmptyAddBookView implements AddBookView {

        @Override
        public void finish() {

        }

        @Override
        public void showAddBookError() {

        }
    }
}
