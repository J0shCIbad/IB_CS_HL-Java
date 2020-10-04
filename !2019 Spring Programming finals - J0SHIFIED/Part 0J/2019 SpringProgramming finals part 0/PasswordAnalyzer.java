import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  J0$h Ibad
 * @version 05/05/2019 12:41:32
 * 
 * J0$hified
 */
public class PasswordAnalyzer
{
    private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMS = "0123456789";
    /**
     *   returns true if 
     *        pw Contains at least 8 characters.
     *     and pw Contains NO spaces
     *     and Contains at least one of the following
     *         Both UPPER case and lower case letters
     *         a letter and a digit/number
     *         a letter and a symbol
     * 
     */
    public boolean isValid(String pw)
    {
        if(pw.length() < 8 || pw.indexOf(" ") >= 0){return false;}
        boolean majLet, minLet, dig, sym;       majLet = minLet = dig = sym = false;
        int zahl = 0;
        for(int i=0; i<pw.length(); i++)
        {
            String str = pw.substring(i, i+1);
            if(LETTERS.indexOf(str) >= 0){minLet = true; zahl++;}
            if(LETTERS.toUpperCase().indexOf(str) >= 0){majLet = true; zahl++;}
            if(NUMS.indexOf(str) >= 0){dig = true; zahl++;}
        }
        sym = zahl<pw.length();
        return (majLet && minLet) || ((majLet || minLet) && (dig || sym));
    }

    /**
     * Length bonus: (total max = 25 points)
     *  repeated or consecutive letters count as one letter
     *       for example: "letter" has length 5, "bookkeeper" has length 7 and "brrrr111" has length 3
     *                    mixed case not test:  that is Rr is not tested
     *  +2 for each additional character(s) that makes the length greater than 8 up to and including the length of 15.  Max of 14 (7 * 2) points.
     *  +1 for one additional character(s) beyond 15 up to a max of 11 addition points.
     *  
     *  9th char counts for doubling
     */
    public int getLengthBonus(String pw)
    {
        if(!isValid(pw)){return 0;}
        int length = 0;
        int antwort = 0;
        char recent = ' ';
        for(int i=0; i<pw.length(); i++){
            char c = pw.charAt(i);
            if(recent != c){
                length++;
                if(length > 8 && antwort < 14)
                    antwort += 2;
                else if(antwort >= 14 && antwort < 25)
                    antwort++;
            }
            recent = c;
        }
        return antwort;
    }

    /**
     *   Upper case bonus:  (total max = 10 points)
     *      Repeated Upper case letters are treated as separate letters (example "PASS" is 4 upper case letters)
     *   +1 for each upper case letter (max 5 points)
     *   +1 for each non upper case letter (lower case, numbers or symbols, max 5 points)
     */
    public int getUpperCaseBonus(String pw)
    {
        if(!isValid(pw)){return 0;}
        int maj =0; int etc = 0;
        for(int i=0; i<pw.length(); i++)
        {
            if(LETTERS.toUpperCase().indexOf(pw.charAt(i)) >= 0){
                if(maj<5){maj++;}
            } else if(etc < 5)
                etc++;
        }
        return maj+etc;
    }

    /**
     *   Digit (number) Bonus (total max = 15 points)
     *   +1 for each digit contained in the password.  (The digits 10 counts as two numbers. Max of 10 points)
     *   +1 for each non digit (lower/upper case symbols, or symbols, max 5 points)
     *      Repeated non digits are counted seperately.  For example, AAA is three non digits
     */
    public int getDigitBonus(String pw)
    {
        if(!isValid(pw)){return 0;}
        int digs =0; int etc = 0;
        for(int i=0; i<pw.length(); i++)
        {
            if(NUMS.indexOf(pw.charAt(i)) >= 0){
                if(digs<10){digs++;}
            }else if(etc < 5)
                etc++;
        }
        return digs+etc;
    }

    /**
     *   Symbol Bonus (total max = 15 points)
     *       A symbol is any character that is not a letter and not a digit/number)
     *   +1 for each Symbol contained in the password.  (max 10 points)
     *   +1 for each non symbol (lower/upper case letter, or digit, max 5 points)
     */
    public int getSymbolBonus(String pw)
    {
        if(!isValid(pw)){return 0;}
        int alphanum =0; int sym = 0;
        for(int i=0; i<pw.length(); i++)
        {
            char c = pw.charAt(i);
            if(NUMS.indexOf(c) >= 0 || LETTERS.indexOf(c) >= 0 || LETTERS.toUpperCase().indexOf(c) >= 0){
                if(alphanum < 5){alphanum++;}
            }else if(sym < 10)
                sym++;
        }
        return alphanum + sym;
    }

    /**
     *  Combination Bonus (total max = 10 points)
     *     A combination is defined to be any of the following
     *     -   Letter (upper of lower case) followed immediately  by a digit/number
     *     -   letter (upper of lower case) followed immediately by a symbol
     *     -   Digit/number followed immediately by a symbol
     *     -   Symbol followed immediately by a digit/number
     *     The password containing "A7#" has two combinations
     *  +1 for each combination in the password.  (max 10 points)
     */
    public int getCombinationBonus(String pw)
    {
        int combs = 0;
        for(int i=0; i<pw.length()-1; i++)
        {
            char c = pw.charAt(i);
            char d = pw.charAt(i+1);
            if(LETTERS.indexOf(c) >= 0 || LETTERS.toUpperCase().indexOf(c) >= 0){
                if(LETTERS.indexOf(d) < 0 && LETTERS.toUpperCase().indexOf(d) < 0) {combs++;}
            }else if(NUMS.indexOf(c) >= 0){
                if(LETTERS.indexOf(d) < 0 && LETTERS.toUpperCase().indexOf(d) < 0 && NUMS.indexOf(d) < 0) {combs++;}
            }else if(NUMS.indexOf(d) >= 0) {combs++;}
            
            if(combs == 10) {return 10;}
        }
        return combs;
    }

    public int getPoints(String pw)
    {
        if(isValid(pw))
            return 50 + getLengthBonus(pw) + getUpperCaseBonus(pw) + getDigitBonus(pw) + getSymbolBonus(pw) + getCombinationBonus(pw);
        return 50;
    }

    /**
     *   Passwords that are not valid receive a rating of rejected.  
     *   Valid password with 70 or fewer points received a rating of unacceptable.
     *   Passwords receiving more than 70 points and 80 points or less receive a rating of weak.
     *   Passwords receiving more than 80 points and 95 points or less receive a rating of average.
     *   Passwords receiving more than 95 points and 115 points or less receive a rating of good.
     *   Passwords receiving more than 115 points receive a rating of excellent.
     */
    public String getRating(String pw)
    {
        int pts = getPoints(pw);
        if(pts == 50) {return "rejected";}
        if(pts <= 70) {return "unacceptable";}
        if(pts <= 80) {return "weak";}
        if(pts <= 95) {return "average";}
        if(pts <= 115) {return "good";}
        else {return "excellent";}
    }
}