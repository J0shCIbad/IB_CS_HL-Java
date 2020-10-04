import java.util.*;
import java.lang.*;

/**
 *     all vertices are numbered 0, 1, 2, ....., n
 *     
 *     Edges are of the form (a, b), a and b are String
 *     
 *     Edges are assumed to be directed, which implies (1,3) is different from Edge (3,1)t
 *     
 *     ONLY NEEDS getSimpleCycle() method
 *     
 *     @author  -   Josh Ibad
 *     @date    -   04/23/2019
 *     @teacher -   Mr. Allen
 *     @period  -   1
 */

public class DirectedGraph 
{
    private Set<String> myVertices;
    private Set<Edge> myEdges;

    /**
     * Constructor for objects of class DirectedGraph
     */
    public DirectedGraph(Set<String> vertices)
    {
        myVertices = new HashSet<String>();
        Iterator<String> it = vertices.iterator();
        while(it.hasNext())
        {
            myVertices.add(it.next());
        }
        myEdges = new HashSet<Edge>();
    }

    /**
     * precondition
     *   for every edge in edges,
     *     myVertices.contains(edge.getA()) == true
     *     && myVertices.contains(edge.getB()) == true
     *   myEdges.contains(edge) == false
     * postcondtion:  every edge in edges is added to myEdges
     */
    public void addEdges(Set<Edge> edges)
    {
        Iterator<Edge> it = edges.iterator();
        while(it.hasNext())
        {
            myEdges.add(it.next());
        }
    }

    /**
     * precondition
     *   myVertices.contains(e.getA()) == true
     *   && myVertices.contains(e.getB()) == true
     *   myEdges.contains(e) == false
     * postcondtion:  myEdges.contains(e) == true
     */
    public void addEdge(Edge e)
    {
        myEdges.add(e);
    }

    /** 3/3
     *     According to http://webwhompers.com/graph-theory.html
     *     
     *     Two vertices are called adjacent if they share a common edge,   (direction of edge not important)
     *     
     *     precondition myVertices.contains(s) == true  && myVertices.contains(t)
     *     
     *     returns true iff vertex s and vertex t share a common edge (in either direction)
     *                  
     *         yes, you can be adjacent to your self
     */
    public boolean isAdjacent(String s, String t)
    {
        Iterator<Edge> it = myEdges.iterator();
        while(it.hasNext())
        {
            if(it.next().adjHelper(s,t))
                return true;
        }
        return false;
    }

    /** 3/3
     *     The neighborhood of a vertex v in a graph G is the set of vertices adjacent to v.
     *                      Use the definition of adjacent from isAdjacent above
     *                      i.e. - direction is NOT important
     *     
     *     precondition myVertices.contains(s) == true
     *     
     *     returns a Set of all neighbors of s
     *     The neighborhood does not include itself.
     *     
     *     I AM ASSUMING THAT !@# is not a valid vertex name
     *     FIXED INCLUDING SELF CASE
     */
    public Set<String> getNeighbors(String s)
    {
        Set<String> n = new HashSet<String>();
        Iterator<Edge> it = myEdges.iterator();
        while(it.hasNext())
        {
            n.add(it.next().neighborHelper(s));
        }
        n.remove("!@#");
        if(n.contains(s))
            n.remove(s);
        return n;
    }

    /** 3/3
     *   two graphs are equal iff both graphs have the same vertices and the same edges.
     */
    public boolean equals(Object obj)
    {
        DirectedGraph temp = (DirectedGraph) obj;
        
        return myEdges.containsAll(temp.getEdges()) && myVertices.containsAll(temp.getVertices())
            && temp.getEdges().containsAll(myEdges) && temp.getVertices().containsAll(myVertices);
    }

    /**
     *  precondition
     *    myVertices.contains(s) == false
     *    
     *  postcondition
     *    myVertices.contains(s) == true
     */
    public void addVertex(String s)
    {
        myVertices.add(s);
    }

