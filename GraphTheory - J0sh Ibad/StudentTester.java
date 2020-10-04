import java.util.*;

/**
 * The test class StudentTester.
 *
 * @author  Mr. Allen
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
   public void testEdgeEquals01()
   {
      Edge e1 = new Edge("a", "b");
      Edge e2 = new Edge("a", "b");
      Edge e3 = new Edge("b", "b");
      Edge e4 = new Edge("a", "c");
      assertEquals(true,e1.equals(e2));
      assertEquals(false,e1.equals(e3));
      assertEquals(false,e1.equals(e4));
      assertEquals(false,e4.equals(e3));
   }

   public void testDriectedGraphEquals01()
   {
      Set<String> v = new HashSet<String>();
      v.add("a");
      v.add("b");
      v.add("c");
      v.add("d");
      v.add("e");
      DirectedGraph dg1 = new DirectedGraph(v);
      dg1.addVertex("f");
      DirectedGraph dg2 = new DirectedGraph(v);
      dg1.addEdge(new Edge("a", "b"));
      dg1.addEdge(new Edge("a", "c"));
      dg1.addEdge(new Edge("a", "d"));
      dg1.addEdge(new Edge("a", "e"));

      dg2.addEdge(new Edge("a", "b"));
      dg2.addEdge(new Edge("a", "c"));
      dg2.addEdge(new Edge("a", "d"));
      assertEquals(false, dg1.equals(dg2));
      dg2.addVertex("f");
      dg2.addEdge(new Edge("a", "e"));
      assertEquals(true, dg1.equals(dg2));
   }

/*
 *     Example from: http://webwhompers.com/graph-theory.html
 *           Section Neighborhood and Degree 
 */
   public void testIsAdjacent01()
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      v.add("6");
      DirectedGraph dg1 = new DirectedGraph(v);
      dg1.addEdge(new Edge("1", "2"));
      dg1.addEdge(new Edge("2", "5"));
      dg1.addEdge(new Edge("2", "3"));
      dg1.addEdge(new Edge("3", "4"));
      dg1.addEdge(new Edge("4", "5"));
      dg1.addEdge(new Edge("4", "6"));
      dg1.addEdge(new Edge("1", "5"));
      assertEquals(true, dg1.isAdjacent("1", "2"));
      assertEquals(true, dg1.isAdjacent("2", "1"));
      assertEquals(true, dg1.isAdjacent("5", "2"));

      assertEquals(false, dg1.isAdjacent("1", "3"));
      assertEquals(false, dg1.isAdjacent("4", "2"));
      assertEquals(false, dg1.isAdjacent("6", "1"));
   }

