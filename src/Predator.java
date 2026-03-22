/**
 * The Predator class represents a type of 
 * predator animal in a state in Australia
 * 
 * Each Predator has a name, and a dangerFactor
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public class Predator extends Animal
{

    private String predatorName;
    private double dangerFactor;

    /*
    Initialises the predatorName and dangerFactor
    fields to default values
    */
    public Predator()
    {
        predatorName = "Unknown";
        dangerFactor = 0.0;
    }

    /*
    Initialises the predatorName and dangerFactor
    fields to parameter values
    */
    public Predator(String predatorName, double dangerFactor)
    {
        this.predatorName = predatorName;
        this.dangerFactor = dangerFactor;
    }

    /*
    Displays the state of the Predator object
    to the user
    */
    public void display()
    {
        System.out.println("Predator Type: " + predatorName 
            + ", Danger Factor: " + dangerFactor);
    }

    // Returns the type of predator as a String
    @Override
    public String getAnimalType()
    {
        return predatorName;
    }

    // Returns the danger factor of the predator
    public double getDangerFactor()
    {
        return dangerFactor;
    }

    /*
    Assigns a new value to the field
    dangerFactor
    */
    public void setDangerFactor(double dangerFactor)
    {
        this.dangerFactor = dangerFactor;
    }

}
