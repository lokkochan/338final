package myLib.dataStructure.nodes;

public class DNode{
    public int data;
    public DNode next;
    public DNode prev;

    public DNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DNode(int data, DNode prev, DNode next){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DNode(int data, DNode next){
        this.data = data;
        this.next = next;
        this.prev = null;
    }

    public void setNull(){
        this.next = null;
        this.prev = null;
    }
}