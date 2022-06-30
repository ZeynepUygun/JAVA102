import java.util.*;

public record Brands(String brand) {

    public static TreeSet<Brands> brandList = new TreeSet<>(new ComparatorBrands());


    public static TreeSet<Brands> brands() {
        //Markaları kümeye attık. Ve sıraladık.

        for (Phone say : Phone.phoneList) {
            brandList.add(new Brands(say.getBrand()));
        }
        for (Notebook say : Notebook.notebookList) {
            brandList.add(new Brands(say.getBrand()));
        }


        return brandList;
    }


    public static void brandPrint() {
        for (Brands say : Brands.brands()) {
            System.out.println("- " + say.brand());
        }
    }

}
