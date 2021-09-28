package coffeMacine.DataClasses;

public class Recipe {
    String name;
    int milk;
    int coffee;
    int water;

    public Recipe(int milk, int coffee, int water, String name){
        this.milk = milk;
        this.coffee = coffee;
        this.water = water;
        this.name = name;
    }

    public int getMilk() {
        return milk;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffee() {
        return coffee;
    }
    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getWater() {
        return water;
    }
    public void setWater(int water) {
        this.water = water;
    }

    public String getName() {
        return name;
    }
}
