import java.util.*;

/**
 * A Set of integers that can do basic operations with other
 * sets of integers inputed as arrays.
 * 
 * @author  Josh Ibad
 * @teacher Mr. Allen
 * @period  1
 * @version 08/16/2018
 */

public class SetWithArray
{
    private int[] x;

    public SetWithArray(int[] num)
    {
        x = SetWithArray.simplify(num);
    }

    /*
     * returns an Set (array) containing all elements in x OR y
     */
    public int[] union(int[] y)
    {
        y = SetWithArray.simplify(y);
        /**Basic method**/
        int[] xAndY = intersection(y);
        int[] ans = new int[x.length+y.length-xAndY.length];
        int i=0;
        for(int a: x)
        {
            ans[i] = x[i];
            i++;
        }
        for(int b: y)
        {
            boolean diff = true;
            for(int c: xAndY)
            {
                diff &= b!=c;
            }
            if(diff)
            {
                ans[i] = b;
                i++;
            }
        }
        
        return ans;
    }

    /*
     * returns an Set (array) containing all elements in x AND y
     * 
     *      if the intersection is empty, return an arrray of length 0
     * 
     */
    public int[] intersection(int[] y)
    {
        y = SetWithArray.simplify(y);
        /**Basic method**/
        int length = 0;
        for(int a: x)
        {
            for(int b: y)
            {
                if(a==b)
                    length++;
            }
        }
        int[] ans = new int[length];
        int i = 0;
        for(int a: x)
        {
            for(int b: y)
            {
                if(a==b)
                {
                    ans[i] = a;
                    i++;
                }
            }
        }
        return ans;
    }

    /*
     * returns an Set (array) containing all elements in x that are not in y
     * 
     *      if the intersection is empty, return an arrray of length 0
     */
    public int[] difference(int[] y)
    {
        y = SetWithArray.simplify(y);
        /**Basic method**/
        int[] arr = new int[x.length];
        int length = 0;
        int i = 0;
        for(int a: x)
        {
            boolean boo = false;
            for(int b:y)
            {
                boo |= a==b;
            }
            if(!boo)
            {
                arr[i] = a;
                length++;
                i++;
            }
        }
        int[] ans = new int[length];
        for(int j=0; j<length; j++)
        {
            ans[j] = arr[j];
        }
        return ans;
    }

    /*
     * returns true if all elements of x are contained in y
     */
    public boolean isSubSetOf(int[] y)
    {
        y = SetWithArray.simplify(y);
        /**Basic method**/
        for(int a: x)
        {
            boolean boo = false;
            for(int b:y)
            {
                boo |= a==b;
            }
            if(!boo)
            return false;
        }
        return true;
    }

    /*
     * returns true if all elements in y are contained in x
     *              and if all elements in x are contained in y
     */
    public boolean isEqualTo(int[] y)
    {
        y = SetWithArray.simplify(y);
        /**Basic method**/
        return isSubSetOf(y) && x.length==y.length;
    }

    /*
     * returns the set of elements which are in one of the set
     *         that is:  (x - y) union (y - x)
     * 
     *      if the intersection is empty, return an arrray of length 0
     */
    public int[] symmetricDifference(int[] y)
    {
        y = SetWithArray.simplify(y);
        /**Basic method**/
        int[] xAndY = intersection(y);
        int[] arr = new int[x.length+y.length-xAndY.length];
        int length = 0;
        int i=0;
        for(int a: x)
        {
            boolean diff = true;
            for(int c: xAndY)
            {
                diff &= a!=c;
            }
            if(diff)
            {
                arr[i] = a;
                i++;
                length++;
            }
        }
        for(int b: y)
        {
            boolean diff = true;
            for(int c: xAndY)
            {
                diff &= b!=c;
            }
            if(diff)
            {
                arr[i] = b;
                i++;
                length++;
            }
        }
        int[] ans = new int[length];
        for(int j=0; j<length; j++)
        {
            ans[j] = arr[j];
        }
        return ans;
    }

    /*
     * returns true if all the collection sets in s form a partition of x
     *         you may assume that x is a universal set.
     *         
     *         You might have to look up the definition of a partition and 
     *            use the Set API to figure out how to use a Set
     */
    public boolean isPartition(List<int[]> s)
    {
        /**Basic method**/
        ArrayList list = new ArrayList();
        for(int[] a: s)
        {
            if(a.length == 0)
                return false;
            for(int b: a)
            {
                if(list.contains(b))
                    return false;
                else
                    list.add(b);
                
            }
        }
        int[] fin = new int[list.size()];
        for(int i=0; i<fin.length; i++)
        {
            fin[i] = (Integer)list.get(i);
        }
        Arrays.sort(fin);
        return isEqualTo(fin);
    }
    
    /*
     * Simplifies a set such that repeats are only counted once and the
     * set is sorted for simpler computation
     */
    public static int[] simplify(int[] arr)
    {
        /**Basic method**/
        ArrayList list = new ArrayList();
        int length = 0;
        for(int a: arr)
        {
            if(!list.contains(a))
            {
                length++;
                list.add(a);
            }
        }
        int[] simplified = new int[length];
        for(int i=0; i<length; i++)
        {
            simplified[i] = (Integer)list.get(i);
        }
        Arrays.sort(simplified);
        return simplified;
    }
}