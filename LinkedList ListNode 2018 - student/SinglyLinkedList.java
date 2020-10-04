/**
 * lab goals:        - Learn all about "do it yourself" linked lists
 *                   - Have a lot of fun looking at the bright colors red and green!
 *
 * class invariant: elements stored in the list are all of the same type.
 */
import java.util.*;
import java.io.PrintStream;
import java.lang.Comparable;
import java.lang.Object;
import java.lang.String;

public class SinglyLinkedList
{
    private ListNode first;
    private Class type;

    public SinglyLinkedList()
    {
        first = null;
    }

    private void assertValidType(Object o)
    {
        if(type == null) type = o.getClass();
        else if(type!=o.getClass()) throw new IllegalArgumentException();
    }

/*
 *    returns a string of the form:  [obj.toString(), obj.toString(), obj.toString(), ..., obj.toString()]
 *
 *    returns  [] if the List is empty
 */    
    public String toString()
    {
        if (first == null) return "[]";
        String returnItem = "";
        ListNode temp = first;
        while (temp != null)
        {
            returnItem += " " + temp.getValue().toString() + ",";
            temp = temp.getNext();
        }
        return "[" + returnItem.substring(1,returnItem.length()-1)+"]";
    }

/*    insert obj at index ind, shift all previous objects to the next higher index
 *     e.g., list before: [1, 2, 3, 4]
 *     list.add(2, 11) modifies list to [1, 2, 11, 3, 4]
 *     
 *     preCondition: 0 <= ind <= size()
 */
    public void add(int ind, Object obj)
    {
        int i = 0;
        ListNode back = null;
        ListNode trav = first;
        while (i < ind) 
        {
            i++;
            back = trav;
            trav = trav.getNext();
        }
        if (back == null)
            first = new ListNode(obj, first);
        else
            back.setNext(new ListNode(obj, trav));
    }

/*
 *     return a referrence (not the object) to the obj at index ind.
 *     list is not modified!
 *     preCondition: 0 <= ind < size()
 *                   if list is empty return null
 */
    public Object get(int ind)
    {
        if (size() == 0)
            return null;
        int i = 0;
        ListNode trav = first;
        while (i < ind) 
        {
            i++;
            trav = trav.getNext();
        }
        return trav.getValue();
    }

/*
 *     return a referrence to the ListNode (not the object or Value) at index ind.
 *     list is not modified!
 *     preCondition: 0 <= ind < size()
 *                   if list is empty return null
 */
    public ListNode getNodeAtIndex(int ind)
    {
        if (size() == 0)
            return null;
        int i = 0;
        ListNode trav = first;
        while (i < ind) 
        {
            i++;
            trav = trav.getNext();
        }
        return trav;
    }

/*
 *    returns the number of elements in the List
 *    
 *    returns zero if the List is empty
 */
    public int size()
    {
        int ans = 0;

        ListNode trav = first;
        while (trav !=null) 
        {
            ans++;
            trav = trav.getNext();
        }
        return ans;
    }

/*
 *    returns the number of elements in the List from curNode, including curNode
 *    
 *    returns zero if the List is empty
 *    
 *    preCondition:  curNode is a ListNode in List
 */
    public int sizeFrom(ListNode curNode)
    {
        if (curNode == null) return 0;
        return 1 + sizeFrom(curNode.getNext());
    }


/*
 *    returns true if a ListNode in List is equal ( getValue().equals( o ) == true) 
 *    
 *    returns false otherwise
 */
    public boolean contains(Object o)
    {
        ListNode trav = first;
        while (trav != null)
        {
            if (trav.getValue().equals(o)) return true;
            trav = trav.getNext();
        }
        return false;
    }

/*
 *    returns true if the size of the List is 0
 *    
 *    Returns false otherwise
 */
    public boolean isEmpty()
    {
        return first == null;
    }

    
/*
 * 
 *          END OF METHODS FOR PART 1 !!!!!!!!
 * 
 * 
 */

/*
 *     Creates a ListNOde containing value
 *     
 *     insert the newly created ListNOde at Front of List
 */
    public void addFirst(Object value)
    {
        assertValidType(value);
        first = new ListNode(value, first);
    }

/*
 *     return the Object stored in the first ListNOde
 */
    public Object getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException(); //Don't worry about designing a test to turn this line Green
        }
        else
            return first.getValue();
    }

/*
 *     Creates a ListNOde containing value
 *     
 *     insert the newly created ListNOde at End of List
 */
    public void addLast(Object value)
    {
        assertValidType(value);
        ListNode temp = new ListNode(value, null);
        ListNode trav = first;
        ListNode back = null;
        while (trav != null)
        {
            back = trav;
            trav = trav.getNext();
        }
        if (back == null)
            first = temp;
        else
            back.setNext(temp);
    }

