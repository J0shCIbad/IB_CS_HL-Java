import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
// ****************  Problem107Page134_01
   public void testProblem107Page134_01()
   {
      Problem107Page134 p107 = new Problem107Page134();

      assertEquals(2, p107.findFriday13(1945).length);
      assertEquals("April", p107.findFriday13(1945)[0]);
      assertEquals("July", p107.findFriday13(1945)[1]);

      assertEquals(1, p107.findFriday13(2011).length);
      assertEquals("May", p107.findFriday13(2011)[0]);
   }
}