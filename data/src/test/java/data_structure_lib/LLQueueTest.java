package data_structure_lib;
import myLib.dataStructures.linear.Queue;
import myLib.dataStructures.nodes.SNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LLQueueTest {
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

