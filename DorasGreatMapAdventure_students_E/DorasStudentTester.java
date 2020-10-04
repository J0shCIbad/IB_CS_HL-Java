import java.util.*;
import java.awt.*;

public class DorasStudentTester extends junit.framework.TestCase
{
// test size
    public void testSize01()
    {
       String problemMessage = "Size test 1";
       int numKeyValues = 4;
       int[] setSize = {5, 3, 11, 7};
       int someValue = 5 + 3 + 11 + 7 + numKeyValues;
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       for (int i = 0; i < numKeyValues; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
              first.add(new Integer(i), ""+j);
       }
       assertEquals(someValue, first.size());
    }

// test numDistinctItems
    public void testNumDistinctItems01()
    {
       String problemMessage = "NumDistinctItems test 1";
       int[] setSize = {5, 3, 11, 7};
       int someValue = 11;
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       int numKeyValues = 4;
       for (int i = 0; i < numKeyValues; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
              first.add(new Integer(i), "" + j);
       }
       assertEquals(someValue, first.numDistinctItems());
    }


//toString
    public void testToString01()
    {
       int[] setSize = {5, 3, 4};
       int someValue = 11;
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       int numKeyValues = 3;
       for (int i = 0; i < numKeyValues; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
              first.add(new Integer(i), "" + j);
       }
       String ansTreeString = "{0=[0, 1, 2, 3, 4], 1=[0, 1, 2], 2=[0, 1, 2, 3]}";
       String ansHashString = "{0=[3, 2, 0, 4, 1], 1=[2, 0, 1], 2=[3, 2, 0, 1]}";
       boolean flag = ansTreeString.equals(first.toString()) || ansHashString.equals(first.toString());
       assertEquals(true, flag);
    }

// test numItems
/**
 *      returns the total number of non key items in the iAmTheMap
 *      That is, the sum of the size of each set assocaiated with all keys
*/
    public void testNumItems01()
    {
       String problemMessage = "numItems test 1";
       int[] setSize = {5, 3, 11, 7};
       int someValue = 5 + 3 + 11 + 7;
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       int numKeyValues = 4;
       for (int i = 0; i < numKeyValues; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
              first.add(new Integer(i), ""+j);
       }
       assertEquals(someValue, first.numItems());
    }

// test toArray
/**
 *      returns an array containing all elements from the associated sets
 *      items may appear in the array more than once
 *      keys are not to be added to the array
 */
    public void testToArray01()
    {
       String problemMessage = "toArray test 1";
       int[] setSize = {5, 3, 11, 7};
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       ArrayList<String> correctArray = new ArrayList<String>();
       for (int i = 0; i < setSize.length; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              correctArray.add(""+j);
          }
       }
       
       Object[] array = first.toArray();
       int index = 0;
       assertEquals(26, array.length);
       for (int i = 0; i < array.length; i++)
       {
          assertEquals(true, correctArray.remove(array[i]));
       }
       assertEquals(0, correctArray.size());
    }

/**
 *      Finds the largest value in all the sets contained in the map.
 *      You should assume that all Sets contain comparable items
 *      and that all sets are Comparable to each other
 *      DorasGreatMapAdventure is NOT empty
 */
    public void testMaxItem01()
    {
       int[] setSize = {5, 3, 1, 3, 7};
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       for (int i = 0; i < setSize.length; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
          }
       }
       assertEquals("6", first.maxItem());
       first.add(new Integer(0), "apple");
       assertEquals("apple", first.maxItem());
       first.add(new Integer(1), "banana");
       assertEquals("banana", first.maxItem());
       first.add(new Integer(2), "grapefruit");
       assertEquals("grapefruit", first.maxItem());
       first.add(new Integer(3), "strawberries");
       assertEquals("strawberries", first.maxItem());
       first.add(new Integer(4), "watermelon");
       assertEquals("watermelon", first.maxItem());
    }

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
       ArrayList<Set> answerSet = new ArrayList<Set>();
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
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
       for (Object keys : first.keySet())
       {
          Set mySet = first.getMap().get(keys);
          Set correctSet = answerSet.get(setIndex);
          assertEquals(correctSet.size(), mySet.size());
          for (Object correctItem : correctSet)
              assertEquals(true, mySet.contains(correctItem));
          setIndex++;
       }
    }

/**
 *      returns true iff iAmTheMap continas key-value mappings
 *      otherwise returns false
 */
    public void testIsEmpty01()
    {
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       assertEquals(true, first.isEmpty());
    }

/**
 *      returns true if a one or more associated set contains diego
 *      otherwise (no set contains diego) return false
 */
    public void testContains01()
    {
       int[] setSize = {5, 3, 1, 2, 4};
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       for (int i = 0; i < setSize.length; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), i+""+j);
          }
       }
       assertEquals(true, first.contains("41"));
       assertEquals(false, first.contains("141"));
    }

/**
 *      remove isa from all sets
 */
    public void testRemoveFromAll01()
    {
       int[] setSize = {5, 3, 1, 2, 4};
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       ArrayList<Set> answerSet = new ArrayList<Set>();
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
       for (Object keys : first.keySet())
       {
          Set mySet = first.getMap().get(keys);
          Set correctSet = answerSet.get(setIndex);
          assertEquals(correctSet.size(), mySet.size());
          for (Object correctItem : correctSet)
              assertEquals(true, mySet.contains(correctItem));
          setIndex++;
       }
    }

/**     Every key in this.iAmTheMap is a key in otherDorasGreatMapAdventure.iAMTheMap
 *      Every key in otherDorasGreatMapAdventure.iAmTheMap is a key in this.iAMTheMap
 *      Each pair of set for a given key are equal
 *           that is,  iAmTheMap.get(key).equals(otherDorasGreatMapAdventure.iAmTheMap.get(key))
	public boolean equals (Object otherDorasGreatMapAdventure) {
*/
    public void testEquals01()
    {
       int[] setSize = {5, 8, 11, 7, 14};
       DorasGreatMapAdventure<Integer, String> first = new DorasGreatMapAdventure<Integer, String>("tree");
       DorasGreatMapAdventure<Integer, String> second = new DorasGreatMapAdventure<Integer, String>("tree");
       for (int i = 0; i < setSize.length; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              second.add(new Integer(i), ""+j);
          }
       }
       assertEquals(true, first.equals(second));
       assertEquals(true, second.equals(first));
       first.add(new Integer(0), "not it");
       assertEquals(false, first.equals(second));
       assertEquals(false, second.equals(first));
    }

}