package pl.droidsonroids.examplerealmmvp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Book extends RealmObject {

    @PrimaryKey
    private int id;

    private String isbn;
    private String title;
    private Author author;
    private Publisher publisher;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(final Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(final Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDetails() {
        String details = "";
        details += getAuthorFullName();
        details += " | ";
        details += getPublisher().getName();
        return details;
    }

    public String getAuthorFullName() {
        return String.format("%s %s", getAuthor().getName(), getAuthor().getLastname());
    }
}
