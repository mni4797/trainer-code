package com.revature.friday.lecture.demo;

public class CarTest {
    
    @Test
    //Test will check if cost validation works
    public void Cost_Should_Store_Positive_Integers()
    {
        //Arrange
        int expectedCost = 2000;
        Car car1 = new Car();

        //Act
        car1.setCost(expectedCost);

        //Assert
        Assertion.Equals(expectedCost, car1.getCost());
    }

    @Test(enable = false)
    public void Some_Unit_Test() {
        
    }
}
