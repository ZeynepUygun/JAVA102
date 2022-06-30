import java.util.Comparator;

public class NotebookComparatorID implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        int id1 = o1.getId();
        int id2 = o2.getId();
        return id1 - id2;
    }
}
