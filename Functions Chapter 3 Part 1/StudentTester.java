import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
   public void testOrderedPair()
   {
      OrderedPair r1 = new OrderedPair("a", "3");
      OrderedPair r2 = new OrderedPair("a", "3");
      assertEquals(true, r1.equals(r2));
      OrderedPair r3 = new OrderedPair("3", "a");
      assertEquals(false, r1.equals(r3));
      assertEquals(false, r3.equals(r2));
      int hash1 = r1.hashCode();
      int hash2 = r1.hashCode();
      int hash3 = r1.hashCode();
      assertEquals(hash1, hash2);
      assertEquals(hash3, hash2);
      Set<OrderedPair> opSet = new HashSet<OrderedPair>();
      opSet.add(r1);
      opSet.add(new OrderedPair("d", "4"));
      opSet.add(new OrderedPair("b", "7"));
      opSet.add(r3);
      assertEquals(true, opSet.contains(r1));
      assertEquals(true, opSet.contains(new OrderedPair("a", "3")));
      assertEquals(true, opSet.contains(new OrderedPair("d", "4")));
      assertEquals(true, opSet.contains(new OrderedPair("b", "7")));
      assertEquals(true, opSet.contains(r3));
      assertEquals(false, opSet.contains(new OrderedPair("4", "d")));
      assertEquals(false, opSet.contains(new OrderedPair("7", "b")));
   }

   // ****************  FunctionsChapter3Style
   public void testFunctionsChapter3Style_01()
   {
      Set<String> domain = new HashSet<String>();
      domain.add("a"); domain.add("b"); domain.add("c"); domain.add("d");
      Set<String> codomain = new HashSet<String>();
      codomain.add("1"); codomain.add("2"); codomain.add("3"); codomain.add("4");
      OrderedPair[] r = { new OrderedPair("a", "1"), new OrderedPair("b", "2"),
                        new OrderedPair("c", "3"), new OrderedPair("d", "4") };

      HashSet<OrderedPair> rSet = new HashSet<OrderedPair>();
      for(OrderedPair op : r) rSet.add(op);

      FunctionsChapter3Style f3 = new FunctionsChapter3Style(domain, codomain, rSet);

      assertEquals(true, f3.isFunction());
      assertEquals(true, f3.isOneToOne());
      assertEquals(true, f3.isOnTo());
      assertEquals(true, f3.isBijective());
      assertEquals(false, f3.isReflexive());
      assertEquals(false, f3.isSymmetric());
      assertEquals(true, f3.isAntiSymmetric());
      //assertEquals(true, f3.isTransitive());
      assertEquals(false, f3.isPartiallyOrder());
      assertEquals(false, f3.isEquivalenceRelation());

      Set<String> compCodomain = new HashSet<String>();
      compCodomain.add("!"); compCodomain.add("@"); compCodomain.add("#"); compCodomain.add("$");
      OrderedPair[] rComp = { new OrderedPair("1", "$"), new OrderedPair("2", "!"),
                        new OrderedPair("4", "@"), new OrderedPair("3", "#") };


      rSet = new HashSet<OrderedPair>();
      for(OrderedPair op : rComp)
        {rSet.add(op);}

      FunctionsChapter3Style comp = f3.composition(rSet, compCodomain);
      ArrayList<OrderedPair> compList = new ArrayList<OrderedPair>();
      compList.add(new OrderedPair("a", "$"));
      compList.add(new OrderedPair("b", "!"));
      compList.add(new OrderedPair("c", "#"));
      compList.add(new OrderedPair("d", "@"));
      /** Here **/
      assertEquals(compList.size(), comp.size());
      Set<OrderedPair> compAns = comp.getRelation();
      for (OrderedPair k : compAns)
         assertEquals(true, compList.contains( k ) );

      ArrayList<OrderedPair> inverse = new ArrayList<OrderedPair>();
      inverse.add(new OrderedPair("1", "a"));
      inverse.add(new OrderedPair("2", "b"));
      inverse.add(new OrderedPair("3", "c"));
      inverse.add(new OrderedPair("4", "d"));
      Set<OrderedPair> ans = f3.getRelation();
      for (OrderedPair k : compList)
         assertEquals(true, compList.contains( k ) );
   }

   public void testFunctionsChapter3Style_02()
   {
      Set<String> domain = new HashSet<String>();
      domain.add("a"); domain.add("b"); domain.add("c"); domain.add("d");
      Set<String> codomain = new HashSet<String>();
      codomain.add("1"); codomain.add("2"); codomain.add("3"); codomain.add("4");
      OrderedPair[] r = { new OrderedPair("a", "1"), new OrderedPair("b", "2"),
                          new OrderedPair("c", "3"), new OrderedPair("d", "4"),
                          new OrderedPair("a", "3") };

      Set<OrderedPair> rSet = new HashSet<OrderedPair>();
      for(OrderedPair op : r) rSet.add(op);
      FunctionsChapter3Style f3 = new FunctionsChapter3Style(domain, codomain, rSet);

      assertEquals(false, f3.isFunction());
      assertEquals(false, f3.isOneToOne());
      assertEquals(false, f3.isOnTo());
      assertEquals(false, f3.isBijective());
      assertEquals(false, f3.isReflexive());
      assertEquals(false, f3.isSymmetric());
      assertEquals(true, f3.isAntiSymmetric());
      assertEquals(true, f3.isTransitive());
      assertEquals(false, f3.isPartiallyOrder());
      assertEquals(false, f3.isEquivalenceRelation());
   }

   public void testFunctionsChapter3Style_03()
   {
      Set<String> domain = new HashSet<String>();
      domain.add("a"); domain.add("b"); domain.add("c"); domain.add("d");
      Set<String> codomain = new HashSet<String>();
      codomain.add("1"); codomain.add("2"); codomain.add("3"); codomain.add("4");
      OrderedPair[] r = { new OrderedPair("a", "1"), new OrderedPair("b", "1"),
                          new OrderedPair("c", "1"), new OrderedPair("d", "1") };

      Set<OrderedPair> rSet = new HashSet<OrderedPair>();
      for(OrderedPair op : r) rSet.add(op);
      FunctionsChapter3Style f3 = new FunctionsChapter3Style(domain, codomain, rSet);

      assertEquals(true, f3.isFunction());
      assertEquals(false, f3.isOneToOne());
      assertEquals(false, f3.isOnTo());
      assertEquals(false, f3.isBijective());
      assertEquals(false, f3.isReflexive());
      assertEquals(false, f3.isSymmetric());
      assertEquals(true, f3.isAntiSymmetric());
      assertEquals(true, f3.isTransitive());
      assertEquals(false, f3.isPartiallyOrder());
      assertEquals(false, f3.isEquivalenceRelation());
   }
}