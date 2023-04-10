package myLib.dataStructure.linear;

import myLib.dataStructure.nodes.SNode;


public class CSLL extends SLL{
    public CSLL(){
        super();
    }
    public CSLL(SNode node){
        super(node);
    }
    @Override
    public void InsertHead(SNode node){
        super.InsertHead(node);
        if (this.size >= 1){
            this.tail.next = this.head;    
        }    
    }  

    @Override
    public void InsertTail(SNode node){
        super.InsertTail(node);
        this.tail.next = this.head;
    }

    //Deletion from head
    @Override
    public SNode DeleteHead(){
        SNode temp = super.DeleteHead();
        try{
            this.tail.next = this.head;
        }catch(Exception e){
            this.tail = null;
        }
        return temp;
    }

    //Deletion from tail
    @Override
    public SNode DeleteTail(){
        SNode temp = super.DeleteTail();
        this.tail.next = this.head;
        return temp;
    }

    @Override
    public void sort(){
        super.sort();
        this.tail.next = this.head;
    }
    @Override
    public void Print(){
        String print="";
        print+="List length: "+this.size+"\n";
        print+="List sorted: "+this.isSorted()+"\n";
        print+="List: ";
        for (SNode temp = this.head; temp != this.tail; temp = temp.next) {
            print+=temp.data+", ";
        }
        print+=this.tail.data;
        System.out.println(print);
    }
}
