package com.revature.friday.lecture.demo;

public class Car {
    private int cost;
    
    private String name;

    public int getCost() {
        return cost;
    }

    //Validation to only be able to set cost >= 0
    public void setCost(int cost) {

        if (cost >= 0) {
            this.cost = cost;
        }
        else {
            this.cost = 0;
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
