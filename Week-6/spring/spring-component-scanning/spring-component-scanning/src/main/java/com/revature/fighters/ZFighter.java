package com.revature.fighters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.revature.trainings.Training;

@Component("zFighter")
public class ZFighter implements Fighter {
    @Value("Goku")
    private String name;
    @Value("Fists of fury")
    private String weapon;
    private Training training;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    /**
     * @Qualifier is used to differentiate similar beans from one another
     */
    // setter injection!
    @Autowired
    public void setTraining(@Qualifier("counterTraining") Training training) {
        this.training = training;
    }

}
