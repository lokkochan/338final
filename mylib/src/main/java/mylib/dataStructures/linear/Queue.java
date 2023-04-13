package mylib.dataStructures.linear;

import mylib.dataStructures.nodes.SNode;

public class Queue extends SLL {
    public Queue() {
        super();
    }

    public void enqueue(SNode data) {
        super.InsertTail(data);
    }

    public void dequeue() {
        super.DeleteHead();
    }
    @Override
    public void InsertHead(SNode insertHeadNode) {
        System.out.println("Queue is a FIFO data structure. InsertHead is not allowed");
    }
    @Override 
    public void Insert(SNode insertNode, int position) {
        System.out.println("Queue is a FIFO data structure. Insert is not allowed");
    }
    @Override
    public void SortedInsert(SNode insertNode){
        System.out.println("Queue is a FIFO data structure. SortedInsert is not allowed");
    }
    @Override
    public void DeleteTail() {
        System.out.println("Queue is a FIFO data structure. DeleteTail is not allowed");
    }
    @Override
    public void Delete(SNode position) {
        System.out.println("Queue is a FIFO data structure. Delete is not allowed");
    }
    @Override
    public void Sort(){
        System.out.println("Queue is a FIFO data structure. Sort is not allowed");
    }
    public int getLength(){
        // int count = 0;
        // SNode current = this.head;
        // while (current != null){
        //     count++;
        //     current = current.getNext();
        // }
        // return count;
        if(super.head == null){
            return 0;}
        return super.size;
    }
    
}
