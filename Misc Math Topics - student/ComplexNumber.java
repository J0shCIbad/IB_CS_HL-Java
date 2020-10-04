import java.util.*;
/**
 * Write a description of class ComplexNumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComplexNumber
{
    /*
     *    OK - I strated this one for you, but feel free to change instance variable and the constructor is you want. 
     * 
     *
     *    Once again, all calcuulations are in radians unless otherwise stated
     *    
     *    all values with 0.05 of zero may be assumed to be zero
     */
    private double a;    // real part
    private double b;    // imaginary part

    /*
     * Constructor for objects of class ComplexNumber given the complex number in the form:  a + bi
     * 
     *    a = real part
     *    b = imaginary part
     */
    public ComplexNumber(double realPart, double imaginaryPart)
    {
        a = realPart;
        b = imaginaryPart;
    }

    /*
     * Constructor for objects of class ComplexNumber given the number in trig form:  z = r(cos(t) + i sin(t))
     *    note; r may be negative, but t >=0
     * 
     *    trigForm[0] = magnitude   (r)
     *    trigForm[1] = angle       (t)
     *    
     *    note:  r and t must be both be converted to postive values
     */
    public ComplexNumber(double[] trigForm)
    {
        a = trigForm[0]*Math.cos(trigForm[1]);
        b = trigForm[0]*Math.sin(trigForm[1]);
    }

    /*
     * @return     the real part of the complex number
     */
    public  double getRealPart()
    {
        return a;
    }

    /*
     * @return     the imaginary part of the complex number
     */
    public  double getImaginaryPart()
    {
        return b;
    }

    /*
     *       set the real part of the complex number to x
     */
    public  void setRealPart(double x)
    {
        a = x;
    }

    /*
     *       set the imaginary part of the complex number to y
     */
    public  void setImaginaryPart(double y)
    {
        a = y;
    }

    /*
     *    converts the current complex number (this) in a + bi form to its trig form equivalence a + bi = |z|(cos(t) + i sin(t))
     *    
     *    @retuns  a two item array with arr[0] = magnitude if complex number (z)
     *                              and  arr[1] = the angle (t)
     *
     *    Yes, I think the only difficult part will be to determine which quadrant (to add Math.PI || !)
     */   
    public double[] convertToTrigForm()
    {
        double[] ans = new double[2];
        ans[0] = Math.sqrt(a*a + b*b);
        double phi = Math.atan(b/a);
        ans[1] = Math.atan2(b , a);
        /*
        if(b>=0){
            if(a>=0)
                ans[1] = phi;
            else
                ans[1] = Math.PI - phi;
        }else{
            if(a>=0){
                ans[1] = Math.PI + phi;
            }else{
                ans[1] = 2*Math.PI - phi;
            }
        }*/
        return ans;
    }

    /*
     *    converts the current complex number (this) in a + bi form to its trig form equivalence a + bi = |z|(cos(t) + i sin(t))
     *    and raises it to an integer (n) power  (think De Moivre formula)
     *    
     *    @retuns  a two item array with arr[0] = magnitude if complex number (z)
     *                              and  arr[1] = the angle (t), 0 <= t < 2*Math.PI
     *
     */   
    public double[] pow(int n)
    {
        double[] ans = convertToTrigForm();
        ans[0] = Math.pow(ans[0], n);
        ans[1] *= n;
        return ans;
    }

    /*
     *    converts the current complex number (this) in a + bi form to its trig form equivalence a + bi = |z|(cos(t) + i sin(t))
     *    and returns all n-th (n an integer) roots  (once again, think De Moivre formula)
     *    
     *    @returns  an ArrayList of  Complex Numbers
     *
     *    note:  the ArrayList should contain n Complex Number
     *
     */   
    public ArrayList<ComplexNumber> nthRoot(int n)
    {
        ArrayList<ComplexNumber> ans = new ArrayList<ComplexNumber>();
        double[] temp = convertToTrigForm();
        temp[0] = Math.pow(temp[0], 1.0/n);
        temp[1] /= n;
        double interval = 2*Math.PI/n;
        for(int i=0; i<n; i++)
        {
            ans.add(new ComplexNumber(temp[0] * Math.cos(temp[1] + interval*i), temp[0] * Math.sin(temp[1] + interval*i)));
        }
        return ans;
    }

    /*
     *    @returns  true if the real and imaginary values are close enough  (say within 0.02)
     *
     */   
    public boolean equals(Object obj)
    {
        ComplexNumber cn = (ComplexNumber)obj;
        double x = Math.abs(a-cn.getRealPart());
        double y = Math.abs(b-cn.getImaginaryPart());
        return x<0.02 && y<0.02;
    }
}