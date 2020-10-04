import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
public class FunctionsChapter3StylePart2
{
    private int[][] mat;

    public FunctionsChapter3StylePart2(int[][] r){
        mat = r;
    }

    public int getNumRows(){
        return mat.length;
    }

    public int getNumCols(){
        return mat[0].length;
    }

    /**
     *    replaces the current relation instance variable with r
     */
    public void setRelation(int[][] r){
        mat = r;
    }

    /**
     *    returns the current relation instance variable 
     */
    public int[][] getRelation(){  
        return mat;
    }

    /** (Only checks for 1s)
     *    retruns the number of Order Pairs in the relation
     *      that is, the number of one's (1) in the Matrix
     *      
     */
    public int getSize(){
        int temp = 0;
        for(int r=0; r<mat.length; r++){
            for(int c=0; c<mat[0].length; c++){
                if(mat[r][c] == 1)
                    temp++;
            }
        }
        return temp;
    }

    /**
     *    f is a function if
     *       for each x in X, there is exactly one y in Y with (x,y) in f
     *    returns true if the matrix forms a function
     *    returns false otherwise
     */
    public boolean isFunction(){
        int temp = 0;
        for(int r=0; r<mat.length; r++){
            temp = 0;
            for(int c=0; c<mat[0].length; c++){
                temp += mat[r][c];
            }
            if(temp != 1)
                return false;
        }
        return true;
    }

    /**
     *    A function f from X to Y is said to be one to one if 
     *    for each y in Y, there is at most one x in X with f(x) = y
     *
     *    returns true if the matrix is a function and the function is one to one
     *    returns false otherwise
     *    column sum is one for every column
     */
    public boolean isOneToOne(){
        if(!isFunction())
            return false;
        else{
            boolean flag = false;
            for(int c=0; c<mat[0].length; c++){
                flag = false;
                for(int r=0; r<mat.length; r++){
                    if(mat[r][c] == 1){
                        if(!flag)
                            flag = true;
                        else
                            return false;
                    }
                }
            }
            return true;
        }
    }

    /**
     *    A function from X to Y is said to be onto if
     *    the range of f == Y
     *
     *    returns true if the matrix is a function and the function is onto
     *    returns false otherwise
     *    column sum > 0 for all columns
     */
    public boolean isOnTo(){
        if(!isFunction())
            return false;
        else{
            int temp = 0;
            for(int c=0; c<mat[0].length; c++){
                temp = 0;
                for(int r=0; r<mat.length; r++){
                    temp += mat[r][c];
                }
                if(temp == 0)
                    return false;
            }
            return true;
        }
    }

    /**
     *     returns true if the matrix is a function and the function is bijective
     *              that is both one to one and onto
     *     returns false otherwise
     */
    public boolean isBijective(){
        if(!isFunction())
            return false;
        else{
            boolean flag = false;
            int temp = 0;
            for(int c=0; c<mat[0].length; c++){
                temp = 0;
                flag = false;
                for(int r=0; r<mat.length; r++){
                    if(mat[r][c] == 1){
                        if(!flag)
                            flag = true;
                        else
                            return false;
                    }
                    temp += mat[r][c];
                }
                if(temp == 0)
                    return false;
            }
            return true;
        }
    }

    /** Good
     *   precondition:  comp is a function.
     *   
     *   returns a new FunctionsChapter3StylePart2 Object.
     *   The domain of the new Object is this.domain
     *   The coDomain of the new Object is comp.coDomain
     *   
     *   The new function is the composition: relation o b = b ( relation )
     *   
     *   See the tester for more information
     */
    public FunctionsChapter3StylePart2 composition(int[][] comp){
        int[][] compMat = Matrix.product(mat, comp);
        for(int r=0; r<compMat.length; r++){
            for(int c=0; c<compMat[0].length; c++){
                if(compMat[r][c] > 1)
                    compMat[r][c] = 1;
            }
        }
        FunctionsChapter3StylePart2 ans = new FunctionsChapter3StylePart2(compMat);
        return ans;
    }

    /**
     *   precondition:  relation is a function.
     *   rel does not have to be both 1-1 and onto
     *   the inverse does not need to be a function
     */
    public int[][] getInverse(){
        int[][] neu = new int[mat[0].length][mat.length];
        for(int r=0; r<mat.length; r++){
            for(int c=0; c<mat[0].length; c++){
                neu[c][r] = mat[r][c];
            }
        }
        return neu;
    }

    /**
     * A relation is reflexive if (x, x) in R for every x in X
     * 
     *       returns true if the current relation is reflexive
     *       returns false otherwise
     *       
     *       You shuld not assume the matrix is a square matrix.
     */
    public boolean isReflexive()
    {
        if(mat.length != mat[0].length)
            return false;
        for(int r=0; r<mat.length; r++){
            if(mat[r][r] != 1)
                return false;
        }
        return true;
    }

    /**
     *       A relation is symmetric if
     *       for all x, y in X, if (x,y) in R, then (y,x) in R
     * 
     *       returns true if the current relation is symmetric
     *       returns false otherwise
     */
    public boolean isSymmetric()
    {
        for(int r=0; r<mat.length; r++){
            for(int c=0; c<mat[0].length; c++){
                if(mat[r][c] != mat[c][r])
                    return false;
            }
        }
        return true;
    }

    /* 
     *       A relation is Antisymmetric if
     *       for all x, y in X, if (x,y) in R, and (y,x) in R, then x = y
     * 
     *    returns true if the current relation is Antisymmetric
     *    returns false otherwise
     */
    public boolean isAntiSymmetric()
    {
        for(int r=0; r<mat.length; r++){
            for(int c=0; c<mat[0].length; c++){
                if(mat[r][c] != 0 && mat[c][r] != 0 && r!=c)
                    return false;
            }
        }
        return true;
    }

    /** Good
     *       A relation is transitive:
     *       if (a,b) and (b,c) then (a,c)
     * 
     *       returns true if the current relation is transitive
     *       returns false otherwise
     */
    public boolean isTransitive(){
        int[][] square = Matrix.product(mat,mat);
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(square[i][j] != 0)
                    if(mat[i][j] == 0)
                        return false;
            }
        }
        return true;
    }

    /** Good
     *    returns true is the relation is an Equivalence Relation
     *    returns false otherwise
     */
    public boolean isEquivalenceRelation(){
        return isReflexive() && isSymmetric() && isTransitive();
    }

    /** Good
     *    returns true is the relation is an Partially Order
     *    returns false otherwise
     */
    public boolean isPartiallyOrder(){
        return isReflexive() && isAntiSymmetric() && isTransitive();
    }

    /** Good
     *    returns [[a, c, ....d], [...], ...[]]
     */
    public String toString(){
        String ans = "";
        for(int i=0; i<mat.length; i++)
        {
            ans += "[";
            for(int j=0; j<mat[0].length-1; j++)
                ans += mat[i][j] + ", ";
            ans += mat[i][mat[0].length-1] + "]";
            if(i<mat.length-1)
                ans += ", ";
        }
        return "[" + ans + "]";
    }

    public boolean isSquare(){
        return mat.length == mat[0].length;
    }
}