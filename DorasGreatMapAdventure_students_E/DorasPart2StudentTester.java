import java.util.*;
import java.awt.*;

public class DorasPart2StudentTester extends junit.framework.TestCase
{
// test size
/**
 *      if tico is in the Set associate with key
 *          remove tico from the set associated with key.
 *          if the Set becomes Empty, remove the key from iAmTheMap
 *      otherwise - do not throw an exception, that exit the method gracefully
 */
    public void testRemove_key_Object01()
    {
       String problemMessage = "Remove_key_Object test 1";
       int[] setSize = {5, 3, 1, 2, 4};
       ArrayList<Set<String>> answerSet = new ArrayList<Set<String>>();
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       ArrayList<String> correctArray = new ArrayList<String>();
       for (int i = 0; i < setSize.length; i++)
       {
          answerSet.add(new HashSet());
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              answerSet.get(i).add(""+j);
          }
       }
       first.remove(new Integer(4), "0");
       answerSet.get(4).remove("0");
       int setIndex = 0;
       for (Integer keys : first.keySet())
       {
          Set<String> mySet = first.getMap().get(keys);
          Set correctSet = answerSet.get(setIndex);
          assertEquals(correctSet.size(), mySet.size());
          for (Object correctItem : correctSet)
              assertEquals(true, mySet.contains(correctItem));
          setIndex++;
       }
    }


/**
 *      remove isa from all sets
 */
    public void testRemoveFromAll01()
    {
       int[] setSize = {5, 3, 1, 2, 4};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       ArrayList<Set<String>> answerSet = new ArrayList<Set<String>>();
       for (int i = 0; i < setSize.length; i++)
       {
          answerSet.add(new HashSet());
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              answerSet.get(i).add(""+j);
          }
       }

       first.removeFromAll("1");
       for (int i = 0; i < setSize.length; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
          {
             answerSet.get(j).remove("1");
          }
       }

       int setIndex = 0;
       for (Integer keys : first.keySet())
       {
          Set<String> mySet = first.getMap().get(keys);
          Set<String> correctSet = answerSet.get(setIndex);
          assertEquals(correctSet.size(), mySet.size());
          for (Object correctItem : correctSet)
              assertEquals(true, mySet.contains(correctItem));
          setIndex++;
       }
    }

/**
 *      This allows me to take the union of two DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are in either Map.
 *      For keys that are in both Maps, the associated Sets will be a union of the two sets
 */
    public void testMapUnion01()
    {
       Map<Integer, Set<String>> answerMap = new TreeMap<Integer, Set<String>>();

       int[] firstSetSize = {5, 3, 1, 2, 4, 2};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       for (int i = 0; i < firstSetSize.length; i++)
       {
          answerMap.put(new Integer(i), new HashSet());
          for (int j = 0; j < firstSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              answerMap.get(new Integer(i)).add(""+j);
          }
       }

       int[] secondSetSize = {5, 3, 1, 2, 4};
       DorasGreatMapAdventurePart2<Integer, String> second = new DorasGreatMapAdventurePart2<Integer, String>("hash");
       for (int i = 0; i < secondSetSize.length; i++)
       {
          if (answerMap.get(new Integer(i*2)) == null)
             answerMap.put(new Integer(i*2), new HashSet());
          for (int j = 0; j < secondSetSize[i]; j++)
          {
              second.add(new Integer(i*2), "" + (10 + j));
              answerMap.get(new Integer(i*2)).add("" + (10 + j));
          }
       }
       DorasGreatMapAdventurePart2<Integer, String> union = first.mapUnion(second);
       assertEquals(answerMap, union.getMap());
    }


/**  returns a DorasGreatMapAdventure implemented with a HashMap
 *      This allows me to take the intersection of DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are only in both Maps.
 *      the associated Sets will be an intersection of the two sets
    public DorasGreatMapAdventure setIntersection(DorasGreatMapAdventure backpack)
*/
    public void testMapIntersection01() {
       Map<Integer, Set<String>> answerMap = new TreeMap<Integer, Set<String>>();

       int[] commonSetSize = {5, 3, 1, 2, 4, 2};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       DorasGreatMapAdventurePart2<Integer, String> second = new DorasGreatMapAdventurePart2<Integer, String>("hash");
       for (int i = 0; i < commonSetSize.length; i++)
       {
          answerMap.put(new Integer(i), new HashSet());
          for (int j = 0; j < commonSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              second.add(new Integer(i), "" + j);
              answerMap.get(new Integer(i)).add(""+j);
          }
       }

       int[] firstSetSize = {2, 3, 7, 12, 4, 3, 10};
       for (int i = 0; i < firstSetSize.length; i++)
       {
          for (int j = 0; j < firstSetSize[i]; j++)
          {
              first.add(new Integer(i+10), "" + (10 + j));
          }
       }
       int[] secondSetSize = {7, 8, 6, 12, 4, 4, 4, 4, 4, 4};
       for (int i = 0; i < secondSetSize.length; i++)
       {
          for (int j = 0; j < secondSetSize[i]; j++)
          {
              second.add(new Integer(i+22), "" + (20 + j));
          }
       }
       DorasGreatMapAdventurePart2<Integer, String> intersection = first.mapIntersection(second);
       assertEquals(answerMap, intersection.getMap());
    }

