package myLib.dataStructure.nodes;

public class SNode{
    public int data;
    public SNode next;

    public SNode(int data){
        this.data = data;
        this.next = null;
    }

    public SNode(int data, SNode next){
        this.data = data;
        this.next = next;
    }

    public void setNull(){
        this.next = null;
    }
    
}