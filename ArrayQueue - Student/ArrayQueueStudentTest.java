import java.util.*;

/**
import java.util.*;

/**
 * @author  Don Allen
 */
public class ArrayQueueStudentTest extends junit.framework.TestCase
{
   public void testArrayQueue01()
   {
      ArrayQueue aq = new ArrayQueue();

      assertEquals(0, aq.size());
      assertEquals(true, aq.isEmpty());
      aq.enqueue("a");
      assertEquals(false, aq.isEmpty());
      aq.enqueue("b");
      assertEquals("a", aq.dequeue());
      aq.enqueue("c");
      aq.enqueue("d");
      aq.enqueue("e");
      
      assertEquals(4, aq.size());
      assertEquals("b", aq.dequeue());
      assertEquals("c", aq.dequeue());
      assertEquals(5, aq.getQueue().length);
   }
}