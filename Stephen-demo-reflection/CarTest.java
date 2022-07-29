package com.revature.friday.lecture.demo;

public class CarTest {
    
    //Test will check if cost validation works
    public boolean Cost_Should_Store_Positive_Integers()
    {
        //Arrange
        int expectedCost = 2000;
        Car car1 = new Car();

        //Act
        car1.setCost(expectedCost);

        //Assert
        return Assertion.Equals(expectedCost, car1.getCost());

    }
}
