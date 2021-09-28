package coffeMacine.DataClasses;

import java.security.PublicKey;
import java.sql.Time;

public class Log {
    public Time time;
    public String profileName;
    public Log(String profileName, Time time){
        this.profileName = profileName;
        this.time = time;
    }
}
