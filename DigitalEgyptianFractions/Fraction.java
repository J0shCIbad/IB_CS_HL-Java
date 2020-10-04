//  all values will be less than or equal to 1.

import java.util.*;
/**
 * Josh Ibad
 * September 15, 2018
 */
public class Fraction implements Comparable<Fraction>
{
    private int top;
    private int bottom;

    public Fraction(int t, int b)
    {
        top = t;
        bottom = b;
    }

    /*
     * returns
     *       a value less than 0 if this < f
     *       0 if f == this
     *       a value greater than 0 if this > f
     */
    public int compareTo(Fraction f)
    {
        double dou = getDecimal()-f.getDecimal();
        if(dou == 0) return 0;
        if(dou<0) return -1;
        else return 1;
    }

    /*
     * returns the numerator of this fraction
     */
    public void setTop(int t)
    {
        top = t;
    }

    /*
     * returns the denominator of this fraction
     */
    public void setBottom(int b)
    {
        bottom = b;
    }

    /*
     * returns the numerator of this fraction
     */
    public int getTop()
    {
        return top;
    }

    /*
     * returns the denominator of this fraction
     */
    public int getBottom()
    {
        return bottom;
    }

    /*
     * returns the decimal value this fraction (i.e., numerator / denominator
     */
    public double getDecimal()
    {
        return ((double)top)/bottom;
    }

    /*
     * A static method
     * returns the simplified fraction computed by summing all fractions
     *         in it List parameter fs
     */
    public static Fraction addAllFractionsInList(List<Fraction> fs)
    {
        Fraction ans = new Fraction(0,1);
        for(int i=0; i<fs.size(); i++)
        {
            ans.add(fs.get(i));
        }
        return ans;
    }

    /*
     * modifies this by subtracting the parameter f from it
     */
    public void subtract(Fraction f)
    {
        top = top*f.getBottom() - f.getTop()*bottom;
        bottom *= f.getBottom();
        simplify();
    }

    /*
     * modifies this by adding the parameter f to it
     */
    public void add(Fraction f)
    {
        top = top*f.getBottom() + f.getTop()*bottom;
        bottom *= f.getBottom();
        simplify();
    }

    /*
     * modifies this by multipling it by the parameter f
     */
    public void multiply(Fraction f)
    {
        top *= f.getTop();
        bottom *= f.getBottom();
        simplify();
    }

    /*
     * returns true if the the two objects are equal.
     *         You may assume both Fractions are in simplest form
     */
    public boolean equals(Object obj)
    {
        return getDecimal()==((Fraction)obj).getDecimal();
    }

    /*
     * returns a string in the form
     * 
     *              "numerator / denominator"
     *         there is exactly one space on both sides of /
     *         no space infront of the numerator and no spaces after the denominator
     */
    public String toString()
    {
        return top + " / " + bottom;
    }

    
    public void simplify()
    {
        int gcd = gcd(getTop(), getBottom());
        setBottom(getBottom()/gcd);
        setTop(getTop()/gcd);
    }
    
    public int gcd(int a, int b)
    {
        if(b>a)
        {
            int temp = a;
            a=b;
            b=temp;
        }
        while(b!=0)
        {
            int t=b;
            b = a%b;
            a=t;
        }
        return a;
    }
}