/**
 * The Simulation class represents a single
 * simulation of a farm with a particular
 * level of alpaca protection
 * 
 * Each Simulation has a farm and a collection
 * of runs

 * @ version 1.0
 * @ author Rebecca Chalmers
 */


import java.util.ArrayList;

public class Simulation
{

    private Farm farm;
    private Run[] runs;

    // Initialises the farm and runs fields to default values
    public Simulation()
    {
        farm = new Farm();
        runs = new Run[10];
    }

    // Initialises the farm and runs fields to parameter values
    public Simulation(Farm farm, Run[] runs)
    {
        this.farm = farm;
        this.runs = runs;
    }

    // Calculates the average deaths for a particular animal in a single Run
    public double calculateAverageDeaths(String animalType)
    {
        double sum = 0.0;

        for (Run run : runs)
        {
            sum = sum + run.getAnimalDeathCount(animalType);
        }

        return sum / runs.length;
    }

    // Calculates the average kills of a predator across runs
    public double calculateAverageKills(String predatorName)
    {
        double totalKills = 0.0;

        for (Run run : runs)
        {
            FarmAnimal[] flock = run.getFarm().getFlock();
            
            for (FarmAnimal animal : flock)
            {
                Predator predator = animal.getPredatorWasKilledBy();

                if (animal.isDead() 
                    && predator!= null 
                    && predator.getAnimalType().equals(predatorName))
                {
                    totalKills++;
                }
            }

            ArrayList<Alpaca> alpacas = run.getAlpacaGuards();

            for (Alpaca alpaca : alpacas)
            {
                Predator predator = alpaca.getPredatorWasKilledBy();
                
                if (alpaca.isDead() 
                    && predator!= null 
                    && predator.getAnimalType().equals(predatorName))
                {
                    totalKills++;
                }
            }
        }

        double averageKills = totalKills / (double) runs.length;
        return averageKills;
    }

    // Calculates the average total cost across runs
    public double calculateAverageTotalCost()
    {
        double sum = 0.0;

        for (Run run : runs)
        {
            sum = sum + run.getTotalCost();
        }

        double averageTotalCost = sum / (double) runs.length;
        return averageTotalCost;
    }

    // Calculates the highest total cost across runs
    public double calculateHighestTotalCost()
    {
        double highestTotalCost = runs[0].getTotalCost();

        for (Run run : runs)
        {
            if (run.getTotalCost() > highestTotalCost)
            {
                highestTotalCost = run.getTotalCost();
            }
        }

        return highestTotalCost;
    }

    // Calculates the lowest total cost across runs
    public double calculateLowestTotalCost()
    {
        double lowestTotalCost = runs[0].getTotalCost();

        for (Run run : runs)
        {
            if (run.getTotalCost() < lowestTotalCost)
            {
                lowestTotalCost = run.getTotalCost();
            }
        }

        return lowestTotalCost;
    }

    // Displays the simulation data to the user
    public void display(double averageTotalCost, double lowestTotalCost, 
        double highestTotalCost, double averageTotalSheepLost, 
        double averageTotalLambsLost, double averageTotalAlpacasLost, 
        double averageFoxKills, double averageDingoKills, 
        double averagePigKills, double averageEagleKills, int numberOfAlpacas)
    {
        System.out.printf("\n* Running simulation with " + numberOfAlpacas 
            + " alpacas\n");
        System.out.printf("    Lowest cost:  $%5.2f%n", lowestTotalCost);
        System.out.printf("    Highest cost: $%5.2f%n", highestTotalCost);
        System.out.printf("    Average cost: $%5.2f%n", averageTotalCost);
        
        System.out.printf("\n    Average number of animals lost:\n");
        System.out.printf("        Sheep:    %8.2f%n", averageTotalSheepLost);
        System.out.printf("        Lambs:    %8.2f%n", averageTotalLambsLost);
        System.out.printf("        Alpacas:  %8.2f%n", 
            averageTotalAlpacasLost);

        System.out.printf
            ("    Average number of animals killed by each predator:\n");
        System.out.printf("        Fox:      %8.2f%n", averageFoxKills);
        System.out.printf("        Dingo:    %8.2f%n", averageDingoKills);
        System.out.printf("        Pig:      %8.2f%n", averagePigKills);
        System.out.printf("        Eagle:    %8.2f%n", averageEagleKills);
    }

    // Returns the value of the farm field
    public Farm getFarm()
    {
        return farm;
    }

    // returns the value of the runs field
    public Run[] getRuns()
    {
        return runs;
    }

    // Runs a simulation with 10 runs with a particular number of alpacas
    public void runSimulation(int numberOfAlpacas)
    {
        this.runs = new Run[10];

        for (int i = 0; i < runs.length; i++)
        {
            Run run = new Run(farm, numberOfAlpacas);
            runs[i] = run;
            run.simulateRun();
        }

        double averageTotalCost         = calculateAverageTotalCost();
        double lowestTotalCost          = calculateLowestTotalCost();
        double highestTotalCost         = calculateHighestTotalCost();

        double averageSheepDeaths       = calculateAverageDeaths("Sheep");
        double averageLambDeaths        = calculateAverageDeaths("Lamb");
        double averageAlpacaDeaths      = calculateAverageDeaths("Alpaca");

        double averageFoxKills          = calculateAverageKills("Fox");
        double averageDingoKills        = calculateAverageKills("Dingo");
        double averagePigKills          = calculateAverageKills("Feral Pig");
        double averageEagleKills        
            = calculateAverageKills("Wedge-Tailed Eagle");

        display(averageTotalCost, lowestTotalCost, highestTotalCost, 
            averageSheepDeaths, averageLambDeaths, averageAlpacaDeaths, 
            averageFoxKills, averageDingoKills, averagePigKills, 
            averageEagleKills, numberOfAlpacas);
    }

    // Assigns a new value to the farm field
    public void setFarm(Farm farm)
    {
        this.farm = farm;
    }

    // Assigns a new value to the runs field
    public void setRuns(Run[] runs)
    {
        this.runs = runs;
    }

}
