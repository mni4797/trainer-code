package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.models.Fighter;
import com.revature.models.Knight;
import com.revature.models.StreetFighter;
import com.revature.trainings.HadokenTraining;
import com.revature.trainings.SpringTraining;
import com.revature.trainings.Training;

// This is the java class we'll be using to configure our spring beans
@Configuration
public class AppConfig {
    // the manual way we're passing SpringTraining to Knight is
    // called manual bean wiring

    // WIRING refers to the act of combining objects to work with each other
    // you can also come up with a different name for your bean
    // by setting the name attribute of your bean annotation
    @Bean(name = "MrBean")
    @Scope("prototype")
    public Fighter getKFighter() {
        return new Knight(getSpringTraining());
    }

    // beans have names
    // by default, they have the same name as the method name
    @Bean(name = "BeanieBaby")
    public Fighter getSFighter() {
        StreetFighter ryu = new StreetFighter();
        ryu.setTraining(getHadokenTraining());
        return ryu;
    }

    @Bean
    public Training getSpringTraining() {
        return new SpringTraining();
    }

    @Bean
    public Training getHadokenTraining() {
        return new HadokenTraining();
    }
}
