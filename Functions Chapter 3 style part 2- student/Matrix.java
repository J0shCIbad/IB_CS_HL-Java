
/**
 * Write a description of class Matrix here.
 * 
 * need Matrix operations
 * 
 * @author Don Allen
 * @version March 2011
 */
public class Matrix
{
    // All methods will be static methods

    /**
     *    Matrix multiplication
     * 
     * @return     matrix x times matrix y 
     */
    public static int[][] product(int[][] x, int[][] y)
    {
        int[][] ans = new int[x.length][y[0].length];   // this is the correct dimension
        int temp = 0;
        for(int rx=0; rx<x.length; rx++)
        {
            
            for(int cy=0; cy<y[0].length; cy++)
            {
                temp = 0;
                for(int j=0; j<x[rx].length; j++)
                {
                    temp += x[rx][j] * y[j][cy];
                }
                ans[rx][cy] = temp;
            }
        }
        return ans;
    }
}
