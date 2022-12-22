package com.revature.models;

import com.revature.trainings.Training;

public class Knight implements Fighter {
    private String name;
    private String weapon;
    private Training training;

    public Knight(Training training) {
        System.out.println("Creating a knight");
        this.training = training;
    }

    @Override
    public void goToTraining() {
        training.beginTraining();

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getWeapon() {
        return weapon;
    }

}
