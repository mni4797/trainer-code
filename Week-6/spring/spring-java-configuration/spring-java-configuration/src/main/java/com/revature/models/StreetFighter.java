package com.revature.models;

import com.revature.trainings.Training;

public class StreetFighter implements Fighter {
    private String name;
    private String weapon;
    private Training training;

    @Override
    public void goToTraining() {
        training.beginTraining();

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public String getWeapon() {
        // TODO Auto-generated method stub
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    // set this up with setter injection
    // useful for optional dependencies
    public void setTraining(Training training) {
        this.training = training;
    }

}
