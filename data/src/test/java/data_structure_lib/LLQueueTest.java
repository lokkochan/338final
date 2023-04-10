package data_structure_lib;
import myLib.dataStructure.linear.LLQueue;
import myLib.dataStructure.nodes.SNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LLQueueTest {
    @Test
    public void testEmptyQueue() {
        LLQueue q = new LLQueue();

        assertNull(q.DeleteHead());
    }

    @Test
    public void testEnqueueDequeue() {
        LLQueue q = new LLQueue();

        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);

        assertEquals(1, q.DeleteHead().data);
        assertEquals(2, q.DeleteHead().data);
        assertEquals(3, q.DeleteHead().data);
        assertNull(q.DeleteHead());
    }

    @Test
    public void testEnqueueDequeueNodes() {
        LLQueue q = new LLQueue();

        q.Enqueue(new SNode(1));
        q.Enqueue(new SNode(2));
        q.Enqueue(new SNode(3));

        assertEquals(1, q.DeleteHead().data);
        assertEquals(2, q.DeleteHead().data);
        assertEquals(3, q.DeleteHead().data);
        assertNull(q.DeleteHead());
    }
    

}

