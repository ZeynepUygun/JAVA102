import java.util.Comparator;

public class PhoneComparatorBrands implements Comparator<Phone> {

    @Override
    public int compare(Phone o1, Phone o2) {
        String name1=o1.getBrand();
        String name2=o2.getBrand();
        return name1.compareTo(name2);
    }
}
