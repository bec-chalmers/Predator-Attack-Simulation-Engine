/**
 * The RandomNumberGenerator class is a helper
 * class used for generating random numbers
 * 
 * @ version 1.0
 * @ author Rebecca Chalmers
 */

public class RandomNumberGenerator
{

    private double minimum;
    private double maximum;

    public RandomNumberGenerator()
    {
        minimum = 0.0;
        maximum = 1.0;
    }

    public RandomNumberGenerator(double minimum, double maximum)
    {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public void display()
    {
        System.out.println("Generating a number between " 
            + minimum + " and " + maximum);
    }

    public double generateRandomNumber(double minimum, double maximum)
    {
        return (Math.random() * (maximum - minimum)) + minimum;
    }

    public double getMaximum()
    {
        return maximum;
    }

    public double getMinimum()
    {
        return minimum;
    }

    public void setMaximum(double maximum)
    {
        this.maximum = maximum;
    }

    public void setMinimum(double minimum)
    {
        this.minimum = minimum;
    }

}
