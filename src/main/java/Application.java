import coffeMacine.Machine;
import lombok.*;

import java.util.Scanner;

public class Application {
    private static Machine coffeeMachine;
    private static Scanner in;

    public static void main(String[] args){
        coffeeMachine = new Machine();
        in = new Scanner(System.in);

        System.out.print("Press Enter PowerOn");
        String inp = in.nextLine();
        if(inp == ""){
            String str;
            coffeeMachine.power();
            while(true){
                if(!coffeeMachine.checkState()) str = "PowerOn";
                else str = "PowerOff";
                System.out.println("Press Enter to " + str +"\n" +
                                    "Press \"coffee\" to choose coffee\n" +
                                    "Press \"r\" to open recipe menu\n"+
                                    "Press \"p\" to add products\n" +
                                    "Press \"c\" to check cleanness\n" +
                                    "Press \"clean\" to clean machine\n" +
                                    "Press \"s\" to show log\n" +
                                    "Press \"x\" to exit\n");
                System.out.print("Enter command : ");
                inp = in.nextLine();

                switch (inp){
                    case "coffee": coffee(); break;
                    case "r": recipe();break;
                    case "p": addProduct();break;
                    case "c":coffeeMachine.checkCleanness();break;
                    case "clean":coffeeMachine.clean();break;
                    case "s": showLog();
                                break;
                    case "": coffeeMachine.power();
                            break;
                    case "x":
                        in.close();
                        return;
                }
            }
        }
    }

    private static void coffee(){
        System.out.print("Enter cup amount : ");
        int amount = convertToInt(in.nextLine());
        if(amount == 0) return;

        coffeeMachine.showCoffeeProfiles();

        System.out.print("Enter coffee NUMBER : ");
        int inp = convertToInt(in.nextLine());
        if(inp == 0) return;

        for (int i = 0; i < Math.abs(amount); i++){
            coffeeMachine.makeCoffee(inp);
        }
    }

    private static void recipe(){
        String inp;
        do {
            System.out.println("Enter \"s\" to show recipes" +
                                "\nEnter \"a\" to add recipe" +
                                "\nPress \"x\" to exit\n");

            System.out.print("Enter command : ");
            inp = in.nextLine();

            switch (inp){
                case "s": {
                    coffeeMachine.showCoffeeProfiles();
                    System.out.print("Enter coffee NUMBER : ");
                    int num = convertToInt(in.nextLine());
                    if(num == 0) return;

                    coffeeMachine.showRecipe(num);
                    break;
                }
                case "a":{
                    System.out.print("Enter profile name : ");
                    String name = in.nextLine();

                    System.out.print("Enter milk value : ");
                    int milk = convertToInt(in.nextLine());
                    if(milk == 0) return;

                    System.out.print("Enter coffee value : ");
                    int coffee = convertToInt(in.nextLine());
                    if(coffee == 0) return;

                    System.out.print("Enter water value : ");
                    int water = convertToInt(in.nextLine());
                    if(water == 0) return;

                    coffeeMachine.addRecipe(milk,
                                            coffee,
                                            water,
                                            name);

                    System.out.println("Recipe successfully added");
                    break;
                }
            }
        }while (!inp.equals("x"));
    }

    private static void addProduct(){
        String inp;
        do {
            System.out.println("Press \"m\" to add milk\n" +
                    "Press \"c\" to add coffee\n" +
                    "Press \"w\" to add water\n" +
                    "Press \"a\" to check amount\n" +
                    "Press \"x\" to exit\n");

            System.out.print("Enter command : ");
            inp = in.nextLine();

            switch (inp) {
                case "m": {
                    System.out.print("Enter milk value : ");
                    int value = convertToInt(in.nextLine());
                    if(value == 0) return;

                    if (coffeeMachine.addMilk(value))
                        System.out.println("Successful!");
                    else System.out.println("You can add only " + (Machine.MAX_MILK_VALUE -
                            coffeeMachine.getCurrentMilkValue()));
                    break;
                }
                case "c": {
                    System.out.print("Enter coffee value : ");
                    inp = in.nextLine();
                    if (coffeeMachine.addCoffee(Integer.valueOf(inp)))
                        System.out.println("Successful!");
                    else System.out.println("You can add only " + (Machine.MAX_COFFEE_VALUE -
                            coffeeMachine.getCurrentCoffeeValue()));
                    break;
                }
                case "w": {
                    System.out.print("Enter water value : ");
                    inp = in.nextLine();
                    if (coffeeMachine.addWater(Integer.valueOf(inp)))
                        System.out.println("Successful!");
                    else System.out.println("You can add only " + (Machine.MAX_WATER_VALUE -
                            coffeeMachine.getCurrentWaterValue()));
                    break;
                }
                case "a":
                    System.out.println("current milk : " + coffeeMachine.getCurrentMilkValue() +
                            "\ncurrent coffee : " + coffeeMachine.getCurrentCoffeeValue() +
                            "\ncurrent water : " + coffeeMachine.getCurrentWaterValue());
                    break;
            }
        }while (!inp.equals("x"));
    }

    private static int convertToInt(String inp){
        int num;
        try{
            num = Integer.valueOf(inp);
        }catch (NumberFormatException e){
            System.out.println("wrong parameter!");
            num = 0;
        }
        return num;
    }

    private static void showLog(){

        System.out.println("Press \"c\" to show coffee log\n" +
                            "Press \"p\" to show products log");
        String str = in.nextLine();
        switch (str){
            case "c" :
                coffeeMachine.logCoffee();
                break;
            case "p" :
                coffeeMachine.logProduct();
                break;
        }
    }
}
