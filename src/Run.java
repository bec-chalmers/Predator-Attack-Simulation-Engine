/**
 * The Run class represents a single run
 * of a simulation with a particular level of
 * alpaca protection
 *
 * Each run has a farm, a group of alpaca guards,
 * a total cost, and a number of dead sheep,
 * lambs and alpacas
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

import java.util.ArrayList;

public class Run
{

    private Farm farm;
    private ArrayList<Alpaca> alpacaGuards;
    private double totalCost;
    private double deadSheepCount;
    private double deadLambCount;
    private double deadAlpacaCount;

    /*
    Initialises the farm,  alpacaGuards, totalCost, deadSheepCount, 
    deadLambCount, and deadAlpacaCount fields to default values
    */
    public Run()
    {
        farm = new Farm();
        alpacaGuards = new ArrayList<>();
        totalCost = 0.00;
        deadSheepCount = 0;
        deadLambCount = 0;
        deadAlpacaCount = 0;
    }

    /*
    Initialises the farm and alpacaGuards fields to parameter values
    */
    public Run(Farm farm, int numberOfAlpacas)
    {
        this.farm = farm;
        this.alpacaGuards = new ArrayList<>();

        for (int i = 0; i < numberOfAlpacas; i++)
        {
            alpacaGuards.add(new Alpaca());
        }

        this.totalCost = 0.00;
        this.deadSheepCount = 0;
        this.deadLambCount = 0;
        this.deadAlpacaCount = 0;
    }

    // Calculates the guard factor by the number of alpaca guards
    public double calculateGuardFactor()
    {
        double guardFactor = 1.0;

        for (Alpaca alpaca : alpacaGuards)
        {
            guardFactor = guardFactor / 2;
        }

        return guardFactor;
    }

    // Calculates the randomised hiring cost of all alpaca guards
    public double calculateHiringCosts()
    {
        return alpacaGuards.size() * 500;
    }

    // Calculates the maintenance costs of all alpacas
    public double calculateMaintenanceCosts()
    {
        double totalMaintenanceCost = 0.0;
        RandomNumberGenerator random 
            = new RandomNumberGenerator();

        for (Alpaca alpaca : alpacaGuards)
        {
            double maintenanceCost 
                = random.generateRandomNumber(400.00, 600.00);

            if (alpaca.isDead())
            {
                maintenanceCost = maintenanceCost / 2;
            }

            totalMaintenanceCost = totalMaintenanceCost + maintenanceCost;
        }

        return totalMaintenanceCost;
    }

    // Calculates the total stock lost from animal deaths
    public double calculateTotalStockLoss()
    {
        double stockLoss = 0.00;
        FarmAnimal[] flock = farm.getFlock();

        for (FarmAnimal animal : flock)
        {
            if (animal.isDead())
            {
                stockLoss = stockLoss + animal.getStockValue();
            }
        }

        for (Alpaca alpaca : alpacaGuards)
        {
            if (alpaca.isDead())
            {
                stockLoss = stockLoss + alpaca.getStockValue();
            }
        }

        return stockLoss;
    }

    // Displays the state of the run to the user
    public void display()
    {
        System.out.printf
            ("Number of alpaca guards: %d%n", alpacaGuards.size());
        System.out.printf("Total cost: $%.2f%n", totalCost);
    }

    // Returns the value of the field alpacaGuards
    public ArrayList<Alpaca> getAlpacaGuards()
    {
        return alpacaGuards;
    }

    // Returns the number of dead animals
    public int getAnimalDeathCount(String animalType)
    {
        int count = 0;

        if (animalType.equals("Sheep") || animalType.equals("Lamb"))
        {
            for (FarmAnimal animal : farm.getFlock())
            {
                if (animal.getAnimalType().equals(animalType) 
                    && animal.isDead())
                {
                    count++;
                }
            }
        }
        else if (animalType.equals("Alpaca"))
        {
            for (Alpaca alpaca : alpacaGuards)
            {
                if (alpaca.isDead())
                {
                    count++;
                }
            }
        }

        return count;
    }

    // Returns the number of dead alpacas
    public double getDeadAlpacaCount()
    {
        return deadAlpacaCount;
    }

    // Returns the number of dead lambs
    public double getDeadLambCount()
    {
        return deadLambCount;
    }

    // Returns the number of dead sheep
    public double getDeadSheepCount()
    {
        return deadSheepCount;
    }

    // Returns the value of the farm field
    public Farm getFarm()
    {
        return farm;
    }

    // Returns the value of the totalCost field
    public double getTotalCost()
    {
        return totalCost;
    }

    /*
    Sets a farm animal object's state to a dead farm animal's and adds to 
    their corresponding death count
    */
    public void killAnimal(FarmAnimal animal, Predator predator)
    {
        animal.setIsDead(true);
        animal.setPredatorWasKilledBy(predator);

        if (animal.getAnimalType().equals("Sheep"))
        {
            deadSheepCount++;
        }
        else if (animal.getAnimalType().equals("Lamb"))
        {
            deadLambCount++;
        }
        else if (animal.getAnimalType().equals("Alpaca"))
        {
            deadAlpacaCount++;
        }
    }

    // Resets the state of a farm animal to being alive
    public void resetAnimal(FarmAnimal animal)
    {
        animal.setIsDead(false);
        animal.setPredatorWasKilledBy(null);
    }

    // Assigns a new value to the alpacaGuards field
    public void setAlpacaGuards(ArrayList<Alpaca> alpacaGuards)
    {
        this.alpacaGuards = alpacaGuards;
    }

    // Assigns a new value to the deadAlpacaCount field
    public void setDeadAlpacaCount(double deadAlpacaCount)
    {
        this.deadAlpacaCount = deadAlpacaCount;
    }

    // Assigns a new value to the deadLambCount field
    public void setDeadLambCount(double deadLambCount)
    {
        this.deadLambCount = deadLambCount;
    }

    // Assigns a new value to the deadSheepCount field
    public void setDeadSheepCount(double deadSheepCount)
    {
        this.deadSheepCount = deadSheepCount;
    }

    // Assigns a new value to the farm field
    public void setFarm(Farm farm)
    {
        this.farm = farm;
    }

    // Assigns a new value to the totalCost field
    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }

    // Simulates a year of attacks by a particular predator on sheeps and lambs
    public void simulateAttacks(FarmAnimal animal, Predator[] predators)
    {
        RandomNumberGenerator random = new RandomNumberGenerator();
        double survivalFactor = animal.getSurvivalFactor();

        for (Predator predator : predators)
        {
            double dangerFactor = predator.getDangerFactor() * survivalFactor;
            int numberOfAlpacas = alpacaGuards.size();
            double guardedDangerFactor 
                = dangerFactor / Math.pow(2, numberOfAlpacas);

            if (!animal.isDead())
            {
                double preyFactor = random.generateRandomNumber(0, 1);

                if (preyFactor < survivalFactor * guardedDangerFactor)
                {
                    killAnimal(animal, predator);
                }
            }
        }
    }

    // Simulates a year of attacks by a particular predator on alpacas
    public void simulateAttacks(Alpaca alpaca, Predator[] predators)
    {
        RandomNumberGenerator random = new RandomNumberGenerator();
        double survivalFactor = alpaca.getSurvivalFactor();

        for (Predator predator : predators)
        {
            double dangerFactor = predator.getDangerFactor() * survivalFactor;

            if (!alpaca.isDead())
            {
                double preyFactor = random.generateRandomNumber(0, 1);

                if (preyFactor < dangerFactor)
                {
                    killAnimal(alpaca, predator);
                }
            }
        }
    }

    // Simulates a year of running the farm and calculates the total cost
    public void simulateRun()
    {
        FarmAnimal[] flock = farm.getFlock();
        Predator[] predators = farm.getFarmState().getPredators();
        double stockLoss = 0.00;

        // resets the alpaca and animal objects for each new run
        for (Alpaca alpaca : alpacaGuards)
        {
            resetAnimal(alpaca);
            simulateAttacks(alpaca, predators);
        }

        for (FarmAnimal animal : flock)
        {
            resetAnimal(animal);
            simulateAttacks(animal, predators);
        }

        double totalStockLoss = calculateTotalStockLoss();
        double alpacaHiringCost = calculateHiringCosts();
        double alpacaMaintenanceCost = calculateMaintenanceCosts();

        totalCost = totalStockLoss + alpacaHiringCost + alpacaMaintenanceCost;
    }

}
