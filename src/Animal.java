/**
 * This class as an abstract class that
 * represents an animal in Australia
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public abstract class Animal
{

    // Returns the animal type as a String
    public abstract String getAnimalType();

    // Displays the state of an object of a subclass of the Animal class
    public void display()
    {
        System.out.println("Animal Type: " + getAnimalType());
    }

}
