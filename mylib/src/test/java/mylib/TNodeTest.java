package mylib;

import org.junit.Test;
import static org.junit.Assert.*;

import mylib.dataStructures.nodes.TNode;

public class TNodeTest {
    
    @Test
    public void testGetData() {
        // Arrange
        TNode node = new TNode(10);
        
        // Act
        int data = node.getData();
        
        // Assert
        assertEquals(data, 10);
    }
    
    @Test
    public void testSetData() {
        // Arrange
        TNode node = new TNode(10);
        
        // Act
        node.setData(15);
        
        // Assert
        assertEquals(node.getData(), 15);
    }
    
    @Test
    public void testSetLeft() {
        // Arrange
        TNode node = new TNode(10);
        TNode left = new TNode(5);
        
        // Act
        node.setLeft(left);
        
        // Assert
        assertEquals(node.getLeft(), left);
    }
    
    @Test
    public void testSetRight() {
        // Arrange
        TNode node = new TNode(10);
        TNode right = new TNode(15);
        
        // Act
        node.setRight(right);
        
        // Assert
        assertEquals(node.getRight(), right);
    }
    
    @Test
    public void testSetParent() {
        // Arrange
        TNode node = new TNode(10);
        TNode parent = new TNode(20);
        
        // Act
        node.setParent(parent);
        
        // Assert
        assertEquals(node.getParent(), parent);
    }
    
    @Test
    public void testSetBalance() {
        // Arrange
        TNode node = new TNode(10);
        
        // Act
        node.setBalance(2);
        
        // Assert
        assertEquals(node.getBalance(), 2);
    }
    
    @Test
    public void testGetHeight() {
        // Arrange
        TNode node = new TNode(10);
        node.setHeight(3);
        
        // Assert
        assertEquals(node.getHeight(), 3);
    }
    
    @Test
    public void testToString() {
        // Arrange
        TNode node = new TNode(10);
        
        // Assert
        assertEquals(node.toString(), " 10");
    }
    
    @Test
    public void testPrint() {
        // Arrange
        TNode node = new TNode(10);
        node.setLeft(new TNode(5));
        node.setRight(new TNode(15));
        node.setParent(new TNode(20));
        node.setBalance(2);
        node.setHeight(3);
        
        // Act
        node.print();
    }
}

