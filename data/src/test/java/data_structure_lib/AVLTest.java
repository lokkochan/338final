package data_structure_lib;

import org.junit.jupiter.api.Test;
import myLib.dataStructure.tree.AVL;
import myLib.dataStructure.nodes.TNode;
import myLib.dataStructure.tree.BST;
import static org.junit.jupiter.api.Assertions.*;

public class AVLTest {
    
    @Test
    public void testInsert() {
        AVL tree = new AVL();
        tree.Insert(new TNode(10));
        tree.Insert(new TNode(5));
        tree.Insert(new TNode(6));
        assertEquals(tree.Search(6).getData(), 6);
        assertEquals(tree.Search(5).getData(), 5);
        assertEquals(tree.Search(10).getData(), 10);
    }
    
    @Test
    public void testDelete() {
        AVL tree = new AVL();
        tree.Insert(new TNode(10));
        tree.Insert(new TNode(5));
        tree.Insert(new TNode(6));
        tree.printBF();
        tree.Delete(5);
        tree.printBF();
        assertNull(tree.Search(5));
        assertNotNull(tree.Search(6));
        assertNotNull(tree.Search(10));
    }

    @Test
    public void testTreeBalance() {
        AVL tree = new AVL();
        tree.Insert(new TNode(10));
        tree.Insert(new TNode(5));
        tree.Insert(new TNode(6));
        tree.Insert(new TNode(3));
        tree.Insert(new TNode(8));
        tree.Insert(new TNode(9));

        tree.printBF();
        TNode node = tree.Search(5);
        assertEquals(node.getLeft().getData(), 3);
        assertTrue(Math.abs(tree.getRoot().getLeft().getBalance()) <= 1);
        assertTrue(Math.abs(tree.getRoot().getBalance()) <= 1);
        assertTrue(Math.abs(tree.getRoot().getBalance()) <= 1);
    }

    @Test
    public void testPrintBF() {
        AVL bst = new AVL();
        bst.Insert(2);
        bst.Insert(3);
        bst.Insert(1);
        bst.Insert(5);
        bst.Insert(4);
        System.out.println("Tree");
        bst.printBF();
        System.out.println("Tree end");

        bst.Insert(6);
        System.out.println(bst.Search(2).getHeight());
        System.out.println("Tree");
        bst.printBF();
        //print the balance of each node out
        assertTrue(Math.abs(bst.getRoot().getLeft().getBalance()) <= 1);
        assertTrue(Math.abs(bst.getRoot().getRight().getBalance()) <= 1);
        assertTrue(Math.abs(bst.getRoot().getBalance()) <= 1);
    }    

    @Test
    public void reTest(){
        BST bst = new BST();
        bst.Insert(1);
        bst.Insert(2);
        bst.Insert(3);
        bst.printBF();
        System.out.println((bst.getRoot().getLeft()!=null));
        System.out.println((bst.getRoot().getRight()!=null));
        AVL tree = new AVL(bst.getRoot());
        tree.printBF();
    }

    @Test
    public void removeTest(){
        AVL tree = new AVL();
        tree.Insert(1);
        tree.Insert(2);
        tree.Insert(3);
        tree.Insert(4);
        tree.Insert(5);
        tree.Insert(6);
        tree.Insert(7);
        tree.Insert(8);
        tree.Insert(9);
        tree.Insert(10);

        tree.printBF();
        tree.Delete(3);
        tree.printBF();
    }
}