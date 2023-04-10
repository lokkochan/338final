package data_structure_lib;
import myLib.dataStructure.linear.CDLL;
import myLib.dataStructure.nodes.DNode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CDLLTest {
    @Test
    void testInsertHead() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertHead(node1);
        assertEquals(1, list.getSize());
        assertEquals(node1, list.gethead());
        assertEquals(node1, list.gettail());
        list.InsertHead(node2);
        assertEquals(2, list.getSize());
        assertEquals(node2, list.gethead());
        assertEquals(node1, list.gettail());
        list.InsertHead(node3);
        assertEquals(3, list.getSize());
        assertEquals(node3, list.gethead());
        assertEquals(node1, list.gettail());
        assertEquals(node2.next, node1);
        assertEquals(node1.prev, node2);
    }
    @Test
    void testDeleteHead() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertHead(node1);
        list.InsertHead(node2);
        list.InsertHead(node3);
        assertEquals(node3, list.DeleteHead());
        assertEquals(2, list.getSize());
        assertEquals(node2, list.gethead());
        assertEquals(node1, list.gettail());
        assertEquals(node2.next, node1);
        assertEquals(node1.prev, node2);
        assertEquals(node1.next, node2);
        assertEquals(node2.prev, node1);
    }

    @Test
    void testSort() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(3);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(1);
        list.InsertHead(node3);
        list.InsertHead(node2);
        list.InsertHead(node1);
        assertEquals(node1, list.gethead());
        assertEquals(node3, list.gettail());
        list.Print();
        list.sort();
        list.Print();
        assertEquals(node3.data, list.gethead().data);
        assertEquals(node1.data, list.gettail().data);
        assertEquals(node1.prev.data, node2.data);
    }

}
