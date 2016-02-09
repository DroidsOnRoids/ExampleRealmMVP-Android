package pl.droidsonroids.examplerealmmvp.ui.publisher;

import io.realm.RealmList;
import pl.droidsonroids.examplerealmmvp.model.Book;

public interface PublisherView {

    void showBooks(RealmList<Book> books);

    class EmptyPublisherView implements PublisherView {

        @Override
        public void showBooks(final RealmList<Book> books) {

        }
    }
}
