import java.lang.*;

/**
 * The test class for SinglyLinkedListTest for Part C
 * 
 *    test the following methods
 *       remove(int)
 *       remove(Object)
 *       removeAll(Object)
 *       removeFirst()
 *       removeLast()
 * 
 */
public class StudentLinkedListPartCTest extends junit.framework.TestCase
{
	public void testPartc()
	{
        SinglyLinkedList obj = new SinglyLinkedList();
        obj.addFirst("2");            // 2
        obj.addLast("-2");            // 2 -2
        obj.add(2, "22");             // 2 -2 22
        obj.add(2, "222");            // 2 -2 222 22
        obj.addFirst("0");            // 0 2 -2 222 22
        obj.addLast("992");           // 0 2 -2 222 22 992
        assertEquals("992", obj.remove(5));             // 0 2 -2 222 22
        assertEquals("[0, 2, -2, 222, 22]", obj.toString());
        assertEquals(true, obj.remove("0"));           // 2 -2 222 22
        assertEquals("[2, -2, 222, 22]", obj.toString());
        assertEquals("2", obj.removeFirst());         // -2 222 22
        assertEquals("22", obj.removeLast());         // -2 222
        obj.addFirst("0");            // 0 -2 222
        obj.addFirst("0");            // 0 0 -2 222
        obj.addLast("0");             // 0  -2 222 0
        assertEquals(true, obj.removeAll("0"));           // -2 222
        assertEquals("[-2, 222]", obj.toString());
	}
}