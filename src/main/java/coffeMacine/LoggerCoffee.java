package coffeMacine;

import coffeMacine.DataClasses.Log;
import coffeMacine.sorters.CompareNameLog;
import coffeMacine.sorters.CompareTimeLog;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class LoggerCoffee extends LoggerFather{

    Comparator<Log> compareTime;
    Comparator<Log> compareName;

    public LoggerCoffee(){
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

//    private ArrayList<Log> logs;
//
//    public LoggerCoffee(){
//        logs = new ArrayList<>();
//    }
//
//    public void add(String name){
//        logs.add(new Log(Time.valueOf(LocalTime.now()), name));
//    }
//
//    public void showLog(){
//        for (var curr: logs) {
//            System.out.println("At " + curr.time + " cup of " + curr.profileName);
//        }
//    }

}

//new Log(name, Time.valueOf(LocalTime.now()))