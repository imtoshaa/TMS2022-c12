package com.tms.task6;


import com.tms.task6.model.Book;
import com.tms.task6.model.EmailAddress;
import com.tms.task6.model.Library;
import com.tms.task6.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Task6 {
    public static void main(String[] args) {
        List<Book> booksLibrary = new ArrayList<>();
        booksLibrary.add(new Book("Александр Сергеевич Пушкин", "Сказки", 1961));
        booksLibrary.add(new Book("Александр Сергеевич Пушкин", "Стихи", 1977));
        booksLibrary.add(new Book("Брюс Эккель", "Философия Java", 2008));
        booksLibrary.add(new Book("Джордж Мартин", "Песнь льда и пламени", 2018));
        booksLibrary.add(new Book("Полина Христорождественская", "Английский язык", 2012));
        booksLibrary.add(new Book("Николай Васильевич Гоголь", "Мёртвые души", 1988));
        booksLibrary.add(new Book("Лев Николаевич Толстой", "Война и мир", 1961));

        List<Reader> readers = new ArrayList<>();

        List<Book> vladimirsBooks = new ArrayList<>();
        vladimirsBooks.add(new Book("Джордж Мартин", "Песнь льда и пламени", 2018));
        vladimirsBooks.add(new Book("Александр Сергеевич Пушкин", "Сказки", 1961));
        readers.add(new Reader(
                "Владимир",
                new EmailAddress("vladimir@yandex.ru", "Я Владимир"),
                false,
                vladimirsBooks));

        List<Book> petrsBooks = new ArrayList<>();
        petrsBooks.add(new Book("Брюс Эккель", "Философия Java", 2008));
        petrsBooks.add(new Book("Полина Христорождественская", "Английский язык", 2012));
        petrsBooks.add(new Book("Александр Сергеевич Пушкин", "Стихи", 1977));
        readers.add(new Reader(
                "Пётр",
                new EmailAddress("petr@yandex.ru", "Я Пётр"),
                true,
                petrsBooks));

        List<Book> ivanBooks = new ArrayList<>();
        ivanBooks.add(new Book("Николай Васильевич Гоголь", "Мёртвые души", 1988));
        readers.add(new Reader(
                "Иван",
                new EmailAddress("ivan@yandex.ru", "Я Иван"),
                false,
                ivanBooks));

        Library library = new Library(booksLibrary, readers);

        System.out.println(library.checkBookOfPushkin()); //проверка на Пушкина
        System.out.println();
        library.getAllBooksSortedByYear().forEach(System.out::println); //сортировка по годам
        System.out.println();
        library.getMailingListForClosingLibrary().forEach(System.out::println); //лист рассылки при закрытии библиотеки
        System.out.println();
        library.getMailingListForNotification().forEach(System.out::println); //лист рассылки
        System.out.println();
        library.getAllBooksWhichReaderTook().forEach(System.out::println); //книги на руках у читателей с учётом того,
        // что у читателя на руках более двух книг
        System.out.println();
        Optional<Integer> count = library.getMaxNumberOfBook();
        if (count.isPresent()) {
            System.out.println("Максимальное количество книг на руках у читателей = " + count.get());
        } else {
            System.out.println("Not present!");
        }
        //макс количество книг на руках
        System.out.println();
        library.getTwoListOfReaders().forEach(System.out::println);

    }
}
