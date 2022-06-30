import java.util.TreeMap;

public class Notebook extends DataBase {
    private final String storage;//Depolama
    public int id;
    private static final TreeMap<Notebook, Integer> notebookList2 = new TreeMap<>((o1, o2) -> {

        String name1 = o1.getBrand() + "a";
        String name2 = o2.getBrand() + "b";


        return name1.compareTo(name2);
    });

    public Notebook(int id, int unitPrice, int discountRate, int amount, String productName, String brand,
                    String screenSize,
                    String ram, String storage) {
        super(unitPrice, discountRate, amount, productName, brand, screenSize, ram);

        this.storage = storage;
        this.id = id;
    }

    public static void notebooks() {
        notebookList.add(new Notebook(1,
                7000,
                5,
                50,
                "HUAWEI Matebook 14",
                "Huawei",
                "15.6 inc",
                "16 GB",
                "512 "));
        notebookList.add(new Notebook(2,
                5688,
                10,
                75,
                "LENOVO V14 IGL ",
                "Lenovo",
                "14 inc",
                "8 GB",
                "1024"));
        notebookList.add(new Notebook(
                3,
                688,
                10,
                75,
                "ASUS Tuf Gaming",
                "Asus  ",
                "15.6 inc",
                "32 GB",
                "2048"));
    }
    public static void notebookBrandForComparator() {
        notebookList2.clear();
        for (Notebook say : Notebook.notebookList) {
            notebookList2.put(new Notebook(say.getId(), say.getUnitPrice(), say.getDiscountRate(),
                    say.getAmount(),
                    say.getProductName(),
                    say.getBrand(),
                    say.getScreenSize(),
                    say.getRam(),
                    say.getStorage()),

                     say.getId()
            );
            System.out.println(notebookList2.size() + "   " + say.getId());
        }


        System.out.println(

                "-------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-30s %-13s %-11s %-15s %-10s  %-10s  %-10s %-15s %-1s", "| ID", "| URUN " +
                "ADI ", "|    FIYAT ", "| " +
                "  MARKA ", "|    DEPOLAMA ", "|  EKRAN ", "|   RAM ", "|   STOK ", "| INDIRIM " +
                "ORANI", "|");
        System.out.println(
                "\n" +
                        "-------------------------------------------------------------------------------------------------------------------------------");
        for (Notebook bay : notebookList2.keySet()) {
            System.out.printf("%-4s %-30s %-10s %-10s %-15s %-10s  %-10s  %-10s %-15s %-1s",
                    "| " + bay.getId(),
                    "| " + bay.getProductName(),
                    "| " + bay.getUnitPrice() + ",00 TL",
                    " | " + bay.getBrand(),
                    "| " + bay.getStorage(),
                    "| " + bay.getScreenSize(),
                    "| " + bay.getRam(),
                    "| " + bay.getAmount() + " Adet",
                    "|   %" + bay.getDiscountRate(),
                    "|\n"

            );
        }

        System.out.println(

                "-------------------------------------------------------------------------------------------------------------------------------");
    }
    public static void notebookPrint() {


        System.out.println(

                "-------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-30s %-10s %-10s %-15s %-10s  %-10s  %-10s %-15s %-1s", "| ID", "| URUN " +
                "ADI ", "|    FIYAT ", "| " +
                "  MARKA ", "|    DEPOLAMA ", "|  EKRAN ",  "|   RAM ",  "|   STOK ", "| INDIRIM " +
                "ORANI", "|");
        System.out.println(
                "\n" +
                        "-------------------------------------------------------------------------------------------------------------------------------");
        for (Notebook say : Notebook.notebookList) {
            System.out.printf("%-4s %-30s %-10s %-10s %-15s %-10s  %-10s  %-10s %-15s %-1s",
                    "| " + say.getId(),
                    "| " + say.getProductName(),
                    "| " + say.getUnitPrice() + ",00 TL",
                    "| " + say.getBrand(),
                    "| " + say.getStorage(),
                    "| " + say.getScreenSize(),
                    "| " + say.getRam(),
                    "| " + say.getAmount() + " Adet",
                    "|   %" + say.getDiscountRate(),
                    "|\n"

            );
        }
        System.out.println(

                "-------------------------------------------------------------------------------------------------------------------------------");
    }
    public static void notebookDelete(int id) {
        Notebook delete = null;

        for (Notebook tay : Notebook.notebookList) {
            if (tay.getId() == id) {
                delete = tay;
                break;
            }
        }

        if (delete != null) {
            notebookList.remove(delete);
        } else {
            System.out.println("\n\nBu Urun Zaten yok.");
        }


    }
    public static void notebooksAdd(int i, int unitPrice, int discountRate, int amount, String productName,
                                    String brand,
                                 String screenSize, String ram, String storage) {

       notebookList.add(new Notebook(i, unitPrice, discountRate, amount,
                productName, brand, screenSize, ram, storage));
    }

    public int getId() {
        return id;
    }

    public String getStorage() {
        return storage;
    }
}
