/**
 * The FileIO class is a helper class
 * which handles input and output from/to files
 * 
 * Each FileIO class has states (read from File),
 * and the name of the file to be read from
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

import java.util.*;
import java.io.*;

public class FileIO
{

    private ArrayList<State> states;
    private final static String FILENAME = "predators.txt";

    // Initialises the states field to default values
    public FileIO()
    {
        states = new ArrayList<>();
    }

    // Inititalises the states field to parameter values
    public FileIO(ArrayList<State> states)
    {
        this.states = states;
    }

    /*
    Displays the values of the states field
    to the user
    */
    public void display()
    {
        for (State state : states)
        {
            state.display();
        }
    }

    // Returns the value of the field states
    public ArrayList<State> getStates()
    {
        return states;
    }

    /*
    Reads states and the danger factors of
    predators in that state from a file
    */
    public void readFile() throws FileNotFoundException, IOException
    {
        FileReader reader = new FileReader(FILENAME);

        try
        {
            Scanner scanner = new Scanner(reader);
            int counter = 0;

            while(scanner.hasNextLine())
            {
                counter++;
                String line = scanner.nextLine();
                String[] lineContents = line.split(",");

                String stateName                = lineContents[0];
                String foxDangerFactorString    = lineContents[1];
                String dingoDangerFactorString  = lineContents[2];
                String pigDangerFactorString    = lineContents[3];
                String eagleDangerFactorString  = lineContents[4];

                if (!Validation.checkAlphabetic(stateName))
                {
                    System.out.println("Error on line " + counter 
                        + ": 'State Name' must contain letters "
                        + "and spaces only");
                    continue;
                }

                if (!Validation.checkDouble(foxDangerFactorString))
                {
                    System.out.println("Error on line " + counter 
                        + ": 'Fox Danger Factor' must be a numeric character");
                    continue;
                }
                    
                if (!Validation.checkDouble(dingoDangerFactorString))
                {
                    System.out.println("Error on line " + counter 
                        + ": 'Dingo Danger Factor' " 
                        + "must be a numeric character");
                    continue;
                }

                if (!Validation.checkDouble(pigDangerFactorString))
                {
                    System.out.println("Error on line " + counter 
                        + ": 'Feral Pig Danger Factor' must be a numeric "
                        + "character");
                    continue;
                }
                    
                if (!Validation.checkDouble(eagleDangerFactorString))
                {
                    System.out.println("Error on line " + counter 
                        + ": 'Wedge-Tailed Eagle Danger Factor' must be a " 
                        + "numeric character");
                    continue;
                }

                double foxDangerFactor      
                    = Double.parseDouble(foxDangerFactorString);
                double dingoDangerFactor    
                    = Double.parseDouble(dingoDangerFactorString);
                double pigDangerFactor      
                    = Double.parseDouble(pigDangerFactorString);
                double eagleDangerFactor    
                    = Double.parseDouble(eagleDangerFactorString);
                
                State state = new State();
                
                state.getFox().setDangerFactor(foxDangerFactor);
                state.getDingo().setDangerFactor(dingoDangerFactor);
                state.getPig().setDangerFactor(pigDangerFactor);
                state.getEagle().setDangerFactor(eagleDangerFactor);

                Predator[] predators = new Predator[4];

                predators[0] = state.getFox();
                predators[1] = state.getDingo();
                predators[2] = state.getPig();
                predators[3] = state.getEagle();

                state.setStateName(stateName);
                state.setPredators(predators);
                states.add(state);
            }
        }
        finally
        {
            reader.close();
        }
    }

    // Assigns a new value to the states field
    public void setStates(ArrayList<State> states)
    {
        this.states = states;
    }

    /*
    Writes an Alpaca Sheep guard Viability
    Report to a file
    */
    public void writeFile(Farm farm, int numberOfSheep, int numberOfLambs, 
        int recommendedProtectionLevel, double lowestTotalCost, 
        double predictedAnimalsLost, String mostTroublesomePredator)
    {
        final String filename = "alpacaSheepGuardViability.txt";

        try (FileWriter writer = new FileWriter(filename))
        {
            writer.write("Alpaca Sheep Guard Viability Report\n");
            writer.write("-----------------------------------\n");
            writer.write("Farm Name: " + farm.getFarmName() + "\n");
            writer.write("Number of Sheep: " + numberOfSheep + "\n");
            writer.write("Number of Lambs: " + numberOfLambs + "\n");
            writer.write("Recommended Protection Level: " 
                + recommendedProtectionLevel + "\n");
            writer.write("Total Cost for Recommended " 
                + "Protection Level: $%.2f\n" 
                + lowestTotalCost + "\n");
            writer.write("Predicted Total Deaths: $%.2f\n" 
                + predictedAnimalsLost + "\n");
            writer.write("Most Troublesome Predator: " 
                + mostTroublesomePredator + "\n");
        }
        catch (IOException e)
        {
            System.out.println("Error writing " 
                + "to alpacaSheepGuardViability.txt: " + e.getMessage());
        }
    }

}
