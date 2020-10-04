import java.util.*;
import java.awt.*;

/**
 * The test class MorseCodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MorseCodeStudentTest  extends junit.framework.TestCase
{
    /**
     * Default constructor for test class MorseCodeTest
     */
    public void testDecode_AEIOU()
    {
       String problemMessage = "decode test 1";
       String morse = ".- . .. --- ..- ";
       MorseCode.start();

       assertEquals("AEIOU", MorseCode.decode(morse));
    }

    public void testEncode_I_AM_A_CONSERVATIVE()
    {
       String problemMessage = "encode test 1";
       String text = "I AM A CONSERVATIVE";
       MorseCode.start();

       assertEquals("..  .- --  .-  -.-. --- -. ... . .-. ...- .- - .. ...- . ",
                                                        MorseCode.encode(text));
    }
}

