package mylib;

import org.junit.Test;
import static org.junit.Assert.*;
import mylib.dataStructures.nodes.DNode;

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
