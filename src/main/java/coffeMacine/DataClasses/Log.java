package coffeMacine.DataClasses;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Time;

@RequiredArgsConstructor
@Getter
public class Log {
    @NonNull private Time time;
    @NonNull private String profileName;
}
