package com.revature.friday.lecture.demo;

public class Car {
    private int cost;
    
    private String name;

    private String[] owners;

    public int getCost() {
        return cost;
    }

    public String[] getOwners() {
        return owners;
    }

    public void setOwners(String[] owners) {
        this.owners = owners;
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
