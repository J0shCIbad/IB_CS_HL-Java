import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Wnawn
 * @version 1.5
 * @gamemode BedWars
 */
public class ArrayQueue
{
    private int back;
    private int size = 5;
    private String[] myQueue;
    public ArrayQueue()
    {
        myQueue = new String[5];
    }

    /*
     *   You must 
     *       adds the parameter item to back of queue
     *   
     *   For Extra Credit
     *      if the queue is full
     *      {
     *          create a new String[] with double the size
     *                         and copy contents to new array
     *   
     *          resasign myQueue to the String{}
     *       
     *       }
     */
    public void enqueue(String item)
    {
        if(back == size)
        {
            size *= 2;
            String[] temp = new String[size];
            for(int i=0; i<myQueue.length; i++)
                temp[i] = myQueue[i];
            myQueue = temp;
        }
        myQueue[back] = item;
        back++;
    }

    /*
     *   returns (and removes) the front element from queue
     */
    public String dequeue()
    {
        String ans = myQueue[0];
        for(int i=0; i<back-1; i++)
            myQueue[i] = myQueue[i+1];
        myQueue[back-1] = "";
        back--;
        return ans;
    }

    /*
     *   returns the number of elements in the queue
     */
    public int size()
    {
        return back;
    }

    /*
     *    returns true if the queue is empty
     *            false if the queue contains at least one element
     */
    public boolean isEmpty()
    {
        return back==0;
    }

    public String[] getQueue()
    {
        return myQueue;
    }
}