import java.io.PrintStream;
import java.lang.Comparable;
import java.lang.Object;
import java.lang.String;

/**
 * The test class SinglyLinkedListTest.
 */
public class SinglyLinkedListStudentsTest extends junit.framework.TestCase
{
	public void testToString00()
	{
		SinglyLinkedList obj=new SinglyLinkedList();
		assertEquals("[]", obj.toString());
	}

	public void testAddFirst00()
	{
		SinglyLinkedList obj=new SinglyLinkedList();
		String problemMsg="Problem with: addFirst00";
		obj.addFirst("OneWord");
		//Examine the object and assert something appropriate here
		assertEquals("[OneWord]", obj.toString());
	}

	public void testAdd00()    // you should expand this test!!!!!
	{
		SinglyLinkedList obj=new SinglyLinkedList();
		String problemMsg="Problem with: addFirst00";
		obj.add(0, "Troy");
		obj.add(1, "Warriors");
		//Examine the object and assert something appropriate here
		assertEquals("[Troy, Warriors]", obj.toString());
	}

	public void testGet00()    // you should expand this test!!!!!
	{
		SinglyLinkedList obj=new SinglyLinkedList();
		Integer first = new Integer(1);
		obj.add(0, first);
		Integer second = new Integer(2);
		obj.add(1, second);
		//Examine the object and assert something appropriate here
		assertEquals(first, obj.get(0));
		assertEquals(second, obj.get(1));
	}

	public void testGetFirst00()
	{
		SinglyLinkedList singlyLi2 = new SinglyLinkedList();
		singlyLi2.addFirst(new Integer(2));
		singlyLi2.addFirst(new Integer(1));
		singlyLi2.addFirst(new Integer(7));
		assertEquals(new Integer(7), singlyLi2.getFirst());
	}

	public void testRemove00()
	{
		SinglyLinkedList singlyLi2 = new SinglyLinkedList();
		singlyLi2.addFirst(new Integer(2));    // [2]
        Integer one = new Integer(1);
		singlyLi2.addFirst(one);               // [1 2]
		singlyLi2.addFirst(new Integer(7));    // [7 1 2]
        Integer temp = new Integer(33);
		singlyLi2.add(1, temp);                // [7 33 1 2]
		assertEquals(one, singlyLi2.remove(2) );
		assertEquals("[7, 33, 2]", singlyLi2.toString());
	}

	public void testSet00()
	{
		SinglyLinkedList singlyLi2 = new SinglyLinkedList();
		singlyLi2.addFirst(new Integer(2));    // [2]
        Integer one = new Integer(1);
		singlyLi2.addFirst(one);               // [1 2]
		singlyLi2.addFirst(new Integer(7));    // [7 1 2]
        Integer temp = new Integer(33);
		singlyLi2.add(1, temp);                // [7 33 1 2]
		assertEquals(one, singlyLi2.set(2, new Integer(44) ) );
		assertEquals("[7, 33, 44, 2]", singlyLi2.toString());
	}
}