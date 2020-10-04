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

public class EquationSolver 
{
    private int ziel;
    public int optiA, optiB, optiC;
    private int[] digsA, digsB, digsC;
    private int anzahlA, anzahlB, anzahlC;

    private int THRESHOLD = 2;
    private int AUSGLEICHEN = 55555; //50000;
    public void berechnenA(){if(ziel <= AUSGLEICHEN){optiA = 0;} else{optiA = (int)(Math.sqrt(ziel));}}
    public void berechnenB(){if(ziel <= AUSGLEICHEN){optiB = 0;} else{optiB = (ziel-AUSGLEICHEN)/optiA;}}
    public void berechnenC(){optiC = ziel - optiA*optiB;}

    /* 
     * post condition 
     *   0 <= t <= 99,999
     */
    public EquationSolver(int t){
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
        switch(anzahlA){
            case 2: /** ZWEI **/
                minInd = str.indexOf(" ");
                str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
                optiA = verwandeln(str);
                berechnenB();
                return str;
            case 3: /** Disabled due to causing no improvement while delaying run time **/
                while(digsA[minInd] != -10){minInd++;}
                neuBerechnenA(minInd, str);                 /** Reoptimization algorithm **/
                THRESHOLD = 3;
            default:
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
                if(min > THRESHOLD){                        /** Damage Control if Threshold surpassed **/
                    minInd = digsA.length-1;
                    while(digsA[minInd] == -10){minInd--;}
                }
                str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
                anzahlA++;  digsA[minInd] = -10; return str;
        }
    }

    /*
     *    create term b of the equation a * b + c that is closes to ziel
     *    
     *    0 <= b <= 999
     */
    public String build_b(String str, int n)
    {
        int minInd = 0;
        switch(anzahlB){
            case 2: /** ZWEI **/
                minInd = str.indexOf(" ");
                str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
                optiB = verwandeln(str);
                berechnenC();
                //System.out.println(optiA + "*" + optiB + " + " + optiC);
                return str;
            default:
                int[] unterschied = new int[digsB.length];
                for(int i=0; i<unterschied.length; i++)
                    unterschied[i] = Math.abs(digsB[i]-n);
                int min = 10;
                for(int i=0; i<unterschied.length; i++){    /** Find minimum difference **/
                    if(unterschied[i] < min){
                        minInd = i;
                        min = unterschied[i];
                    }
                }
                if(min > THRESHOLD){                                /** Damage Control if Threshold surpassed **/
                    minInd = digsB.length-1;
                    while(digsB[minInd] == -10){minInd--;}
                }
                str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
                anzahlB++;  digsB[minInd] = -10; return str;
        }
    }

    /*
     *    create term c of the equation a * b + c that is closes to ziel
     *    
     *    0 <= c <= 99999
     */
    public String build_c(String str, int n)
    {
        int minInd = 0;
        switch(anzahlC){
            case 4: /** VIER **/
                minInd = str.indexOf(" ");
                str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
                optiC = verwandeln(str);
                //System.out.println(optiA + "*" + optiB + " + " + optiC);
                return str;
            default:
                int[] unterschied = new int[digsC.length];
                for(int i=0; i<unterschied.length; i++)
                    unterschied[i] = Math.abs(digsC[i]-n);
                int min = 10;
                for(int i=0; i<unterschied.length; i++){    /** Find minimum difference **/
                    if(unterschied[i] < min){
                        minInd = i;
                        min = unterschied[i];
                    }
                }
                if(min > 1){                                /** Damage Control if Threshold surpassed **/
                    minInd = digsC.length-1;
                    while(digsC[minInd] == -10){minInd--;}
                }
                str = str.substring(0,minInd) + n + str.substring(minInd+1,str.length());
                anzahlC++;  digsC[minInd] = -10; return str;
        }
    }

    
    /**
     * Reoptimization algorithm
     * DISABLED DUE TO INEFFICIENCY WITH NO IMPROVEMENTS
     */
    public void neuBerechnenA(int i, String str){
        int delta = (int)((optiA%Math.pow(10, 3-i))/Math.pow(10,2-i)) - (int)(str.charAt(i))+48;
        if(delta==0){return;}
        int neuA = optiA - delta*(int)Math.pow(10, 2-i);
        switch(i){
            case 0:
                if(delta>0){neuA = (neuA/100)*100+99;}
                else{neuA = (neuA/100)*100;}
                break;
            case 1:
                if(delta>0){
                    if(delta>5){neuA = (neuA/10)*10+100;}
                    else{neuA = (neuA/10)*10+9;}
                }else{
                    if(delta<-5){neuA = (neuA/10)*10-91;}//-91 = +9-100
                    else{neuA = (neuA/10)*10;}
                }
                break;
            default:
                if(delta>5){neuA+=10;} //Digit undershot
                else if (delta<-5){neuA-=10;} //Digit overshot
                break;
        }
        if(neuA<0){neuA=0;}
        else if(neuA>999){neuA=99;}
        optiA = neuA;
        String temp = "" + neuA;
        for(int j=0; j<digsA.length; j++){
            if(digsA[i] != -10){digsA[i] = ((int)(temp.charAt(i)) - 48);}
        }
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