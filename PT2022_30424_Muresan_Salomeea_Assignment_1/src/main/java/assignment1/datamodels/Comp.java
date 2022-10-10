package assignment1.datamodels;

import java.util.Comparator;

public class Comp implements Comparator<Monomial> {
    @Override
    public int compare(Monomial o1, Monomial o2) {
        return o1.compareTo(o2);
    }
}