/*
 *     Example from: http://webwhompers.com/graph-theory.html
 *           Section Neighborhood and Degree 
 */
   public void testGetNeighbors01()
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      DirectedGraph dg1 = new DirectedGraph(v);
      dg1.addEdge(new Edge("1", "2"));
      dg1.addEdge(new Edge("2", "5"));
      dg1.addEdge(new Edge("2", "3"));
      dg1.addEdge(new Edge("3", "4"));
      dg1.addEdge(new Edge("4", "5"));
      dg1.addEdge(new Edge("4", "6"));
      dg1.addEdge(new Edge("1", "5"));

      assertEquals(2, dg1.getNeighbors("1").size());
      assertEquals(false, dg1.getNeighbors("1").contains("1"));
      assertEquals(true, dg1.getNeighbors("1").contains("2"));
      assertEquals(false, dg1.getNeighbors("1").contains("3"));
      assertEquals(false, dg1.getNeighbors("1").contains("4"));
      assertEquals(true, dg1.getNeighbors("1").contains("5"));
      assertEquals(false, dg1.getNeighbors("1").contains("6"));
   }

   public void testHasLoop01()
   {
      Set<String> v = new HashSet<String>();
      v.add("a");
      v.add("b");
      v.add("c");
      v.add("d");
      v.add("e");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("a", "b"));
      dg.addEdge(new Edge("a", "c"));
      dg.addEdge(new Edge("a", "d"));
      dg.addEdge(new Edge("a", "e"));
      assertEquals(false, dg.hasLoop());
      dg.addEdge(new Edge("b", "b"));
      dg.addEdge(new Edge("b", "c"));
      dg.addEdge(new Edge("b", "d"));
      dg.addEdge(new Edge("b", "e"));
      assertEquals(true, dg.hasLoop());
   }

   public void testParallelEdges01()
   {
      Set<String> v = new HashSet<String>();
      v.add("a");
      v.add("b");
      v.add("c");
      v.add("d");
      v.add("e");
      DirectedGraph dg = new DirectedGraph(v);

      dg.addEdge(new Edge("a", "b"));
      dg.addEdge(new Edge("a", "c"));
      dg.addEdge(new Edge("a", "d"));
      dg.addEdge(new Edge("a", "e"));
      dg.addEdge(new Edge("b", "c"));
      dg.addEdge(new Edge("b", "d"));
      dg.addEdge(new Edge("b", "e"));
      assertEquals(false, dg.hasParallelEdges());
      dg.addEdge(new Edge("c", "b"));
      dg.addEdge(new Edge("c", "d"));
      dg.addEdge(new Edge("c", "e"));
      assertEquals(true, dg.hasParallelEdges());
   }

   public void testGetAllIsolatedEdges01()
   {
      Set<String> v = new HashSet<String>();
      v.add("a");
      v.add("b");
      v.add("c");
      v.add("d");
      v.add("e");
      DirectedGraph dg = new DirectedGraph(v);

      dg.addEdge(new Edge("a", "b"));
      dg.addEdge(new Edge("a", "c"));
      dg.addEdge(new Edge("a", "d"));
      dg.addEdge(new Edge("a", "e"));
      dg.addEdge(new Edge("b", "c"));
      dg.addEdge(new Edge("b", "d"));
      dg.addEdge(new Edge("b", "e"));
      assertEquals(0, dg.getAllIsolatedVertices().size());
      dg.addEdge(new Edge("c", "b"));
      dg.addEdge(new Edge("c", "d"));
      dg.addEdge(new Edge("c", "e"));
      assertEquals(0, dg.getAllIsolatedVertices().size());
      dg.addVertex("f");
      assertEquals(1, dg.getAllIsolatedVertices().size());
      assertEquals("f", dg.getAllIsolatedVertices().get(0));
   }

   public void testGetVertexDegree01()
   {
      Set<String> v = new HashSet<String>();
      v.add("a");
      v.add("b");
      v.add("c");
      v.add("d");
      v.add("e");
      DirectedGraph dg = new DirectedGraph(v);
      assertEquals(0, dg.getVertexDegree("a"));

      dg.addEdge(new Edge("a", "b"));
      dg.addEdge(new Edge("b", "c"));
      dg.addEdge(new Edge("b", "d"));
      dg.addEdge(new Edge("c", "e"));
      assertEquals(1, dg.getVertexDegree("a"));
      assertEquals(3, dg.getVertexDegree("b"));
   }

   public void testUnion01()
   {
      Set<String> v = new HashSet<String>();
      v.add("a");
      v.add("b");
      v.add("c");
      v.add("d");
      v.add("e");
      DirectedGraph dg1 = new DirectedGraph(v);
      dg1.addEdge(new Edge("a", "b"));
      dg1.addEdge(new Edge("b", "c"));
      dg1.addEdge(new Edge("b", "d"));
      dg1.addEdge(new Edge("c", "e"));

      DirectedGraph dg2 = new DirectedGraph(v);
      assertEquals(dg1, dg1.union(dg2) );
   }

   public void testIntersection01()
   {
      Set<String> v = new HashSet<String>();
      v.add("a");
      v.add("b");
      v.add("c");
      v.add("d");
      v.add("e");
      DirectedGraph dg1 = new DirectedGraph(v);
      dg1.addEdge(new Edge("a", "b"));
      dg1.addEdge(new Edge("b", "c"));
      dg1.addEdge(new Edge("b", "d"));
      dg1.addEdge(new Edge("c", "e"));

      DirectedGraph dg2 = new DirectedGraph(v);
      assertEquals(dg2, dg1.intersection(dg2) );
   }

   public void testIsBipartite01()    // see figure 8.1.13 on page 383  - bottom left
   {
      Set<String> v1 = new HashSet<String>();
      v1.add("1");
      v1.add("2");
      v1.add("3");

      Set<String> v2 = new HashSet<String>();
      v2.add("4");
      v2.add("5");

      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("1", "4"));
      dg.addEdge(new Edge("2", "5"));
      dg.addEdge(new Edge("3", "5"));
      assertEquals(true, dg.isBipartite(v1, v2));
   }

/*
 *    is there a path from v to w of any length <= myVertices.size()
 *    
 *    page 388:  Example 8.2.2/ Figure 8.2.1 - assume all edges in Figure 8.2.1 are bidirectional
 *                    The edges in DirectedGraph are still one direction       
 */
   public void testHasPath01()    // is there a path from v to w of any length
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      v.add("6");
      v.add("7");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("1", "2"));
      dg.addEdge(new Edge("2", "3"));
      dg.addEdge(new Edge("3", "4"));
      assertEquals(true, dg.hasPath("1", "2"));
      assertEquals(false, dg.hasPath("1", "7"));
      dg.addEdge(new Edge("4", "2"));
      dg.addEdge(new Edge("2", "5"));
      dg.addEdge(new Edge("2", "6"));
      dg.addEdge(new Edge("5", "6"));
      assertEquals(false, dg.hasPath("1", "7"));

      dg.addEdge(new Edge("6", "7"));
      assertEquals(true, dg.hasPath("1", "7"));
   }

