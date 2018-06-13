package com.sbt.javaschool.examples.lambdas.dishes;

public class Dish {

    private int calories;
    private String type;
    private String name;
    private boolean isVegenerian;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegenerian() {
        return isVegenerian;
    }

    public void setVegenerian(boolean vegenerian) {
        isVegenerian = vegenerian;
    }

    public Dish(int calories, String type, String name, boolean isVegenerian) {
        this.calories = calories;
        this.type = type;
        this.name = name;
        this.isVegenerian = isVegenerian;
    }
}
