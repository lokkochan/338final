package myLib.dataStructures.nodes;

public class DNode {
    public int data;
    public DNode prev;
    public DNode next;
    public DNode(int data){
        this.data=data;
        
    }
    public int getData(){
        return data;
    }
    public DNode getNext(){
        return next;
    }
    public DNode getPrev(){
        return prev;
    }




    
}
