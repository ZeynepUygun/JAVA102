
import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> bookLibrary = new TreeSet<>(Book::compareTo);

        bookLibrary.add(new Book("Yabanci",100,"Albert Camus","1980"));
        bookLibrary.add(new Book("Sokratesin savunmasi",200,"Sokrates","1970"));
        bookLibrary.add(new Book("Küçük Prens",302,"Antoine de Saint-Exupéry","1860"));
        bookLibrary.add(new Book("Simyacý",350,"Paulo coelho","2014"));
        bookLibrary.add(new Book("Hayvan Çiftliði",120,"George Orwell","1850"));

        System.out.println("\n");

        System.out.print(String.format("%-25s%-20s%-26s%-5s","\tKitap Adi","Sayfa Sayisi","Yazar Adi","Yayin Tarihi"));
        System.out.println("\n-------------------------------------------------------------------------------------------");



        for (Book say : bookLibrary.descendingSet()) {

            System.out.print(String.format("%-30s%-15s%-30s%-5s","\t" + say.getBookName(), say.getPageNum(),say.getAuthor(),say.getReleaseDate()));
            System.out.println();
        }
        System.out.println("\n-------------------------------------------------------------------------------------------");


        Set<Book> one=new TreeSet<>(new Comparator<Book>() {
            //sorts books by number of pages.
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNum() - o2.getPageNum();
            }
        });

        Collection<? extends Book> Collections = bookLibrary;
        one.addAll(Collections);

        System.out.println("\n");
        System.out.print(String.format("%-22s%-30s%-25s%-5s","Sayfa Sayisi","Kitap Adi","Yazar Adi","Yayin Tarihi"));
        System.out.println("\n-------------------------------------------------------------------------------------------");


        for(Book say :one){
            System.out.print(String.format("%-20s%-30s%-28s%-5s","\t"+say.getPageNum(), say.getBookName(), say.getAuthor(),say.getReleaseDate()));            System.out.println();
            }
        System.out.println("\n-------------------------------------------------------------------------------------------");

    }

}