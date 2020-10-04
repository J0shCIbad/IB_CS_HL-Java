/*
 * review for IB Math
 * 
 * JOSHIFIED
 */

public class Triangle
{
    public double a;
    public double b;
    public double c;
    public double A;
    public double B;
    public double C;
    
    public double altB;
    public double altC;
    public double altc;
    public int numTris;
    /** 
     * Constructor
     */
    public Triangle()
    {
        a=b=c=A=B=C =altB=altC=altc = 0.0;
        numTris = 1;
    }

    /**
     *   this method will only be invoke if getNumTriangles() == 2

     *   In the case there are two triangles, this method returns the second (obtuse)
     *   Triangle with ALL sides and Angles properly initialized
     *   
     *   use the orignal data (hint: setSSA)
     *   
     */
    public Triangle getSecondTriangle()
    {
        Triangle altTri = new Triangle();
        altTri.a = a;       altTri.b = b;       altTri.A = A;
        altTri.c = altc;    altTri.B = altB;    altTri.C = altC;
        return altTri;
    }

    /**
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
        return numTris;
    }

    /**
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
        A = aA;     B = aB;     a = sA;
        
        C = Math.PI - A - B;
        b = a*Math.sin(B)/Math.sin(A);
        c = a*Math.sin(C)/Math.sin(A);
        
        numTris = 1;
        return true;
    }

    /**
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
        A = aA;     c = sC;     B = aB;

        C = Math.PI - A - B;
        a = c*Math.sin(A)/Math.sin(C);
        b = c*Math.sin(B)/Math.sin(C);
        
        numTris = 1;
        return true;
    }

    /**
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
        a = sA;     C = aC;     b = sB;

        c = Math.sqrt(a*a + b*b - 2*a*b*Math.cos(C));
        if(a<b){
            A = Math.asin(a*Math.sin(C)/c);
            B = Math.PI - A - C;
        }else{
            B = Math.asin(b*Math.sin(C)/c);
            A = Math.PI - B - C;
        }
        
        numTris = 1;
        return true;
    }

    /**
     *   calculates all three angles for this triangle.
     *   given all three sides
     *   
     *   return true if successful
     *   
     *   returns false if unsuccessful
     **                 yes it is possible that no triangle may exist with the given sides
     *   
     */
    public boolean setSSS(double sA, double sB, double sC)
    {
        a = sA;     b = sB;     c = sC;
        if(a>b+c || b>a+c || c>a+b){
            numTris = 0;
            return false;
        }
            
        A = Math.acos((c*c + b*b - a*a)/(2*c*b));
        B = Math.acos((a*a + c*c - b*b)/(2*a*c));
        C = Math.PI - A - B;
        
        numTris = 1;
        return true;
    }

    /**
     *   calculates all remaining angles and sides for this triangle.
     *   given two sides (side A and side B) and non-included angle (side C)
     *   
     *   return true if successful
     *   
     *   returns false if unsuccessful
     **                 yes it is possible that no triangle may exist with the given values
     *                 or better yet, two triangles may exist
     *                 
     *                 it two triangles exist, find the triangle with acute angles
     *                 and return true
     *                 
     *                 TWO TRIANGLES POSSIBLE
     *   
     */
    public boolean setSSA(double sA, double sB, double aA)
    {
        a = sA;     b = sB;     A = aA;

        double interB = b*Math.sin(A)/a;
        if(interB > 1){
            numTris = 0;
            return false;
        }
        B = Math.asin(interB);
        C = Math.PI - A - B;
        c = a*Math.sin(C)/Math.sin(A);
        if((A - B)>0){
            numTris = 1;
        }else{
            altB = Math.PI - B;
            altC = B - A;
            altc = a*Math.sin(altC)/Math.sin(A);
            
            numTris = 2;
        }
        return true;
    }

    public void setAngleA(double a){A=a;}
    public void setAngleB(double b){B=b;}
    public void setAngleC(double c){C=c;}
    public double getAngleA(){return A;}
    public double getAngleB(){return B;}
    public double getAngleC(){return C;}
    public void setSideA(double a){this.a = a;}
    public void setSideB(double b){this.b = b;}
    public void setSideC(double c){this.c = c;}
    public double getSideA(){return a;}
    public double getSideB(){return b;}
    public double getSideC(){return c;}

    public double getPerimeter(){return a+b+c;}

    /**
     * Area using Heron's formula
     */
    public double getArea()
    {
        double s = (a + b + c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}