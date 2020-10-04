
/**
 * @author  J0$h Ibad
 * @version 05/05/2019
 * 
 * J0$hified
 */
public class PolarEquation
{
    private double radius;
    private double distanceCenterToOrigin;
    private double phi;
    
    /**
     * Constructor for objects of class PolarEquation
     */
    public PolarEquation(double r, double d, double angle)
    {
       radius = r;
       distanceCenterToOrigin = d;
       phi = angle;
    }

    public double getA()
    {
        return radius;
    }

    public double getRo()
    {
        return distanceCenterToOrigin;
    }

    public double getPhi()
    {
        return phi;
    }
}