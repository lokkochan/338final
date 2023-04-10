package data_structure_lib;
import myLib.dataStructure.linear.LLStack;
import myLib.dataStructure.nodes.SNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LLStackTest {

    @Test
    void testPushAndPop() {
        LLStack stack = new LLStack();

        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        
        stack.push(node1);
        stack.push(node2);
        stack.push(node3);
        
        assertEquals(node3, stack.pop());
        assertEquals(node2, stack.pop());
        assertEquals(node1, stack.pop());
    }
    
    @Test
    void testPeek() {
        LLStack stack = new LLStack();
        
        SNode node = new SNode(1);
        stack.push(node);
        
        assertEquals(node, stack.peek());
    }
    
    @Test
    void testSearchReturnsNode() {
        LLStack stack = new LLStack();
        
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        
        stack.push(node1);
        stack.push(node2);
        stack.push(node3);
        
        assertEquals(node2, stack.Search(node2));
    }
    
    @Test
    void testSearchReturnsNull() {
        LLStack stack = new LLStack();
        
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        
        stack.push(node1);
        stack.push(node2);
        
        assertNull(stack.Search(node3));
    }

    @Test
    void testInheritedMethodsInhibited() {
        LLStack stack = new LLStack();
        
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        
        stack.push(node1);
        stack.push(node2);
        stack.push(node3);
        
        try{
            stack.InsertTail(node1);
        } catch (IllegalArgumentException e){
            assertEquals("InsertTail is not allowed in a stack", e.getMessage());
        }
    }


}
