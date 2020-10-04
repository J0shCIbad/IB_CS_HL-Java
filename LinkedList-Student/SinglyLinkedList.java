import java.util.*;
import java.io.PrintStream;
import java.lang.*;

public class SinglyLinkedList
{
    private ListNode first;
    private Class type;

    public SinglyLinkedList()
    {
        first = null;
    }

    public ListNode getFront()
    {
        return first;   // so it compiles
    }

    protected void assertValidType(Object o)
    {
        if(type == null) type = o.getClass();
        else if(type!=o.getClass()) throw new IllegalArgumentException();
    }

    //  insert obj at index ind, shift all previous objects to the next higher index
    //  e.g., list before [1 2 3 4]
    //  list.add(2, 11) modifies list to [1 2 11 3 4]
    //  preCondition: 0 <= ind <= size()
    public void add(int ind, Object obj)
    {
        if(first == null)
        {
            first = new ListNode(obj, null);
        }
        else
        {
            ListNode temp = first;
            for(int i=0; i<ind; i++)
            {
                if(temp.getNext() == null)
                    temp.setNext(new ListNode(null, null));
                temp = temp.getNext();
            }
            if(temp.getValue() != null)
            {
                Object temp2 = temp.getValue();
                temp.setValue(obj);
                while(temp.getNext() != null)
                {
                    temp = temp.getNext();
                    Object temp3 = temp.getValue();
                    temp.setValue(temp2);
                    temp2 = temp3;
                }
                temp = temp.getNext();
                temp.setValue(temp2);
            }
            else
            {
                temp.setValue(obj);
            }
        }
    }

    /**
     *  return a referrence (not the object) to the obj at index ind.
     *  list is not modified!
     *  preCondition: 0 <= ind < size()
     *                if list is empty return null
     */
    public Object get(int ind)
    {
        ListNode ans = first;
        for(int i=0; i<ind; i++)
        {
            ans = ans.getNext();
        }
        if(ans.getValue() == null)
            return null;
        else
            return ans.getValue();    
    }

    //  return the object at index ind.
    //  preCondition: 0 <= ind < size()
    //                0 < size()
    public Object remove(int ind)
    {
        ListNode ans = first;
        for(int i=0; i<ind; i++)
        {
            ans = ans.getNext();
        }
        if(ans.getValue() == null)
            return null;
        else
            return ans.getValue();
    }

    //  return the object previously at index ind.
    //  replace that value with obj!
    //  preCondition: 0 < ind < size()
    //                size() > 0
    public Object set(int ind, Object obj)
    {
        ListNode temp = first;
        for(int i=0; i<ind; i++)
        {
            temp = temp.getNext();
            System.out.println(temp.getValue());
        }
        Object ans = temp.getValue();
        temp.setValue(obj);
        return ans;
    }

    public Object getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException(); //Don't worry about testing to this
        }
        else
            return first;    // so it compiles
    }

    public void addFirst(Object value)
    {
        assertValidType(value);

    }

    public String toString()
    {
        return "[ so it compiles ]";
    }

    public int size()
    {
        return -999;    // so it compiles
    }

    private int size(ListNode curNode)
    {
        return -1;    // what is this method for?
    }

    // returns Object stored in first node - use getValue()
    public Object removeFirst()
    {
        return null;    // so it compiles
    }
}
