/**
 * This class represents a sheep on a sheep
 * farm in Australia
 * 
 * Each Sheep has a flag which tracks if it has
 * died, the predator that killed it,
 * a stockValue, and a survival factor

 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public class Sheep extends FarmAnimal
{

    /*
    Initialises the isDead, predatorWasKilledBy,
    stockValue, and survivalFactor fields to
    default values
    */
    public Sheep()
    {
        super(false, null, 150.00, 1.0);
    }

    /* 
    Returns the type of animal as
    a String (Sheep)
    */
    @Override
    public String getAnimalType()
    {
        return "Sheep";
    }

}