    /** 3/3
     *   see top of page 379 for defintion of loop:
     *   
     *   An edge incident on a single vertex is called a loop.
     */
    public boolean hasLoop()
    {
        Iterator<String> it = myVertices.iterator();
        while(it.hasNext())
        {
            String temp = it.next();
            if(isAdjacent(temp, temp))
                return true;
        }
        return false;
    }

    /** 3/3
     *   see top of page 379 for defintion of loop:
     *   
     *   Two Edges associated with the same vertices are said to be parallel edges
     *   
     *   note:  loops are NOT parallel Edges (if multiple edges say two points are adjacent)
     *   
     *   FIXED LOOP CASE
     */
    public boolean hasParallelEdges()
    {
        Iterator<Edge> it = myEdges.iterator();
        while(it.hasNext())
        {
            Edge temp = it.next();
            if(myEdges.contains(new Edge(temp.b(), temp.a())) && !temp.b().equals(temp.a()))
                return true;
        }
        return false;
    }

    /** 3/3
     *   see top of page 379 for defintion of loop:
     *   
     *   A vertex not incident on any edge is called an isolated vertex
     *   A vertex incident on itself (i.e., a loop) is NOT isolated
     *   
     *   returns a List of all Isolted Vertices.  If there are not Isolated vertices, return an empty List
     */
    public List<String> getAllIsolatedVertices()
    {
        ArrayList<String> ans = new ArrayList<String>();
        Iterator<String> it1 = myVertices.iterator();
        while(it1.hasNext())
        {
            String str = it1.next();
            boolean cntrl = true;
            Iterator<Edge> it2 = myEdges.iterator();
            while(it2.hasNext() && cntrl)
            {
                if(it2.next().containsVertex(str))
                    cntrl = false;
            }
            if(cntrl)
                ans.add(str);
        }
        return ans;
    }

    /** 3/3
     *  precondition:   myVertices.contains(v) == true
     *  postcondition:  no side effects
     *    returns the number of edges incident on v
     *    
     *  note the sentence that states:
     *      (By definition, each loop on v contributes 2 to the degree of v)
     *    
     *    see page 392
     *   
     *   FIXED LOOP CASE
     */
    public int getVertexDegree(String v)
    {
        int count = 0;
        Iterator<Edge> it = myEdges.iterator();
        while(it.hasNext())
        {
            Edge temp = it.next();
            if(temp.containsVertex(v)){
                count++;
                if(temp.a().equals(temp.b()))
                    count++;
            }
        }
        return count;
    }

    /** 3/3
     *   returns the union DirectGraoh this . and DirectedGraph g
     *   return a DirectedGraph with:
     *        myVertices = union of this.myVertices and g.myVertices
     *        myEdges = union of this.myEdges and g.myEdges
     */
    public DirectedGraph union(DirectedGraph g)
    {
        Set<String> neuVertices = new HashSet<String>();
        Set<Edge> neuEdges = new HashSet<Edge>();
        Iterator<String> it = myVertices.iterator();
        while(it.hasNext())
            neuVertices.add(it.next());
        it = g.getVertices().iterator();
        while(it.hasNext())
            neuVertices.add(it.next());

        Iterator<Edge> it2 = myEdges.iterator();
        while(it2.hasNext())
            neuEdges.add(it2.next());
        it2 = g.getEdges().iterator();
        while(it2.hasNext())
            neuEdges.add(it2.next());

        DirectedGraph ans = new DirectedGraph(neuVertices);
        ans.addEdges(neuEdges);
        return ans;
    }

    /** 3/3
     *   returns the intersection DirectGraoh this . and DirectedGraph g
     *   return a DirectedGraph with:
     *        myVertices = intersection of this.myVertices and g.myVertices
     *        myEdges = intersection of this.myEdges and g.myEdges
     */
    public DirectedGraph intersection(DirectedGraph g)
    {
        Set<String> neuVertices = new HashSet<String>();
        Set<Edge> neuEdges = new HashSet<Edge>();
        Iterator<String> it = myVertices.iterator();
        while(it.hasNext())
        {
            String temp = it.next();
            if(g.getVertices().contains(temp))
                neuVertices.add(temp);
        }
        Iterator<Edge> it2 = myEdges.iterator();
        while(it2.hasNext())
        {
            Edge temp = it2.next();
            if(g.getEdges().contains(temp))
                neuEdges.add(temp);
        }
        DirectedGraph ans = new DirectedGraph(neuVertices);
        ans.addEdges(neuEdges);
        return ans;
    }

