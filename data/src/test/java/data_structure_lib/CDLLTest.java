
package data_structure_lib;

import myLib.dataStructures.linear.CDLL;
import myLib.dataStructures.nodes.DNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for CDLL.
 */
public class CDLLTest {
    @Test
    public void testIsEmpty() {
        CDLL list = new CDLL();
        assertTrue(list.isEmpty());

        list.InsertTail(new DNode(1));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testInsertTail() {
        CDLL list = new CDLL();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        assertEquals(3, list.getSize());
    }

    @Test
    public void testInsertHead() {
        CDLL list = new CDLL();
        list.InsertHead(new DNode(1));
        list.InsertHead(new DNode(2));
        list.InsertHead(new DNode(3));
        assertEquals(3, list.getSize());
    }

    @Test void testInsert() {
        CDLL list = new CDLL();
        list.Insert(new DNode(1), 0);
        list.Insert(new DNode(2), 1);
        list.Insert(new DNode(3), 1);
        assertEquals(3, list.getSize());
    }

    @Test
    public void testInsertInvalidPosition() {
        CDLL list = new CDLL();
        try{
            list.Insert(new DNode(1), 1);
        } catch (IndexOutOfBoundsException e) {
            return;
            
        }
    }

    @Test
    public void testDeleteHead() {
        CDLL list = new CDLL();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        list.DeleteHead();
        assertEquals(2, list.getSize());
    }

    @Test

    public void testDeleteTail() {
        CDLL list = new CDLL();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        list.DeleteTail();
        assertEquals(2, list.getSize());
    }

    @Test
    public void testDeleteInvalidPosition() {
        CDLL list = new CDLL();
        DNode delete = new DNode(1);
        try{
            list.Delete(delete);
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    @Test
    public void testDelete() {
        CDLL list = new CDLL();
        DNode delete = new DNode(1);
        list.InsertTail(delete);
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        list.Delete(delete);
        assertEquals(2, list.getSize());
    }

    @Test
    public void testDeleteHeadEmptyList() {
        CDLL list = new CDLL();
        try{
            list.DeleteHead();
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    @Test
    public void testDeleteTailEmptyList() {
        CDLL list = new CDLL();
        try{
            list.DeleteTail();
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    @Test
    public void search() {
        CDLL list = new CDLL();
        DNode search = new DNode(1);
        list.InsertTail(search);
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        assertEquals(search, list.Search(search));
    }

    @Test 
    public void testSearchEmptyList() {
        CDLL list = new CDLL();
        DNode search2 = new DNode(1);
        assertEquals(null, list.Search(search2));
    }

    @Test
    public void isCircular() {
        CDLL list = new CDLL();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        assertEquals(true, list.isCircular());
    }

    @Test
    public void isDoublyLinkedList() {
        CDLL list = new CDLL();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        assertEquals(true, list.isDoublyLinkedList());
    }
}