package com.revature.fighters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.trainings.Training;

@Component("kFighter")
@Scope("prototype")
public class Knight implements Fighter {
    @Value("Dark Knight")
    private String name;
    @Value("${knight.weapon}")
    private String weapon;
    private Training training;

    // autowiring
    // with constructor injection, if spring is managing a bean
    // of the type that an object is dependent on
    // it automagically injects that dependency
    public Knight(@Qualifier("springTraining") Training training) {
        this.training = training;
    }

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

}