/*
 *    page 388 - 389
 *       A graph is connected if given any vertices v and w in G, there is a path from v to w
 *    
 *    Example 8.2.5 / Figure 8.2.1 - assume all edges in Figure 8.2.1 are bidirectional
 *                    The edges in DirectedGraph are still one direction       
 */
   public void testIsConnectedGraph01()
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      v.add("6");
      v.add("7");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("1", "2"));
      dg.addEdge(new Edge("2", "3"));
      dg.addEdge(new Edge("3", "4"));
      dg.addEdge(new Edge("4", "2"));
      dg.addEdge(new Edge("2", "5"));
      dg.addEdge(new Edge("2", "6"));
      dg.addEdge(new Edge("5", "6"));
      dg.addEdge(new Edge("6", "7"));
      assertEquals(false, dg.isConnectedGraph());

      dg.addEdge(new Edge("2", "1"));
      dg.addEdge(new Edge("3", "2"));
      dg.addEdge(new Edge("4", "3"));
      dg.addEdge(new Edge("2", "4"));
      dg.addEdge(new Edge("5", "2"));
      dg.addEdge(new Edge("6", "2"));
      dg.addEdge(new Edge("6", "5"));
      dg.addEdge(new Edge("7", "6"));
      assertEquals(true, dg.isConnectedGraph());
   }

/*    isSimplePath(List<String> p)
 *    page 391
 *       A simple path from v to w is a path from v to w with no repeated vertices
 *       
 *    Example 8.2.15 / Figure 8.2.1 - assume all edges in Figure 8.2.1 are bidirectional
 *                    The edges in DirectedGraph are still one direction       
 */
   public void testIsSimplePath01()
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      v.add("6");
      v.add("7");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("1", "2"));
      dg.addEdge(new Edge("2", "3"));
      dg.addEdge(new Edge("3", "4"));
      dg.addEdge(new Edge("4", "2"));
      dg.addEdge(new Edge("2", "5"));
      dg.addEdge(new Edge("2", "6"));
      dg.addEdge(new Edge("5", "6"));
      dg.addEdge(new Edge("6", "7"));

      dg.addEdge(new Edge("2", "1"));
      dg.addEdge(new Edge("3", "2"));
      dg.addEdge(new Edge("4", "3"));
      dg.addEdge(new Edge("2", "4"));
      dg.addEdge(new Edge("5", "2"));
      dg.addEdge(new Edge("6", "2"));
      dg.addEdge(new Edge("6", "5"));
      dg.addEdge(new Edge("7", "6"));

      List<String> sp = new ArrayList<String>();
      sp.add("6");
      sp.add("5");
      sp.add("2");
      sp.add("4");
      sp.add("3");
      sp.add("2");
      sp.add("1");
      assertEquals(false, dg.isSimplePath(sp));

      sp = new ArrayList<String>();
      sp.add("6");
      sp.add("5");
      sp.add("2");
      sp.add("4");
      
      assertEquals(true, dg.isSimplePath(sp));

      sp = new ArrayList<String>();
      sp.add("2");
      sp.add("6");
      sp.add("5");
      sp.add("2");
      sp.add("4");
      sp.add("3");
      sp.add("2");
      assertEquals(false, dg.isSimplePath(sp));

      sp = new ArrayList<String>();
      sp.add("5");
      sp.add("6");
      sp.add("2");
      sp.add("5");
      assertEquals(false, dg.isSimplePath(sp));

      sp = new ArrayList<String>();
      sp.add("7");
      assertEquals(true, dg.isSimplePath(sp));
   }

