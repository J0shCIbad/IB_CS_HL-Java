import java.lang.*;

/**
 * The test class for SinglyLinkedListTest for Part B
 * 
 *    test the following methods
 *       addFirst(Object)
 *       getFirst()
 *       addLast(Object)
 *       getLast()
 *       set(int, Object)
 *       getMiddleNode()
 * 
 */
public class StudentLinkedListPartBTest extends junit.framework.TestCase
{
	public void testPartB()
	{
        SinglyLinkedList obj = new SinglyLinkedList();
        obj.addFirst("2");           // 2
        assertEquals("2", obj.getFirst());
        obj.addLast("-2");           // 2 -2
        assertEquals("-2", obj.getLast());
        obj.addLast("22");           // 2 -2 22
        obj.set(2, "222");           // 2 -2 222
        assertEquals("222", obj.getLast());
        assertEquals("-2", obj.getMiddleNode().getValue());
	}
}