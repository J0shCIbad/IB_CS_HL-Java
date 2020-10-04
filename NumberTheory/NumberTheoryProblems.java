import java.util.*;
import java.lang.Math;
/**
 * Friday the 13.
 *
 * @author  
 * @version (a version number or a date)
 */
public class NumberTheoryProblems
{
    /* OK
     *    returns the prime factorization of m
     */
    public ArrayList<PrimeFactor> getPrimeFactorization(int m)
    {
        ArrayList<PrimeFactor> lpf = new ArrayList<PrimeFactor>();
        int n=2;
        int exp;
        while(m>1){
            exp = 0;
            while(m%n == 0){
                exp++;
                m/=n;
            }
            if(exp != 0)
                lpf.add(new PrimeFactor(n, exp));
            n++;
        }
        return lpf;
    }

    /** Ok **/
    public int get_GCD(int m, int n)
    {
        int a1 = Math.max(m,n);
        int a2 = Math.min(m,n);
        while(a1%a2 != 0)
        {
            int temp = a1%a2;
            a1 = a2;
            a2 = temp;
        }
        return a2;
    }

    /** Ok **/
    public int get_LCM(int m, int n)
    {
        return m*n/get_GCD(m,n);
    }

    /** Ok **/
    public String toBinary(int n)
    {
        String ans = "";
        while(n>0)
        {
            ans = n%2 + ans;
            n /= 2;
        }
        return ans;
    }

    /** OK **/
    public String toHexadecimal(int n)
    {
        String ans = "";
        int temp = 0;
        while(n>0)
        {
            temp = n%16;
            switch(temp){
                case 10:
                ans = "A" + ans;
                break;
                case 11:
                ans = "B" + ans;
                break;
                case 12:
                ans = "C" + ans;
                break;
                case 13:
                ans = "D" + ans;
                break;
                case 14:
                ans = "E" + ans;
                break;
                case 15:
                ans = "F" + ans;
                break;
                default:
                ans = temp  + ans;
                break;
            }
            n /= 16;
        }
        return ans;
    }

    /** Ok **/
    public String hexadecimalToBinary(String hex)
    {
        String ans = "";
        for(int i=0; i<hex.length(); i++)
        {
            int temp = Character.getNumericValue(hex.charAt(i));
            switch(temp){
                case 0: ans += "0000"; break;
                case 1: ans += "0001"; break;
                case 2: ans += "0010"; break;
                case 3: ans += "0011"; break;
                case 4: ans += "0100"; break;
                case 5: ans += "0101"; break;
                case 6: ans += "0110"; break;
                case 7: ans += "0111"; break;
                case 8: ans += "1000"; break;
                case 9: ans += "1001"; break;
                case 10: ans += "1010"; break;
                case 11: ans += "1011"; break;
                case 12: ans += "1100"; break;
                case 13: ans += "1101"; break;
                case 14: ans += "1110"; break;
                case 15: ans += "1111"; break;
            }
        }
        while(ans.charAt(0) == '0')
            ans = ans.substring(1);
        return ans;
    }
    /** Ok **/
    public int binaryToDecimal(String bin)
    {
        int ans = 0;
        for(int i=0; i<bin.length(); i++)
        {
            ans += (int)(Math.pow(2,bin.length()-i-1)) * Integer.parseInt(bin.substring(i, i+1));
        }
        return ans;
    }

    /** Ok **/
    public int hexadecimalToDecimal(String hex)
    {
        return binaryToDecimal(hexadecimalToBinary(hex));
    }

    /** Ok **/
    public String binaryToHexadecimal(String bin)
    {
        return toHexadecimal(binaryToDecimal(bin));
    }

    /** Ok **/
    public int page246_algorithm_5_2_19(int base, int exp, int mod)
    {
        int ans = 1;
        int x = base%mod;
        while(exp>0){
            if(exp%2 == 1)
                ans = (ans*x)%mod;
            x = (x*x)%mod;
            exp /= 2;
        }
        return ans;
    }
}