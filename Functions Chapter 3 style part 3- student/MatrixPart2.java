
/**
 * Write a description of class Matrix here.
 * 
 * need Matrix operations
 * 
 * @author Don Allen
 * @version March 2011
 */
public class MatrixPart2
{
    /*
     *     preCondition:  m.length == n.length
     *                    m[i].length == n[i].length, 0 <= i < m.length
     */
    public static boolean haveSameNonZeros(int[][] m, int[][] n)
    {
        for(int r=0; r<m.length; r++){
            for(int c=0; c<m[1].length; c++){
                if(m[r][c] != n[r][c] && (m[r][c] == 0 || n[r][c] == 0))
                    return false;
            }
        }
        return true;
    }
}