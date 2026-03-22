/**
 * The FarmAnimal class is an abstract class
 * representing an animal living on a farm
 * in Australia
 * 
 * Each FarmAnimal has a flag which tracks 
 * if it has died, the predator that killed it,
 * a stockValue, and a survival factor
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public abstract class FarmAnimal extends Animal
{

    protected boolean isDead;
    protected Predator predatorWasKilledBy;
    private final double stockValue;
    protected double survivalFactor;

    /*
    Initialises the isDead, predatorWasKilledBy,
    stockValue, and survivalFactor fields to
    default values
    */
    public FarmAnimal()
    {
        isDead = false;
        predatorWasKilledBy = new Predator();
        stockValue = 0.00;
        survivalFactor = 0.00;
    }

    /*
    Initialises the isDead, predatorWasKilledBy,
    stockValue, and survivalFactor fields to
    default values
    */
    public FarmAnimal(boolean isDead, 
        Predator predatorWasKilledBy, 
        double stockValue, double survivalFactor)
    {
        this.isDead = isDead;
        this.predatorWasKilledBy 
            = predatorWasKilledBy;
        this.stockValue = stockValue;
        this.survivalFactor = survivalFactor;
    }

    /*
    Displays the state of the FarmAnimal
    object to the user
    */
    public void display()
    {
        System.out.println("Animal Type: " 
            + getAnimalType());
        System.out.println("Stock Value: " 
            + stockValue);
        
        if (predatorWasKilledBy != null)
        {
            System.out.println("Status: Dead");
            System.out.println("Killed by: " 
                + predatorWasKilledBy.getAnimalType());
        }
        else
        {
            System.out.println("Status: Alive");
        }

        System.out.println("Risk Factor: x" 
            + survivalFactor);
        
        System.out.println("\n");
    }

    /*
    Returns the value of the field
    predatorWasKilledBy
    */
    public Predator getPredatorWasKilledBy()
    {
        return predatorWasKilledBy;
    }

    // Returns the value of the field stockValue
    public final double getStockValue()
    {
        return stockValue;
    }

    /*
    Returns the value of the field
    survivalFactor
    */
    public double getSurvivalFactor()
    {
        return survivalFactor;
    }

    /*
    Returns the value of the field
    isDead
    */
    public boolean isDead()
    {
        return isDead;
    }

    // Assigns a new value to the field isDead
    public void setIsDead(boolean isDead)
    {
        this.isDead = isDead;
    }

    /*
    Assigns a new value to the field
    predatorWasKilledBy
    */
    public void setPredatorWasKilledBy
        (Predator predatorWasKilledBy)
    {
        this.predatorWasKilledBy 
            = predatorWasKilledBy;
    }

    /*
    Assigns a new value to the field
    survivalFactor
    */
    public void setSurvivalFactor
        (double survivalFactor)
    {
        this.survivalFactor = survivalFactor;
    }

}
