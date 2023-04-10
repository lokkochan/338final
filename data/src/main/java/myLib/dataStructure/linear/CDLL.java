package myLib.dataStructure.linear;
import myLib.dataStructure.nodes.DNode;
public class CDLL extends DLL{
    public CDLL(){
        super();
    }
    public CDLL(DNode node){
        super(node);
    }

    @Override
    public void InsertHead(DNode node){
        super.InsertHead(node);
        if (this.size != 1){
            this.tail.next = this.head;  
            this.head.prev = this.tail;  
        }    
    }
    @Override
    public void InsertTail(DNode node){
        super.InsertTail(node);
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }

    //Deletion from head
    @Override
    public DNode DeleteHead(){
        DNode temp = super.DeleteHead();
        this.tail.next = this.head;
        this.head.prev = this.tail;
        return temp;
    }

    //Deletion from tail
    @Override
    public DNode DeleteTail(){
        DNode temp = super.DeleteTail();
        this.tail.next = this.head;
        this.head.prev = this.tail;
        return temp;
    }

    @Override
    public void sort(){
        super.sort();
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }
    @Override
    public void Print(){
        String print="";
        print+="List length: "+this.size+"\n";
        print+="List sorted: "+this.isSorted()+"\n";
        print+="List: ";
        for (DNode temp = this.head; temp != this.tail; temp = temp.next) {
            print+=temp.data+", ";
        }
        print+=this.tail.data;
        System.out.println(print);
    }
}
