package data_structure_lib;
import myLib.dataStructures.linear.LinkedLists.Stack;
import myLib.dataStructures.nodes.SNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LLStackTest {
    @Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.getLength());

        stack.push(2);
        assertEquals(2, stack.getLength());

        stack.push(3);
        assertEquals(3, stack.getLength());

        stack.push(4);
        assertEquals(4, stack.getLength());

        stack.push(5);
        assertEquals(5, stack.getLength());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();
        assertEquals(4, stack.getLength());

        stack.pop();
        assertEquals(3, stack.getLength());

        stack.pop();
        assertEquals(2, stack.getLength());

        stack.pop();
        assertEquals(1, stack.getLength());

        stack.pop();
        assertEquals(0, stack.getLength());
    }
 
}
