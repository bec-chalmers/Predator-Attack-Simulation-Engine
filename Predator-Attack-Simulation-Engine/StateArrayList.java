/**
 * The StateArrayList class is a helper class
 * which stores the states read from a file
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */


import java.util.ArrayList;
import java.io.*;

public class StateArrayList
{

    private ArrayList<State> stateArrayList;

    // Initialises the stateArrayList field to default value
    public StateArrayList()
    {
        stateArrayList = new ArrayList<>();
    }

    // Initialises the stateArrayList field to parameter value
    public StateArrayList(ArrayList<State> stateArrayList)
    {
        this.stateArrayList = stateArrayList;
    }

    // Reads from a file and creates an arraylist of states
    public void createStateArrayList()
    {
        FileIO fileIO = new FileIO();
        try
        {
            fileIO.readFile();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
        catch (IOException e)
        {
            System.out.println("Error: Cannot read file");
        }
        stateArrayList = fileIO.getStates();
    }

    // Displays the stateArrayList to the user
    public void display()
    {
        for (State state : stateArrayList)
        {
            System.out.println("\nStates read from file:");
            state.display();
        }
    }

    // Returns the stateArrayList to the user
    public ArrayList<State> getStateArrayList()
    {
        return stateArrayList;
    }

    // Assigns a new value to the stateArrayList
    public void setStateArrayList(ArrayList<State> stateArrayList)
    {
        this.stateArrayList = stateArrayList;
    }

}
