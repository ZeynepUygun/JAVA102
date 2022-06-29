
import java.util.TreeSet;

public abstract class DataBase {
    public static TreeSet<Phone> phoneList = new TreeSet<>(new PhoneComparatorID());
    //private static TreeSet<IDataBase> notebookList;
    private int unitPrice;//birim fiyatı

    private int discountRate;//indirim oranı
    private int amount;//Stok miktarı
    private String productName;//Ürün adı
    private String brand;//MArka adı
    private String screenSize; //Ekran Boyutu
    private String ram;


    public DataBase( int unitPrice, int discountRate, int amount, String productName, String brand,
                     String screenSize, String ram) {

        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.amount = amount;
        this.productName = productName;
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;

    }

    public  TreeSet<Phone> getPhoneList() {
        return phoneList;
    }

    public  void setPhoneList(TreeSet<Phone> phoneList) {
        DataBase.phoneList = phoneList;
    }

    public int getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getRam() {
        return this.ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
