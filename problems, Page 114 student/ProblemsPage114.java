import java.util.*;
import java.lang.Math;
/**
 * Discrete Math 
 * 
 * Problem 8, 9 and 11, Page114.
 * Friday the 13.
 *
 * @author  
 * @version (a version number or a date)
 */
public class ProblemsPage114
{
    public static int problem_8(int n)
    {
        switch(n){
            case 1:
            case 2: 
                return 0;
            default:
                return problem_8((int)Math.floor(n/3)) + n;
        }
    }

    public static int problem_9_10(int n)
    {
        switch(n){
            case 1:
                return 0;
            default:
                return problem_9_10((int)Math.floor(n/2)) + (int)Math.pow(n, 2);
        }
    }

    public static int problem_11_13(int n)
    {
        switch(n){
            case 1:
                return 0;
            default:
                return 4*problem_11_13((int)Math.floor(n/2)) + n;
        }
    }
}