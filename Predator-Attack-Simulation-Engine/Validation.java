/**
 * The Validation class is a helper class used
 * for validation of values
 *
 * @ version 1.0
 * @ author Rebecca Chalmers
 */


public class Validation
{

    // Empty default constructor to create a Validation object
    public Validation()
    {

    }

    /*
    Checks if a string input is made up of only 
    alphabetic (and space) characters
    */    
    public static boolean checkAlphabetic(String input)
    {
        if (input == null || input.isBlank())
        {
            return false;
        }

        for (int i = 0; i < input.length(); i++)
        {
            char character = input.charAt(i);

            if (!Character.isLetter(character) && character != ' ')
            {
                return false;
            }
        }

        return true;
    }

    // Checks if a String input is a double
    public static boolean checkDouble(String input)
    {
        try
        {
            Double.parseDouble(input);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    // Checks if a String input is numeric
    public static boolean checkNumeric(String input)
    {
        for (int i = 0; i < input.length(); i++)
        {
            char character = input.charAt(i);

            if (i == 0 && character == '-')
            {

            }
            else if (!Character.isDigit(character))
            {
                return false;
            }
        }
        return true;
    }

    // Checks if an integer value is within a specified range (min-max)
    public static boolean intValueInRange(int value, int min, int max)
    {
        boolean inRange = false;

        if ((value >= min) && (value <= max))
        {
            inRange = true;
        }

        return inRange;
    }

    // Checks if a String is blank
    public static boolean stringIsBlank(String value)
    {
        boolean blank = false;

        if (value.trim().length() == 0)
        {
            blank = true;
        }

        return blank;
    }

    // Checks if the length of a String is above a minimum integer
    public static boolean stringLengthAboveMin(String value, int min)
    {
        boolean inRange = false;

        if (value.trim().length() >= min)
        {
            inRange = true;
        }

        return inRange;
    }

    // Checks if the length of a String is within a specified range (min-max)
    public static boolean stringLengthInRange(String value, int min, int max)
    {
        boolean inRange = false;

        if ((value.trim().length() >= min) && (value.trim().length() <= max))
        {
            inRange = true;
        }

        return inRange;
    }

}
