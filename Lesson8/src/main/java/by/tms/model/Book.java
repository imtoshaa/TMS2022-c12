package by.tms.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private String nameBook;
    private String nameAuthor;

    public Book(String nameBook, String nameAuthor) {
        this.nameBook = nameBook;
        this.nameAuthor = nameAuthor;
    }

    public Book(String nameBook) {
        this.nameBook = nameBook;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameBook='" + nameBook + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(nameBook, book.nameBook) && Objects.equals(nameAuthor, book.nameAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameBook, nameAuthor);
    }
}
