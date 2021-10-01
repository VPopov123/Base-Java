package coffeMacine.sorters;

import coffeMacine.DataClasses.Log;

import java.util.Comparator;

public class CompareNameLog implements Comparator<Log> {
    @Override
    public int compare(Log o1, Log o2) {
        return o1.getProfileName().compareTo(o2.getProfileName());
    }
}
