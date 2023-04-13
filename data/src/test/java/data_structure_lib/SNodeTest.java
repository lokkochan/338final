package data_structure_lib;
import myLib.dataStructures.nodes.SNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
/**
 * Unit test for SNode.
 */
public class SNodeTest {

    @Test
    public void testGetNext() {
        SNode node = new SNode(1);
        assertNull(node.getNext());
    }

    @Test
    public void testGetData() {
        SNode node = new SNode(1);
        assertEquals(1, node.getData());
    }

}
