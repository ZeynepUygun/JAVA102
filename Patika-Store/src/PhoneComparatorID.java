import java.util.Comparator;

public class PhoneComparatorID implements Comparator<Phone> {

    @Override
    public int compare(Phone o1, Phone o2) {
        int id1=o1.getId();
        int id2=o2.getId();
        return id1-id2;
    }

}
