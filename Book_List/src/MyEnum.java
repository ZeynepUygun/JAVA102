import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


import static java.lang.String.format;

public enum MyEnum {

    bookname(1), pageNumber(2), writerName(3);


private final ArrayList<Book> arrayList =new ArrayList<>();
private final Map<String,String> mapList = new TreeMap<>();
    private final int book;

    MyEnum(int book) {
        this.book = book;
        this.arrayList.add(new Book("İnci", 120, "John Steinbeck", "2000/04/07"));
        this.arrayList.add(new Book("Ateş ve Kan", 800, "George R. R. Martin", "2020/05/12"));
        this.arrayList.add(new Book("Sol Ayağım", 89, "Christy Brown", "1985/04/25"));
        this.arrayList.add(new Book("Yıldız Gemisi", 125, "Brian Aldiss", "1954/08/11"));
        this.arrayList.add(new Book("Yabancı", 90, "Albert Camus", "2004/10/04"));
        this.arrayList.add(new Book("Dönüşüm", 160, "Franz Kafka", "1940/04/05"));
        this.arrayList.add(new Book("Siyah İnci", 150, "Anna Sewell", "2014/02/25"));
        this.arrayList.add(new Book("Ejderhaların Dansı", 700, "George R. R. Martin", "2013/02/10"));
        this.arrayList.add(new Book("Kış Rüzgarları", 657, "George R. R. Martin", "2022/05/16"));





    }


    public void getBookList() {
        switch (this.book) {
            case 1 -> arrayList.forEach(i -> System.out.println(i.getBookName()));
            case 2 -> {
                arrayList.forEach(i -> System.out.format(format("%-35s%s", "\n" + i.getBookName(), " " +
                        "----------> " +
                        i.getPageNumber())));
                System.out.println();
            }

            case 3 -> {
                arrayList.forEach(i -> mapList.put(i.getBookName(), i.getWriterName()));


                mapList.entrySet().forEach(System.out::println);


            }

        }
        System.out.println("----------------------------------------------------------------------------------------");

    }

    public void filter(int page){
        System.out.println("Sayfa sayısı "+page+" buyuk olan kitaplarin listesi.");

        switch (this.book) {
            case 1, 2 ->
                    arrayList.stream().filter(i -> i.getPageNumber() > page).forEach(i -> System.out.println(i.getBookName() +
                            "  " +
                            "  " + i.getPageNumber()));
            case 3 ->
                    arrayList.stream().filter(i -> i.getPageNumber() > page).forEach(i -> System.out.println(i.getWriterName() +
                            "  " +
                            "  " + i.getPageNumber()));
        }
        System.out.println("----------------------------------------------------------------------------------------");

    }

}

