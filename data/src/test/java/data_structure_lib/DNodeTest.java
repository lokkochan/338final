package data_structure_lib;
import myLib.dataStructure.nodes.DNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DNodeTest {
    @Test
    public void testConstructorWithData() {
        int data = 5;
        DNode node = new DNode(data);
        assertEquals(data, node.data);
        assertNull(node.next);
        assertNull(node.prev);
    }

    @Test
    public void testConstructorWithDataAndPrevNext() {
        int data1 = 5;
        int data2 = 7;
        DNode node2 = new DNode(data2);
        DNode node1 = new DNode(data1, null, node2);
        assertEquals(data1, node1.data);
        assertNull(node1.prev);
        assertEquals(node2, node1.next);
    }

    @Test
    public void testConstructorWithDataAndNext() {
        int data1 = 5;
        int data2 = 7;
        DNode node2 = new DNode(data2);
        DNode node1 = new DNode(data1, node2);
        assertEquals(data1, node1.data);
        assertNull(node1.prev);
        assertEquals(node2, node1.next);
    }

    @Test
    public void testSetNull() {
        DNode node = new DNode(5);
        node.setNull();
        assertNull(node.prev);
        assertNull(node.next);
    }

}
