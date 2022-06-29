import java.util.*;

public class Brands {

    private String brand;
    public static TreeSet<Brands> brandList = new TreeSet<>(new ComparatorBrands());
    public Brands(){

    }
    public Brands(String brand){

        this.brand = brand;
    }


    public static TreeSet<Brands> brands(){
        //Markaları kümeye attık. Ve sıraladık.

        for (Phone say : Phone.phoneList) {
            brandList.add(new Brands(say.getBrand()));
        }




    return  brandList;
    }


    public void brandPrint(){
        for (Brands say : Brands.brands()) {
            System.out.println("- " + say.getBrand());
        }
    }





    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static TreeSet<Brands> getBrandList() {
        return brandList;
    }

    public static void setBrandList(TreeSet<Brands> brandList) {
        Brands.brandList = brandList;
    }
}
