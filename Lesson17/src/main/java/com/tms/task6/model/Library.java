package com.tms.task6.model;

import lombok.AllArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Library {
//    *  Задачи:
//            *  a) Получить список всех книг библиотеки, отсортированных по году издания.
//            *  b) Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
//            *      При этом флаг согласия на рассылку учитывать не будем: библиотека закрывается, так что хотим оповестить всех.
//            *  c) Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей, которые согласились на рассылку.
//     *      Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
//            *  d) Получить список всех книг, взятых читателями.
//     *      Список не должен содержать дубликатов (книг одного автора, с одинаковым названием и годом издания).
//            *  e) Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Пушкина Александра Сергеевича.

    private List<Book> books;
    private List<Reader> readers;

    public List<Book> getAllBooksSortedByYear() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getYear))
                .collect(Collectors.toList());
    }

    public List<EmailAddress> getMailingListForClosingLibrary() {
        return readers.stream()
                .map(Reader::getEmailAddress)
                .collect(Collectors.toList());
    }

    public List<EmailAddress> getMailingListForNotification() {
        return readers.stream()
                .filter(Reader::isAgreeToReceiveMessages)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmailAddress)
                .collect(Collectors.toList());
    }

    public Set<Book> getAllBooksWhichReaderTook() {
        Set<Book> bookSet = new HashSet<>();
        readers.stream()
                .map(Reader::getBooks)
                .forEach(bookSet::addAll);
        return bookSet;
    }


    public boolean checkBookOfPushkin() {
//        readers.stream()
//                .map(Reader::getBooks)
//                .forEach(books1 -> books1.stream()
//                        .map(Book::getAuthor)
//                        .forEach(s -> {
//                            if (s.equals("Александр Сергеевич Пушкин")) {
//                                isTrue.set(true);
//                            }
//                        }));
        return readers.stream()
                .flatMap(reader -> reader.getBooks().stream())
                //завернули книжки в стрии
                .anyMatch(book -> book.getAuthor().equals("Александр Сергеевич Пушкин"));
        //вернули boolean
    }

    public Optional<Integer> getMaxNumberOfBook() {
        return readers.stream()
                .map(Reader::getBooks)
                .map(List::size)
                .reduce((integer, integer2) -> {
                    if (integer >= integer2) {
                        return integer;
                    }
                    return integer2;
                });
    }

    public ArrayList<String> getTwoListOfReaders() {
        String TOO_MUCH = readers.stream()
                .filter(reader -> reader.getBooks().size() >= 2)
                .map(reader -> reader.getName() + ", ")
                .reduce("TOO_MUCH: {", (s, s2) -> s + s2)
                .concat("}")
                .replace(", }", "}");
        String OK = readers.stream()
                .filter(reader -> reader.getBooks().size() < 2)
                .map(reader -> reader.getName() + ", ")
                .reduce("OK: {", (s, s2) -> s + s2)
                .concat("}")
                .replace(", }", "}");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(TOO_MUCH);
        arrayList.add(OK);
        return arrayList;
    }
}
