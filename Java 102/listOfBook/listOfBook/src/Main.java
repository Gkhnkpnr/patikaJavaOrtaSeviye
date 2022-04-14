import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book1",100,"Ahmet","01-01-2001");
        Book book2 = new Book("Book2",200,"Mehmet","02-02-2002");
        Book book3 = new Book("Book3",300,"Ali","03-03-2003");
        Book book4 = new Book("Book4",400,"Hasan","04-04-2004");
        Book book5 = new Book("Book5",500,"Huseyin","05-05-2005");
        Book book6 = new Book("Book6",600,"Ayse","06-06-2006");
        Book book7 = new Book("Book7",700,"Fatma","07-07-2007");
        Book book8 = new Book("Book8",800,"Zeynep","08-08-2008");
        Book book9 = new Book("Book9",900,"Duygu","09-09-2009");
        Book book10 = new Book("Book10",1000,"Adile","10-10-2010");

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);

        HashMap<String, String> bookAuthorMatch = new HashMap<>();
        bookList.forEach(book -> bookAuthorMatch.put(book.getName(), book.getAuthorName()));
        bookAuthorMatch.keySet().forEach(name -> System.out.println(name + " " + bookAuthorMatch.get(name)));

        ArrayList<Book> bookListFiltered = new ArrayList<>();
        bookList.stream().filter(book -> book.getPageNumber() > 100).forEach(bookListFiltered::add);
        bookListFiltered.forEach(book -> System.out.println(book.getName()));
    }
}
