package coffeMacine;

import coffeMacine.DataClasses.Recipe;
import java.util.ArrayList;

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

    private Logger logger;

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
        logger = new Logger();

        recipes = new ArrayList<>();
        Recipe cappuccino = new Recipe(4, 3, 3, "cappuccino");
        Recipe espresso = new Recipe(0, 6, 4, "espresso");

        currentMilkValue = 50;
        currentCoffeeValue = 50;
        currentWaterValue = 50;

        recipes.add(cappuccino);
        recipes.add(espresso);

    }

    public boolean addWater(int value){
        if(state) {
            if (currentWaterValue + value > MAX_WATER_VALUE) return false;
            else {
                currentWaterValue += value;
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
                return true;
            }
        }else return false;
    }

    public boolean addCoffee(int value){
        if(state) {
            if (currentCoffeeValue + value > MAX_COFFEE_VALUE) return false;
            else {
                currentCoffeeValue += value;
                return true;
            }
        }else return false;
    }

    public boolean power(){
        if(state == false) state = true;
        else state = false;
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
            if (name == null) name = new String("profile " + (recipes.size() - 1));
            Recipe recipe = new Recipe(milk, coffee, water, name);
            recipes.add(recipe);
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
                        currentWaterValue < recipes.get(id).getCoffee())
                    System.out.println("Missing components");
                else {
                    currentMilkValue -= recipes.get(id).getMilk();
                    currentCoffeeValue -= recipes.get(id).getCoffee();
                    currentWaterValue -= recipes.get(id).getCoffee();
                    cleanness++;
                    logger.add(recipes.get(id).getName());
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

    public void log(){
        if(state) {
            logger.showLog();
        }
    }
}
