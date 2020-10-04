import java.io.*;
import java.util.*;
import java.math.*;
/**
 * @author  J0$h Ibad
 * @version 05/05/2019
 * 
 * J0$hified
 */
public class ForestPlayGround 
{
    String[] myTree;

    /**
     *   PreConditions
     *        tree is a valid represntation fo a binary tree
     *        tree != null
     *        tree.size() >= 0
     */
    public ForestPlayGround(String[] tree)
    {
        myTree = tree;
    }

    /**
     *    return the number of non null nodes in myTree
     */
    public int getNumNodes()
    {
        int nodes = 0;
        for(String str : myTree)
            if(str != null){nodes++;}
        return nodes;
    }

    /**
     *    A leaf is a node in the tree in which both children have 0 children.
     *    An empty tree contains NO leafs
     */
    public int getNumLeafs()
    {
        int leafs = 0;
        for(int i=0; i<myTree.length; i++){
            if((myTree[i] != null) && (getRightChild(i) == null) && getLeftChild(i) == null){leafs++;}
        }
        return leafs;
    }

    /**
     *    Precondition:   0 <= p < myTree.length
     *
     *    returns:
     *        the right child of myTree[p]
     *        null if myTree[p] does not have a right child
     */
    public String getRightChild(int p)
    {
        try{
            return myTree[2*p+2];
        }catch(Exception e)
        {
            return null;
        }
    }

    /**
     *    Precondition:   0 <= p < myTree.length
     *
     *    returns:
     *        the left child of myTree[p]
     *        null if myTree[p] does not have a left child
     */
    public String getLeftChild(int p)
    {
        try{
            return myTree[2*p+1];
        }catch(Exception e)
        {
            return null;
        }
    }

    /**
     *    Precondition:   0 <= p < myTree.length
     *                    myTree[p] != null
     *
     *    returns:
     *        the parent of myTree[p]
     *        null if myTree[p] does not have a parent
     */
    public String getParent(int p)
    {
        if(p==0){return null;}
        try{
            return myTree[(p-1)/2];
        }catch(Exception e)
        {
            return null;
        }
    }

    /**
     *    Precondition:   0 <= p < myTree.length
     *                    myTree[p] != null
     *
     *    returns:
     *        the List of all ancestors (parent and their parent ans so on) of myTree[p]
     *        an empty List if myTree[p] does not have a parent
     */
    public List<String> getAncestors(int p)
    {
        ArrayList<String> ans = new ArrayList<String>();
        if(getParent(p) == null)
            return ans;
        else{
            while(true)
            {
                p = (p-1)/2;
                ans.add(myTree[p]);
                if(p == 0) 
                    break;
            }
        }
        return ans;
    }

    /**
     * Preconditions:
     *    myTree[p] != null
     *    0 <= p < myTree.length
     */
    public List<String> getDescendants(int p)
    {
        ArrayList<String> ans = new ArrayList<String>();
        if((myTree[p] != null) && (getRightChild(p) == null) && (getLeftChild(p) == null))
            return ans;
        p = 2*p + 1;
        if(p < myTree.length){
            String temp = myTree[p];
            if(temp != null){ans.add(temp);}
            ans.addAll(getDescendants(p));
            p++;
            if(p < myTree.length){
                temp = myTree[p];
                if(temp != null){ans.add(temp);}
                ans.addAll(getDescendants(p));
            }
        }
        return ans;
    }

    /**
     *    In a complete binary tree every level, except possibly the last, is completely filled,
     *    and all nodes in the last level are as far left as possible.
     *    
     *    This implies that the end of the array may contain multiple nulls
     *                               and the array/tree may still be complete
     */
    public boolean isComplete()
    {
        if(myTree.length < 2)
            return true;
        int i = myTree.length - 1;
        while(myTree[i] == null){i--;}
        while(i>=0){
            if(myTree[i]==null)
                return false;
            i--;
        }
        return true;
    }

    /**
     *    A full binary tree is a tree in which every node in the tree has either 0 or 2 children.
     */
    public boolean isFull()
    {
        if(myTree.length < 2)
            return true;
        int i = myTree.length - 1;
        while(myTree[i] == null){i--;}
        while(i>=0){
            if(myTree[i]!=null && ((getLeftChild(i)!=null && getRightChild(i)==null) || (getLeftChild(i)==null && getRightChild(i)!=null)))
                return false;
            i--;
        }
        return true;
    }

    /**
     *    returns the least common ancestor of child1 and child2
     *    
     *    you may assume child1 and child2 are valid nodes in the tree
     */
    public String getLowestCommonAncestor(String child1, String child2)
    {
        if(child1.equals(child2)){return child1;}
        int p=0, q=0;
        for(int i=0; i<myTree.length; i++){
            String temp = myTree[i];
            if(temp == null)
                continue;
            if(child1.equals(temp)){p=i;}
            if(child2.equals(temp)){q=i;}
        }
        
        List<String> li1 = getAncestors(p);
        List<String> li2 = getAncestors(q);
        if(li1.contains(child2)) return child2;
        if(li2.contains(child1)) return child1;
        for(int i=0; i<li1.size(); i++)
        {
            String temp = li1.get(i);
            for(int j=0; j<li2.size(); j++)
            {
                if(temp.equals(li2.get(j)))
                    return temp;
            }
        }
        return null;
    }
}