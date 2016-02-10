package pl.droidsonroids.examplerealmmvp.ui.books;

import io.realm.RealmResults;
import pl.droidsonroids.examplerealmmvp.model.Book;

public interface BooksView {

    void showBooks(RealmResults<Book> books);
    void showBookDetailView(int id);
    void showAddNewBookView();

    class EmptyMyListView implements BooksView {

        @Override
        public void showBooks(final RealmResults<Book> books) {

        }

        @Override
        public void showBookDetailView(final int id) {
            
        }

        @Override
        public void showAddNewBookView() {

        }
    }
}
