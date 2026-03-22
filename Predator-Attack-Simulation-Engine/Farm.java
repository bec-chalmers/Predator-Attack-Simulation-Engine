/**
 * This class represents a sheep farm in 
 * Australia.
 * 
 * Each farm has a name, the state in which 
 * it is located, and a flock of farm animals
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public class Farm
{

    private String farmName;
    private State farmState;
    private FarmAnimal[] flock;

    /*
    Initialises the farmName, farmState,
    and flock to default values
    */
    public Farm()
    {
        farmName = "Unknown";
        farmState = new State();
        flock = new FarmAnimal[0];
    }

    /*
    Initialises the farmName, farmState,
    and flock to parameter values
    */
    public Farm
        (String farmName, State farmState, 
        int numberOfSheep, int numberOfLambs)
    {
        this.farmName = farmName;
        this.farmState = farmState;

        this.flock = new FarmAnimal[numberOfSheep + numberOfLambs];
        int counter = 0;

        for (int i = 0; i < numberOfSheep; i++)
        {
            flock[counter] = new Sheep();
            counter++;
        }

        for (int i = 0; i < numberOfLambs; i++)
        {
            flock[counter] = new Lamb();
            counter++;
        }
    }

    // Calculates the total number of sheep and lambs on the farm
    public int calculateTotalFlockSize()
    {
        return flock.length;
    }

    // Displays the state of the Farm object to the user
    public void display()
    {
        int sheepCount = 0;
        int lambCount = 0;

        for (FarmAnimal animal : flock)
        {
            if (animal.getAnimalType().equals("Sheep"))
            {
                sheepCount++;
            }
            else if (animal.getAnimalType().equals("Lamb"))
            {
                lambCount++;
            }
        }

        System.out.println("Farm name: " + farmName);
        System.out.println(", Farm located in: " + farmState.getStateName());
        System.out.println(", Number of adult sheep: " + sheepCount);
        System.out.println(", Number of lambs: " + lambCount);
    }

    // Returns the value of the field farmName
    public String getFarmName()
    {
        return farmName;
    }

    // Returns the value of the field farmState
    public State getFarmState()
    {
        return farmState;
    }

    // Returns the array value of the field flock
    public FarmAnimal[] getFlock()
    {
        return flock;
    }

    // Returns the number of lambs in the flock
    public int getNumberOfLambs()
    {
        int count = 0;

        for (FarmAnimal animal : flock)
        {
            if (animal.getAnimalType().equals("Lamb"))
            {
                count++;
            }
        }

        return count;
    }

    // Returns the number of sheep in the flock
    public int getNumberOfSheep()
    {
        int count = 0;

        for (FarmAnimal animal : flock)
        {
            if (animal.getAnimalType().equals("Sheep"))
            {
                count++;
            }
        }

        return count;
    }

    /*
    Checks if the total size of the flock of sheep is valid 
    (between 0-100 sheep/lambs)
    */
    public boolean isValidFlockSize()
    {
        int totalFlockSize = calculateTotalFlockSize();

        return Validation.intValueInRange(totalFlockSize, 1, 100);
    }

    // Assigns a new value to the field flock
    public void setFlock(FarmAnimal[] flock)
    {
        this.flock = flock;
    }

    // Assigns a new value to the field farmName
    public void setFarmName(String farmName)
    {
        this.farmName = farmName;
    }

    // Assigns a new value to the field farmState
    public void setFarmState(State farmState)
    {
        this.farmState = farmState;
    }

}
