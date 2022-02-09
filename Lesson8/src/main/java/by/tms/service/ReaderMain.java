package by.tms.service;

import by.tms.model.Book;
import by.tms.model.Reader;
import by.tms.utils.Constants;

public class ReaderMain {
    public static void main(String[] args) {
        Reader reader = new Reader("Петров В.В.", 88323, "ХТиТ", "08.05.1999", 6668670);
        reader.mustBooks();
        reader.takeBook(3);
        reader.mustBooks();
        reader.returnBook(3);
        reader.mustBooks();
        reader.takeBook("Словарь", "Сопротивление материалов");
        reader.mustBooks();
        reader.returnBook("Словарь", "Сопротивление материалов");
        reader.mustBooks();
        reader.takeBook(new Book("Философия JAVA", "Брюс Эккель"), new Book("Грокаем алгоритмы", "Адитья Бхаргава"));
        reader.mustBooks();
        reader.returnBook(new Book("Философия JAVA", "Брюс Эккель"), new Book("Грокаем алгоритмы", "Адитья Бхаргава"));
        reader.mustBooks();
    }
}
