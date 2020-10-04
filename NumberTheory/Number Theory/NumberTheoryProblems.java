import java.util.*;
import java.lang.*;
import java.math.*;
/**
 * Friday the 13.
 *
 * @author  
 * @version (a version number or a date)
 */
public class NumberTheoryProblems
{
    /*
     *    returns the prime factorization of m
     */
    public ArrayList<PrimeFactor> getPrimeFactorization(int m)
    {
        ArrayList<PrimeFactor> lpf = new ArrayList<PrimeFactor>();
        int n = 2;
        int exp;
        while( m > 1)
        {
            exp = 0;
            while( m % n == 0)
            {
                exp++;
                m/= n;
            }
            if( exp != 0)
            {
                lpf.add(new PrimeFactor(n, exp));
            }
            n++;
        }
        return lpf;
    }

    public int get_GCD(int m, int n)
    {
        int a = m;
        int b = n;
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public int get_LCM(int m, int n)
    {
        return m * (n / get_GCD(m, n));
    }

    public String toBinary(int n)
    {
        String ans = Integer.toBinaryString(n);
        if ( n < 0)
        {
            return ans.substring(ans.indexOf("0") + 1);
        }
        return ans;  
    }

    public String toHexadecimal(int n)
    {
        return Integer.toHexString(n).toUpperCase();
    }

    public String hexadecimalToBinary(String hex)
    {
        BigInteger x = new BigInteger(hex, 16);
        return x.toString(2);
    }

    public int binaryToDecimal(String bin)
    {
        return Integer.parseInt(bin, 2);
    }

    public int hexadecimalToDecimal(String hex)
    {
        return Integer.parseInt(hex, 16);
    }

    //   no leading zero's allowed
    public String binaryToHexadecimal(String bin)
    {
        return Integer.toHexString(Integer.parseInt(bin, 2)).toUpperCase();
    }

    public int page246_algorithm_5_2_19(int base, int exp, int mod)
    {
        int result = 1;
        int x = base % mod;
        int temp = exp;
        while ( temp > 0)
        {
            if ( temp % 2 == 1)
            {
                result = ( result * x) % mod;
            }
            x = x * x % mod;
            temp /= 2;
        }
        return result;
    }
}