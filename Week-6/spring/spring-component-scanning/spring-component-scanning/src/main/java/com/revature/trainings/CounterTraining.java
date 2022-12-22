package com.revature.trainings;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CounterTraining implements Training {

    @Override
    public void beginTraining() {
        System.out.println("Begin counting! 1...2... What comes after 2??? Uhhh 1... 2... 4???");

    }

}
