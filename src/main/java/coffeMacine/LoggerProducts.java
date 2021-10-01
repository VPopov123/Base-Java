package coffeMacine;

import coffeMacine.DataClasses.Log;
import coffeMacine.sorters.CompareNameLog;
import coffeMacine.sorters.CompareTimeLog;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class LoggerProducts extends LoggerFather{

    Comparator<Log> compareTime;
    Comparator<Log> compareName;

    public LoggerProducts(){
        compareTime = new CompareTimeLog();
        compareName = new CompareNameLog();
    }

    @Override
    public void add(String name) {
        this.logs.add(new Log(Time.valueOf(LocalTime.now()), name));
    }

    @Override
    public void sortName() {
        this.logs.sort(compareName);
        showLog();
    }

    @Override
    public void sortTime() {
        this.logs.sort(compareTime);
        showLog();
    }
}
