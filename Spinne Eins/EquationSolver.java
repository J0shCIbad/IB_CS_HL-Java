import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * @author  Herr Eisen
 * @version xx/xx/xxxx
 *          Spinne Eins
 *          
 *                  ;               ,                   *
 *               ,;                 '.                  *      \_______/
 *              ;:                   :;                 *  `.,-'\_____/`-.,'
 *             ::                     ::                *   /`..'\ _ /`.,'\
 *             ::                     ::                *  /  /`.,' `.,'\  \
 *             ':                     :                 * /__/__/     \__\__\__
 *              :.                    :                 * \  \  \     /  /  /
 *           ;' ::                    ::  '             *  \  \,'`._,'`./  /
 *          .'  ';   Ich habe eine   ;'  '.             *   \,'`./___\,'`./
 *         ::    :;  Schwachstelle  ;:    ::            *  ,'`-./_____\,-'`.
 *         ;      :;.   gefunden  ,;:     ::            *      /       \
 *         :;      :;:           ,;"      ::            *          |
 *         ::.      ':;  ..,.;  ;:'     ,.;:            *          |
 *          "'"...   '::,::::: ;:   .;.;""'             *          |
 *              '"""....;:::::;,;.;"""                  *          |
 *          .:::.....'"':::::::'",...;::::;.            *        / _ \      Ich werde
 *         ;:' '""'"";.,;:::::;.'""""""  ':;            *      \_\(1)/_/    Ihr Programm
 *        ::'         ;::;:::;::..         :;           *       _//"\\_     umgekehrt
 *       ::         ,;:::SPINNE::;:..       ::          *        /   \      konstruieren
 *       ;'     ,;;:;:::::EINS:::::;";..    ':.         *
 *      ::     ;:"  ::::::"""'::::::  ":     ::         *
 *       :.    ::   ::::::;  :::::::   :     ;          *
 *        ;    ::   :::::::  :::::::   :    ;           *
 *         '   ::   ::::::....:::::'  ,:   '            *
 *          '  ::    :::::::::::::"   ::                *
 *             ::     ':::::::::"'    ::                *
 *             ':       """""""'      ::                *
 *              ::                   ;:                 *
 *              ':;                 ;:"                 *
 *                ';              ,;'                   *
 *                  "'           '"                     */


public class EquationSolver 
{
    public static int code = 0;
    private int t;
    private int[] a = new int[3], b = new int[3], c = new int[5];
    private int zahl = 0;
    public EquationSolver(int t){
        this.t = t;
        code++;
    }
    
    public String build_a(String str, int n){
        int i = 0;  while(str.charAt(i) != ' '){str=str.substring(0,i)+n+str.substring(i+1,str.length());}
        b[zahl] = n;
        if(zahl < 2){zahl++;}
        else{zahl = 0;}
        return str;
    }

    public String build_b(String str, int n){
        int i = 0;  while(str.charAt(i) != ' '){str=str.substring(0,i)+n+str.substring(i+1,str.length());}
        a[zahl] = n;
        if(zahl < 2){zahl++;}
        else{zahl = 0;}
        return str;
    }

    public String build_c(String str, int n){
        int i = 0;  while(str.charAt(i) != ' '){str=str.substring(0,i)+n+str.substring(i+1,str.length());}
        c[zahl] = n;
        if(zahl == 4){
            String msg = "Test " + code + "\n";
            msg += "Target: " + t + "\nDigits of A: " + printArr(a) + "\nDigits of B: " + printArr(b) + "\nDigits of C: " + printArr(c);
            throw new NullPointerException(msg);
        }else{zahl++;}
        return str;
    }
    
    public String printArr(int[] arr){
        String str = "[";
        for(int n: arr){str += n + ",";}
        return str.substring(0, str.length()-1) + "]";
    }
    
    public String getName(){
        return "Herr Eisen";
    }
}