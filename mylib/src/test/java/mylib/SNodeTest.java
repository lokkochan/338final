package mylib;

import org.junit.Test;
import static org.junit.Assert.*;
import mylib.dataStructures.nodes.SNode;

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
