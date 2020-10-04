import java.util.*;
/**
 * @author  J0$h Ibad
 * @version 05/05/2019
 * 
 * J0$hified
 */
public class Circle 
{
    private Point x, y, z;
    private Point center;
    private double radius = -1;
    /**
     * Constructor
     */
    public Circle (Point x, Point y, Point z){
        this.x = x;     this.y = y;     this.z = z;
        if(slope(x,y) == slope(y,z)){
            radius = -1;
            center = null;
        }else{
            double a=2*x.getX(), b=2*x.getY(), c=-1.0;   double d1=x.getX()*x.getX() + x.getY()*x.getY();
            double d=2*y.getX(), e=2*y.getY(), f=-1.0;   double d2=y.getX()*y.getX() + y.getY()*y.getY();
            double g=2*z.getX(), h=2*z.getY(), i=-1.0;   double d3=z.getX()*z.getX() + z.getY()*z.getY();
            
            double detA = det3(a, b, c, d, e, f, g, h, i);
            double A = det3(d1, b, c, d2, e, f, d3, h, i)/detA;
            double B = det3(a, d1, c, d, d2, f, g, d3, i)/detA;
            
            radius = Math.sqrt(A*A + B*B - det3(a, b, d1, d, e, d2, g, h, d3)/detA);
            center = new Point(A, B);
        }
    }

    /**
     * Returns center as calculated in constructor throuhg Craemers Rule
     */
    public Point getCenter()
    {
        return center;
    }

    /**
     * Returns radius as calculated in constructor throuhg Craemers Rule
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * A = PI*R^2
     * returns -1 if no circle exists
     */
    public double getCircleArea()
    {
        if(getRadius() == -1){return -1;}
        return Math.pow(getRadius(), 2)*Math.PI;
    }

    /**
     * C = 2PI*R
     * returns -1 if no circle exists
     */
    public double getCirclePerimeter()
    {
        if(getRadius() == -1){return -1;}
        return 2*Math.PI*getRadius();
    }

    /**
     * Uses Heron's formula
     */
    public double getTriangleArea()
    {
        double a = dist(x,y);
        double b = dist(y,z);
        double c = dist(z,x);
        double s = (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    /**
     * Utilizes distance formula and sums up side lengths
     */
    public double getTrianglePerimeter()
    {
        return dist(x,y) + dist(y,z) + dist(z,x);
    }

    /*
     *    remember, if the circle is centered at the origin, set phi to zero
     */
    public PolarEquation getPolarEquation()
    {
        double x = center.getX();
        double y = center.getY();
        double phi = Math.atan2(y,x);
        if(phi < 0)
            phi += Math.PI*2;
        if(x==0 && y==0)
            phi = 0;
        return new PolarEquation(radius, Math.sqrt(x*x + y*y), phi);
    }

    
    
    public double slope(Point x, Point y){
        return (x.getY()-y.getY())/(x.getX()-y.getX());
    }
    public double det3(double a, double b, double c, double d, double e, double f, double g, double h, double i){
        return a*(e*i-f*h)-b*(d*i-f*g)+c*(d*h-e*g);
    }
    public double dist(Point x, Point y){
        double deltaX = x.getX()-y.getX();
        double deltaY = x.getY()-y.getY();
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }
}