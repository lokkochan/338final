package data_structure_lib;

import myLib.dataStructures.linear.CSLL;
import myLib.dataStructures.nodes.SNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CSLLTest {

    @Test
    public void testInsertTail() {
        CSLL list = new CSLL();
        list.InsertTail(new SNode(1));
        list.InsertTail(new SNode(2));
        list.InsertTail(new SNode(3));
        assertEquals(3, list.size());
    }

    @Test
    public void testInsertHead() {
        CSLL list = new CSLL();
        list.InsertHead(new SNode(1));
        list.InsertHead(new SNode(2));
        list.InsertHead(new SNode(3));
        assertEquals(3, list.size());
    }

    @Test
    public void testInsert() {
        CSLL list = new CSLL();
        list.Insert(new SNode(1), 0);
        list.Insert(new SNode(2), 1);
        list.Insert(new SNode(3), 1);
        assertEquals(3, list.size());
    }

    @Test
    public void testDeleteHead() {
        CSLL list = new CSLL();
        list.InsertTail(new SNode(1));
        list.InsertTail(new SNode(2));
        list.DeleteHead();
        assertEquals(1, list.size());
        assertEquals(2, list.gethead().getData());
    }

    @Test
    public void testDeleteTail() {
        CSLL list = new CSLL();
        list.InsertTail(new SNode(1));
        list.InsertTail(new SNode(2));
        list.DeleteTail();
        assertEquals(1, list.size());
        assertEquals(1, list.gethead().getData());
    }

    @Test
    public void testIsSorted() {
        CSLL list = new CSLL();
        list.InsertTail(new SNode(1));
        list.InsertTail(new SNode(2));
        list.InsertTail(new SNode(3));
        assertTrue(list.isSorted());
        list.InsertTail(new SNode(0));
        assertFalse(list.isSorted());
    }

    @Test
    public void testSort() {
        CSLL list = new CSLL();
        list.InsertTail(new SNode(3));
        list.InsertTail(new SNode(1));
        list.InsertTail(new SNode(4));
        list.InsertTail(new SNode(2));
        list.Sort();
        assertTrue(list.isSorted());
    }

    @Test
    public void testDelete() {
        CSLL list = new CSLL();
        SNode nodeToDelete = new SNode(2);
        list.InsertTail(new SNode(1));
        list.InsertTail(nodeToDelete);
        list.InsertTail(new SNode(3));
        list.Delete(nodeToDelete);
        assertEquals(2, list.size());
        assertNull(list.Search(nodeToDelete));
    }

    @Test
    public void testClear() {
        CSLL list = new CSLL();
        list.InsertTail(new SNode(1));
        list.InsertTail(new SNode(2));
        list.Clear();
        assertEquals(0, list.size());
        assertNull(list.gethead());
    }

    @Test
    public void testSearch() {
        CSLL list = new CSLL();
        SNode nodeToSearch = new SNode(2);
        list.InsertTail(new SNode(1));
        list.InsertTail(nodeToSearch);
        list.InsertTail(new SNode(3));
        assertEquals(nodeToSearch, list.Search(nodeToSearch));
    }

    @Test
    public void testIsCircular() {
        CSLL list = new CSLL();
        list.InsertTail(new SNode(1));
        list.InsertTail(new SNode(2));
        list.InsertTail(new SNode(3));
        assertTrue(list.isCircular());
    }
}