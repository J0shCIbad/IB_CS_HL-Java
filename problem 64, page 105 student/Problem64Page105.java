import java.util.*;
import java.lang.Math;
/**
 * Discrete Math 
 * 
 * Problem64, Page105.
 *
 * @author  
 * @version (a version number or a date)
 */
public class Problem64Page105
{
/*
 *  1 <= num < ????
 */
   public static int evaluate_J(int num)
   {
      int i = (int)Math.floor(Math.log(num)/Math.log(2));
      int j = num - (int)Math.pow(2, i);
      return 2*j+1;
   }
}