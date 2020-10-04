/*    implewment (almost) ALL the methods in this class.
 * 
 *    But first, you need to finish implementing the OrderedPair class
 *    
 *    The first tester provided test the OrderedPair class methods equals and hashCode
 *    which I believe are important methods that you may use or I use in the tester when I create
 *    a HashSet.  This tester method is only for your benefit as it is not included the stipulator tester.
 */

import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
public class FunctionsChapter3Style
{
    public Set<String> domain;
    public Set<String> codomain;
    public Set<OrderedPair> rel;
    public FunctionsChapter3StylePart2 cheat;
    public FunctionsChapter3Style(Set<String> d, Set<String> co){
        domain = d;
        codomain = co;
        rel = new HashSet<OrderedPair>();
        cheat = new FunctionsChapter3StylePart2(new int[0][0]);
    }

    public FunctionsChapter3Style(Set<String> d, Set<String> co, Set<OrderedPair> r){
        domain = d;
        codomain = co;
        rel = r;
        cheat = new FunctionsChapter3StylePart2(new int[0][0]);
        updateMat();
    }

    /**
     *    returns a String of the form: [(a,b), (c,d), ...(v,w)]
     */
    public String getRelString(){
        String ans = "[";
        Iterator<OrderedPair> temp = rel.iterator();
        OrderedPair temp2 = new OrderedPair("", "");
        while(temp.hasNext()){
            temp2 = temp.next();
            if(temp.hasNext())
                ans += temp2.toString() + ", ";
        }
        if(temp.hasNext())
            return ans + temp2.toString() + "]";
        else
            return "[]";
    }

    /**
     *    replaces the current relation instance variable with op
     */
    public void setRelation(Set<OrderedPair> op){
        rel = op;
        updateMat();
    }

    /**
     *    returns the current relation instance variable 
     */
    public Set<OrderedPair> getRelation(){  
        return rel;
    }

    /**
     *    retruns the number of Order Pairs in the relation
     */
    public int size(){
        return rel.size();
    }

    /**
     *    returns true if the array of Order Pairs forms a function
     *    returns false otherwise
     */
    public boolean isFunction(){
        return cheat.isFunction();
    }

    /**
     *    A function f from X to Y is said to be one to one if 
     *    for each y in Y, there is at most one x in X with f(x) = y
     *
     *    returns true if array of order Pairs is a function and the function is one to one
     *    returns false otherwise
     */
    public boolean isOneToOne(){
        return cheat.isOneToOne();
    }

    /**
     *    A function from X to Y is said to be onto if
     *    the range of f == Y
     *
     *    returns true if array of order Pairs is a function and the function is onto
     *    returns false otherwise
     */
    public boolean isOnTo(){
        return cheat.isOnTo();
    }

    /**
     *     returns true if the array of order Pairs is a function and the function is bijective
     *              that is both one to one and onto
     *     returns false otherwise
     */
    public boolean isBijective(){
        return cheat.isBijective();
    }

    /**
     *   precondition:  getRelation() and op (the parameter) are both functions.  
     *                  Domain of op is a subset of coDomain of getRelation()
     *   
     *   returns a new FunctionsChapter3Style Object.
     *   The domain of new FunctionsChapter3Style Object is this.domain
     *   The coDomain is opCoDomain (the paramenter)
     *   
     *   The new function is the composition op( this.getRelation (this.domain) )
     */
    public FunctionsChapter3Style composition(Set<OrderedPair> op, Set<String> opCoDomain){
        Set<OrderedPair> comp1 = new HashSet<OrderedPair>();
        Iterator<OrderedPair> it1 = op.iterator();
        Iterator<OrderedPair> it2;
        while(it1.hasNext()){
            OrderedPair temp1 = it1.next();
            String x1 = temp1.getX();
            it2 = rel.iterator();
            while(it2.hasNext()){
                OrderedPair temp2 = it2.next();
                if(temp2.getY().equals(x1)){
                    comp1.add(new OrderedPair(temp2.getX(), temp1.getY()));
                }
            }
        }
        FunctionsChapter3Style ans = new FunctionsChapter3Style(opCoDomain, opCoDomain, comp1);
        return ans;
    }

