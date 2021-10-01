package Emploees.comporators;

import Emploees.Emploee;

import java.util.Comparator;

public class SortByPay implements Comparator<Emploee> {
    @Override
    public int compare(Emploee o1, Emploee o2) {
        return o1.getPay() - o2.getPay();
    }
}
