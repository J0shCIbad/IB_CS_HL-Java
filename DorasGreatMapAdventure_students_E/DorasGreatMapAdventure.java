/*
 *   If client creates a "hash" DorasGreatMapAdventure, key will have a reasonable hashCode, the associated set contains Objects
 *   If client creates a "tree" DorasGreatMapAdventure, key will implement Comparable interface as required by the TreeMap() class,
 *                                                                          the associated set contains Objects
 */

import java.util.*;
/**
 * DorasGreatMapAdventure 1
 * 
 * @author Josh Ibad
 * @teacher Mr. Allen
 * @period 1
 * @version 08/23/18
 */
public class DorasGreatMapAdventure<K,V>{

    /*
     *   Thou shall add NO methods that that modify any properties of iAmTheMap.
     *   Modify any properties of iAmTheMap may cause you other methods to fail toString() testing
     */
    private Map<K, Set<V>> iAmTheMap;

    /*
     *   Thou shall not modify the constructor.
     *   Modify the constructor of iAmTheMap may cause you other methods to fail toString() testing
     */
    public DorasGreatMapAdventure(String type) {
        if ("hash".equals(type))
            iAmTheMap = new HashMap<K, Set<V>>();
        else if ("tree".equals(type))
            iAmTheMap = new TreeMap<K, Set<V>>();
        else
            iAmTheMap = new HashMap<K, Set<V>>();
    }

    /*
     *      returns the set of keys from iAmTheMap
     *      I know, I gave it to you.
     */
    public Set<K> keySet() {
        return iAmTheMap.keySet();   
    }

    /*
     *      returns iAmTheMap - Just in case there is a DorasGreatMapAdventureTheSequel
     *      I know, I gave it to you.
     */
    public Map<K, Set<V>> getMap() {
        return iAmTheMap;
    }

    /*
     *      add tico to the set associated with key.
     *      If key is not in iAmTheMap, add a new TreeSet containg tico as its sole member
     *
     *    yes - add a TREE set to insure matching traversal order 
     *
     *
     */
    public void add(K key, V tico) {
        Set<V> set;
        if(!iAmTheMap.containsKey(key))
        {
            set = new TreeSet<V>();
            set.add(tico);
            iAmTheMap.put(key, set);
        }
        else
        {
            set = iAmTheMap.get(key);
            set.add(tico);
        }
    }

    /*
     *      returns the total number of items in the iAmTheMap
     *      That is, the sum of the size of each set assocaiated with all keys
     *               plus the number of keys
     *               redundant items are counted multiple times.
     */
    public int size() {
        int size = 0;
        Iterator<K> it1 = iAmTheMap.keySet().iterator();
        while(it1.hasNext())
        {
            size++;
            size += iAmTheMap.get(it1.next()).size();
        }
        return size;
    }

    /*
     *      returns the total number of non key items in the iAmTheMap
     *      That is, the sum of the size of each set assocaiated with all keys
     */
    public int numItems()
    {
        int size = 0;
        Iterator<K> it1 = iAmTheMap.keySet().iterator();
        while(it1.hasNext())
        {
            size += iAmTheMap.get(it1.next()).size();
        }
        return size;
    }

    /*
     *      returns the total number of distinct non key items in the iAmTheMap
     *      That is, the sum of the size of each set assocaiated with all keys,
     *               not counting duplicates
     */
    public int numDistinctItems() {
        int size = 0;
        Iterator<K> it1 = iAmTheMap.keySet().iterator();
        ArrayList<V> li = new ArrayList<V>();
        while(it1.hasNext())
        {
            Iterator<V> it2 = iAmTheMap.get(it1.next()).iterator();
            while(it2.hasNext())
            {
                V obj = it2.next();
                if(!li.contains(obj))
                {
                    size++; 
                    li.add(obj);
                }
            }
        }
        return size;
    }

    /*
     *      returns true iff
     *           iAmTheMap is Empty or all sets in the Map are Empty
     *      otherwise returns false
     */
    public boolean isEmpty() {
        if(iAmTheMap.isEmpty())
            return true;
        Iterator<K> it = iAmTheMap.keySet().iterator();
        while(it.hasNext())
        {
            if(iAmTheMap.get(it.next()).isEmpty())
                return true;
        }
        return false;
    }

