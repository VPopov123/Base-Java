package Emploees;


import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
@NonNull
public class Emploee {
    private String name;
    private int workAge;
    private int pay;
    private int age;

    public void print(){
        System.out.println(name + " " +
                            age + " годиков "  +
                            "зарабатывает " + pay + " деревянных" +
                            " работает уже " + workAge + " лет");
    }
}
