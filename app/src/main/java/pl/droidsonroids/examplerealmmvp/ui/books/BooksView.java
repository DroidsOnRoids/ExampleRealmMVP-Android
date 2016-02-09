package pl.droidsonroids.examplerealmmvp.ui.books;

import io.realm.RealmResults;
import pl.droidsonroids.examplerealmmvp.model.Book;

public interface BooksView {

    void showBookView(int isbn);
    void showBooks(RealmResults<Book> books);

    class EmptyMyListView implements BooksView {

        @Override
        public void showBookView(final int isbn) {
            
        }

        @Override
        public void showBooks(final RealmResults<Book> books) {

        }
    }
}