/**  returns a DorasGreatMapAdventure implemented with a HashMap
 *      This allows me to take the difference of DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are in this.iAmTheMap.
 *      for each key in this.iAmTheMap, if that key is in swiper,
 *      the associated set is the set difference of this.iAmTheMap - swiper.iAmTheMap
    public DorasGreatMapAdventure mapDifference(DorasGreatMapAdventure swiper)
*/
    public void testMapDifference01() {
       Map<Integer, Set<String>> answerMap = new TreeMap<Integer, Set<String>>();

       int[] answerSetSize = {2, 4, 2};
        DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       DorasGreatMapAdventurePart2<Integer, String> second = new DorasGreatMapAdventurePart2<Integer, String>("hash");
       for (int i = 0; i < answerSetSize.length; i++)
       {
          answerMap.put(new Integer(i), new HashSet());
          for (int j = 0; j < answerSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              answerMap.get(new Integer(i)).add(""+j);
          }
       }

       int[] firstSetSize = {2, 3, 7, 12, 4, 3, 10};
       for (int i = 0; i < firstSetSize.length; i++)
       {
          for (int j = 0; j < firstSetSize[i]; j++)
          {
              first.add(new Integer(i+10), "" + (10 + j));
              second.add(new Integer(i+10), "" + (10 + j));
          }
       }
       DorasGreatMapAdventurePart2<Integer, String> difference = first.mapDifference(second);
       assertEquals(answerMap, difference.getMap());
    }

/**
 *      returns true iff
 *         for each key in this.iAmTheMap, backpack.iAmTheMap contains the same key
 *         this.iAmTheMap.get(key) is a subset of backpack.iAmTheMap.get(k)
 *      note:  this allows both Maps to be equal
 *      otherwise return false
    public boolean isSubmapOf(DorasGreatMapAdventure backpack) {
*/
    public void testIsSubmapOf01()
    {
        int[] answerSetSize = {2, 4, 2, 13, 5, 21};
        DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       DorasGreatMapAdventurePart2<Integer, String> second = new DorasGreatMapAdventurePart2<Integer, String>("hash");
       for (int i = 0; i < answerSetSize.length; i++)
       {
          for (int j = 0; j < answerSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              second.add(new Integer(i), ""+j);
          }
       }

       assertEquals(true, first.isSubmapOf(second));
       assertEquals(true, second.isSubmapOf(first));

       first.add(new Integer(99), "help");
       assertEquals(false, first.isSubmapOf(second));
       second.add(new Integer(99), "help");
       second.add(new Integer(99), "me");
       assertEquals(true, first.isSubmapOf(second));
       assertEquals(false, second.isSubmapOf(first));
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
    public void testIsProperSubmapOf01()
    {
       int[] answerSetSize = {2, 4, 2, 13, 5, 21};
        DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       DorasGreatMapAdventurePart2<Integer, String> second = new DorasGreatMapAdventurePart2<Integer, String>("hash");
       for (int i = 0; i < answerSetSize.length; i++)
       {
          for (int j = 0; j < answerSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              second.add(new Integer(i), ""+j);
          }
       }

       assertEquals(false, first.isProperSubmapOf(second));
       assertEquals(false, second.isProperSubmapOf(first));

       first.add(new Integer(99), "help");
       assertEquals(false, first.isProperSubmapOf(second));
       assertEquals(true, second.isProperSubmapOf(first));
       second.add(new Integer(99), "help");
       second.add(new Integer(99), "me");
       assertEquals(true, first.isProperSubmapOf(second));
       assertEquals(false, second.isProperSubmapOf(first));
    }

/**
 *      Removes all mappings from this map
 *  public void clear() 
*/
    public void testClear01()
    {
       int[] answerSetSize = {24, 12, 13, 5, 2, 1, 12, 32, 12, 3, 11, 4, 6, 7, 8, 9};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       for (int i = 0; i < answerSetSize.length; i++)
       {
          for (int j = 0; j < answerSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
          }
       }

       assertEquals(answerSetSize.length, first.keySet().size());
       first.clear();
       assertEquals(0, first.keySet().size());
    }
    
/**
 *      the set associated with key is emptied
 *  public void clearKey(Object isa)
*/
    public void testClearKey01()
    {
       int[] answerSetSize = {24, 12, 13, 5, 2, 1, 12, 32, 12, 3, 11, 4, 6, 7, 8, 9};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       for (int i = 0; i < answerSetSize.length; i++)
       {
          for (int j = 0; j < answerSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
          }
       }

       assertEquals(answerSetSize.length, first.keySet().size());
       first.clearKey(new Integer(0));
       first.clearKey(new Integer(answerSetSize.length-1));
       assertEquals(0, first.getMap().get(new Integer(0)).size());
       assertEquals(0, first.getMap().get(new Integer(answerSetSize.length-1)).size());
       for (int i = 1; i < answerSetSize.length-1; i++)
       {
           assertEquals(answerSetSize[i], first.getMap().get(new Integer(i)).size());
       }
    }

/**
 *      returns the number key-value mapping in iAmTheMap
    public int numMappings() 

 */
    public void testNumMappings01()
    {
       int[] answerSetSize = {2, 4, 1, 2, 1, 3, 5, 2, 1, 12, 32, 12, 3, 11, 4, 6, 7, 8, 9};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       for (int i = 0; i < answerSetSize.length; i++)
       {
          for (int j = 0; j < answerSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
          }
       }

       int[] moreSets = {2, 4, 1, 2, 1, 3, 5, 2, 1, 12, 32, 12, 3, 11, 4, 6, 7, 8, 9};
       assertEquals(answerSetSize.length, first.numMappings());
       for (int i = 0; i < moreSets.length; i++)
       {
          for (int j = 0; j < moreSets[i]; j++)
          {
              first.add(new Integer(answerSetSize.length+i), ""+(i*10+j));
          }
          assertEquals(1+answerSetSize.length + i, first.numMappings());
       }
    }
}