    /** 3/3 
     *    use definition of Bipartite on page 383
     *       intersection is empty
     *       union == this
     *    Each edge in this.myEdges has one vertex in v1 and one vertex in v2   
     *    
     *    returns true if v1 and v2 form a Biparitite of this Directed Graph
     *    
     *    returns false otherwise
     */
    public boolean isBipartite(Set<String> v1, Set<String> v2)
    {
        Iterator<String> it = v2.iterator();
        Set<String> temp = new HashSet<String>();
        while(it.hasNext())
        {
            String vb = it.next();
            if(v1.contains(vb)) //
                return false;
            temp.add(vb);
        }
        it = v1.iterator();
        while(it.hasNext())
            temp.add(it.next());
            
        Iterator<Edge> it2 = myEdges.iterator();
        while(it2.hasNext())
        {
            Edge e = it2.next();
            if(!((v1.contains(e.a()) && v2.contains(e.b())) ||
                (v1.contains(e.b()) && v2.contains(e.a()))))
                return false;
        }
        return temp.equals(myVertices);
    }

    /** 3/3
     *   see page 388
     *   
     *   precondition:  myVertices.contains(v) == true  && myVertices.contains(w) == true
     *                  v and w may be the same vertex, i.e. v.equals(w) may be true
     *                  
     *                  A path must contain at least two different vertices.
     *                  This imples that a single isolated vertex is not a path
     *                  and a loop by itself is not a path
     *                  
     *   returns true iff there exist a path from v to w of any length and the path contains two different vertices.
     *   
     *       v and w
     *       
     *   FIXED LOOP CASE (i think ;_;)
     */
    public boolean hasPath(String v, String w)
    {
        if(getAllIsolatedVertices().contains(v) || (v.equals(w) && myEdges.contains(new Edge(v,v))))
            return false;
        Set<String> reps = new HashSet<String>();
        return pathHelper(v, w, reps);
    }
    /** Lets Break it again */
    public boolean conGraphHelper(String v, String w)
    {
        if(getAllIsolatedVertices().contains(v))
            return false;
        Set<String> reps = new HashSet<String>();
        return pathHelper(v, w, reps);
    }
    public boolean pathHelper(String v, String w, Set reps)
    {
        if(v == w)
            return true;
        Set<String> moglichkeiten = new HashSet<String>();
        reps.add(v);
        Iterator<Edge> it = myEdges.iterator();
        while(it.hasNext())
        {
            Edge temp = it.next();
            if(temp.a() == v)
                moglichkeiten.add(temp.b());
        }
        moglichkeiten.removeAll(reps);
        if(moglichkeiten.size() == 0)
            return false;
        Iterator<String> it2 = moglichkeiten.iterator();
        boolean ans = false;
        while(it2.hasNext())
        {
            ans |= pathHelper(it2.next(), w, reps);
        }
        return ans;
    }

    /**  3/3 
     *   see page 388 for definition
     *   
     *   A graph is connected if given any two vertices v and w, there exist a path from v to w
     *   
     *   NOT ANYMORE ;-;
     *   NVM BROKE CODE AGAIN WHICH FIXED THIS :D
     */
    public boolean isConnectedGraph()
    {
        Iterator<String> it1 = myVertices.iterator();
        Iterator<String> it2;
        while(it1.hasNext())
        {
            String v = it1.next();
            it2 = myVertices.iterator();
            while(it2.hasNext())
            {
                if(!conGraphHelper(v, it2.next()))
                    return false;
            }
        }
        return true;
    }

