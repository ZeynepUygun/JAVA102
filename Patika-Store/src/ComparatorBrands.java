import java.util.Comparator;

public class ComparatorBrands implements Comparator<Brands> {
@Override
    public int compare(Brands o1, Brands o2) {
        String name1 = o1.getBrand();
        String name2 = o2.getBrand();
        return name1.compareTo(name2);
    }



}
