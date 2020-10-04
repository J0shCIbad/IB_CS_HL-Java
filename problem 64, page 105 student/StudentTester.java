import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{

// ****************  Problem64Page105
   public void testProblem64Page105_01()
   {
      Problem64Page105 p64 = new Problem64Page105();

      assertEquals(119, p64.evaluate_J(123), 0.005);
      assertEquals(359, p64.evaluate_J(435), 0.005);
      assertEquals(31, p64.evaluate_J(271), 0.005);
      assertEquals(363, p64.evaluate_J(437), 0.005);
      assertEquals(935, p64.evaluate_J(1491), 0.005);
      assertEquals(859, p64.evaluate_J(1453), 0.005);
      assertEquals(265, p64.evaluate_J(2180), 0.005);
      assertEquals(587, p64.evaluate_J(805), 0.005);
      assertEquals(743, p64.evaluate_J(883), 0.005);
      assertEquals(2059, p64.evaluate_J(9221), 0.005);
   }
}