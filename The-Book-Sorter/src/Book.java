import java.util.Collection;

public class Book implements Comparable<Book>{
    private String bookName;
    private int pageNum;
    private String author;
    private String releaseDate;
    private Book[] library;



    public Book(String bookName,int pageNum,String author,String releaseDate){
        this.bookName = bookName;
        this.pageNum = pageNum;
        this.author = author;
        this.releaseDate = releaseDate;
    }

//sorts the book by name from A to Z.
    @Override
    public int compareTo(Book o) {
        int bookNameCompare = this.bookName.compareTo(o.bookName);

        if(bookNameCompare != 0) {
            return bookNameCompare;
        }

        return this.author.compareTo(o.author);

    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


}
