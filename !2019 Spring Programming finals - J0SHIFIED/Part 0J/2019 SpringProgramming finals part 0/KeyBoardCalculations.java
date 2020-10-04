import java.lang.*;
import java.util.*;
/**
 * @author  J0$h Ibad
 * @version 05/05/2019 15:37:07
 * 
 * J0$hified
 * All Good
 */
public class KeyBoardCalculations
{
    private static final String[] ROW = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
    private static final String DIR = "QAZWSXEDCRFVTGBYHNUJMIKOLP";
    
    /**
     * Based off Ibad's personal observations
     */
    public static int kbDistance(String s1, String s2)
    {
        int r1, r2, i1, i2; r1=r2=i1=i2=-1;
        for(int i=0; i<3; i++)
        {
            int a = ROW[i].indexOf(s1);     int b = ROW[i].indexOf(s2);
            if(a>=0){r1=i; i1=a;}
            if(b>=0){r2=i; i2=b;}
        }
        
        if(r1>r2){
            int temp = r1;  r1 = r2;    r2 = temp;
            temp = i1;  i1 = i2;    i2 = temp;
        }
        int x = Math.abs(i1-i2) + r2-r1;
        if(r2-r1 == 1){
            if(i1>i2)
                x--;
        }else if(r2-r1 == 2){
            if(i1>i2)
                x = Math.max(2, x-2);
        }
        return x;
    }
    
    /**
     * Sums key to key distances and divides by number of letters -1;
     */
    public static double averageDistance(String word)
    {
        double sum = 0.0;
        for(int i=0; i<word.length()-1; i++){
            sum += kbDistance(word.substring(i, i+1), word.substring(i+1, i+2));
        }
        return sum/(word.length()-1);
    }

    /**
     * Uses helper method to check every middle letter if it is furthest left or right than its neighbors
     */
    public static int numDirectionChanges(String word)
    {
        int zahl = 0;
        for(int i=0; i<word.length()-2; i++)
        {
            if(dirChange(word.substring(i, i+3)))
                zahl++;
        }
        return zahl;
    }
    public static boolean dirChange(String triplet)
    {
        int a = DIR.indexOf(triplet.substring(0,1));
        int b = DIR.indexOf(triplet.substring(1,2));
        int c = DIR.indexOf(triplet.substring(2,3));
        return (b>a && b>c) || (b<a && b<c);
    }
    
    /**
     * Uses above methods and chart on prompt
     */
    public static String wordDifficulty(String word)
    {
        int len = word.length();
        double dis = averageDistance(word);
        int dir = numDirectionChanges(word);
        if(len < 4 && dis < 2 && dir <= 1){return "elementary";}
        else if(len < 7 && dis < 3 && dir <= 2){return "basic";}
        else if(len < 9 && dis < 4 && dir <= 3){return "so-so";}
        else if(len < 10 && dis < 5 && dir <= 4){return "average";}
        else if(len < 10 && dis < 6 && dir <= 5){return "demanding";}
        else{return "challenging";}
    }
}