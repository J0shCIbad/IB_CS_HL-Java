/*
 * code authored by Maria & Gary Litvan
 * Josh Ibad
 * September 17, 2018
 */

public class Twos_Complement
{
    private String type;
    /*
     * Convert the 2s complement representation to its integer equivalent
     * 
     * precondition  s is the 2s complement number that is to be convert to an int
     *               The number of bits = s.length()
     * 
     *                 see the student tester for sample input/output
     */
    public static int convertToDecimal(String s)
    {
        int ans = 0;
        for(int i=0; i<s.length(); i++)
        {
            int temp = Integer.parseInt(s.substring(i, i+1))*(int)Math.pow(2, s.length()-1-i);
            if(i==0)    temp *= -1;
            ans += temp;
        }
        return ans;
    }

    /*
     * Convert the int parameter val to its 2s complement representatino
     * 
     * precondition:  -2^(bits-1) <+ val <+ (2^[bits-1]) - 1
     *                i.e., the valu fits in the range
     *                
     * postcondition   The return value has length() == bits
     * 
     *                 see the student tester for sample input/output
     */
    public static String convertDecimalTo2sComplement(int val, int bits)
    {
        String ans = "";
        boolean isNeg = false;
        if(val<0)
        {
            isNeg = true;
            val = Math.abs(val);
        }
        for(int i=0; i<bits; i++)
        {
            if(val>0)
            {
                ans = val%2 + ans;
                val /= 2;
            }
            else
            {
                ans = "0" + ans;
            }
        }
        while(ans.length()<bits)
        {
            ans = "0" + ans;
        }
        if(isNeg)
        {
            ans = invert(ans);
        }
        return ans;
    }

    /*
     *    inverts the String parameter s to it negative value
     *    precondition:  s is a valid 2s complement number with s.length() bits
     *    
     *    postcondition  return a string with length() == s.length()
     *                   the decimals value of s == - decimal value of return String
     *                   
     *                   e.g.,  If s = 0111 1111n , the String 1001 is returned
     *                          If s = 001, the String 111 is returned
     */
    public static String invert(String s)
    {
        int num = 0;
        for(int i=0; i<s.length(); i++)
        {
            num += Integer.parseInt(s.substring(i, i+1))*(int)Math.pow(2, s.length()-1-i);
        }
        boolean wasNeg = num<0;
        num = ((int)Math.pow(2,s.length())-num)%(int)Math.pow(2,s.length());
        String ans = "";
        while(num>0) 
        {
            ans = num%2 + ans;
            num /= 2;
        }
        if(wasNeg)
        {
            while(s.length()-ans.length() != 0)
            {
                if(!ans.substring(0, 1).equals("1"))
                    ans = "0" + ans;
            }
        }
        while(ans.length() < s.length())
        {
            ans = "0" + ans;
        }
        return ans;
    }
}