    /** 4/6 False Positive (TEST)
     *    See page 391
     *    
     *    precondition:
     *       myVertices.contains(p.get(k)) == true for all k, 0 <= k < p.size()
     *       p.get(k).length() == 1 for all k, 0 <= k < p.size()
     *    postcondition:
     *       myVertices & myEdges are not altered
     *       
     *    returns true iff there is a path from p.get(0) to p.get(p.size()-1) with no repeated Vertices
     *            yes, you need to make sure myEdges contains the Edges required in p
     *            
     *    FIXED hasPath
     *    FIXED EDGE EXISTENCE CHECKING
     */
    public boolean isSimplePath(List<String> p)
    {
        Set<String> temp = new HashSet<String>();
        for(int i=0; i<p.size(); i++)
        {
            if(!myEdges.contains(new Edge(p.get(i), p.get(i+1))) || temp.contains(p.get(i))){
                return false;
            }
            temp.add(p.get(i));
        }
        return hasPath(p.get(0), p.get(p.size()-1));
    }

    /** (Test)
     * 2/3 False positive
     *    See page 391
     *    
     *    precondition:
     *       c.get(0).equals(c.get(c.size()-1)) == true
     *       myVertices.contains(c.get(k)) == true for all k, 0 <= k < c.size()
     *       c.get(k).length() == 1 for all k, 0 <= k < c.size()
     *    postcondition:
     *       myVertices & myEdges are not altered
     *
     *    returns true iff there is a path of nonzerolength from c.get(0) to c.get(c.size()-1) with no repeated edges
     *            yes, you need to make sure myEdges contains the Edges required in c
     *            
     *    FIXED REPEATED EDGE CASE
     */
    public boolean isCycle(List<String> c)
    {
        Set<Edge> reps = new HashSet<Edge>();
        for(int i=0; i<c.size()-1; i++)
        {
            Edge temp = new Edge(c.get(i), c.get(i+1));
            if(!myEdges.contains(temp) || reps.contains(temp))
                return false;
            reps.add(temp);
        }
        return c.size() > 1;
    }

    /** 0/3
     *    See page 391
     *    
     *    precondition:
     *       c.get(0).equals(c.get(c.size()-1)) == true
     *       myVertices.contains(c.get(k)) == true for all k, 0 <= k < c.size()
     *       c.get(k).length() == 1 for all k, 0 <= k < c.size()
     *    postconditino:
     *       myVertices & myEdges are not altered
     *
     *    returns true iff there is a cycle from c.get(0) to c.get(c.size()-1) in which, except for beginning and ending vertices, 
     *                     there are no repeated vertices.
     *            yes, you need to make sure myEdges contains the Edges required in c
     *            
     *            
     *    REWRITTEN
     *    FIXED REPEATED VERTICES CASE
     */
    public boolean isSimpleCycle(List<String> sc)
    {
        Set<Edge> reps = new HashSet<Edge>();
        Set<String> reps2 = new HashSet<String>();
        for(int i=0; i<sc.size()-1; i++)
        {
            String str = sc.get(i);
            Edge temp = new Edge(str, sc.get(i+1));
            if(!myEdges.contains(temp) || reps.contains(temp) || reps2.contains(str))
                return false;
            reps.add(temp);
            reps2.add(str);
        }
        return sc.size() > 1;
    }

    /* STILL NOT FINISHED
     *   precondition:
     *       v.length() == 1;
     *       myVertices.contains(v) == true
     *
     *   See page 391 for defintion of a cycle
     *      A cycle (or circuit) is a path of nonzero length from v to v with no repeated edges
     *      loops can form a simple cycle, that is, the path "vv" is consider a simple cycle in this method
     *
     *   return
     *       A String containing a list vertices which form a simple cycle from v to v
     *          The first and last vertice of the String should be v, e.g.:  "v.....v"
     *              and no other vertice should be repeated in the String
     *       null if a simple cycle does not exist.
     */
    public String getSimpleCycle(String v)
    {
        String antwort = "v";
        boolean cntrl = false;
        List<String> antworten = new ArrayList<String>();
        
        
        if(cntrl)
            return null;
        return antwort;
    }
    public List<String>[] moglichkeiten(String v)
    {
        return null;
    }
    
    public Set<Edge> getEdges() {return myEdges;}

    public Set<String> getVertices() {return myVertices;}
}