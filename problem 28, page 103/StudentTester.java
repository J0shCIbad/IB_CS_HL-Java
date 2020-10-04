import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{

// ****************  Problem28Page103
   public void testProblem28Page103_01()
   {
      Problem28Page103 p28 = new Problem28Page103();

      assertEquals(0.5, p28.evaluate(1), 0.005);
      assertEquals(0.8333333333333334, p28.evaluate(5), 0.005);
   }
}