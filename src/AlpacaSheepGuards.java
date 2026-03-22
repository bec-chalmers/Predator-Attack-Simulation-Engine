/**
 * The AlpacaSheepGuards class manages the
 * running of the program
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

import java.util.ArrayList;

public class AlpacaSheepGuards
{

    /*
    Returns a list of predators who did not
    kill any animals in the given simulation
    */
    public ArrayList<String> 
        calculateHarmlessPredators
        (Simulation simulation)
    {
        String[] predatorNames = {"Fox", 
            "Dingo", "Feral Pig", 
            "Wedge-Tailed Eagle"};
        ArrayList<String> harmlessPredators 
            = new ArrayList<>();

        for (String predatorName : predatorNames)
        {
            double kills = 
                simulation.calculateAverageKills
                (predatorName);

            if (kills == 0)
            {
                harmlessPredators.add
                    (predatorName);
            }
        }

        return harmlessPredators;
    }

    /*
    Returns a list of predators who did not
    kill any animals in the given simulation
    */
    public String 
        calculateMostTroublesomePredator
        (Simulation simulation)
    {
        String[] predatorNames = {"Fox", "Dingo", "Feral Pig", 
            "Wedge-Tailed Eagle"};
        double highestKills = -1.0;
        String mostTroublesomePredator = "";

        for (String predatorName : predatorNames)
        {
            double kills = simulation.
                calculateAverageKills
                (predatorName);

            if (kills > highestKills)
            {
                highestKills = kills;
                mostTroublesomePredator 
                    = predatorName;
            }
        }
        
        return mostTroublesomePredator;
    }

    /*
    Requests farm name, state, number of sheep and number of lambs 
    from user, and creates the farm object
    */
    public Farm createFarm()
    {
        String farmName = requestFarmName();
        State farmState = requestState();
        int numberOfSheep = requestNumberOfAnimal
            ("How many adult sheep are on your farm?: ");
        int numberOfLambs 
            = requestNumberOfAnimal("How many lambs are on your farm?: ");

        boolean proceed = false;

        do
        {
            if (numberOfSheep + numberOfLambs 
                > 100)
            {
                System.out.println
                    ("Error: Total number of sheep and lambs " 
                    + "must be no greater than 100");
                numberOfSheep = requestNumberOfAnimal
                    ("How many adult sheep are on your farm?: ");
                numberOfLambs = requestNumberOfAnimal
                    ("How many lambs are on your farm?: ");
            }
            else if (numberOfSheep + numberOfLambs <= 0)
            {
                System.out.println
                    ("Error: Total number of sheep and lambs " 
                    + "must be greater than 0");
                numberOfSheep = requestNumberOfAnimal
                ("How many adult sheep are on your farm?: ");
                numberOfLambs = requestNumberOfAnimal
                ("How many lambs are on your farm?: ");
            }
            else
            {
                proceed = true;
            }
        }
        while (!proceed);

        Farm userFarm 
            = new Farm(farmName, farmState, numberOfSheep, numberOfLambs);
        return userFarm;
    }

    // Displays a welcome message to the user
    public void displayWelcomeMessage()
    {
        System.out.println("Welcome to the Alpaca Sheep Guard Simulation!");
    }

    // Main method that begins the program
    public static void main(String[] args)
    {
        AlpacaSheepGuards program = new AlpacaSheepGuards();
        program.runProgram();
    }

    /*
    Requests the name of the farm where the simulation will take place
    from the user
    */
    public String requestFarmName()
    {
        Input input = new Input();
        Validation validation = new Validation();
        boolean proceed = false;
        String farmName = "";

        do
        {
            farmName = input.acceptStringInput
                ("What is the name of your farm?: ");

            if (!validation.stringLengthAboveMin(farmName.trim(), 6))
            {
                System.out.println
                    ("Error: Your farm name must be at least 6 characters");
            }
            else
            {
                proceed = true;
            }

        } while (!proceed);

        return farmName;
    }

    /*
    Requests the name of the state where the simulation will take place
    from the user
    */
    public State requestState()
    {
        Input input = new Input();
        StateArrayList stateList = new StateArrayList();
        stateList.createStateArrayList();

        if (stateList.getStateArrayList().isEmpty())
        {
            System.out.println("Error: Unable to load states from file");
        }
        
        State farmState = null;
        boolean proceed = false;

        System.out.println("What state is your farm located in?: ");

        for (int i = 0; i < stateList.getStateArrayList().size(); i++)
        {
            System.out.println
                (stateList.getStateArrayList().get(i).getStateName());
        }

        do
        {
            String stateName = input.acceptStringInput("State: ");
            
            for (int i = 0; i < stateList.getStateArrayList().size(); i++)
            {
                String currentStateName 
                    = stateList.getStateArrayList().get(i).getStateName();

                if (currentStateName.toUpperCase().equals
                    (stateName.toUpperCase()))
                {
                    farmState = stateList.getStateArrayList().get(i);
                    proceed = true;
                }
            }

            if (proceed == false)
            {
                System.out.println("Error: Invalid State");
            }
        }
        while (!proceed);

        return farmState;
    }

    /*
    Requests the number of a certain animal on the user's farm
    */
    public int requestNumberOfAnimal(String prompt)
    {
        Input input = new Input();
        Validation validation = new Validation();
        boolean proceed = false;
        int numberOfAnimal = 0;

        do
        {
            String numberOfAnimalString = input.acceptStringInput(prompt);

            if (!Validation.checkNumeric(numberOfAnimalString))
            {
                System.out.println("Error: Not an integer");
            }
            else if (Validation.stringIsBlank(numberOfAnimalString))
            {
                System.out.println("Error: Input is blank");
            }
            else
            {
                numberOfAnimal = Integer.parseInt(numberOfAnimalString);

                if (!Validation.intValueInRange(numberOfAnimal, 0, 100))
                {
                    System.out.println
                        ("Error: Number must be greater than 0 "
                        + "and no greater than 100");
                }
                else
                {
                    proceed = true;
                }
            }
        }
        while (!proceed);

        return numberOfAnimal;
    }

    // Handles the running of the program
    public void runProgram()
    {
        displayWelcomeMessage();
        Farm farm = createFarm();

        Simulation simulationZero = new Simulation(farm, new Run[10]);
        Simulation simulationOne = new Simulation(farm, new Run[10]);
        Simulation simulationTwo = new Simulation(farm, new Run[10]);

        simulationZero.runSimulation(0);
        simulationOne.runSimulation(1);
        simulationTwo.runSimulation(2);

        // Calculate average costs for each level of alpaca protection
        double averageSimulationZero 
            = simulationZero.calculateAverageTotalCost();
        double averageSimulationOne 
            = simulationOne.calculateAverageTotalCost();
        double averageSimulationTwo 
            = simulationTwo.calculateAverageTotalCost();

        // Find recommended protection level
        int recommendedProtectionLevel = 0;
        double lowestTotalCost = averageSimulationZero;
        Simulation bestSimulation = simulationZero;

        if (averageSimulationOne < lowestTotalCost)
        {
            lowestTotalCost = averageSimulationOne;
            recommendedProtectionLevel = 1;
            bestSimulation = simulationOne;
        }
        if (averageSimulationTwo < lowestTotalCost)
        {
            lowestTotalCost = averageSimulationTwo;
            recommendedProtectionLevel = 2;
            bestSimulation = simulationTwo;
        }

        int numberOfSheep = farm.getNumberOfSheep();
        int numberOfLambs = farm.getNumberOfLambs();

        double sheepDeaths = bestSimulation.calculateAverageDeaths("Sheep");
        double lambDeaths = bestSimulation.calculateAverageDeaths("Lamb");
        double alpacaDeaths = bestSimulation.calculateAverageDeaths("Alpaca");

        double predictedAnimalsLost = sheepDeaths + lambDeaths + alpacaDeaths;

        // Display data
        System.out.println("\n========================");
        System.out.println("End of Simulation Report");
        System.out.println("========================\n");

        System.out.printf("Lowest Average Cost: $%.2f\n", lowestTotalCost);
        System.out.println("Recommended Protection: " 
            + recommendedProtectionLevel + " Alpaca(s)");

        String mostTroublesomePredator 
            = calculateMostTroublesomePredator(bestSimulation);
        System.out.println("    Most Troublesome Predator:\n        " 
            + mostTroublesomePredator);

        ArrayList<String> harmlessPredators 
            = calculateHarmlessPredators(bestSimulation);
        System.out.println("    " + harmlessPredators.size() 
            + " predator(s) that had no kills:");
        
        for (String predatorName : harmlessPredators)
        {
            System.out.println("        " + predatorName);
        }

        // Write report to alpacaSheepGuardViability.txt
        FileIO fileIO = new FileIO();
        fileIO.writeFile(farm, numberOfSheep, numberOfLambs, 
            recommendedProtectionLevel, lowestTotalCost, 
            predictedAnimalsLost, mostTroublesomePredator);
    }

}
