package coffeMacine;

import coffeMacine.DataClasses.Log;
import coffeMacine.interfaces.ISort;
import lombok.Cleanup;


import java.util.ArrayList;
import java.util.Scanner;

public abstract class LoggerFather implements ISort {
    protected ArrayList<Log> logs;

    public LoggerFather(){
        this.logs = new ArrayList<>();
    }

    public void add(String name){ }

    public void showLog(){
        Scanner inp = new Scanner(System.in);
        int currentLog = 0;
        String str = "";

        while(currentLog < logs.size()) {

            int increment = currentLog + 10 > logs.size() ?
                    logs.size() - currentLog :
                    10;
            increment += currentLog;

            for (int i = currentLog; i < increment; i++) {
                System.out.println("At " + logs.get(i).getTime() + " cup of " + logs.get(i).getProfileName());
                currentLog++;
            }
            //currentLog += increment;

            str = getLine(inp);
            if (str.equals("x")) {
                break;
            }
        }
    }

    private String getLine(Scanner inp){
        System.out.println("Press Enter to show next\n" +
                            "Press \"x\" to exit\n");
        return inp.nextLine();
    }

}