

public class Main {
    public static void main(String[] args) {

        MyEnum.bookname.getBookList();//Kitap isimlerini listeler.
        MyEnum.pageNumber.getBookList();//Kitap isimlerini sayfa numaralarıyla birlikte listeler.
        MyEnum.writerName.getBookList();//Kitap isimlerini yazar isimleri ile listeler.

        MyEnum.bookname.filter(100);//Sayfa sayısı 100'den büyük olan kitapları,kitap ismi ve sayfa sayısı ile listeler.
MyEnum.pageNumber.filter(200);//Sayfa sayısı 200'den büyük olan kitapları,kitap ismi ve sayfa sayısı ile listeler.
MyEnum.writerName.filter(50);//Sayfa sayısı 50'den büyük olan kitapları,yazar ismi ve sayfa sayısı ile listeler.









    }
}