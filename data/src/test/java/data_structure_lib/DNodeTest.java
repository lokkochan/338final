package data_structure_lib;
import myLib.dataStructures.nodes.DNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DNodeTest {
    @Test
    public void testGetNext() {
        DNode node = new DNode(1);
        assertNull(node.getNext());
    }

    @Test
    public void testGetPrev() {
        DNode node = new DNode(1);
        assertNull(node.getPrev());
    }

    @Test
    public void testGetData() {
        DNode node = new DNode(1);
        assertEquals(1, node.getData());
    }


}
