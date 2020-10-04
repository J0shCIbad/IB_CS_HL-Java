/**
 * lab goals:        - Learn all about "do it yourself" linked lists
 *                   - Learn how to create unit tests using JUnit and the Jamtester tool. 
 *                   - Learn how to create a complete battery of tests so as to attain complete "code coverage".
 *                   - Have a lot of fun looking at the bright colors red and green!
 *
 * lab instructions: 
 *                   while ( everyMethodNotYetWrittenAndThoroughlyTested() ) {
 *                     1) Write a test for a method.
 *                     2) Run and watch the test fail.
 *                     
 *                     while ( testNotYetGreen() ) {
 	                     3) Write/modify the code for the method.
 *                       4) re-run the test.
 *                     }
 *                   } 
 *
 *                   Now that you have at least one test method per method in your class, go back and run
 *                   all tests in the student tool. Do you have complete code coverage? If not, design more
 *                   tests until you do.
 *
 * class invariant: elements stored in the list are all of the same type.
 */
import java.util.*;
import java.io.PrintStream;
import java.lang.Comparable;
import java.lang.Object;
import java.lang.String;

public class SinglyLinkedList2 extends SinglyLinkedList
{
  public Object middleNode()
  {
      return null;    // so it compiles
  }

  public SinglyLinkedList concatenateList()
  {
      return null;    // so it compiles
  }

  public String toString()
  {
	  return "[ so it compiles ]";
  }

  public void addLast(Object value)
  {
    assertValidType(value);

  }

  public Object getLast()
  {
      return null;    // so it compiles
  }

  private int size(ListNode curNode)
  {
      return -1;    // what is this method for?
  }

  public void reverse()
  {
  }

  public boolean contains(Object o)
  {
    return false;
  }

  public boolean remove(Object elem)
  {
    return true;
  }

  public boolean removeAll(Object elem)
  {
     return false;
  }

// returns Object stored in last node - use getValue()
  public Object removeLast()
  {
      return null;    // so it compiles
  }

  public void inOrderInsert(Comparable c) {
  }
}