/*
 *     return the Object stored in the last ListNOde
 */
    public Object getLast()
    {
        if (first == null) return null;
        ListNode trav = first;
        ListNode back = null;
        while (trav != null)
        {
            back = trav;
            trav = trav.getNext();
        }
        if (back == null)
            return first.getValue();
        else
            return back.getValue();
    }

    //  return the object previously at index ind.
    //  replace that value with obj!
    //  preCondition: 0 < ind < size()
    //                size() > 0
    public Object set(int ind, Object obj)
    {
        int i = 0;
        ListNode trav = first;
        Object temp = trav.getValue();
        while (i < ind)
        {
            i++;
            trav = trav.getNext();
            temp = trav.getValue();
        }
        trav.setValue(obj);
        return temp;
    }

/*
 *     return a reference to the middle ListNode
 *     
 *     That is, the Listnode at index = size() / 2   (remember to use integer Math - truncate/round down
 *     
 *     if size() == 0 return null
 */
    public ListNode getMiddleNode()
    {
        if ( size() == 0 ) return null;
        ListNode temp = first;
        int limit = size()/2;
        //      if (size() % 2 == 0) limit++;
        for (int i = 0; i < limit; i++)
            temp = temp.getNext();
        return temp;
    }

  
    
/*
 * 
 *          END OF METHODS FOR PART 2 !!!!!!!!
 * 
 * 
 */
    
    
/*
 *     return the object at index ind.
 *     
 *     deletes the ListNode at index = ind
 *     
 *     preCondition: 0 <= ind < size()
 *                   0 < size()
 *                   
 *     postCondition  size has been decreased by 1
 */
    public Object remove(int ind)
    {
        int i = 0;
        ListNode trav = first;
        ListNode back = null;
        while (i < ind)
        {
            i++;
            back = trav;
            trav = trav.getNext();
        }
        if (back == null)
            first = first.getNext();
        else
            back.setNext(trav.getNext());
        return trav.getValue();
    }

/*
 *   contents of the List have been reversed
 *   
 *   Sample:   if  toString().equals("[a, b, c, d, ... ,m]") == true before reverse
 *   
 *           then  toString().equals("[m, l, k, j, ... ,a]") == true after reverse
 *           
 *   if size() == 0, or size() == 1. the List is not modified
 * 
 */
    public void reverse()
    {
        ArrayList l = new ArrayList();
        ListNode trav = first;
        while (trav != null)
        {
            l.add(0, trav.getValue());
            trav = trav.getNext();
        }

        trav = first;
        while (trav != null)
        {
            trav.setValue(l.get(0));
            l.remove(0);
            trav = trav.getNext();
        }
    }

/*
 *     deletes the first (at smallest index) ListNode in the List such that .getValue().equals(elem) and return true
 * 
 *     if no ListNode contains elem, return false and do NOT modify the List
 */
    public boolean remove(Object elem)
    {
        ListNode curr = first;
        ListNode back = null;

        while (curr != null && !curr.getValue().equals(elem))
        {
            back = curr;
            curr = curr.getNext();
        }
        if (curr == null) // elem not found
            return false;

        if (back == null)  // first node
        {
            first = first.getNext();
            return true;
        }
        back.setNext(curr.getNext());
        return true;

    }


/*
 *     deletes all ListNode in the List such that .getValue().equals(elem) and return true
 * 
 *     if no ListNode contains elem, return false and do NOT modify the List
 */
    public boolean removeAll(Object elem)
    {
        boolean flag = false;
        while ( contains(elem))
        {
            remove(elem);
            flag = true;
        }
        return flag;
    }

/*
 *    returns Object stored in first ListNode (use getValue()) in the List
 *    AND removes that node from the List
 *    
 *    preCondition:  0 < size()
 *    
 *    postondtion:  size() has been decresed by 1
 *    
 */
    public Object removeFirst()
    {
        if (first == null)
            return null;
        Object temp = first.getValue();
        first = first.getNext();
        return temp;
    }

    // returns Object stored in last node - use getValue()
    public Object removeLast()
    {
        reverse();
        Object temp = removeFirst();
        reverse();
        return temp;
    }

    public void inOrderInsert(Comparable c) {
        assertValidType(c);

        ListNode back = null;
        ListNode trav = first;
        while (trav != null && c.compareTo(trav.getValue()) > 0)
        {
            back = trav;
            trav = trav.getNext();
        }
        if (back == null)  // front insert
        {
            addFirst(c);
            return;
        }
        ListNode temp = new ListNode(c, trav);
        back.setNext(temp);
    }
}


