import java.util.*;

/**
 * Write a description of class DorasGreatMapAdventurePart2 here.
 * 
 * @author Josh Ibad
 * @teacher Mr. Allen
 * @period 1
 * @version 08/23/18
 */
public class DorasGreatMapAdventurePart2<K, V> extends DorasGreatMapAdventure<K,V>
{

    /*
     *   If client creates a "hash" DorasGreatMapAdventure, key will have a reasonable hashCode, the associated set contains Objects
     *   If client creates a "tree" DorasGreatMapAdventure, key will implement Comparable interface as required by the TreeMap() class,
     *                                                                          the associated set contains Objects
     */
    public DorasGreatMapAdventurePart2(String type) {
        super(type);
    }

    /*  returns a DorasGreatMapAdventure implemented with a HashMap
     *      This allows me to take the union of DorasGreatMapAdventure implemented with TreeMaps and HashMap
     *
     *      the returned Map will contains the keys that are in either Map.
     *      For keys that are in both Maps, the associated Sets will be a union of the two sets
     */
    public DorasGreatMapAdventurePart2<K, V> mapUnion(DorasGreatMapAdventure<K, V> boots)
    {
        DorasGreatMapAdventurePart2<K, V> union = new DorasGreatMapAdventurePart2<K, V>("Hash");
        Map map = union.getMap();
        Iterator<K> it = keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            map.put(key, getMap().get(key));
        }
        it = boots.keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            if(map.containsKey(key))
                
