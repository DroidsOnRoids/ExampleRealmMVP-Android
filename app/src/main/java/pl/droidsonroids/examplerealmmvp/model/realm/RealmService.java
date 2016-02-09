package pl.droidsonroids.examplerealmmvp.model.realm;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import pl.droidsonroids.examplerealmmvp.model.Author;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.model.Publisher;

public class RealmService {

    private final Realm mRealm;

    public RealmService(final Realm realm) {
        mRealm = realm;
    }

    public void closeRealm() {
        mRealm.close();
    }

    public RealmResults<Book> getAllBooks() {
        return mRealm.allObjects(Book.class);
    }

    public Book getBook(final int bookId) {
        return mRealm.where(Book.class).equalTo("id", bookId).findFirst();
    }

    public RealmList<Book> getPublisherBooks(final String publisher) {
        Publisher foundPublisher = getPublisher(publisher, mRealm);
        return foundPublisher == null ? new RealmList<Book>() : foundPublisher.getBooks();
    }

    public RealmList<Book> getAuthorBooks(final String author) {
        Author foundAuthor = getAuthor(splitAuthorName(author), mRealm);
        return foundAuthor == null ? new RealmList<Book>() : foundAuthor.getBooks();
    }

    public void addBookAsync(final String title, final String author, final String isbn, final String publisher, final OnTransactionCallback onTransactionCallback) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(final Realm realm) {
                Book book = realm.createObject(Book.class);
                book.setId(realm.allObjects(Book.class).size());
                book.setTitle(title);
                book.setAuthor(createOrGetAuthor(author, book, realm));
                book.setPublisher(createOrGetPublisher(publisher, book, realm));
                book.setIsbn(isbn);
            }
        }, new Realm.Transaction.Callback() {

            @Override
            public void onSuccess() {
                if (onTransactionCallback != null) {
                    onTransactionCallback.onRealmSuccess();
                }
            }

            @Override
            public void onError(final Exception e) {
                if (onTransactionCallback != null) {
                    onTransactionCallback.onRealmError(e);
                }
            }
        });
    }

    private Author createOrGetAuthor(final String author, final Book book, final Realm realm) {
        String[] authorName = splitAuthorName(author);
        Author foundAuthor = getAuthor(authorName, realm);
        if(foundAuthor == null) {
            foundAuthor = addAuthor(authorName, realm);
        }
        foundAuthor.getBooks().add(book);
        return foundAuthor;
    }

    private Author addAuthor(final String[] authorName, final Realm realm) {
        Author author = realm.createObject(Author.class);
        author.setId(realm.allObjects(Author.class).size());
        author.setName(authorName[0]);
        author.setLastname(authorName[1]);
        return author;
    }

    private Publisher createOrGetPublisher(final String publisher, final Book book, final Realm realm) {
        Publisher foundPublisher = getPublisher(publisher, realm);
        if(foundPublisher == null) {
            foundPublisher = addPublisher(publisher, realm);
        }
        foundPublisher.getBooks().add(book);
        return foundPublisher;
    }

    private Publisher addPublisher(final String publisherName, final Realm realm) {
        Publisher publisher = realm.createObject(Publisher.class);
        publisher.setId(realm.allObjects(Publisher.class).size());
        publisher.setName(publisherName);
        return publisher;
    }

    private Author getAuthor(final String[] authorName, final Realm realm) {
        return realm.where(Author.class).equalTo("name", authorName[0]).equalTo("lastname", authorName[1]).findFirst();
    }

    private String[] splitAuthorName(final String author) {
        return author.split(" ");
    }

    private Publisher getPublisher(final String publisher, final Realm realm) {
        return realm.where(Publisher.class).equalTo("name", publisher).findFirst();
    }

    public interface OnTransactionCallback {
        void onRealmSuccess();
        void onRealmError(final Exception e);
    }
}