    /*
     *      returns true if a one or more associated set contains diego
     *      otherwise (no set contains diego) return false
     *      
     */
    public boolean contains(Object diego)
    {
        Iterator<K> it = iAmTheMap.keySet().iterator();
        while(it.hasNext())
        {
            if(iAmTheMap.get(it.next()).contains((V) diego))
                return true;
        }
        return false;
    }

    /*
     *      returns an array containing all elements from the associated sets
     *      items may appear in the array more than once
     *      keys are not to be added to the array
     */
    public Object[] toArray()
    {
        ArrayList<V> li = new ArrayList<V>();
        Iterator<K> it1 = iAmTheMap.keySet().iterator();
        while(it1.hasNext())
        {
            Iterator<V> it2 = iAmTheMap.get(it1.next()).iterator();
            while(it2.hasNext())
            {
                li.add(it2.next());
            }
        }
        return li.toArray();
    }

    /*
     *      if tico is in the Set associate with key
     *          remove tico from the set associated with key.
     *          if the Set becomes Empty, remove the key from iAmTheMap
     *      otherwise (tico is not in the Set) 
     *          - do not throw an exception, that is exit the method gracefully
     */
    public void remove(K key, V tico) {
        if(iAmTheMap.containsKey(key))
        {
            iAmTheMap.get(key).remove(tico);
            if(iAmTheMap.get(key).size() == 0)
                iAmTheMap.remove(key);
        }
    }

    /*
     *      remove isa from all sets
     *          if the Set becomes Empty, remove the key from iAmTheMap
     */
    public void removeFromAll(V isa)
    {
        Map<K, Set<V>> temp = new HashMap<K, Set<V>>();
        Iterator<K> it = iAmTheMap.keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            temp.put(key, iAmTheMap.get(key));
        }
        it = iAmTheMap.keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            if(temp.containsKey(key))
            {
                temp.get(key).remove(isa);
                if(temp.get(key).size() == 0)
                    temp.remove(key);
            }
        }
        iAmTheMap = temp;
    }

    /*
     *      Every key in this.iAmTheMap is a key in otherDorasGreatMapAdventure.iAMTheMap
     *      Every key in otherDorasGreatMapAdventure.iAmTheMap is a key in this.iAMTheMap
     *      Each pair of set for a given key are equal
     *           that is,  iAmTheMap.get(key).equals(otherDorasGreatMapAdventure.iAmTheMap.get(key))
     */
    public boolean equals (Object otherDorasGreatMapAdventure) {
        DorasGreatMapAdventure obj = (DorasGreatMapAdventure) otherDorasGreatMapAdventure;
        Iterator<K> it1 = iAmTheMap.keySet().iterator();
        Iterator<K> it2 = obj.keySet().iterator();
        while(it1.hasNext())
        {
            if(!obj.keySet().contains(it1.next()))
                return false;
        }
        while(it2.hasNext())
        {
            if(!iAmTheMap.keySet().contains(it2.next()))
                return false;
        }
        it1 = iAmTheMap.keySet().iterator();
        while(it1.hasNext())
        {
            K key = it1.next();
            if(!iAmTheMap.get(key).equals(obj.getMap().get(key)))
                return false;
        }
        return true;
    }

    /*
     *      The String should be of the form:
     *      "{key.toString()=iAmThemap.get(key).toString(), <repeat for all keys>}
     *      a single = between key and set, with a comma and a single space between each key set pair
     */
    public String toString() {
        String str = "{";
        Iterator<K> it = iAmTheMap.keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next(); 
            str += key.toString() + "=" + iAmTheMap.get(key).toString();
            if(it.hasNext())
                str += ", ";
        }
        return str + "}";
    }

    // stuff added after attempt 1

    /*
     *      Finds the largest value in all the sets contained in the map.
     *      You should assume that all Sets contain comparable items
     *      and that all sets are Comparable to each other
     *      DorasGreatMapAdventure is NOT empty
     */
    public V maxItem()
    {
        Iterator<K> it1 = iAmTheMap.keySet().iterator();
        Comparable max = (Comparable)iAmTheMap.get(it1.next()).iterator().next();
        it1 = iAmTheMap.keySet().iterator();
        while(it1.hasNext())
        {
            Iterator<V> it2 = iAmTheMap.get(it1.next()).iterator();
            while(it2.hasNext())
            {
                Comparable obj = (Comparable)it2.next();
                if(max.compareTo(obj)<0)
                {
                    max = obj;
                }
            }
        }
        return (V)max;
    }
}