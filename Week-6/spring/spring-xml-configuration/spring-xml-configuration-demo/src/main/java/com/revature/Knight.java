package com.revature;

public class Knight implements Fighter {
    private String name;
    private String weapon;
    private Training training;

    // constructor injection
    // injecting the deps in the object constructor
    // type of dep injection, it forces people who want to instantiate this class
    // to pass a instance of an object this class is dependent in
    public Knight(Training training) {
        System.out.println("building knight object");
        this.training = training;
    }

    @Override
    public void goToTraining() {
        System.out.println("This knight is going to training");
        training.beginTraining();
    }

}
