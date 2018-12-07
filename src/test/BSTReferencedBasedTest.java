package test;

import BST.BSTReferencedBased;
import exceptions.TreeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTReferencedBasedTest {

    BSTReferencedBased bst = null;
    int num1 = 1;
    int num2 = 2;
    int num3 = 3;

    @BeforeEach
    void setUp() {
        bst = new BSTReferencedBased();
    }

    @Test
    void getRootData() throws TreeException {
        assertEquals(true, bst.add(num1));
        assertEquals(num1,bst.getRootData());
    }

    @Test
    void getHeight() {
        assertEquals(true, bst.add(num1));
        assertEquals(1,bst.getHeight());
    }

    @Test
    void size() {
        assertEquals(true, bst.add(num1));
        assertEquals(true, bst.add(num2));
        assertEquals(2,bst.size());
    }

    @Test
    void isEmpty() {
        assertEquals(true, bst.isEmpty());
    }

    @Test
    void clear() {
        assertEquals(true, bst.add(num1));
        bst.clear();
        try {
            bst.getRootData();
            fail("List is not cleared");
        }
        catch (TreeException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void contains() throws TreeException {
        assertEquals(true, bst.add(num1));
        assertEquals(true,bst.contains(num1));
    }

    @Test
    void getEntry() throws TreeException {
        assertEquals(true, bst.add(num1));
        assertEquals(true, bst.add(num2));
        assertEquals(num2,bst.getEntry(num2));
    }

    @Test
    void add() throws TreeException {
        assertEquals(true, bst.add(num1));
        assertEquals(true, bst.contains(num1));
    }
}