package pl.droidsonroids.examplerealmmvp.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Author extends RealmObject {

    @PrimaryKey
    private int id;

    private String name;
    private String lastname;
    private RealmList<Book> books;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public RealmList<Book> getBooks() {
        return books;
    }

    public void setBooks(final RealmList<Book> books) {
        this.books = books;
    }
}
