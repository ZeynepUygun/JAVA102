import java.util.TreeSet;

public abstract class DataBase {
    public static TreeSet<Phone> phoneList = new TreeSet<>(new PhoneComparatorID());
    public static TreeSet<Notebook> notebookList = new TreeSet<>(new NotebookComparatorID());
    private final int unitPrice;//birim fiyatı

    private final int discountRate;//indirim oranı
    private final int amount;//Stok miktarı
    private final String productName;//Ürün adı
    private final String brand;//MArka adı
    private final String screenSize; //Ekran Boyutu
    private final String ram;


    public DataBase(int unitPrice, int discountRate, int amount, String productName, String brand,
                    String screenSize, String ram) {

        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.amount = amount;
        this.productName = productName;
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;

    }

    public int getUnitPrice() {
        return this.unitPrice;
    }

    public int getDiscountRate() {
        return this.discountRate;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public String getRam() {
        return this.ram;
    }

}