/*    isCycle(List<String> c)
 *    page 391
 *       A cycle is a path of nonzero length from v to v with no repeated edges
 * 
 *    Example 8.2.15 / Figure 8.2.1 - assume all edges in Figure 8.2.1 are bidirectional
 *                    The edges in DirectedGraph are still one direction       
 */
   public void testIsCycle01()
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      v.add("6");
      v.add("7");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("1", "2"));
      dg.addEdge(new Edge("2", "3"));
      dg.addEdge(new Edge("3", "4"));
      dg.addEdge(new Edge("4", "2"));
      dg.addEdge(new Edge("2", "5"));
      dg.addEdge(new Edge("2", "6"));
      dg.addEdge(new Edge("5", "6"));
      dg.addEdge(new Edge("6", "7"));

      dg.addEdge(new Edge("2", "1"));
      dg.addEdge(new Edge("3", "2"));
      dg.addEdge(new Edge("4", "3"));
      dg.addEdge(new Edge("2", "4"));
      dg.addEdge(new Edge("5", "2"));
      dg.addEdge(new Edge("6", "2"));
      dg.addEdge(new Edge("6", "5"));
      dg.addEdge(new Edge("7", "6"));

      List<String> c = new ArrayList<String>();
      c.add("6");
      c.add("5");
      c.add("2");
      c.add("4");
      c.add("3");
      c.add("2");
      c.add("1");
      c.add("6");
      assertEquals(false, dg.isCycle(c));

      c = new ArrayList<String>();
      c.add("6");
      c.add("5");
      c.add("2");
      c.add("4");
      c.add("6");
      assertEquals(false, dg.isCycle(c));

      c = new ArrayList<String>();
      c.add("2");
      c.add("6");
      c.add("5");
      c.add("2");
      c.add("4");
      c.add("3");
      c.add("2");
      assertEquals(true, dg.isCycle(c));

      c = new ArrayList<String>();
      c.add("5");
      c.add("6");
      c.add("2");
      c.add("5");
      assertEquals(true, dg.isCycle(c));

      c = new ArrayList<String>();
      c.add("7");
      assertEquals(false, dg.isCycle(c));
   }

/*    isSimpleCycle(List<String> sc)
 *    page 391
 *       A simple cycle is a cycle from v to v in which, except for the beginning and ending vertices that are both equal to v,
 *          there are no repeated edges
 *    
 *    Example 8.2.15 / Figure 8.2.1 - assume all edges in Figure 8.2.1 are bidirectional
 *                    The edges in DirectedGraph are still one direction       
 */
   public void testIsSimpleCycle01()
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      v.add("6");
      v.add("7");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("1", "2"));
      dg.addEdge(new Edge("2", "3"));
      dg.addEdge(new Edge("3", "4"));
      dg.addEdge(new Edge("4", "2"));
      dg.addEdge(new Edge("2", "5"));
      dg.addEdge(new Edge("2", "6"));
      dg.addEdge(new Edge("5", "6"));
      dg.addEdge(new Edge("6", "7"));

      dg.addEdge(new Edge("2", "1"));
      dg.addEdge(new Edge("3", "2"));
      dg.addEdge(new Edge("4", "3"));
      dg.addEdge(new Edge("2", "4"));
      dg.addEdge(new Edge("5", "2"));
      dg.addEdge(new Edge("6", "2"));
      dg.addEdge(new Edge("6", "5"));
      dg.addEdge(new Edge("7", "6"));

      List<String> sc = new ArrayList<String>();
      sc.add("6");
      sc.add("5");
      sc.add("2");
      sc.add("4");
      sc.add("3");
      sc.add("2");
      sc.add("1");
      sc.add("6");
      assertEquals(false, dg.isSimpleCycle(sc));

      sc = new ArrayList<String>();
      sc.add("6");
      sc.add("5");
      sc.add("2");
      sc.add("4");
      sc.add("6");
      assertEquals(false, dg.isSimpleCycle(sc));

      sc = new ArrayList<String>();
      sc.add("2");
      sc.add("6");
      sc.add("5");
      sc.add("2");
      sc.add("4");
      sc.add("3");
      sc.add("2");
      assertEquals(false, dg.isSimpleCycle(sc));

      sc = new ArrayList<String>();
      sc.add("5");
      sc.add("6");
      sc.add("2");
      sc.add("5");
      assertEquals(true, dg.isSimpleCycle(sc));

      sc = new ArrayList<String>();
      sc.add("7");
      assertEquals(false, dg.isSimpleCycle(sc));
   }

/*    getSimpleCycle(String v)
 *    page 391
 *       A cycle is a path of nonzero length from v to v with no repeated edges
 *       
 *    page 391 :  Example 8.2.15 / Figure 8.2.1
 */
   public void testSimpleGetCycle01()
   {
      Set<String> v = new HashSet<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      DirectedGraph dg = new DirectedGraph(v);
      dg.addEdge(new Edge("1", "2"));
      dg.addEdge(new Edge("2", "3"));
      dg.addEdge(new Edge("3", "4"));
      dg.addEdge(new Edge("4", "5"));
      dg.addEdge(new Edge("5", "2"));

      assertEquals("23452", dg.getSimpleCycle("2"));
   }
}