/**
 * This class represents a lamb on a sheep
 * farm in Australia
 *
 * Each Alpaca has a flag which tracks if it has
 * died, the predator that killed it, a stockValue,
 * and a survival factor
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public class Lamb extends FarmAnimal
{

    /*
    Initialises the isDead, predatorWasKilledBy,
    stockValue, and survivalFactor fields to
    default values
    */
    public Lamb()
    {
        super(false, null, 250.00, 2.0);
    }

    /* 
    Returns the type of animal as
    a String (Lamb)
    */
    @Override
    public String getAnimalType()
    {
        return "Lamb";
    }

}
