/*
 * review for IB Math
 */

public class Triangle
{
    private double myaA;
    private double mysA;
    private double myaB;
    private double mysB;
    private double myaC;
    private double mysC;
    public Triangle()
    {
        myaA=mysA=myaB=mysB=myaC=mysC = 0.0;
    }

    /*
     *   this method will only be invoke if getNumTriangles() == 2

     *   In the case there are two triangles, this method returns the second (obtuse)
     *   Triangle with ALL sides and Angles properly initialized
     *   
     *   use the orignal data (hint: setSSA)
     *   
     */
    public Triangle getSecondTriangle()
    {
        return new Triangle();
    }
    /*
     * this method may be invoke at any time
     * 
     * hint:  you might want to calculate once, store it and retrive it when asked for
     * 
     *        I make this suggestion because after the missing part of the triangle are calculated
     *        you may no longer have the knowledge of what values were the given values
     *        
     *  I am not saying you have to, I am just saying to think about it first
     */
    public int getNumTriangles()
    {
        return 1;
    }

    /*
     *   calculates all remaining angles and sides for this triangle.
     *   given two angles (angle A and Angle B) and non-included side (side a)
     *   
     *   return true if successful
     *   
     *   returns false if unsuccessful (not sure how this method would be unsuccessful 
     *                 but might be unsuccessful in other similar methods
     *   
     */
    public boolean setAAS(double aA, double aB, double sA)
    {
        myaA = aA;
        myaB = aB;
        mysA = sA;
        
        myaC = Math.PI - aA - aB;
        mysB = mysA * Math.sin(aB)/Math.sin(aA);
        mysC = mysA * Math.sin(myaC)/Math.sin(aA);
        return true;
    }

    /*
     *   calculates all remaining angles and sides for this triangle.
     *   given two angles (angle A and Angle B) and included side (side C)
     *   
     *   return true if successful
     *   
     *   returns false if unsuccessful (not sure how this method would be unsuccessful 
     *                 but might be unsuccessful in other similar methods
     *   
     */
    public boolean setASA(double aA, double sC, double aB)
    {
        myaA = aA;
        myaB = aB;
        mysC = sC;
        
        myaC = Math.PI - aA - aB;
        mysA = mysC * Math.sin(aA)/Math.sin(myaC);
        mysB = mysC * Math.sin(aB)/Math.sin(myaC);
        return true;
    }

    /*
     *   calculates all remaining angles and sides for this triangle.
     *   given two sides (side A and side B) and included angle (side C)
     *   
     *   return true if successful
     *   
     *   returns false if unsuccessful (not sure how this method would be unsuccessful 
     *                 but might be unsuccessful in other similar methods
     *   
     */
    public boolean setSAS(double sA, double aC, double sB)
    {
        mysA = sA;
        mysB = sB;
        myaC = aC;
        
        mysC = Math.sqrt(sA*sA + sB*sB - 2*sA*sB*Math.cos(aC));
        myaA = Math.asin(sA*Math.sin(aC)/mysC);
        myaB = Math.PI - aC - myaA;//Math.asin(sB*Math.sin(aC)/mysC);
        return true;
    }

    /*
     *   calculates all three angles for this triangle.
     *   given all three sides
     *   
     *   return true if successful
     *   
     *   returns false if unsuccessful
     *                 yes it is possible that no triangle may exist with the given sides
     *   
     */
    public boolean setSSS(double sA, double sB, double sC)
    {
        mysA = sA;
        mysB = sB;
        mysC = sC;
        
        myaA = Math.acos((sC*sC - sA*sA - sB*sB)/(2*sA*sB));
        myaB = Math.asin(sB*Math.sin(myaA)/sA);
        myaC = Math.PI - myaA - myaB;
        return true;
    }

    /*
     *   calculates all remaining angles and sides for this triangle.
     *   given two sides (side A and side B) and non-included angle (side C)
     *   
     *   return true if successful
     *   
     *   returns false if unsuccessful
     *                 yes it is possible that no triangle may exist with the given values
     *                 or better yet, two triangles may exist
     *                 
     *                 it two triangles exist, find the triangle with acute angles
     *                 and return true
     *   
     */
    public boolean setSSA(double sA, double sB, double aA)
    {
        mysA = sA;
        mysB = sB;
        myaA = aA;
        
        myaB = Math.asin(sB*Math.sin(aA)/sA);
        myaC = Math.PI - aA - myaB;
        mysC = sA * Math.sin(myaC)/Math.sin(aA);
        return true;
    }

    
    public void setAngleA(double a){
        myaA = a;
    }
    public void setAngleB(double b){
        myaB = b;
    }
    public void setAngleC(double c){
        myaC = c;
    }
    public double getAngleA(){
        return myaA;
    }
    public double getAngleB(){
        return myaB;
    }
    public double getAngleC(){
        return myaC;
    }
    public void setSideA(double a){
        mysA = a;
    }
    public void setSideB(double b){
        mysB = b;
    }
    public void setSideC(double c){
        mysC = c;
    }
    public double getSideA(){
        return mysA;
    }
    public double getSideB(){
        return mysB;
    }
    public double getSideC(){
        return mysC;
    }
    public double getPerimeter(){
        return mysC + mysB + mysA;
    }
    public double getArea()
    {
        double s = (mysA + mysB + mysC)/2.0;
        return Math.sqrt(s*(s-mysA)*(s-mysB)*(s-mysC));
    }
}