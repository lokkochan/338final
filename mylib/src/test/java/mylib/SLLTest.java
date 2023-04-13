package mylib;

import org.junit.Test;
import static org.junit.Assert.*;
import mylib.dataStructures.linear.SLL;
import mylib.dataStructures.nodes.SNode;

public class SLLTest {

    @Test
    public void testInsertHead() {
        SLL list = new SLL();
        list.InsertHead(new SNode(1));
        assertEquals(1, list.gethead().data);
        assertEquals(null, list.gethead().next);
        assertEquals(list.gethead(), list.gettail());
        list.InsertHead(new SNode(0));
        assertEquals(0, list.gethead().data);
    }
    
    @Test
    public void testInsertTail() {
        SLL list = new SLL();
        list.InsertTail(new SNode(1));
        assertEquals(1, list.gethead().data);
        assertEquals(null, list.gethead().next);
        assertEquals(list.gethead(), list.gettail());
        list.InsertTail(new SNode(2));
        assertEquals(1, list.gethead().data);
        assertEquals(2, list.gettail().data);
    }
    
    @Test
    public void testInsertAtIndex() {
        SLL list = new SLL();
        boolean thrown = false;
        try {
            list.Insert(new SNode(1), 1);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.Insert(new SNode(1), 0);
        assertEquals(1, list.gethead().data);
        assertEquals(list.gethead(), list.gettail());
        list.Insert(new SNode(2), 1);
        assertEquals(2, list.gettail().data);
        list.Insert(new SNode(3), 1);
        assertEquals(3, list.gethead().next.data);
    }
    
    @Test
    public void testSortedInsert() {
        // Create a new singly linked list
        SLL list = new SLL();

        // Insert some nodes into the list
        list.InsertHead(new SNode(5));
        list.InsertHead(new SNode(3));
        list.InsertHead(new SNode(1));

        // Insert a new node into the sorted list
        SNode insertNode = new SNode(4);
        list.SortedInsert(insertNode);

        // Ensure that the node was inserted in the correct position
        assertEquals(4, list.getsize());
        assertEquals(1, list.gethead().data);
        assertEquals(5, list.gettail().data);
        assertEquals(insertNode, list.gethead().next.next);
    }
    
    @Test
    public void testSearch() {
        SLL list = new SLL();
        SNode search =new SNode(1);
        assertEquals(null, list.Search(search));
        list.InsertHead(new SNode(2));
        list.InsertHead(new SNode(1));
        list.InsertTail(search);
        assertEquals(3, list.getsize());
        assertEquals(list.gethead().data, list.Search(list.gethead()).data);
        assertEquals(list.gettail().data, list.Search(list.gettail()).data);
    }
    
    @Test
    public void testDeleteHead(){
        SLL list = new SLL();
        list.InsertHead(new SNode(2));
        list.InsertHead(new SNode(1));
        list.InsertTail(new SNode(3));
        assertEquals(3, list.getsize());
        list.DeleteHead();
        assertEquals(2, list.getsize());
        assertEquals(2, list.gethead().data);
    }

    @Test
    public void testDeleteTail(){
        SLL list = new SLL();
        list.InsertHead(new SNode(2));
        list.InsertHead(new SNode(1));
        list.InsertTail(new SNode(3));
        assertEquals(3, list.getsize());
        list.DeleteTail();
        list.Print();
        assertEquals(2, list.getsize());
        assertEquals(2, list.gettail().data);
    }

    @Test
    public void testDelete() {
        SLL linkedList = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        linkedList.SortedInsert(node1);
        linkedList.SortedInsert(node2);
        
        // delete the head of the list
        linkedList.Delete(node2);
        
        // assert that the head was deleted and the list has only one node left
        assertNull(linkedList.Search(node2));
        assertNotNull(linkedList.Search(node1));
        assertEquals(1, linkedList.getsize());
    }
    
    @Test
    public void testClear() {
        SLL list = new SLL();
        list.InsertHead(new SNode(2));
        list.InsertHead(new SNode(1));
        list.InsertTail(new SNode(3));
        assertEquals(3, list.getsize());
        list.Clear();
        assertEquals(0, list.getsize());
    }
    
}

