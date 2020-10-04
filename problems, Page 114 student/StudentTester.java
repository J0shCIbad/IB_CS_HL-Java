import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
// ****************  ProblemsPage114
   public void testProblemsPage114_01()
   {
      ProblemsPage114 p114 = new ProblemsPage114();

      assertEquals(0, p114.problem_8(1));
      assertEquals(0, p114.problem_9_10(1));
      assertEquals(0, p114.problem_11_13(1));
   }
}