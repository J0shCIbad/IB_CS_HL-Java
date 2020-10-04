import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
/*
 *    For this project, you may assume all int[][] have square dimensions
 *    
 *    Remember to not change the parameter!!!!!!!!!
 */
public class FunctionsChapter3StylePart3
{
    /**
     *    add the fewest 1s to copy of matrix m so that the copy is reflexive 
     */
    public static int[][] makeReflexive(int[][] m){
        int[][] temp = new int[m.length][m[0].length];
        for(int r=0; r<m.length; r++){
            for(int c=0; c<m[0].length; c++){
                if(r == c)
                    temp[r][c] = 1;
                else
                    temp[r][c] = m[r][c];
            }
        }
        return temp;
    }

    /**
     *    add the fewest 1s to copy of matrix m so that the copy is symmetric 
     */
    public static int[][] makeSymmetric(int[][] m){  
        int[][] temp = new int[m.length][m[0].length];
        for(int r=0; r<m.length; r++){
            for(int c=0; c<m[0].length; c++){
                temp[r][c] = m[r][c];
            }
        }
        for(int r=0; r<m.length; r++){
            for(int c=0; c<m[0].length; c++){
                if(temp[r][c] == 0 && temp[c][r] != 0)
                    temp[r][c] = 1;
            }
        }
        return temp;
    }

    /*
     *    add the fewest 1s to copy of matrix m so that the copy is transitive 
     */
    public static int[][] makeTransitive(int[][] m){
        /** Create copy **/
        int[][] temp = new int[m.length][m[0].length];
        for(int r=0; r<m.length; r++){
            for(int c=0; c<m[0].length; c++){
                temp[r][c] = m[r][c];
            }
        }
        
        /** Make transitive **/
        boolean cntrl = true;
        while(cntrl){
            cntrl = false;
            for(int r=0; r<m.length; r++){
                for(int c=0; c<m[0].length; c++){
                    if(temp[r][c] != 0){
                        for(int y=0; y<m[0].length; y++){
                            if(temp[c][y] != 0 && temp[r][y] != 1){
                                temp[r][y] = 1;
                                cntrl = true;
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }
}