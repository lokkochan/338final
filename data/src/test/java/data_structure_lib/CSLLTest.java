package data_structure_lib;

import myLib.dataStructure.linear.CSLL;
import myLib.dataStructure.nodes.SNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSLLTest {
    
    @Test
    void testInsertHead() {
        SNode node1 = new SNode(1);
        CSLL list = new CSLL(node1);
        SNode node2 = new SNode(2);
        list.InsertHead(node2);
        assertEquals(list.gethead(), node2);
        assertEquals(list.gettail().next, node2);
    }
    
    @Test
    void testInsertTail() {
        SNode node1 = new SNode(1);
        CSLL list = new CSLL(node1);
        SNode node2 = new SNode(2);
        list.InsertTail(node2);
        assertEquals(list.gettail(), node2);
    }
    
    @Test
    void testDeleteHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        CSLL list = new CSLL(node1);
        list.InsertTail(node2);
        SNode deletedNode = list.DeleteHead();
        assertEquals(deletedNode, node1);
        assertEquals(list.gethead(), node2);
    }
    
    @Test
    void testDeleteTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        CSLL list = new CSLL(node1);
        list.InsertTail(node2);
        SNode deletedNode = list.DeleteTail();
        assertEquals(deletedNode, node2);
        assertEquals(list.gettail(), node1);
    }
    
    @Test
    void testSort() {
        SNode node1 = new SNode(4);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(1);
        CSLL list = new CSLL(node1);
        list.InsertHead(node2);
        list.InsertHead(node3);
        list.Print();
        list.SortedInsert(node4);
        list.Print();
        assertEquals(list.gethead().data, node4.data);
        assertEquals(list.gettail().data, node1.data);
    }
}
