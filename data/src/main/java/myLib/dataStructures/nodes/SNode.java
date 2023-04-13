package myLib.dataStructures.nodes;

public class SNode {

    public int data;
    public SNode next;
    public SNode(int data){
        this.data=data;
    }
    public SNode getNext(){
        return next;
    }
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data=data;
    }
    public void setNext(SNode next){
        this.next=next;
    }



    
}
