package pl.droidsonroids.examplerealmmvp.ui.detail;

import pl.droidsonroids.examplerealmmvp.model.Book;

public interface DetailView {

    void showBookDetails(Book book);
    void showPublisherView(String publisher);
    void showAuthorView(String author);

    class EmptyDetailView implements DetailView {

        @Override
        public void showBookDetails(final Book book) {

        }

        @Override
        public void showPublisherView(final String publisher) {

        }

        @Override
        public void showAuthorView(final String author) {

        }
    }
}
