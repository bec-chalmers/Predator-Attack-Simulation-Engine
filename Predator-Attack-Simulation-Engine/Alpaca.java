/**
 * This class represents an alpaca, used on sheep farms to guard 
 * sheep and lambs from predators
 *
 * Each Alpaca has a flag which tracks if it has died, the predator that 
 * killed it, a stockValue, and a survival factor
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public class Alpaca extends FarmAnimal
{

    /*
    Initialises the isDead, predatorWasKilledBy,
    stockValue, and survivalFactor fields to
    default values
    */
    public Alpaca()
    {
        super(false, null, 1000.00, 0.01);
    }

    /* 
    Returns the type of animal as
    a String (Alpaca)
    */
    @Override
    public String getAnimalType()
    {
        return "Alpaca";
    }

}
