
/**
 * Write a description of class PrimeFactor here.
 * 
 * @author Mr. Allen
 * @version (a version number or a date)
 */
public class PrimeFactor
{
    private int value;
    private int exponent;

    /**
     * Constructor for objects of class PrimeFactor
     */
    public PrimeFactor(int v, int exp)
    {
       value = v;
       exponent = exp;
    }

    public int getExponent()
    {
       return exponent;
    }

    public int getValue()
    {
       return value;
    }

    public int hashCode()
    {
       return value + exponent;
    }

    public boolean equals(Object obj)
    {
       PrimeFactor temp = (PrimeFactor)obj;
       
       return value == temp.getValue() && exponent == temp.getExponent();
    }

    /*
     *   This method is not tested
     */
    public String toString()
    {
       return value + "" + exponent;
    }
}