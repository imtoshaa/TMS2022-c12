package by.tms.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {
    private String fullName;
    private int userNumber;
    private String faculty;
    private String dateOfBirth;
    private int mobilePhoneNumber;
    private ArrayList<Book> listBook = new ArrayList<>();
    private int numberOfBooks = 0;

    public Reader(String fullName, int userNumber, String faculty, String dateOfBirth, int mobilePhoneNumber) {
        this.fullName = fullName;
        this.userNumber = userNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void takeBook(Book... book) {
        ArrayList<Book> returnBookList = new ArrayList<>(List.of(book));
        System.out.println(fullName + " взял книги: ");
        listBook.addAll(returnBookList);
        numberOfBooks = listBook.size();
        for (int i = 0; i < returnBookList.size(); i++) {
            System.out.println(returnBookList.get(i));
        }
    }

    public void takeBook(String... nameBook) {
        ArrayList<String> stringNameBookList = new ArrayList<>(List.of(nameBook));
        for (int i = 0; i < stringNameBookList.size(); i++) {
            listBook.add(new Book((stringNameBookList.get(i))));
        }
        numberOfBooks = listBook.size();
        System.out.println(fullName + " взял книги: " + stringNameBookList);
    }

    public void takeBook(int count) {
        System.out.println(fullName + " взял книг в размере = " + count);
        for (int i = 0; i < count; i++) {
            listBook.add(new Book());
        }
        numberOfBooks = listBook.size();
    }

    public void returnBook(Book... book) {
        System.out.println(fullName + " сдал книги: ");
        ArrayList<Book> returnBookList = new ArrayList<>(List.of(book));
        for (int i = 0; i < returnBookList.size(); i++) {
            Iterator<Book> iterator = listBook.iterator();
            while (iterator.hasNext()) {
                Book book1 = iterator.next();
                if (returnBookList.get(i).equals(book1)) {
                    iterator.remove();
                    System.out.println(book1);
                }
            }
        }
        numberOfBooks = listBook.size();
    }

    public void returnBook(int count) {
        System.out.println(fullName + " сдал книг в размере = " + count);
        for (int i = 0; i < 3; i++) {
            listBook.remove(0);
        }
        numberOfBooks = listBook.size();
    }

    public void returnBook(String... nameBook) {
        System.out.println(fullName + " сдал книги: ");
        ArrayList<String> stringBookList = new ArrayList<>(List.of(nameBook));
        for (int i = 0; i < stringBookList.size(); i++) {
            for (int j = 0; j < listBook.size(); j++) {
                if (stringBookList.get(i).equals(listBook.get(j).getNameBook())) {
                    listBook.remove(j);
                    System.out.println(stringBookList.get(i));
                }
            }
        }
        numberOfBooks = listBook.size();
    }

    public void mustBooks() {
        System.out.println(fullName + " должен книг в размере = " + numberOfBooks);
    }

}
