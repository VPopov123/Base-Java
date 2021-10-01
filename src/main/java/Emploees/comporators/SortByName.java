package Emploees.comporators;

import Emploees.Emploee;

import java.util.Comparator;
import java.util.stream.Collector;

public class SortByName implements Comparator<Emploee> {
    @Override
    public int compare(Emploee o1, Emploee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
