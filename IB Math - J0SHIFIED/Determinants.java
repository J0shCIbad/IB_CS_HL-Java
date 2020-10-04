/**
 * review for IB Math
 * J0SHIFIED
 */

public class Determinants
{
    /**
     *   m is a square matrix of dimension > 1
     *   
     *   returns the determinant of m
     *   
     *   yes, you should not asume all matrices are 3x3, or even 4x4, or even 5x5
     *   you need to prepare for larger determinants, like 7 x 7 matrices
     *   
     *   Oh yea - you should not assume all matrices are square matrices
     *            return 0 if the matrix is not a square matrix
     *   
     *   
     */
    public static double getDeterminant(double[][]  m)
    {
        if(m.length != m[0].length)
            return 0.0;
        if(m.length == 1)
            return m[0][0];
        else{
            double temp = 0;
            for(int i=0; i<m.length; i++){
                double[][] minor = new double[m.length-1][m.length-1];
                int z=0;
                for(int x=0; x<m.length; x++){
                    if(x!=i){
                        for(int y=1; y<m.length; y++)
                            minor[z][y-1] = m[x][y];                        
                        z++;
                    }
                }
                temp += Math.pow(-1.0, i)*m[i][0]*Determinants.getDeterminant(minor);
            }
            return temp;
        }
    }

    public static boolean isSingular(double [][] m)
    {
        return Determinants.getDeterminant(m)==0.0;
    }
    
    public static void pr(double[][] m)
    {
        System.out.print("{");
        for(int i=0; i<m.length; i++){
            System.out.print("{");
            for(int j=0; j<m.length; j++)
                System.out.print(m[i][j] + ", ");
            System.out.println("}");
        }
        System.out.print("}");
    }
}