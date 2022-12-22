package com.revature.trainings;

public class SpringTraining implements Training {
    public SpringTraining() {
        System.out.println("Building spring training");
    }

    @Override
    public void beginTraining() {
        System.out.println("Begin training in Spring FW. Going to make my enemies weep in Java");

    }

}
