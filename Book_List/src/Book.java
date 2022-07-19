import java.util.ArrayList;

public class Book {
    private String bookName, writerName, date;
    private int pageNumber;

    public Book(String bookName, int pageNumber, String writerName, String date) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.writerName = writerName;
        this.date = date;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getDate() {
        return date;
    }
}
