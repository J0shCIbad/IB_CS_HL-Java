import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
// ****************  Problem77Page134
   public void testProblem77Page134_01()
   {
      String[] domain = {"1", "2", "3"};
      problem77Page134 p103 = new problem77Page134(domain);

      String[] para = {"1", "2", "3"};
      assertEquals("111", p103.weirdStringFunction(para));

      String[] para1 = {"a", "b", "c"};
      assertEquals("000", p103.weirdStringFunction(para1));

      String[] para2 = {"s", "b", "1"};
      assertEquals("001", p103.weirdStringFunction(para2));
   }
}