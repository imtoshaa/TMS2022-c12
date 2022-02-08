package by.tms.model;

import lombok.Getter;

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
}
