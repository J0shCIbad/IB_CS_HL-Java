import java.util.*;

public class MatissaExponentConverter
{
    /*
     *   @param m = bits in mantissa
     *   @param e = bits in exponent
     *   @param val = value in decimal
     */
    public static String toMatissaExponent(double val, int mBits, int eBits)
    {
        String me = "";
        if(val == 0.0){
            for(int i=0; i<mBits; i++)
                me += "0";
            me += " ";
            for(int i=0; i<eBits; i++)
                me += "0";
            return me;
        }
        /** Divide... **/
        double exp = Math.floor((Math.log(Math.abs(val))/Math.log(2)) + 1);
        val /= Math.pow(2, exp);
        if(val < 0)
        {
            val = 1 - Math.abs(val);
            me += "1";
        }
        else
            me += "0";

        /** ... and Conquer (Mantissa) **/
        double temp = 0.5;
        for(int i=1; i<mBits; i++)
        {
            if(val == 0.0)
                me += "0";
            else
            {
                if((val-temp)>=0){
                    me += "1";
                    val -= temp;
                }else
                    me += "0";
            }
            temp /= 2;
        }
        if(val!=0){
            return "np";
        }

        /** ... and more Conquering (Exponent) **/
        me += " ";
        temp = Math.pow(2, eBits-1);
        if(exp < 0)
        {
            exp = temp + exp;
            me += "1";
        }
        else
            me += "0";
        for(int i=1; i<eBits; i++)
        {
            temp /= 2;
            if(exp == 0.0)
                me += "0";
            else
            {
                if((exp-temp)>=0){
                    me += "1";
                    exp -= temp;
                }else
                    me += "0";
            }
        }
        if(exp!=0){
            return "np";
        }
        return me;
    }

    /**
     * Converts mantissa exponent in string form separated by one space into a decimal in double form
     */
    public static double toDouble(String str)
    {
        String[] me = str.split(" ");
        double ans = -1 * Double.parseDouble(me[0].substring(0, 1));
        for(int i=1; i<me[0].length(); i++)
        {
            ans += Double.parseDouble(me[0].substring(i, i+1))*Math.pow(2, -1*i);
        }
        double exp = -1*Double.parseDouble(me[1].substring(0, 1))*Math.pow(2, me[1].length()-1);
        for(int j=1; j<me[1].length(); j++)
        {
            exp += Double.parseDouble(me[1].substring(j, j+1))*Math.pow(2, me[1].length()-j-1);
        }
        return ans * Math.pow(2, exp);
    }
}