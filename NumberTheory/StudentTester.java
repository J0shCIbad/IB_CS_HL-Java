import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
    public void testPF_Equals()
    {
        PrimeFactor pf1 = new PrimeFactor(2, 4);
        PrimeFactor pf2 = new PrimeFactor(2, 4);
        assertEquals(pf1, pf2);
    }

    public void testTemp()
    {
        NumberTheoryProblems nt = new NumberTheoryProblems();

        ArrayList<PrimeFactor> ans = nt.getPrimeFactorization(2*2*2*2);
        assertEquals(1, ans.size());
        assertEquals(2, ans.get(0).getValue());
        assertEquals(4, ans.get(0).getExponent());

        ans = nt.getPrimeFactorization(2*2*2*2*3*3*5);
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(new PrimeFactor(2, 4)));
        assertEquals(true, ans.contains(new PrimeFactor(3, 2)));
        assertEquals(true, ans.contains(new PrimeFactor(5, 1)));
        assertEquals(false, ans.contains(new PrimeFactor(2, 3)));
        assertEquals(false, ans.contains(new PrimeFactor(3, 1)));
        assertEquals(false, ans.contains(new PrimeFactor(5, 0)));
    }

    public void testEmAll()
    {
        NumberTheoryProblems nt = new NumberTheoryProblems();
        assertEquals("1011", nt.toBinary(11));
        assertEquals("111111", nt.toBinary(16+16+16+15));
        assertEquals("3F", nt.toHexadecimal(16+16+16+15));
        assertEquals("11100001010", nt.hexadecimalToBinary("70A"));
        assertEquals(17, nt.binaryToDecimal("10001"));
        assertEquals(3*16+15, nt.hexadecimalToDecimal("3F"));
        assertEquals("F1", nt.binaryToHexadecimal("11110001"));
        assertEquals(113, nt.page246_algorithm_5_2_19(572, 29, 713));
        assertEquals(5, nt.get_GCD(5, 25));
        assertEquals(18, nt.get_LCM(9, 6));
        
        ArrayList<PrimeFactor> ans = nt.getPrimeFactorization(2*2*2*2);
        assertEquals(1, ans.size());
        assertEquals(2, ans.get(0).getValue());
        assertEquals(4, ans.get(0).getExponent());
    }

    public void testSelected()
    {
        NumberTheoryProblems nt = new NumberTheoryProblems();
        assertEquals("111111", nt.toBinary(16+16+16+15));
        assertEquals("1011", nt.toBinary(11));
        assertEquals("3F", nt.toHexadecimal(16+16+16+15));
        assertEquals("11100001010", nt.hexadecimalToBinary("70A"));
        assertEquals(17, nt.binaryToDecimal("10001"));
        assertEquals(3*16+15, nt.hexadecimalToDecimal("3F"));
        assertEquals("F1", nt.binaryToHexadecimal("11110001"));
        assertEquals(113, nt.page246_algorithm_5_2_19(572, 29, 713));
        assertEquals(5, nt.get_GCD(5, 25));
        assertEquals(18, nt.get_LCM(9, 6));
        
        
    }

}