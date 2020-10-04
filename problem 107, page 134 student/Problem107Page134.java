import java.util.*;
import java.lang.Math;
/**
 * Friday the 13.
 *
 * @Josh C Ibad
 * @18.01.19
 */
public class Problem107Page134
{
    /*
     *  returns an array of all months with a Friday the 13th in Calendar order
     *        Use the following Strings for each Month
     *        "Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"
     *
     *  Please note:  The objective of this program is to use the formula presented in the book.
     *      
     *  The tester test long ago years (like year 1, 2, etc.) which may differ from actual Friday the 13ths
     *     
     *  More on Leap Years (According to wikipedia):
     *        Every year that is exactly divisible by four is a leap year,
     *        except for years that are exactly divisible by 100,
     *        but these centurial years are leap years if they are exactly divisible by 400.
     *        For example, the years 1700, 1800, and 1900 were not leap years, but the years 1600 and 2000 were
     */
    public static String[] findFriday13(int year)
    {
        int y = (year + (int)Math.floor((year-1)/4.0) - (int)Math.floor((year-1)/100.0) + (int)Math.floor((year-1)/400.0)) % 7;
        if(((year%4 == 0 && year%100 != 0) || (year%400 == 0))){
            switch(y){
                case 0:
                String[] ans1 = {"Jan", "April", "July"};
                return ans1;
                case 1:
                String[] ans2 = {"Sept", "Dec"};
                return ans2;
                case 2:
                String[] ans3 = {"June"};
                return ans3;
                case 3:
                String[] ans4 = {"March", "Nov"};
                return ans4;
                case 4:
                String[] ans5 =  {"Feb", "Aug"};
                return ans5;
                case 5:
                String[] ans6 = {"May"};
                return ans6;
                case 6:
                String[] ans7 = {"Oct"};
                return ans7;
            }
        }else{
            switch(y){
                case 0:
                String[] ans8 = {"Jan", "Oct"};
                return ans8;
                case 1:
                String[] ans9 = {"April", "July"};
                return ans9;
                case 2:
                String[] an0 = {"Sept", "Dec"};
                return an0;
                case 3:
                String[] ansa = {"June"};
                return ansa;
                case 4:
                String[] ansv = {"Feb", "March", "Nov"};
                return ansv;
                case 5:
                String[] ansb = {"Aug"};
                return ansb;
                case 6:
                String[] ansn = {"May"};
                return ansn;
            }
        }
        return new String[0];
    }

}