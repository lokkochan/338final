package data_structure_lib;
import myLib.dataStructure.linear.SLL;
import myLib.dataStructure.nodes.SNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SLLTest {

    @Test
    void testInsertHead() {
        SLL list = new SLL();
        list.InsertHead(1);
        assertEquals(1, list.gethead().data);
        assertEquals(null, list.gethead().next);
        assertEquals(list.gethead(), list.gettail());
        list.InsertHead(0);
        assertEquals(0, list.gethead().data);
        assertEquals(1, list.gettail().data);
    }
    
    @Test
    void testInsertTail() {
        SLL list = new SLL();
        list.InsertTail(1);
        assertEquals(1, list.gethead().data);
        assertEquals(null, list.gethead().next);
        assertEquals(list.gethead(), list.gettail());
        list.InsertTail(2);
        assertEquals(1, list.gethead().data);
        assertEquals(2, list.gettail().data);
    }
    
    @Test
    void testInsertAtIndex() {
        SLL list = new SLL();
        assertThrows(IllegalArgumentException.class, () -> {
            list.Insert(new SNode(1), 1);
        });
        list.Insert(new SNode(1), 0);
        assertEquals(1, list.gethead().data);
        assertEquals(list.gethead(), list.gettail());
        list.Insert(new SNode(2), 1);
        assertEquals(2, list.gettail().data);
        list.Insert(new SNode(3), 1);
        assertEquals(3, list.gethead().next.data);
    }
    
    @Test
    void testSortedInsert() {
        SLL list = new SLL();
        list.SortedInsert(2);
        assertEquals(2, list.gethead().data);
        assertEquals(list.gethead(), list.gettail());
        list.SortedInsert(1);
        assertEquals(1, list.gethead().data);
        assertEquals(2, list.gettail().data);
        list.SortedInsert(4);
        assertEquals(4, list.gettail().data);
        list.InsertTail(3);
        assertEquals(4, list.getSize());
        list.Print();
        list.SortedInsert(6);
        list.Print();
        assertEquals(6, list.gettail().data);

    }
    
    @Test
    void testSearch() {
        SLL list = new SLL();
        assertEquals(null, list.Search(1));
        list.InsertHead(2);
        list.InsertHead(1);
        list.InsertTail(5);
        assertEquals(3, list.getSize());
        assertEquals(list.gethead().data, list.Search(list.gethead()).data);
        assertEquals(list.gettail().data, list.Search(list.gettail()).data);
        assertEquals(null, list.Search(3));
    }
    
    @Test
    void testDelete() {
        SLL list = new SLL();
        assertEquals(null, list.Delete(0));
        list.InsertHead(2);
        list.InsertHead(1);
        list.InsertTail(3);
        list.InsertTail(4);
        assertEquals(4, list.getSize());
        assertEquals(4, list.Delete(4).data);
        assertEquals(list.gethead(), list.DeleteHead());
        assertEquals(list.gettail(), list.DeleteTail());
        assertEquals(2, list.gethead().data);
        assertEquals(2, list.gettail().data);
    }
    
    @Test
    void testClear() {
        SLL list = new SLL();

        list.InsertHead(1);
        list.InsertHead(2);
        list.InsertHead(3);
        list.sort();
        assertEquals(1, list.gethead().data);
        assertEquals(3, list.gettail().data);
        list.Clear();
        list.Print();
        assertEquals(null, list.gethead());
        assertEquals(null, list.gettail());
        assertEquals(0, list.getSize());
    }
    
}

