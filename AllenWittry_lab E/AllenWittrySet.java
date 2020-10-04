/*
If client creates a "hash" AllenWittrySet, then it may hold heterogeneous info and other AllenWittrySets.
If client creates a "tree" AllenWittrySet, then it may only hold elements which implement the Comparable interface as required by the TreeSet() class.
This class also has a compareTo() method which enables it to hold other AllenWittrySets.

YES, YOU SHOULD IMPLEMENT    add    AND    toString     FIRST!!!!!!!!!!!!!!!
If you do not implement add, I cannot add objects to AllenWittrySet object
If you do not implement    toString(),   I cannot see what is in your AllenWittrySet object
 */
import java.util.*;

public class AllenWittrySet <E> implements Comparable <E> {

    private Set <E> mySet;

    /*
     * Constructor works - do NOT modify
     */ 
    public AllenWittrySet (String type) {
        if ("hash".equals(type))
            mySet = new HashSet <E> ();
        else if ("tree".equals(type))
            mySet = new TreeSet <E> ();
        else
            mySet = new HashSet <E> ();
    }

    /*
     * Return an AllenWittrySet that is the Union of mySet and s 
     * that is (mySet U s.mySet)
     */
    public AllenWittrySet<E> setUnion(AllenWittrySet <E> s) {
        AllenWittrySet <E> temp = new AllenWittrySet<E>("tree");
        Iterator<E> it = mySet.iterator();
        while(it.hasNext())
        {
            E a = it.next();
            if(!temp.contains(a))
                temp.add(a);
        }
        it = s.iterator();
        while(it.hasNext())
        {
            E a = it.next();
            if(!temp.contains(a))
                temp.add(a);
        }
        return temp;
    }

    /*  
     * Return an AllenWittrySet that is the Intersection of mySet and s 
     * that is(mySet (unsidedown U) s)
     */
    public AllenWittrySet<E> setIntersection(AllenWittrySet <E>  s) {
        AllenWittrySet <E> temp = new AllenWittrySet <E>("tree");
        Iterator<E> it1 = mySet.iterator();
        while(it1.hasNext())
        {
            boolean boo = false;
            E a = it1.next();
            Iterator<E> it2 = s.iterator();
            while(it2.hasNext())
            {
                boo |= a.equals(it2.next());
            }
            if(boo)
            {
                temp.add(a);
            }
        }
        return temp;
    }

    //  return an AllenWittrySet that is the items in mySet and NOT in s 
    //  that is(mySet - s)
    public AllenWittrySet<E> setDifference(AllenWittrySet <E> s) {
        AllenWittrySet<E> temp = new AllenWittrySet<E>("tree");
        Iterator<E> it = mySet.iterator();
        while(it.hasNext())
        {
            E a = it.next();
            if(!s.contains(a))
                temp.add(a);
        }
        return temp;
    }

    //  returns true if mySet is a subset of s
    public boolean isSubsetOf(AllenWittrySet <E> s) {
        Iterator<E> it = mySet.iterator();
        while(it.hasNext())
        {
            if(!s.contains(it.next()))
            {
                return false;
            }
        }
        return true;
    }

    /*  returns true if mySet is a proper subset of s
     *           A set is a proper subset of B iff
     *           set A is a subset B and set A does not equal B
     */
    public boolean isProperSubsetOf(AllenWittrySet <E> s) {
        return isSubsetOf(s) && s.size()!=mySet.size();
    }

    
    
    /*
     * This works - do not mess with
     */
    public Iterator <E> iterator() {
        return mySet.iterator();
    }

    /*
     * Returns the number of elements in mySet
     */
    public int size() {
        return mySet.size();
    }

    /*
     * Returns true if mySet is empty
     */
    public boolean isEmpty() {
        return mySet.isEmpty();
    }

    /*
     * Returns true if mySet contains o
     */
    public boolean contains(E o) {
        return mySet.contains(o);
    }

    /*  
     * Removes all elements of mySet.
     */
    public void clear(){
        mySet.clear();
    }

    //  returns an array which contains only the elements in mySet
    //  That is, mySet.contains(Object[k]), 0 <= k < Object.length
    //  && mySet.size() == Object.length
    public Object[] toArray() {
        return mySet.toArray();
    }

    /*
     * Add o to mySet
     */ 
    public void add(E o) {
        mySet.add(o);
    }

    /*
     * Remove o from mySet
     */
    public void remove(E o) {
        mySet.remove(o);
    }

    // this method is auto-called by Set class when determining
    // if an AllenWittrySet is already in this AlllenWittrySet - if you don't
    // have a compareTo(), then the system issues an exception because it 
    // doesn't have a way to check for equality since the add() method will
    // automatically try to call this since it cannot allow duplicate items
    // to be put into a set

    // return 0 only if both sets contain the same elements
    //  otherwise, since sets are not ordered, you may return any non zero value
    public int compareTo(E otherObj) {
        //   remember to cast otherObj to an AllenWittrySet

        return -1; // we don't care if 1 or -1, just that it means !=
    }

    /*
    public AllenWittrySet<E> sigmaN(int n) {
    Object[] objs = toArray();

    }
    */

    /* return true if mySet is a subset of otherObj 
     *             && otherObj is a subset of mySet 
     *             but there is an easier way :)
     */  
    public boolean equals (Object otherObj) {
        /*
        if (otherObj == null) return false;
        if (getClass() != otherObj.getClass()) return false;
        AllenWittrySet<E> other = (AllenWittrySet) otherObj;
        //  add code below here
        return true;
        */
        AllenWittrySet<E> temp = (AllenWittrySet<E>)otherObj;
        return isSubsetOf(temp) && temp.size()==mySet.size();
    }

    /*
     * 
     * returns a string of the form
     *     "[obj1.toString(), obj2.toString(),...., objN.toString()]
     */
    public String toString() {
        String ans = "[";
        Iterator<E> it = mySet.iterator();
        while(it.hasNext())
        {
            ans += it.next().toString();
            if(it.hasNext())
                ans += ", ";
        }
        ans += "]";
        return ans;
    }
}