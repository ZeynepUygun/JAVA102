import java.util.*;

public class Phone extends DataBase {


    private static final TreeMap<Phone, Integer> phoneList2 = new TreeMap<>((o1, o2) -> {

        String name1 = o1.getBrand() + "a";
        String name2 = o2.getBrand() + "b";


        return name1.compareTo(name2);
    });


    private final String storage;//Depolama
    private final String batteryPower;//Pil Gücü
    private final String color;//renk

    public int id;

    public Phone(int id, int unitPrice, int discountRate, int amount, String productName, String brand,
                 String screenSize, String ram, String storage, String batteryPower, String color) {
        super(unitPrice, discountRate, amount, productName, brand,
                screenSize, ram);

        this.storage = storage;
        this.batteryPower = batteryPower;
        this.color = color;
        this.id = id;


    }


    public static void phones() {


        //Telefonları kümeye attık. Ve sıraladık.

        phoneList.add(new Phone(
                1,
                3199,
                5,
                50,
                "Samsung Galaxy A51",
                "Samsung",
                "6,5 inc",
                "8 GB",
                "64 GB",
                "4000 mA",
                "Mavi"));

        phoneList.add(new Phone(
                2,
                5688,
                10,
                75,
                "Philips 11 64 GB",
                "Philips",
                "7.1 inc",
                "16 GB",
                "128 GB",
                "6000 mA",
                "Siyah"));

        phoneList.add(new Phone(
                3,
                688,
                10,
                75,
                "iPhone 11 64 GB",
                "Iphone",
                "7.1 inc",
                "16 GB",
                "128 GB",
                "6000 mA",
                "Beyaz"));

        phoneList.add(new Phone(
                4,
                319,
                5,
                50,
                "Samsung Galaxy A51",
                "Samsung",
                "6,5 inc",
                "8 GB",
                "64 GB",
                "4000 mA",
                "Siyah"));


    }


    public static void phonesBrandForComparator() {
        phoneList2.clear();
        for (Phone say : Phone.phoneList) {
            phoneList2.put(new Phone(say.getId(), say.getUnitPrice(), say.getDiscountRate(),
                    say.getAmount(),
                    say.getProductName(),
                    say.getBrand(),
                    say.getScreenSize(),
                    say.getRam(),
                    say.getStorage(),

                    say.getBatteryPower(),

                    say.getColor()), say.getId()
            );
            System.out.println(phoneList2.size() + "   " + say.getId());
        }


        System.out.println(

                "----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-30s %-12s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-1s", "| ID", "| URUN " +
                "ADI ", "|    FIYAT ", "| " +
                "  MARKA ", "|    DEPOLAMA ", "|  EKRAN ", "|   PIL ", "|   RAM ", "|   RENK ", "|   STOK ", "| INDIRIM " +
                "ORANI", "|");
        System.out.println(
                "\n" +
                        "----------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Phone bay : phoneList2.keySet()) {
            System.out.printf("%-4s %-30s %-10s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-15s %-1s",
                    "| " + bay.getId(),
                    "| " + bay.getProductName(),
                    "| " + bay.getUnitPrice() + ",00 TL",
                    "| " + bay.getBrand(),
                    "| " + bay.getStorage(),
                    "| " + bay.getScreenSize(),
                    "| " + bay.getBatteryPower(),
                    "| " + bay.getRam(),
                    "| " + bay.getColor(),
                    "| " + bay.getAmount() + " Adet",
                    "|   %" + bay.getDiscountRate(),
                    "|\n"

            );
        }

        System.out.println(

                "----------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    public static void phonesPrint() {


        System.out.println(

                "----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-30s %-12s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-1s", "| ID", "| URUN " +
                "ADI ", "|    FIYAT ", "| " +
                "  MARKA ", "|    DEPOLAMA ", "|  EKRAN ", "|   PIL ", "|   RAM ", "|   RENK ", "|   STOK ", "| INDIRIM " +
                "ORANI", "|");
        System.out.println(
                "\n" +
                        "----------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Phone say : Phone.phoneList) {
            System.out.printf("%-4s %-30s %-10s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-15s %-1s",
                    "| " + say.getId(),
                    "| " + say.getProductName(),
                    "| " + say.getUnitPrice() + ",00 TL",
                    "| " + say.getBrand(),
                    "| " + say.getStorage(),
                    "| " + say.getScreenSize(),
                    "| " + say.getBatteryPower(),
                    "| " + say.getRam(),
                    "| " + say.getColor(),
                    "| " + say.getAmount() + " Adet",
                    "|   %" + say.getDiscountRate(),
                    "|\n"

            );
        }
        System.out.println(

                "----------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void phonesDelete(int id) {
        Phone delete = null;

        for (Phone tay : Phone.phoneList) {
            if (tay.getId() == id) {
                delete = tay;
                break;
            }
        }

        if (delete != null) {
            phoneList.remove(delete);
        } else {
            System.out.println("\n\nBu Urun Zaten yok.");
        }


    }


    public static void phonesAdd(int i, int unitPrice, int discountRate, int amount, String productName, String brand,
                                 String screenSize, String ram, String storage, String batteryPower, String color) {

        phoneList.add(new Phone(i, unitPrice, discountRate, amount,
                productName, brand, screenSize, ram, storage,
                batteryPower, color));
    }


    public String getStorage() {
        return storage;
    }

    public String getBatteryPower() {
        return batteryPower;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }
}
