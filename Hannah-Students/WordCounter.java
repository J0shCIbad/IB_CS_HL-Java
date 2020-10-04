/**
 * Word counter is able to count the number of occurences of a certain
 * word in an array of Strings, stacked to form a 2d array of 
 * characters. An occurence is counted when the word is found in the
 * character grid with adjacent characters in any various directions
 * with reusal save using a single point in the grid as a double letter
 * in the target string.
 * 
 * @author Josh Ibad 
 * @version 07.03.2019
 */
public class WordCounter
{
    private char[][] chars;
    private int[] max;
    private char[] ziel;

    /**
     * Constructor for objects of class TearCalculator: Creates a char
     * grid and records the string lengths for later usage in
     * traversing the grid.
     */
    public WordCounter(String[] letters)
    {
        max = new int[letters.length];
        chars = new char[letters.length][];
        for(int i=0; i<letters.length; i++){
            chars[i] = letters[i].toCharArray();
            max[i] = chars[i].length-1;
        }
        ziel = new char[0];
    }


    /**
     * Counts every occurence of a target String in grid
     * 
     * @param  target   Target string to search for
     * @return          Number of occurences 
     */
    public int countEmAll(String target)
    {
        ziel = target.toCharArray();
        int total = 0;
        for (int i = 0; i < chars.length; i++)
            for (int j = 0; j < chars[i].length; j++){
                total += countWord(total, i, j, target);
            }
        return total;
    }

    /**
     * Counts occurences of a target String in char grid using
     * a starting reference grid point.
     * 
     * NOTE: total and target unnecessary
     * 
     * @param total     Total num of occurences
     * @param row       Starting reference grid point's x value
     * @param col       Starting reference grid point's y value
     * @param target    Target string to search for
     * @return          Number of occurences of target String
     *                  using reference starting point (row, col);
     */
    private int countWord(int total, int row, int col, String target)
    {
        int ttl = ziel.length;
        int ans = 0;
        if(ziel[ziel.length-ttl] == chars[row][col]){
            ttl--;
            if(row!=0)
            {
                row--;
                ans+=countWord(row, col, 0, ttl);
                if(col!=max[row]) ans+=countWord(row, col+1, 1, ttl);
                if(col!=0) ans+=countWord(row, col-1, 7, ttl);
                row++;
            }
            if(col!=max[row]) ans+=countWord(row, col+1, 2, ttl);
            if(col!=0) ans+=countWord(row, col-1, 6, ttl);
            if(row!=chars.length-1){
                row++;
                if(col!=max[row]) ans+=countWord(row, col+1, 3, ttl);
                ans+=countWord(row, col, 4, ttl);
                if(col!=0) ans+=countWord(row, col-1, 5, ttl);
            }
        }
        return ans;
    }

    /**
     * Counts occurences of a target String in char grid using
     * a starting reference grid point.
     * 
     * NOTE: total and target unnecessary
     *   
     * @param row       Starting reference grid point's x value
     * @param col       Starting reference grid point's y value
     * @param dir       Direction from which search started
     * @param ttl       Time-to-live
     * @return          Number of occurences of target String
     *                  using reference starting point (row, col);
     */
    private int countWord(int row, int col, int dir, int ttl)
    {
        if(ziel[ziel.length-ttl] == chars[row][col]){
            if(ttl == 1)
                return 1;
            else{
                int ans=0;
                ttl--;
                dir = (dir+4)%8;
                if(row!=0){
                    row--;
                    if(dir != 0) ans+=countWord(row, col, 0, ttl);
                    if(dir != 1 &&(col!=max[row])) ans+=countWord(row, col+1, 1, ttl);
                    if(dir != 7 &&(col!=0)) ans+=countWord(row, col-1, 7, ttl);
                    row++;
                }
                if(dir != 2 &&(col!=max[row])) ans+=countWord(row, col+1, 2, ttl);
                if(dir != 6 &&(col!=0)) ans+=countWord(row, col-1, 6, ttl);
                if(row!=chars.length-1){
                    row++;
                    if(dir != 3 &&(col!=max[row])) ans+=countWord(row, col+1, 3, ttl);
                    if(dir != 4) ans+=countWord(row, col, 4, ttl);
                    if(dir != 5 &&(col!=0)) ans+=countWord(row, col-1, 5, ttl);
                }
                return ans;
            }
        }else{
            return 0;
        }
    }
}