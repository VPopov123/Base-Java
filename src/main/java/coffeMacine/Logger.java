package coffeMacine;

import coffeMacine.DataClasses.Log;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class Logger {
    private ArrayList<Log> logs;

    public Logger(){
        logs = new ArrayList<>();
    }

    public void add(String name){
        logs.add(new Log(name, Time.valueOf(LocalTime.now())));
    }

    public void showLog(){
        for (Log curr: logs) {
            System.out.println("At " + curr.time + " cup of " + curr.profileName);
        }
    }

}
