package data_structure_lib;
import myLib.dataStructures.linear.LinkedLists.*;
import myLib.dataStructures.nodes.DNode;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// public class DLLTest {

//     // @Test
//     // public void testInsertHead() {
//     //     DLL list = new DLL();
//     //     list.InsertHead(1);
//     //     list.InsertHead(2);
//     //     list.InsertHead(3);
//     //     assertEquals(3, list.getSize());
//     //     assertEquals(3, list.gethead().data);
//     //     assertEquals(1, list.gettail().data);
//     // }

//     // @Test
//     // public void testInsertTail() {
//     //     DLL list = new DLL();
//     //     list.InsertTail(1);
//     //     list.InsertTail(2);
//     //     list.InsertTail(3);
//     //     assertEquals(3, list.getSize());
//     //     assertEquals(1, list.gethead().data);
//     //     assertEquals(3, list.gettail().data);
//     // }

//     // @Test
//     // public void testInsert() {
//     //     DLL list = new DLL();
//     //     list.Insert(1, 0);
//     //     list.Insert(2, 1);
//     //     list.Insert(3, 1);
//     //     assertEquals(3, list.getSize());
//     //     assertEquals(1, list.gethead().data);
//     //     assertEquals(3, list.gethead().next.data);
//     //     assertEquals(2, list.gethead().next.next.data);
//     //     assertEquals(2, list.gettail().data);
//     // }

//     // @Test
//     // public void testInsertInvalidPosition() {
//     //     DLL list = new DLL();
//     //     try{
//     //         list.Insert(1, 1);
//     //     } catch (IllegalArgumentException e) {
//     //         assertEquals("Position is out of range", e.getMessage());
//     //     }
//     // }

//     // @Test
//     // public void testSortedInsert() {
//     //     DLL list = new DLL();
//     //     list.SortedInsert(2);
//     //     list.SortedInsert(1);
//     //     list.SortedInsert(3);
//     //     assertEquals(3, list.getSize());
//     //     assertEquals(1, list.gethead().data);
//     //     assertEquals(3, list.gettail().data);
//     // }

//     // @Test
//     // public void testSearch() {
//     //     DLL list = new DLL();
//     //     list.InsertHead(1);
//     //     list.InsertHead(2);
//     //     list.InsertHead(3);
//     //     DNode node = list.Search(2);
//     //     assertNotNull(node);
//     //     assertEquals(2, node.data);
//     //     node = list.Search(4);
//     //     assertNull(node);
//     // }

//     // @Test
//     // public void testDeleteHead() {
//     //     DLL list = new DLL();
//     //     list.InsertHead(1);
//     //     list.InsertHead(2);
//     //     list.InsertHead(3);
//     //     DNode node = list.DeleteHead();
//     //     assertNotNull(node);
//     //     assertEquals(3, node.data);
//     //     assertEquals(2, list.gethead().data);
//     //     assertEquals(2, list.getSize());
//     //     assertNull(list.gethead().prev);
//     // }

//     // @Test
//     // public void testDeleteTail() {
//     //     DLL list = new DLL();
//     //     list.InsertHead(1);
//     //     list.InsertHead(2);
//     //     list.InsertHead(3);
//     //     DNode node = list.DeleteTail();
//     //     assertNotNull(node);
//     //     assertEquals(2, list.gethead().next.next.prev.data);

//     //     assertEquals(1, node.data);
//     //     assertEquals(2, list.gettail().data);
//     //     assertEquals(2, list.getSize());
//     // }

//     // @Test
//     // public void testDelete() {
//     //     DLL list = new DLL();
//     //     list.InsertHead(1);
//     //     list.InsertHead(2);
//     //     list.InsertHead(3);
//     //     DNode node = list.Delete(2);
//     //     assertNotNull(node);
//     //     assertEquals(2, node.data);
//     //     assertEquals(3, list.gethead().data);
//     //     assertEquals(1, list.gettail().data);
//     //     assertEquals(2, list.getSize());
//     //     node = list.Delete(4);
//     //     assertNull(node);
//     // }

//     // @Test
//     // public void testSort() {
//     //     DLL list = new DLL();
//     //     list.InsertHead(3);
//     //     list.InsertHead(2);
//     //     list.InsertHead(4);
//     //     assertEquals(4, list.gethead().next.prev.data);
//     //     list.Print();
//     //     list.sort();
//     //     list.Print();
//     //     assertEquals(2, list.gethead().data);
//     //     assertEquals(4, list.gettail().data);
//     // }

//     // @Test
//     // public void testClear() {
//     //     DLL list = new DLL();
//     //     list.InsertHead(1);
//     //     list.InsertHead(2);
//     //     list.InsertHead(3);
//     //     list.Clear();
//     //     assertEquals(0, list.getSize());
//     //     assertNull(list.gethead());
//     //     assertNull(list.gettail());
//     // }

// }




import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DLLTest {

    @Test
    void testInsertHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        assertEquals(3, dll.getSize());
        assertEquals(node3, dll.getHead());
        assertEquals(node1, dll.getTail());
    }

    @Test
    void testInsertTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertTail(node1);
        dll.InsertTail(node2);
        dll.InsertTail(node3);

        assertEquals(3, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getTail());
    }

    @Test
    void testInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.Insert(node1, 0);
        dll.Insert(node2, 1);
        dll.Insert(node3, 1);

        assertEquals(3, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node2, dll.getTail());
    }

    @Test
    void testSortedInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.SortedInsert(node2);
        dll.SortedInsert(node3);
        dll.SortedInsert(node1);
        dll.Print();

        assertEquals(3, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getTail());
    }

    @Test
    void testDeleteHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

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
        DNode node3 = new DNode(3);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.DeleteTail();

        assertEquals(2, dll.getSize());
        assertEquals(node3, dll.getHead());
        assertEquals(node2, dll.getTail());
    }

    @Test
    void testSort() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertHead(node3);
        dll.InsertHead(node1);
        dll.InsertHead(node2);}}

