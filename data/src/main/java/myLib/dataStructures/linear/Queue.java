package myLib.datastructures.linear;

import myLib.datastructures.linear.LinkedLists.SLL;
import myLib.datastructures.nodes.Snode;

public class Queue extends SLL {
    public Queue() {
        super();
    }

    public void enqueue(Snode data) {
        super.InsertTail(data);
    }

    public void dequeue() {
        super.DeleteHead();
    }
    @Override
    public void InsertHead(Snode insertHeadNode) {
        System.out.println("Queue is a FIFO data structure. InsertHead is not allowed");
    }
    @Override 
    public void Insert(Snode insertNode, int position) {
        System.out.println("Queue is a FIFO data structure. Insert is not allowed");
    }
    @Override
    public void SortedInsert(Snode insertNode){
        System.out.println("Queue is a FIFO data structure. SortedInsert is not allowed");
    }
    @Override
    public void DeleteTail() {
        System.out.println("Queue is a FIFO data structure. DeleteTail is not allowed");
    }
    @Override
    public void Delete(Snode position) {
        System.out.println("Queue is a FIFO data structure. Delete is not allowed");
    }
    @Override
    public void Sort(){
        System.out.println("Queue is a FIFO data structure. Sort is not allowed");
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(new Snode(1));
        queue.enqueue(new Snode(2));
        queue.enqueue(new Snode(3));
        queue.enqueue(new Snode(4));
        queue.enqueue(new Snode(5));
        queue.enqueue(new Snode(6));
        queue.enqueue(new Snode(7));
        queue.enqueue(new Snode(8));
        queue.enqueue(new Snode(9));
        queue.enqueue(new Snode(10));
        queue.dequeue();
        queue.enqueue(new Snode(1000));
        queue.enqueue(new Snode(999));
        queue.Print();

        
    }
    
}
