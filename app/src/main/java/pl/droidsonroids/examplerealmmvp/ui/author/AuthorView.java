package pl.droidsonroids.examplerealmmvp.ui.author;

import io.realm.RealmList;
import pl.droidsonroids.examplerealmmvp.model.Book;

public interface AuthorView {

    void showBooks(RealmList<Book> books);

    class EmptyAuthorView implements AuthorView {

        @Override
        public void showBooks(final RealmList<Book> books) {

        }
    }
}
