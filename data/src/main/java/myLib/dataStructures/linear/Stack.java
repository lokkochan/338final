package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.SNode;

public class Stack extends SLL {
    public Stack() {
        super();
    }

    public void push(int data) {
        SNode node = new SNode(data);
        super.InsertHead(node);
    }

    public void pop() {
        super.DeleteHead();
    }
    @Override
    public void InsertTail(SNode insertTailNode) {
        System.out.println("Stack is a LIFO data structure. InsertTail is not allowed");
    }
    @Override 
    public void Insert(SNode insertNode, int position) {
        System.out.println("Stack is a LIFO data structure. Insert is not allowed");
    }
    @Override
    public void SortedInsert(SNode insertNode){
        System.out.println("Stack is a LIFO data structure. SortedInsert is not allowed");
    }
    @Override
    public void DeleteTail() {
        System.out.println("Stack is a LIFO data structure. DeleteTail is not allowed");
    }
    @Override
    public void Delete(SNode position) {
        System.out.println("Stack is a LIFO data structure. Delete is not allowed");
    }
    @Override
    public void Sort(){
        System.out.println("Stack is a LIFO data structure. Sort is not allowed");
    }
    public int getLength(){
        if(super.head == null){
            return 0;}
        return super.size;
    }
    @Override
    public void Print(){
        if(super.head == null){
            System.out.println("Stack is empty");
            return;
        }
        SNode current = super.head;
        while(current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
            if(current == super.head){
                break;
            }
        }
        System.out.println();
    }
    
}