                map.put(key, setUnion(getMap().get(key), boots.getMap().get(key)));
            else
                map.put(key, boots.getMap().get(key));
        }
        return union;
    }

    /*  returns a DorasGreatMapAdventure implemented with a HashMap
     *      This allows me to take the intersection of DorasGreatMapAdventure implemented with TreeMaps and HashMap
     *
     *      the returned Map will contains the keys that are only in both Maps.
     *      the associated Sets will be an intersection of the two sets
     */
    public DorasGreatMapAdventurePart2<K, V> mapIntersection(DorasGreatMapAdventure<K, V> backpack)
    {
        DorasGreatMapAdventurePart2<K, V> intersection = new DorasGreatMapAdventurePart2<K, V>("Hash");
        Map map = intersection.getMap();
        Iterator<K> it = keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            if(backpack.keySet().contains(key))
                map.put(key, setIntersection(getMap().get(key), backpack.getMap().get(key)));
        }
        return intersection;
    }

    /*  returns a DorasGreatMapAdventure implemented with a HashMap
     *      This takes the difference of DorasGreatMapAdventure implemented with TreeMaps and HashMap
     *
     *      the returned Map will contain the keys that are in this.iAmTheMap.
     *      for each key in this.iAmTheMap,
     *      if that key is in swiper,
     *         the associated set is the set difference of this.iAmTheMap - swiper.iAmTheMap
     *         if the associated Set is Empty, remove the Key - Set pair from the Map
     *      otherswise (key is NOT in swiper)
     *         teh associated set is the set associated with key in this.iAmTheMap
     */
    public DorasGreatMapAdventurePart2<K, V> mapDifference(DorasGreatMapAdventure<K, V> swiper)
    {
        DorasGreatMapAdventurePart2<K, V> difference = new DorasGreatMapAdventurePart2<K, V>("Hash");
        Map map = difference.getMap();
        Iterator<K> it = keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            if(swiper.keySet().contains(key))
                map.put(key, setDifference(getMap().get(key), swiper.getMap().get(key)));
            else
                map.put(key, getMap().get(key));
            Set<V> obj = (Set<V>)map.get(key);
            if(obj.size()==0)
                map.remove(key);
        }
        return difference;
    }

    /*
     *      returns true iff
     *         for each key in this.iAmTheMap, backpack.iAmTheMap contains the same key
     *         this.iAmTheMap.get(key) is a subset of backpack.iAmTheMap.get(k)
     *      note:  this allows both Maps to be equal
     *      otherwise return false
     */
    public boolean isSubmapOf(DorasGreatMapAdventure<K, V> backpack) {
        Iterator<K> it = keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            if(backpack.keySet().contains(key))
            {
                
                /*if(!isSubsetOf(getMap().get(key), backpack.getMap().get(key)))
                    return false;*/
                if(!backpack.getMap().get(key).containsAll(getMap().get(key)))
                    return false;
            }
            else
                return false;
        }
        return true;
    }

    /**
     *      returns true iff
     *         for each key in this.iAmTheMap, backpack.iAmTheMap contains the same key
     *         this.iAmTheMap.get(key) is a subset of backpack.iAmTheMap.get(key) for every key in iAmTheMap.keySet() with either:
     *            1) this.iAmTheMap.get(key) is a proper subset of backpack.iAmTheMap.get(key) for atleast one key in iAmTheMap.keySet()
     *         or 2) backpack.iAmTheMap contains at least one key that this.iAmTheMap does not
     *      note:  this implies that equal sets are NOT properSubsets.
     *      otherwise return false
     */
    public boolean isProperSubmapOf(DorasGreatMapAdventure<K, V> s) {
        Iterator<K> it = keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            if(s.keySet().contains(key))
            {
                if(isProperSubsetOf(getMap().get(key), s.getMap().get(key)))
                {
                    return true;
                }
            }
            else
                return false;
        }
        it = s.getMap().keySet().iterator();
        while(it.hasNext())
        {
            K key = it.next();
            if(!getMap().containsKey(key))
            {
                return true;
            }
        }
        return false;  // so compiles
    }

    
    /*
     *      Removes all mappings from this map
     *  postCondition:  keySet().size() == 0
     */
    public void clear() {
        getMap().clear();
    }

    /*
     *      the set associated with key isa is emptied
     *  postCondition:  getMap().get(isa).size() == 0
     *      if isa is not a key
     *          - do not throw an exception, that is exit the method gracefully
     */
    public void clearKey(K isa) {
        if(keySet().contains(isa))
            getMap().get(isa).clear();
    }

    /*
     *      returns the number key-value mapping in iAmTheMap
     */
    public int numMappings() {
        return getMap().keySet().size();
    }
    
    /** Helper Methods **/
    public Set<V> setUnion(Set<V>x, Set<V> y) {
        Set<V> temp = new HashSet<V>();
        Iterator<V> it = x.iterator();
        while(it.hasNext())
        {
            V a = it.next();
            if(!temp.contains(a))
                temp.add(a);
        }
        it = y.iterator();
        while(it.hasNext())
        {
            V a = it.next();
            if(!temp.contains(a))
                temp.add(a);
        }
        return temp;
    }
    public Set<V> setIntersection(Set<V> x, Set<V> y) {
        Set<V> temp = new HashSet<V>();
        Iterator<V> it1 = x.iterator();
        while(it1.hasNext())
        {
            boolean boo = false;
            V a = it1.next();
            Iterator<V> it2 = y.iterator();
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
    /*  Returns x-y 
     */
    public Set<V> setDifference(Set<V> x, Set<V> y) {
        Set<V> temp = new HashSet<V>();
        Iterator<V> it = x.iterator();
        while(it.hasNext())
        {
            V a = it.next();
            if(!y.contains(a))
                temp.add(a);
        }
        return temp;
    }
    /* Return x (subset of) y 
       */
    public boolean isSubsetOf(Set<V> x, Set<V> y) {
        Iterator<V> it = x.iterator();
        while(it.hasNext())
        {
            if(!y.contains(it.next()))
            {
                return false;
            }
        }
        return true;
    }
    /*  Returns x (proper subset of) y
     */
    public boolean isProperSubsetOf(Set<V> x, Set<V> y) {
        return isSubsetOf(x, y) && x.size()!=y.size();
    }
    /**
    /* Return x (subset of) y 
       /
    public boolean isKeySubsetOf(Set<K> x, Set<K> y) {
        Iterator<K> it = x.iterator();
        while(it.hasNext())
        {
            if(!y.contains(it.next()))
            {
                return false;
            }
        }
        return true;
    }
    /*  Returns x (proper subset of) y
     /
    public boolean isKeyProperSubsetOf(Set<K> x, Set<K> y) {
        return isKeySubsetOf(x, y) && x.size()!=y.size();
    }
    **/
}