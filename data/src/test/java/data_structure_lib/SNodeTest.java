package data_structure_lib;
import myLib.dataStructure.nodes.SNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SNodeTest {

    @Test
    public void testConstructorWithData() {
        int data = 5;
        SNode node = new SNode(data);
        assertEquals(data, node.data);
        assertNull(node.next);
    }

    @Test
    public void testConstructorWithDataAndNext() {
        int data1 = 5;
        int data2 = 7;
        SNode node2 = new SNode(data2);
        SNode node1 = new SNode(data1, node2);
        assertEquals(data1, node1.data);
        assertEquals(node2, node1.next);
    }
}
