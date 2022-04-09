package com.company;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Against the Dark", 1966, "Flory Kenninghan", 2016);
        Book book2 = new Book("Sing Your Song", 1991, "Leonidas Northover", 2013);
        Book book3 = new Book("Romance of Astrea and Celadon", 2010, "Huntley Valentine", 2010);
        Book book4 = new Book("Cape Fear", 2006, "Vincenty Dohmer", 2015);
        Book book5 = new Book("Chinoise", 1500, "Margaret Nelane", 2021);

        TreeSet<Book> bookTreeSetName = new TreeSet<>();

        bookTreeSetName.add(book1);
        bookTreeSetName.add(book2);
        bookTreeSetName.add(book3);
        bookTreeSetName.add(book4);
        bookTreeSetName.add(book5);

        for (Book book : bookTreeSetName) {
            System.out.println("Book Name : " + book.getName() + "Page Number : " + book.getPageNum());
        }

        System.out.println("********************************");

        TreeSet<Book> bookTreeSetPageNum = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNum() - o2.getPageNum();
            }
        }.reversed());

        bookTreeSetPageNum.add(book1);
        bookTreeSetPageNum.add(book2);
        bookTreeSetPageNum.add(book3);
        bookTreeSetPageNum.add(book4);
        bookTreeSetPageNum.add(book5);

        for (Book book : bookTreeSetPageNum){
            System.out.println("Book Name : " + book.getName() + "Page : " + book.getPageNum());
        }
    }
}
