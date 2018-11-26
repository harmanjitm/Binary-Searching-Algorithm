package ADT;

import java.util.Iterator;

public interface BSTADT<E extends Comparable<? super  E>> {

    /**
     * Method to add a new item of type E to the BST
     *
     * Pre-Condition: The toAdd must not be null
     * Post-Condition: If the toAdd is NULL, then a {@link NullPointerException} must be thrown
     *
     * @param toAdd The element of type E to add to the BST.
     */
    void add(E toAdd) throws NullPointerException;

    /**
     * Method to search the BST and check if the specified value
     * exists in the tree. If the value is found, it is returned.
     *
     * Pre-Condition: The value to search for cannot be NULL
     * Post-Condition: The value returned must not be NULL.
     *                 If the value being searched for is NULL, the program
     *                 must throw a {@link NullPointerException}
     *                 If the value is found, return true, else false.
     *
     * @param toSearch The value to search for
     * @return {true, false}. If the value is found then return true
     * else if the value is not found, then return false.
     */
    boolean contains(E toSearch) throws NullPointerException;

    /**
     * Method to search the BST and return the specified element if its found.
     *
     * Pre-Condition: The value being passed in can not be NULL.
     * Post-Condition: If the value is NOT NULL, then the reference must
     *                 be returned if the element is in the BST.
     *                 If the element is not in the BST, then it will return null.
     *
     * @param element The element to search for
     * @return E, the reference to the element if found.
     */
    E get(E element) throws NullPointerException;

    /**
     * Method to get the height of the BST as an Integer
     *
     * Pre-Condition: The BST cannot be NULL and must be instantiated.
     * Post-Condition: The size returned must be >=0 && <= total number of elements
     *
     * @return int The size/height of the BST
     */
    int size();

    /**
     * Method to iterate through the BST and get values in order
     *
     * Pre-Condition: The BST cannot have NULL elements or no elements in it
     * Post-Condition: The value being returned cannot be NULL, and must be of type E
     *
     * @return the element.
     */
    Iterator<E> getInOrderIterator();

    /**
     * Method to iterate through the BST and get values from left, right, root
     *
     * Pre-Condition: The BST cannot have NULL elements or no elements in it
     * Post-Condition: The value being returned cannot be NULL, and must be of type E
     *
     * @return the element.
     */
    Iterator<E> getPostOrderIterator();

    /**
     * Method to iterate through the BST and get values from root, left, right
     *
     * Pre-Condition: The BST cannot have NULL elements or no elements in it
     * Post-Condition: The value being returned cannot be NULL, and must be of type E
     *
     * @return the element.
     */
    Iterator<E> getPreOrderIterator();

}
