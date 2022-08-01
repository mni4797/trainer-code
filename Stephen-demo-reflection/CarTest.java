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

    @Test
    public void Owners_Should_Store_Array_Of_Strings() {
        //Arrange
        String[] expectedOwners = {"Stephen", "Marielle"};
        Car car1 = new Car();
        
        //Act
        car1.setOwners(expectedOwners);
        
        //Assert
        Assertion.ArrayEquals(expectedOwners, car1.getOwners());
    }

    @Test(enable = false)
    public void Name_Should_Store_String()
    {
        //Arrange
        String expectedName = "Toyota";
        Car car1 = new Car();
        
        //Act
        car1.setName("Toyota");
        
        //Assert
        Assertion.Equals(expectedName, car1.getName());
    }

    @Test
    public void This_Unit_Test_Will_Fail()
    {
        //Arrange
        int expectedCost = -2000;
        Car car1 = new Car();

        //Act
        car1.setCost(expectedCost);

        //Assert
        Assertion.Equals(expectedCost, car1.getCost());
    }
}
