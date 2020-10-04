import java.util.*;
/**
 * Write a description of class Coordinate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinate
{
    // instance variables - replace the example below with your own
    private int row, col;
    private ArrayList<Coordinate> preceding;
    private ArrayList<Coordinate> adjacent;
    /**
     * Constructor for objects of class Coordinate
     */
    public Coordinate(int x, int y)
    {
        preceding = null;
        row = x;
        col = y;
    }

    public Coordinate(int x, int y, ArrayList<Coordinate> p)
    {
        preceding = p;
        row = x;
        col = y;
    }

    public int getX()
    {
        return row;
    }

    public int getY()
    {
        return col;
    }

    public ArrayList<Coordinate> getAllAdjacent()
    {
        findAdjacentCoordinates(this);   
        return adjacent;
    }

    public ArrayList<Coordinate> getValidAdjacent()
    {
        findAdjacentCoordinates(this);
        ArrayList<Coordinate> ans = new ArrayList<>();
        for ( Coordinate c : adjacent)
        {
            if ( preceding == null)
            {
                ans.add(c);
            }
            else if (! preceding.contains(c))
            {
                ans.add(c);
            }
        }
        return ans;
    }

    public ArrayList<Coordinate> getPreceding()
    {
        return preceding;
    }

    public ArrayList<Coordinate> getPrecedingAndThis()
    {
        ArrayList<Coordinate> ans = new ArrayList<>();
        if ( preceding == null)
        {
            ans.add(this);
            return ans;
        }
        for ( Coordinate c : preceding)
        {
            ans.add(c);
        }
        ans.add(this);
        return ans;
    }

    public void setCoordinate(int x, int y)
    {
        row = x;
        col = y;
    }

    public boolean equals(Coordinate x, Coordinate y)
    {
        if ( x.equals(null) && y.equals(null))
        {
            return true;
        }
        if ( x.equals(null) ^ y.equals(null))
        {
            return false;
        }
        if ( x.getX() == y.getX() && x.getY() == y.getY())
        {
            return true;
        }
        return false;
    }

    public void findAdjacentCoordinates(Coordinate c)
    {
        ArrayList<Coordinate> ans = new ArrayList<>();
        ans.add(new Coordinate(c.getX() - 1, c.getY() - 1, getPrecedingAndThis()));
        ans.add(new Coordinate(c.getX() - 1, c.getY(), getPrecedingAndThis()));
        ans.add(new Coordinate(c.getX() - 1, c.getY() + 1, getPrecedingAndThis()));
        ans.add(new Coordinate(c.getX(), c.getY() - 1, getPrecedingAndThis()));
        ans.add(new Coordinate(c.getX(), c.getY() + 1, getPrecedingAndThis()));
        ans.add(new Coordinate(c.getX() + 1, c.getY() - 1, getPrecedingAndThis()));
        ans.add(new Coordinate(c.getX() + 1, c.getY(), getPrecedingAndThis()));
        ans.add(new Coordinate(c.getX() + 1, c.getY() + 1, getPrecedingAndThis()));
        for( int x = 0; x < ans.size(); x++)
        {
            if ( ans.get(x).getX() < 0 || ans.get(x).getY() < 0)
            {
                ans.remove(x);
                x--;
            }
        }
        adjacent = ans;
    }

    public String toString()
    {
        return getX() + "," + getY();
    }
}
