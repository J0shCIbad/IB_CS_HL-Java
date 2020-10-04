import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Josh Ibad
 */

public class ArrayStack
{
    private String[] myStack;
    private int top;
    public ArrayStack()
    {
        myStack = new String[10];
        top = 0;
    }

    /*
     *   preCondition:  Stack is not empty
     *   
     *   returns the top element of the Stack
     *   
     *   post Condition:  top element has been removed from Stack
     */
    public String pop()
    {
        top--;
        return myStack[top+1];
    }

    /* 
     *   adds the parameter item to top of Stack
     *   
     *   if size() == myStack.lenght
     *   {
     *       create a new String[ 2*myStack.length ] 
     *         and copy contents to this new String[]
     *       
     *      reassign myStack to this new String[]
     *   }
     *   
     */
    public void push(String item)
    {
        if(top+1 == myStack.length)
        {
            String[] temp = new String[myStack.length*2];
            for(int i=0; i<myStack.length; i++)
                temp[i] = myStack[i];
            myStack = temp;
        }
        top++;
        myStack[top] = item;
    }

    /*
     *   returns true if the Stack is Empty
     *           false if the Stack conatins at least one element
     */
    public boolean isEmpty()
    {
        return top == 0;
    }

    /*
     *   return the number of elements in the Stack
     */
    public int size()
    {
        return top;
    }

    /*
     *   DO NOT MODIFY UNDER PENALTY OF DEATH BY EXTREME TORTURE!!!!!!!!!!!!!!!!!!!
     */
    public String[] getStack()
    {
        return myStack;
    }
}