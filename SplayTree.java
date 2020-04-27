/**
 *  Java Program to Implement SplayTree
 **/

import java.util.ArrayList;
xscvcimport java.util.Scanner;

/** Class Node **/
class SplayNode
{
    SplayNode left, right, parent;

    String elementInEnglish;
    String elementInSpanish;


    /** Constructor **/
    public SplayNode()
    {
        this.left= null;
        this.right=null;
        this.parent=null;
        this.parent=null;
        this.elementInEnglish=null;
        this.elementInSpanish=null;
    }
    /** Constructor **/
    public SplayNode(String elementInEnglish, String elementInSpanish)
    {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.elementInEnglish = elementInEnglish;
        this.elementInSpanish = elementInSpanish;
    }
}





/** Class SplayTree **/
class SplayTree
{
    private SplayNode root;
    private int count = 0;
    ArrayList<SplayNode> splayList = new ArrayList<>();

    /** Constructor **/
    public SplayTree()
    {
        root = null;
    }


    /** function to insert element */
    public void insert(SplayNode element)
    {
        SplayNode z = root;
        SplayNode p = null;
        while (z != null)
        {
            p = z;
            if (element.elementInEnglish.compareTo(p.elementInEnglish) > 0)
                z = z.right;
            else
                z = z.left;
        }

        assert false;
        Splay(z);

        count++;
    }

    /** function splay **/
    private void Splay(SplayNode x)
    {
        while (x.parent != null)
        {
            SplayNode Parent = x.parent;
            SplayNode GrandParent = Parent.parent;
            if (GrandParent == null)
            {
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);
            }
            else
            {
                if (x == Parent.left)
                {
                    if (Parent == GrandParent.left)
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    }
                    else
                    {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                }
                else
                {
                    if (Parent == GrandParent.left)
                    {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    }
                    else
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        root = x;
    }

    /** rotate **/
    public void makeLeftChildParent(SplayNode c, SplayNode p)
    {
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            throw new RuntimeException("WRONG");

        if (p.parent != null)
        {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }

    /** rotate **/
    public void makeRightChildParent(SplayNode c, SplayNode p)
    {
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null)
        {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.left != null)
            c.left.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }






    public void inorder() {
        inorder(root);
    }

    private void inorder(SplayNode r) {

        if (r != null) {
            inorder(r.left);
            splayList.add(r);
            inorder(r.right);
        }

    }


    /** Functions to search for an element **/
    public String search(String word)
    {
        inorder();
        for (SplayNode splayNode : splayList) {
            if (splayNode.elementInEnglish.equals(word)) {
                // System.out.println();
                //  System.out.println(splayList.get(i).spanish);
                return (String) splayNode.elementInSpanish;
            }
        }
        return "*"+word+"*";
    }


}

