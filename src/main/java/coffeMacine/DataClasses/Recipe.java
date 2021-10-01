package coffeMacine.DataClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
//import lombok.Setter;

@Getter
@NonNull
@AllArgsConstructor
public class Recipe {
    private int milk;
    private int coffee;
    private int water;
    private String name;
}
