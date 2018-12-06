package BST;

import ADT.BSTreeADT;
import exceptions.TreeException;
import sun.reflect.generics.tree.Tree;
import utility.DLL;

import java.util.Iterator;

public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT<E> {

    DLL list = new DLL();
    BSTNode root = null;

    public BSTReferencedBased()
    {
        root = null;
    }

    /**
     * The element stored in the root of the Binary Search Tree will be
     * returned.
     *
     * @return data element stored in root of tree is returned
     * @throws TreeException if the root is empty.
     */
    @Override
    public E getRootData() throws TreeException {
        if(root == null)
        {
            throw new TreeException();
        }
        return (E) root.data;
    }

    /**
     * Determines the row height of the tree and returns that value as an
     * integer value.
     *
     * @return the height of the tree.
     */
    @Override
    public int getHeight()
    {
        return heightCalc(root);
    }

    private int heightCalc(BSTNode<E> node)
    {
        if(node == null)
        {
            return -1;
        }
        else
        {
            return 1+Math.max(heightCalc(node.left), heightCalc(node.right));
        }
    }

    /**
     * The number of elements currently stored in the tree is counted and
     * the value is returned.
     *
     * @return number of elements currently stored in tree.
     */
    @Override
    public int size() {
        return sizeCalc(root);
    }

    private int sizeCalc(BSTNode<E> root)
    {
        if(root == null)
        {
            return 0;
        }
        else if(root.left == null && root.right == null)
        {
            return 1;
        }
        else
        {
            return sizeCalc(root.left) + sizeCalc(root.right);
        }
    }

    /**
     * Checks if the tree is currently empty.
     *
     * @return returns boolean true if the tree is empty otherwise false.
     */
    @Override
    public boolean isEmpty() {
        if(root!=null)
        {
            return true;
        }
        return false;
    }

    /**
     * Clears all elements currently stored in tree and makes the tree empty.
     */
    @Override
    public void clear() {
        root.left = null;
        root.right = null;
        root = null;
    }

    /**
     * Checks the current tree to see if the element passed in is stored in
     * the tree. If the element is found in the tree the method returns true
     * and if the element is not in the tree the method returns false.
     *
     * @param entry the element to find in the tree
     * @return returns boolean true if element is currently in the tree and
     * false if the element is not found in the tree
     * @throws TreeException if the tree is empty.
     */
    @Override
    public boolean contains(E entry) throws TreeException {
        if(root == null)
        {
            throw new TreeException();
        }
        return containsSearch(root,entry);
    }

    private boolean containsSearch(BSTNode<E> toStart, E toSearch)
    {
        if(toStart.data.compareTo(toSearch) == 0)
        {
            return true;
        }
        else if(toStart.data.compareTo(toSearch) < 0)
        {
            return containsSearch(toStart.left, toSearch);
        }
        else
        {
            return containsSearch(toStart.right, toSearch);
        }
    }

    /**
     * Retrieves an element from the tree given the object to search for.
     *
     * @param entry element object being searched
     * @return the element located in tree, null if not found
     * @throws TreeException if the tree is empty
     */
    @Override
    public E getEntry(E entry) throws TreeException {
        if(entry == null)
        {
            throw new TreeException();
        }
        if(contains(entry))
        {
            return entry;
        }
        return null;
    }

    /**
     * Adds a new element to the tree according to the natural ordering
     * established by the Comparable implementation.
     *
     * @param newEntry the element being added to the tree
     * @return a boolean true if the element is added successfully else false
     * @throws NullPointerException if the element being added is null
     */
    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if(root == null)
        {
            throw new NullPointerException();
        }
        if()
        return false;
    }

    public BSTNode<E> addNode(BSTNode<E> toStart, E toAdd)
    {

    }

    /**
     * Generates an in-order iteration over the contents of the tree. Elements
     * are in their natural order.
     *
     * @return an iterator with the elements in the natural order
     */
    @Override
    public Iterator<E> inorderIterator() {
        return null;
    }

    /**
     * Generates a pre-order iteration over the contents of the tree. Elements
     * are order in such a way as the root element is first.
     *
     * @return an iterator with the elements in a root element first order
     */
    @Override
    public Iterator<E> preorderIterator() {
        return null;
    }

    /**
     * Generates a post-order iteration over the contents of the tree. Elements
     * are order in such a way as the root element is last.
     *
     * @return an iterator with the elements in a root element last order
     */
    @Override
    public Iterator<E> postorderIterator() {
        return null;
    }
}
