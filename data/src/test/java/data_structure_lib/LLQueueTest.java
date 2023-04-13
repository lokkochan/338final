package data_structure_lib;
import myLib.dataStructures.linear.Queue;
import myLib.dataStructures.nodes.SNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for Queue.
 */

public class LLQueueTest {
    @Test
    public void testIsEmpty() {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());
        queue.enqueue(new SNode(1));
        assertFalse(queue.isEmpty());
    }
    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        queue.enqueue(new SNode(1));
        queue.enqueue(new SNode(2));
        queue.enqueue(new SNode(3));
        assertEquals(3, queue.getLength());
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        queue.enqueue(new SNode(1));
        queue.enqueue(new SNode(2));
        queue.enqueue(new SNode(3));
        queue.dequeue();
        assertEquals(2, queue.getLength());
    }

    

}

