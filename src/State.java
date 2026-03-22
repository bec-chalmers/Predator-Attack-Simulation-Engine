/**
* Represents a state in Australia
*
* Each state has a name (stateName), 
* and a collection of predators (predators)
* 
* @ version 1.0
* @ author Rebecca Chalmers
*/

public class State
{

    private String stateName;
    private Predator[] predators;
    private final Predator FOX = new Predator("Fox", 0.0);
    private final Predator DINGO = new Predator("Dingo", 0.0);
    private final Predator PIG = new Predator("Feral Pig", 0.0);
    private final Predator EAGLE = new Predator("Wedge-Tailed Eagle", 0.0);

    // Initialises the stateName and predators fields to default values
    public State()
    {
        stateName = "Unknown";
        predators = new Predator[4];
    }

    // Initialises the stateName and predators fields to parameter values
    public State(String stateName, Predator[] predators)
    {
        this.stateName = stateName;
        this.predators = predators;
    }

    // Displays the state of the State object to the user
    public void display()
    {
        System.out.println("State: " + stateName);
        
        if (predators != null && predators.length != 0)
        {
            for (int i = 0; i < predators.length; i++)
            {
                predators[i].display();
            }
        }
        else
        {
            System.out.println("No predators found.");
        }
    }

    // Returns the dingo predator in predators
    public Predator getDingo()
    {
        return DINGO;
    }

    // Returns the eagle predator in predators
    public Predator getEagle()
    {
        return EAGLE;
    }

    // Returns the fox predator in predators
    public Predator getFox()
    {
        return FOX;
    }

    // Returns the pig predator in predators
    public Predator getPig()
    {
        return PIG;
    }

    // Returns the value of the field predators
    public Predator[] getPredators()
    {
        return predators;
    }

    // Returns the value of the field stateName
    public String getStateName()
    {
        return stateName;
    }

    // Assigns a new value to the field predators
    public void setPredators(Predator[] predators)
    {
        this.predators = predators;
    }

    // Assigns a new value to the field stateName
    public void setStateName(String stateName)
    {
        this.stateName = stateName;
    }

}
