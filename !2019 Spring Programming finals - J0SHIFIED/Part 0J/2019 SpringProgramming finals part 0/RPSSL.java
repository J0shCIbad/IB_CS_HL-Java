import java.util.*;
/**
 * @author  J0$h Ibad
 * @version 05/05/2019 16:13:38
 * 
 * J0$hified
 * All Good
 */
public class RPSSL 
{
    //Let rock = 0, paper = 1, scissors = 2, spock = 3, lizard = 4;
    private static final int[][] MAT = {{0, -1, 1, -1, 1}, {1, 0, -1, 1, -1},
        {-1, 1, 0, -1, 1}, {1, -1, 1, 0, -1}, {-1, 1, -1, 1, 0}};
    public String playRound(Player p1, Player p2)
    {
        switch(MAT[convert(p1.getChoice())][convert(p2.getChoice())])
        {
            case 1: return p1.getName();
            case 0: return "TIE";
            case -1:return p2.getName();
            default:    return "SOMEONE TOUCHED MY MATRIX";
        }
    }
    
    /**
     * Converts string to index for matrix
     */
    public int convert(String s)
    {
        switch(s)
        {
            case "rock":    return 0;
            case "paper":   return 1;
            case "scissors":return 2;
            case "spock":   return 3;
            case "lizard":  return 4;
            default:        return -1;
        }
    }
}