import java.util.*;
////////////////////////////////////////////////////////////////////////////
//
//    Mr. Allen            
//
//    Purpose       :  Hannah Counter.
//
//    Interface     :  None
//
//    Side-effects  :  exasperation, 
//                     vexation,
//                     botheration
//
////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class TearCalculator here.
 * 
 * @author Mr. Allen 
 * @version (a version number or a date)
 */
public class WordCounter
{
    // instance variables - replace the example below with your own
    private String[] myLetters;
    /**
     * Constructor for objects of class TearCalculator
     */
    public WordCounter(String[] letters)
    {
        myLetters = letters;
    }

    /**
     * The starting method
     * 
     * @param  target, a String  - the 'word' thouest is looking for-est
     * @return     the number of times target can be found in myLetters 
     *             without 'jumping on thy self'
     *             
     *  see the associated word doc.
     */
    public int countEmAll(String target)
    { 
        ArrayList<Coordinate> temp = new ArrayList<>();
        for ( int x = 0; x < myLetters.length; x++)
        {
            for ( int y = 0; y < myLetters[x].length(); y++)
            {
                if ( target.substring(0, 1).equals(String.valueOf(myLetters[x].charAt(y))))
                {
                    temp.add(new Coordinate(x, y, null));
                    //finding all H's(in this case, in other cases it would be the first letter of target)
                }
            }
        }
        if ( target.length() <= 1)
        {
            return temp.size();
        }
        return countWord(0, target, temp);
    }

    /**
     * The recursive helper method - looking for the next letter in target
     * 
     * @param  total:   current number of time target has been found
     *         row:     current row the method is searching
     *         col:     current col the method is searching
     *         target:  the remaining string that needs to found
     *         
     * @return   Either the total number of ways target can be built from
     *           myLetters[row][col]
     */
    private int countWord(int total, String target, ArrayList<Coordinate> c)
    {
        int ans = 0;
        if ( c != null)
        {
            for ( Coordinate x : c)
            {
                if ( x.getPrecedingAndThis().size() == target.length() - 1)
                {
                    ans+= correctAdjacent(x, target).size();
                }
                else
                {
                    ans+= countWord(ans, target, correctAdjacent(x, target));
                }
            }
        }
        System.out.println(total);
        System.out.print(" " + ans);
        return ans;
    }
    
    /**
    * @return arraylist of only adjacent coordinates with the correct next string value
    */
    public ArrayList<Coordinate> correctAdjacent(Coordinate c, String target)
    {
        ArrayList<Coordinate> ans = c.getAllAdjacent();
        String t = String.valueOf(target.charAt(c.getPrecedingAndThis().size()));
        for ( int x = 0; x < ans.size(); x++)
        {
            if ( ans.get(x).getX() >= myLetters.length || ans.get(x).getY() >= myLetters[ans.get(x).getX()].length())
            {
                ans.remove(x);
                x--;
            }
        }
        for ( int x = 0; x < ans.size(); x++)
        {
            String temp = String.valueOf(myLetters[ans.get(x).getX()].charAt(ans.get(x).getY()));
            if ( ! temp.equals(t))
            {
                ans.remove(x);
                x--;
            }
        } 
        return ans;
    }
}