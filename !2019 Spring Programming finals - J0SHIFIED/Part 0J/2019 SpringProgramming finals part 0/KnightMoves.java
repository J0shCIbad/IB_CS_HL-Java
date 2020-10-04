import java.util.*;
/**
 * @author  J0$h Ibad
 * @version 05/05/2019 16:50:00
 * 
 * J0$hified
 * All Good
 */
public class KnightMoves
{
    private static final int[][] MOVES = {{0,3,2,3,2,3,4,5,}, {3,2,1,2,3,4,3,4}, {2,1,4,3,2,3,4,5}, {3,2,3,2,3,4,3,4},
        {2,3,2,3,4,3,4,5}, {3,4,3,4,3,4,5,4}, {4,3,4,3,4,5,4,5}, {5,4,5,4,5,4,5,6}};
    private ChessLocation loc;

    public KnightMoves(ChessLocation cl)
    {
        loc = cl;
    }
    
    /**
     *   precondition: ChessLocation is a valid
     *   
     *   returns a value greater tahn or equal to 0 which represents
     *           the minimum number of moves for the knight to move from its curernt location to destination
     */
    public int minimumNumMovesTo(ChessLocation destination)
    {
        int x = Math.abs(loc.getRow() - destination.getRow());
        int y = Math.abs(convertFromCol(loc.getCol()) - convertFromCol(destination.getCol()));
        int a = loc.getRow(); int b = convertFromCol(loc.getCol());
        if(((a == 1 && (b==1 || b==8)) || (a==8 && (b==1 || b==8)))
            && (x==1 && y==1))
            return 4;
        return MOVES[x][y];
    }
    
    public static ChessLocation forwardTwoThenRight(ChessLocation chLoc)
    {
        int x = chLoc.getRow() + 2;
        String y = convertToCol(convertFromCol(chLoc.getCol())+1);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }

    public static ChessLocation forwardTwoThenLeft(ChessLocation chLoc)
    {
        int x = chLoc.getRow() + 2;
        String y = convertToCol(convertFromCol(chLoc.getCol())-1);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }

    public static ChessLocation forwardOneThenRightTwo(ChessLocation chLoc)
    {
        int x = chLoc.getRow() + 1;
        String y = convertToCol(convertFromCol(chLoc.getCol())+2);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }

    public static ChessLocation forwardOneThenLeftTwo(ChessLocation chLoc)
    {
        int x = chLoc.getRow() + 1;
        String y = convertToCol(convertFromCol(chLoc.getCol())-2);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }

    public static ChessLocation backwardTwoThenRight(ChessLocation chLoc)
    {
        int x = chLoc.getRow() - 2;
        String y = convertToCol(convertFromCol(chLoc.getCol())+1);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }

    public static ChessLocation backwardTwoThenLeft(ChessLocation chLoc)
    {
        int x = chLoc.getRow() - 2;
        String y = convertToCol(convertFromCol(chLoc.getCol())-1);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }

    public static ChessLocation backwardOneThenRightTwo(ChessLocation chLoc)
    {
        int x = chLoc.getRow() - 1;
        String y = convertToCol(convertFromCol(chLoc.getCol())+2);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }

    public static ChessLocation backwardOneThenLeftTwo(ChessLocation chLoc)
    {
        int x = chLoc.getRow() - 1;
        String y = convertToCol(convertFromCol(chLoc.getCol())-2);
        if(y == null || x<1 || x>8)
            return null;
        else
            return new ChessLocation(x,y);
    }
    
    public static int convertFromCol(String col)
    {
        switch(col)
        {
            case "a":   return 1;
            case "b":   return 2;
            case "c":   return 3;
            case "d":   return 4;
            case "e":   return 5;
            case "f":   return 6;
            case "g":   return 7;
            case "h":   return 8;
            default:    return -1;
        }
    }
    public static String convertToCol(int col)
    {
        switch(col)
        {
            case 1: return "a";
            case 2: return "b";
            case 3: return "c";
            case 4: return "d";
            case 5: return "e";
            case 6: return "f";
            case 7: return "g";
            case 8: return "h";
            default:    return null;
        }
    }
}