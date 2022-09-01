package com.revature.trainings;

import org.springframework.stereotype.Component;

@Component
public class SpringTraining implements Training {

    @Override
    public void beginTraining() {
        System.out.println("training for spring, still, it's been 3 apps...");

    }

}
