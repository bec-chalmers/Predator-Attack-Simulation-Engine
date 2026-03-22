/**
 * The FarmTest class is a class used
 * for unit testing of the Farm class
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public class FarmTest
{
    public static void main (String[] args)
    {
        // Test default constructor
        System.out.println("Create a Farm 
            object with the default constructor");
        Farm testFarm = new Farm();
        testFarm.display();

        // Test non-default constructor
        System.out.println("Create a Farm 
            object with the 
            non-default constructor");
        State testState = new State();
        Farm testFarm = new Farm("testFarm", 
            testState, 10, 5);
        testFarm.display();

        System.out.println("Create a Farm 
            object with the non-default 
            constructor (invalid farmName)");
        State testState = new State();
        Farm testFarm = new Farm
            (10, testState, 10, 5);
        testFarm.display();

        System.out.println("Create a Farm 
            object with the non-default 
            constructor (invalid farmState)");
        testState = new State();
        Farm testFarm = new Farm
            ("testFarm", 10, 10, 5);
        testFarm.display();

        System.out.println("Create a Farm 
            object with the non-default 
            constructor 
            (invalid numberOfSheep)");
        State testState = new State();
        Farm testFarm = new Farm
            ("testFarm", testState, -10, 5);
        testFarm.display();

        System.out.println("Create a Farm 
            object with the non-default 
            constructor 
            (invalid numberOfLambs)");
        State testState = new State();
        Farm testFarm = new Farm
            ("testFarm", testState, 10, -5);
        testFarm.display();

        // Test one get method: getFarmName()
        System.out.println("Test getFarmName()");
        State testState = new State();
        Farm testFarm = new Farm
            ("testfarm", testState, 10, 5);
        System.out.println("Farm name: " 
            + testFarm.getFarmName());

        // Test one set method: setFarmName()
        System.out.println("Test setFarmName() 
            with valid parameter values");
        Farm testFarm = new Farm();
        testFarm.setFarmName("testFarm");
        System.out.println("Farm name: " 
            + testFarm.getFarmName());

        System.out.println("Test setFarmName() 
            with invalid parameter values");
        Farm testFarm = new Farm();
        testFarm.setFarmName(-5);
        System.out.println("Farm name: " 
            + testFarm.getFarmName());

        // Test display() method
        System.out.println("Test display() 
            (Farm class)");
        State testState = new State();
        Farm testFarm = new Farm
            ("testFarm", testState, 10, 5);
        testFarm.display();
    }
}
