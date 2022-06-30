import java.util.Comparator;

public class ComparatorBrands implements Comparator<Brands> {
    @Override
    public int compare(Brands o1, Brands o2) {
        String name1 = o1.brand();
        String name2 = o2.brand();
        return name1.compareTo(name2);
    }


}
