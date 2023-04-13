package mylib;

import org.junit.Test;
import static org.junit.Assert.*;
import mylib.dataStructures.linear.Queue;
import mylib.dataStructures.nodes.SNode;


public class LLQueueTest {
    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());
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

