package coffeMacine.clock;

import java.sql.Time;
import java.time.LocalTime;

public class ClockTread extends Thread {
    public void run(){
        try {
            while (true){
                System.out.println(Time.valueOf(LocalTime.now()));
                this.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("close clock Thread thread");
        }
    }
}

