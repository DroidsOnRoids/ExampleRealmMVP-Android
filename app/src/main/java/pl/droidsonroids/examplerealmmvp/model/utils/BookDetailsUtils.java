package pl.droidsonroids.examplerealmmvp.model.utils;

import pl.droidsonroids.examplerealmmvp.model.Book;

public class BookDetailsUtils {

    public static String getDetails(final Book book) {
        String details = "";
        details += getAuthorFullName(book);
        details += " | ";
        details += book.getPublisher().getName();
        return details;
    }

    public static String getAuthorFullName(final Book book) {
        return String.format("%s %s", book.getAuthor().getName(), book.getAuthor().getLastname());
    }
}
