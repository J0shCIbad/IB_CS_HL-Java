import java.util.*;

/**
 * @author  Don Allen
 */
public class ArrayStackStudentTest extends junit.framework.TestCase
{
   public void testArrayStack01()
   {
      ArrayStack as = new ArrayStack();

      assertEquals(true, as.isEmpty());
      as.push("one");
      as.push("two");
      as.push("three");
      as.push("four");
      assertEquals("four", as.pop());
      assertEquals(false, as.isEmpty());
      assertEquals(3, as.size());
      String[] st= as.getStack();
      assertEquals(10, st.length);
   }
}
