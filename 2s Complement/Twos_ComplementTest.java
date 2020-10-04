

/**
 * The test class CarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Twos_ComplementTest extends junit.framework.TestCase
{
    private int two_15 = (int)Math.pow(2, 15);

    public void testInvert01()
    {
        assertEquals("1001", Twos_Complement.invert("0111"));
        assertEquals("111", Twos_Complement.invert("001"));
    }

    public void testConvertDecimalTo2sComplement01()
    {
        assertEquals("00000101", Twos_Complement.convertDecimalTo2sComplement(5, 8));
        assertEquals("1111111111111101", Twos_Complement.convertDecimalTo2sComplement(-3, 16));
    }

    public void testConvertToDecimal01()
    {
        assertEquals(10, Twos_Complement.convertToDecimal("01010"));
        assertEquals(-64+8+4+1, Twos_Complement.convertToDecimal("1001101"));
        assertEquals(2+16+32+128, Twos_Complement.convertToDecimal("010110010"));
        assertEquals(1+8+32+128+256-2048, Twos_Complement.convertToDecimal("100110101001"));
    }

}