    /**
     *   precondition:  rel is a function.
     *   rel does not have to be both 1-1 and onto
     *   the inverse does not need to be a function
     */
    public OrderedPair[] getInverse(){
        OrderedPair[] ans = new OrderedPair[rel.size()];
        Iterator<OrderedPair> it = rel.iterator();
        for(int i=0; i<ans.length; i++){
            OrderedPair temp = it.next();
            ans[i] = new OrderedPair(temp.getY(), temp.getX());
        }
        return ans;
    }

    /**
     * A relation is reflexive if (x, x) in R for every x in X
     * 
     *       returns true if the current relation is reflexive
     *       returns false otherwise
     */
    public boolean isReflexive(){
        Set<String> check1 = new HashSet<String>();
        Iterator<OrderedPair> it1 = rel.iterator();
        while(it1.hasNext())
        {
            OrderedPair temp = it1.next();
            if(temp.getX().equals(temp.getY()))
                check1.add(temp.getY());
        }
        return check1.equals(domain);
    }

    /**
     *       A relation is symmetric if
     *       for all x, y in X, if (x,y) in R, then (y,x) in R
     * 
     *       returns true if the current relation is symmetric
     *       returns false otherwise
     */
    public boolean isSymmetric(){
        return cheat.isSymmetric();
    }

    /**
     *       A relation is Antisymmetric if
     *       for all x, y in X, if (x,y) in R, and (y,x) in R, then x = y
     * 
     *    returns true if the current relation is Antisymmetric
     *    returns false otherwise
     */
    public boolean isAntiSymmetric(){
        return cheat.isAntiSymmetric();
    }

    /**
     *       A relation is transitive:
     *       if (a,b) and (b,c) then (a,c)
     * 
     *       returns true if the current relation is reflexive
     *       returns false otherwise
     */
    public boolean isTransitive()
    {
        Object[] dom1 = domain.toArray();
        Object[] co1 = codomain.toArray();
        String[] dom = new String[dom1.length];
        String[] co = new String[co1.length];
        for(int i=0; i<dom1.length; i++)
            dom[i] = (String)dom1[i];
        for(int i=0; i<co1.length; i++)
            co[i] = (String)co1[i];
        
        int[][] mat = new int[dom.length][co.length];
        /** mat[x][y] **/
        for(int i=0; i<dom.length; i++){
            for(int j=0; j<co.length; j++){
                if(rel.contains(new OrderedPair(dom[i],co[j])))
                    mat[i][j] = 1;
            }
        }
        
        int[][] square = Matrix.product(mat, mat);
        for(int i=0; i<dom.length; i++){
            for(int j=0; j<co.length; j++){
                if(square[i][j] != 0)
                    if(mat[i][j] == 0)
                        return false;
            }
        }
        return true;
    }

    /**
     *    returns true is the relation is an Equivalence Relation
     *    returns false otherwise
     */
    public boolean isEquivalenceRelation(){
        return cheat.isEquivalenceRelation();
    }

    /**
     * 
     *    returns true is the relation is an Partially Order
     *    returns false otherwise
     */
    public boolean isPartiallyOrder(){
        return cheat.isPartiallyOrder();
    }

    /**
     *      not tested.
     *      Not sure why it is here.  I think I needed/used this functionality more than once,
     *      and therefore created a helper method
     */
    public ArrayList<OrderedPair> getRel(String s){
        ArrayList<OrderedPair> ans = new ArrayList<OrderedPair>();
        Iterator<OrderedPair> it = rel.iterator();
        while(it.hasNext()){
            ans.add(it.next());
        }
        return ans;
    }
    
    public void updateMat(){
        String[] dom = new String[domain.size()];
        String[] com = new String[codomain.size()];
        Iterator<String> it1 = domain.iterator();
        Iterator<String> it2 = codomain.iterator();
        for(int i=0; i<domain.size(); i++)
            dom[i] = it1.next();
        for(int i=0; i<codomain.size(); i++)
            com[i] = it2.next();
        
        int[][] mat = new int[dom.length][com.length];
        /** mat[x][y] **/
        for(int i=0; i<dom.length; i++){
            for(int j=0; j<com.length; j++){
                if(rel.contains(new OrderedPair(dom[i],com[j])))
                    mat[i][j] = 1;
            }
        }
        cheat.setRelation(mat);
    }
}