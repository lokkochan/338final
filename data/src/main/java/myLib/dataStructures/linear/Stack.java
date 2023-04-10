package myLib.datastructures.linear;

import myLib.datastructures.linear.LinkedLists.SLL;
import myLib.datastructures.nodes.Snode;

public class Stack extends SLL {
    public Stack() {
        super();
    }

    public void push(int data) {
        Snode node = new Snode(data);
        super.InsertHead(node);
    }

    public void pop() {
        super.DeleteHead();
    }
    @Override
    public void InsertTail(Snode insertTailNode) {
        System.out.println("Stack is a LIFO data structure. InsertTail is not allowed");
    }
    @Override 
    public void Insert(Snode insertNode, int position) {
        System.out.println("Stack is a LIFO data structure. Insert is not allowed");
    }
    @Override
    public void SortedInsert(Snode insertNode){
        System.out.println("Stack is a LIFO data structure. SortedInsert is not allowed");
    }
    @Override
    public void DeleteTail() {
        System.out.println("Stack is a LIFO data structure. DeleteTail is not allowed");
    }
    @Override
    public void Delete(Snode position) {
        System.out.println("Stack is a LIFO data structure. Delete is not allowed");
    }
    @Override
    public void Sort(){
        System.out.println("Stack is a LIFO data structure. Sort is not allowed");
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.pop();
        stack.push(1000);
        stack.push(999);
        stack.Print();

        
    }

    
}
