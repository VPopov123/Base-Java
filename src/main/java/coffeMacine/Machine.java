package coffeMacine;

import coffeMacine.DataClasses.Recipe;
import coffeMacine.clock.ClockRunnable;
import coffeMacine.clock.ClockTread;
import lombok.Cleanup;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine {
    private boolean state;
    private int cleanness;

    public static int MAX_WATER_VALUE = 100;
    public static int MAX_MILK_VALUE = 100;
    public static int MAX_COFFEE_VALUE = 100;
    private int currentWaterValue;
    private int currentMilkValue;
    private int currentCoffeeValue;

    private ArrayList<Recipe> recipes;

    private ClockTread clockTread;
    private Thread clockRunnable;

    private LoggerFather loggerCoffee;
    private LoggerFather loggerProducts;

    public int getCurrentWaterValue() {
        return currentWaterValue;
    }
    public int getCurrentMilkValue() {
        return currentMilkValue;
    }
    public int getCurrentCoffeeValue() {
        return currentCoffeeValue;
    }
    public boolean checkState(){ return this.state; }

    public Machine(){
        state = false;
        loggerCoffee = new LoggerCoffee();
        loggerProducts = new LoggerProducts();

        recipes = new ArrayList<>();
        Recipe cappuccino = new Recipe(4, 3, 3, "cappuccino");
        Recipe espresso = new Recipe(0, 6, 4, "espresso");

        currentMilkValue = 100;
        currentCoffeeValue = 100;
        currentWaterValue = 100;

        recipes.add(cappuccino);
        recipes.add(espresso);

    }

    public boolean addWater(int value){
        if(state) {
            if (currentWaterValue + value > MAX_WATER_VALUE) return false;
            else {
                currentWaterValue += value;
                loggerProducts.add("water");
                return true;
            }
        }
        else return false;
    }

    public boolean addMilk(int value){
        if(state) {
            if(currentMilkValue + value > MAX_MILK_VALUE) return false;

            else {
                currentMilkValue += value;
                loggerProducts.add("milk");
                return true;
            }
        }else return false;
    }

    public boolean addCoffee(int value){
        if(state) {
            if (currentCoffeeValue + value > MAX_COFFEE_VALUE) return false;
            else {
                currentCoffeeValue += value;
                loggerProducts.add("coffee");
                return true;
            }
        }else return false;
    }

    public boolean power(){
        if(state == false){
            state = true;
//            clockTread = new ClockTread();
//            clockTread.start();
//            clockRunnable = new Thread(new ClockRunnable(), "clock");
//            clockRunnable.start();
        }
        else {
            state = false;
//            clockTread.interrupt();
//            clockRunnable.interrupt();
        }
        return state;
    }

    public boolean checkCleanness(){
        if(state) {
            if (cleanness <= 100) {
                System.out.println("no cleaning required");
                return false;
            } else {
                System.out.println("Cleaning required");
                return true;
            }
        }
        else return false;
    }

    public void clean(){
        if(state) {
            if (checkCleanness()) {
                cleanness = 0;
                System.out.println("Machine cleaned!");
            }
        }
    }


    public void addRecipe(int milk, int coffee, int water, String name){
        if(state) {
            if (name == null){
                name = new String("profile " + (recipes.size() - 1));
            }

            recipes.add(new Recipe(milk, coffee, water, name));
        }
    }

    public void showCoffeeProfiles(){
        for (int i = 0; i < recipes.size(); i++)
            System.out.println((i + 1) + " " + recipes.get(i).getName());
    }

    public void makeCoffee(int id){
        if(state) {
            id -= 1;
            if(id >= recipes.size()) System.out.println("Wrong profile number");
            else
                if (currentMilkValue < recipes.get(id).getMilk() ||
                        currentCoffeeValue < recipes.get(id).getCoffee() ||
                        currentWaterValue < recipes.get(id).getWater())
                    System.out.println("Missing components");
                else {
                    currentMilkValue -= recipes.get(id).getMilk();
                    currentCoffeeValue -= recipes.get(id).getCoffee();
                    currentWaterValue -= recipes.get(id).getWater();
                    cleanness++;
                    loggerCoffee.add(recipes.get(id).getName());
                    System.out.println("Your coffee please!");
                }
        }
    }

    public void showRecipe(int id){
        if(state) {
            id -= 1;

            if(id >= recipes.size()) System.out.println("Wrong profile number");
            else
                System.out.println(recipes.get(id).getName() + " recipe" +
                                "\nmilk : " + recipes.get(id).getMilk() +
                                "\ncoffee : " + recipes.get(id).getCoffee() +
                                "\nwater : " + recipes.get(id).getWater());
        }
    }

    public void logCoffee(){
        if(state) {
            Scanner inp = new Scanner(System.in);
            System.out.println("Press \"t\" to sort by time\n" +
                                "Press \"n\" to sort by name");
            String str = inp.nextLine();

            switch (str){
                case "t":
                    loggerCoffee.sortTime();
                    break;
                case "n" :
                    loggerCoffee.sortName();
                    break;
            }
        }
    }

    public void logProduct(){
        if(state) {
            Scanner inp = new Scanner(System.in);
            System.out.println("Press \"t\" to sort by time\n" +
                                "Press \"n\" to sort by name");
            String str = inp.nextLine();

            switch (str){
                case "t":
                    loggerProducts.sortTime();
                    break;
                case "n" :
                    loggerProducts.sortName();
                    break;
            }
        }
    }
}
