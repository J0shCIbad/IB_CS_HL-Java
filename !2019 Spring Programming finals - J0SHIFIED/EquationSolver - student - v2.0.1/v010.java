import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * @author  J0$h Ibad
 * @version 05/11/2019
 * 
 * J0$hified
 * 
 *     Your goal is to build a, b and c so that the equation a * b + c comes as closes to ziel as possible
 *     
 *     You will build a first, then build b and then build c
 *     add the number n, 0 <= n <= 9, to any unoccupied place value in the String num.
 *     e.g., if the str = " 3 ", the build_a(str, 8) could return:    "83 " or " 38"
 *     or    if the str = "  1  5", the build_a(str, 0) could return:
 *                              "0 1 5", " 01 5" or "  105"
 *                              
 *                              
 *     NOTES: t: [0, 1E6)
 *     a & b: [0, 1E3)
 *     c: [0, 1E5)
 */

public class v010
{
    private int ziel;
    public int optiA, optiB, optiC;
    private int[] digsA, digsB, digsC;
    private int anzahlA, anzahlB, anzahlC;

    public void berechnenA(){if(ziel <= 50000){optiA = 0;} else{optiA = (int)(Math.sqrt(ziel));}}
    public void berechnenB(){if(ziel <= 50000){optiB = 0;} else{optiB = (ziel-50000)/optiA;}}
    public void berechnenC(){optiC = ziel - optiA*optiB;}

    /* 
     * post condition 
     *   0 <= t <= 99,999
     */
    public v010(int t){
        ziel = t;
        anzahlA = anzahlB = anzahlC = 0;
        ladenA();  ladenB();  ladenC();
        //System.out.println("\t" + optiA + "*" + optiB + " + " + optiC);
    }

    
    /*
     *    create term a of the equation a * b + c that is closes to ziel
     *    
     *    0 <= a <= 999
     */
    public String build_a(String str, int n){
        int minInd = 0;
        if(anzahlA==2){
            minInd = str.indexOf(" ");
            str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
            optiA = verwandeln(str);
            berechnenB();
            berechnenC();
            //System.out.println(optiA + "*" + optiB + " + " + optiC);
            return str;
        }
        int[] unterschied = new int[digsA.length];
        for(int i=0; i<unterschied.length; i++)
            unterschied[i] = Math.abs(digsA[i]-n);
        int min = 10;
        for(int i=0; i<unterschied.length; i++){    /** Find minimum difference **/
            if(unterschied[i] < min){
                minInd = i;
                min = unterschied[i];
            }
        }
        if(min > 2){                                /** Damage Control if Threshold surpassed **/
            minInd = digsA.length-1;
            while(digsA[minInd] == -10)
                minInd--;
        }
        if(anzahlA==0){switch(minInd){
            case 0:
                
                break;
            case 1:
                
                break;
            default:
            
                break;
        }}
        str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
        anzahlA++;  digsA[minInd] = -10; return str;
    }

    /*
     *    create term b of the equation a * b + c that is closes to ziel
     *    
     *    0 <= b <= 999
     */
    public String build_b(String str, int n)
    {
        return str;
    }

    /*
     *    create term c of the equation a * b + c that is closes to ziel
     *    
     *    0 <= c <= 99999
     */
    public String build_c(String str, int n)
    {
        return str;
    }

    
    /** Loaders will recalculate optimal values and instantiate digitized version of values**/
    public void ladenA(){
        berechnenA();
        String temp = "" + optiA;
        digsA = new int[3];
        for(int i=0; i<temp.length(); i++)
            digsA[i] = ((int)(temp.charAt(i)) - 48);
    }
    public void ladenB(){
        berechnenB();
        String temp = "" + optiB;
        digsB = new int[3];
        for(int i=0; i<temp.length(); i++)
            digsB[i] = ((int)(temp.charAt(i)) - 48);
    }
    public void ladenC(){
        berechnenC();
        String temp = "" + optiC;
        digsC = new int[5];
        for(int i=0; i<temp.length(); i++)
            digsC[i] = ((int)(temp.charAt(i)) - 48);
    }
    /**
     * Converts string to integer, considering spaces as empty place values.
     */
    public int verwandeln(String str)
    {
        int summe = 0;
        int sig = 1;
        for(int i=str.length()-1; i>=0; i--)
        {
            int c = (int)(str.charAt(i));
            if(c == 32)
                c = 48;
            summe += ((int)c - 48)*sig;
            sig *= 10;
        }
        return summe;
    }
    /**
     * Just return name :P
     */
    public String getName()
    {
        System.out.println("This problem has been J0$hified");
        return "Josh Ibad";
    }
}