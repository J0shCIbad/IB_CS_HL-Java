/**
 * See page 120-121 in the Descrete Math book for instructions on 
 * valid ISBN numbers
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ISBN_VerificationTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TearCalculatorTest
     */
    public ISBN_VerificationTest()
    {
    }
	public void testISBN_VerificationTest00()
	{
	    ISBN_Verification iv = new ISBN_Verification();
	    int x = 9+ 3*7 +8+ 3*1 +5+ 3*9 +4+ 3*4 +8+ 3*9 +5+ 3*0;
        assertEquals(10 - x%10 == 1, iv.isValid("978-1-59448-950-1"));
        assertEquals(10 - x%10 == 2, iv.isValid("978-1-59448-950-2"));
        assertEquals(10 - x%10 == 9, iv.isValid("978-1-59448-950-9"));

	    iv = new ISBN_Verification();
	    x = 3 +3*9 + 9 +3*0+ 2 +3*9+ 8 +3*4 + 9 +3*5 + 4 + 3*1;
	    int testvalue = 10 - x%10;
        assertEquals(x%10 == 0, iv.isValid("3990-29-84-9541-0"));
        assertEquals(testvalue == 1, iv.isValid("3990-29-84-9541-1"));
	}
}