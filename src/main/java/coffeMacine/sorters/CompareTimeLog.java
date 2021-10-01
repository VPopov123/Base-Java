package coffeMacine.sorters;

import coffeMacine.DataClasses.Log;

import java.util.Comparator;

public class CompareTimeLog implements Comparator<Log> {
    @Override
    public int compare(Log o1, Log o2) {
        return (o1.getTime().compareTo(o2.getTime()));
    }
}
