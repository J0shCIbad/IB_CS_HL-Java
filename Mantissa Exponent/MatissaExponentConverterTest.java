/**
 * The test class CarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatissaExponentConverterTest extends junit.framework.TestCase
{

    public void testToMatissaExponent01()
    {
        assertEquals("011000 0100", MatissaExponentConverter.toMatissaExponent(12.0, 6, 4));
        assertEquals("np", MatissaExponentConverter.toMatissaExponent(128.+64.+16.+8.+2., 6, 4));
        assertEquals("np", MatissaExponentConverter.toMatissaExponent(16.+8.+2.+1., 6, 3));
    }

    public void testToDouble01()
    {
        assertEquals(7.0, MatissaExponentConverter.toDouble("011100 00011"));
        assertEquals((2*2*2*(-1+1/2.+1/8.)), MatissaExponentConverter.toDouble("110100 00011"), 0.05);
    }
}