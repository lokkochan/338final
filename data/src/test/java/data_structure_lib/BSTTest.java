package data_structure_lib;

import myLib.dataStructures.nodes.TNode;
import myLib.dataStructures.tree.BST;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for BST.
 */
public class BSTTest {
    @Test
    public void testIsEmpty() {
        BST bst = new BST();
        assertTrue(bst.isEmpty());

        bst.Insert(1);
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testGetSize() {
        BST bst = new BST();
        assertEquals(0, bst.getSize());

        bst.Insert(1);
        assertEquals(1, bst.getSize());

        bst.Insert(2);
        assertEquals(2, bst.getSize());
    }

    @Test
    public void testGetRoot() {
        BST bst = new BST();
        assertNull(bst.getRoot());

        TNode node = new TNode(1);
        bst.setRoot(node);
        assertEquals(node, bst.getRoot());
    }

    @Test
    public void testInsert() {
        BST bst = new BST();
        bst.Insert(1);
        assertEquals(1, bst.getSize());

        bst.Insert(2);
        bst.Insert(3);
        bst.Insert(4);
        assertEquals(4, bst.getSize());

        TNode root = bst.getRoot();
        assertEquals(1, root.getData());
        assertEquals(2, root.getRight().getData());
        assertEquals(3, root.getRight().getRight().getData());
        assertEquals(4, root.getRight().getRight().getRight().getData());
    }

    @Test
    public void testDelete() {
        BST bst = new BST();
        bst.Insert(3);
        bst.Insert(2);
        bst.Insert(1);
        bst.Insert(5);
        bst.Insert(4);
        bst.Insert(6);
        bst.printBF();
        System.out.println(bst.getRoot().getHeight());
        System.out.println(bst.getRoot().getLeft().getHeight());
        System.out.println(bst.getRoot().getRight().getLeft().getHeight());

        bst.Delete(5);
        assertEquals(5, bst.getSize());

        bst.Delete(1);
        assertEquals(4, bst.getSize());

        bst.Delete(3);
        assertEquals(3, bst.getSize());

        TNode root = bst.getRoot();
        assertEquals(4, root.getData());
        assertEquals(6, root.getRight().getData());
        assertEquals(2, root.getLeft().getData());
        bst.printBF();
        System.out.println(bst.getRoot().getHeight());
        System.out.println(bst.getRoot().getLeft().getHeight());
    }

    @Test
    public void testSearch() {
        BST bst = new BST();
        bst.Insert(3);
        bst.Insert(2);
        bst.Insert(1);
        bst.Insert(5);
        bst.Insert(4);
        bst.Insert(6);

        assertEquals(2, bst.Search(2).getData());
        assertNull(bst.Search(7));
    }

    @Test
    public void testPrintInOrder() {
        BST bst = new BST();
        bst.Insert(3);
        bst.Insert(2);
        bst.Insert(1);
        bst.Insert(5);
        bst.Insert(4);
        bst.Insert(6);

        bst.printInOrder();
    }

    @Test
    public void testPrintBF() {
        BST bst = new BST();
        bst.Insert(2);
        bst.Insert(3);
        bst.Insert(1);
        bst.Insert(5);
        bst.Insert(4);
        bst.Insert(6);
        System.out.println(bst.getRoot().getHeight());
        System.out.println(bst.getRoot().getRight().getHeight());
        System.out.println(bst.getRoot().getRight().getRight().getHeight());

        System.out.println(bst.getRoot().getRight().getRight().getRight().getHeight());


        bst.printBF();
    }    
}
