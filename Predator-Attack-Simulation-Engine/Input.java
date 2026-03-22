/**
 * The Input class is a helper class for
 * receiving input through the console
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

import java.util.Scanner;

public class Input
{

    // Initialises the Scanner class object
    public void Input()
    {
        Scanner console = new Scanner(System.in);
    }

    /*
    Prompts user for input and returns the
    character at a specified index in the input
    String
    */
    public char acceptCharInput(String msg, int index)
    {
        String input = acceptStringInput(msg);
        return input.charAt(index);
    }

    /*
    Prompts user for input and returns
    input as a double value
    */
    public double acceptDoubleInput(String msg)
    {
        String input = acceptStringInput(msg);
        return Double.parseDouble(input);
    }

    /*
    Prompts user for input and returns
    input as an int value
    */
    public int acceptIntegerInput(String msg)
    {
        String input = acceptStringInput(msg);
        int number = Integer.parseInt(input);
        return number;
    }

    /*
    Prompts user for input and returns
    input as a String value
    */
    public String acceptStringInput(String msg)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        String input = scanner.nextLine().trim();
        return input;
    }

}
