package data_structure_lib;
import myLib.dataStructures.linear.DLL;
import myLib.dataStructures.nodes.DNode;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for DLL.
 */
class DLLTest {
    private static final int TEST_NUMBER =3;
    @Test 
    void testIsEmpty()
     {
        DLL dll = new DLL();
        assertTrue(dll.isEmpty());
        dll.InsertHead(new DNode(1));
        assertFalse(dll.isEmpty());
    }
    
    @Test
    void testInsertHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);
        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        assertEquals(TEST_NUMBER, dll.getSize());
        assertEquals(node3, dll.getHead());
        
        assertEquals(node1, dll.getTail());
    }

    @Test
    void testInsertTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3= new DNode(TEST_NUMBER);

        dll.InsertTail(node1);
        dll.InsertTail(node2);
        dll.InsertTail(node3);

        assertEquals(TEST_NUMBER, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getTail());
    }

    @Test
    void testInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.Insert(node1, 0);
        dll.Insert(node2, 1);
        dll.Insert(node3, 1);

        assertEquals(TEST_NUMBER, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node2, dll.getTail());
    }

    @Test
    void testSortedInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.SortedInsert(node2);
        dll.SortedInsert(node3);
        dll.SortedInsert(node1);
        dll.Print();

        assertEquals(TEST_NUMBER, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getTail());
    }
    @Test
    void testSearch() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        assertEquals(node3, dll.Search(node3));
    }

    @Test
    void testDeleteHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.DeleteHead();

        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());
    }

    @Test
    void testDeleteTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.DeleteTail();
        assertEquals(2, dll.getSize());
        assertEquals(node3, dll.getHead());
        assertEquals(node2, dll.getTail());}
        
    @Test
    void testDelete(){
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.Delete(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node3, dll.getHead());
        assertEquals(node1, dll.getTail());
    }
    @Test
    void testSort() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.Sort();
        assertEquals(3, dll.getSize());
        assertEquals(node3, dll.getHead());
        assertEquals(node1, dll.getTail());
    }
    @Test 
    void testClear(){
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(TEST_NUMBER);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.Clear();
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }
}