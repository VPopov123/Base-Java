package coffeMacine.clock;

import java.sql.Time;
import java.time.LocalTime;

public class ClockRunnable implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                System.out.println(Time.valueOf(LocalTime.now()));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("close clock runnable thread");
        }
    }
}
