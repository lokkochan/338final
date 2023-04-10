package myLib.dataStructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;
    private int height;

    public TNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }
    public TNode(int data, TNode left, TNode right, TNode parent, int balance){
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.balance = balance;
    }

    public int getData(){return this.data;}
    public TNode getLeft(){return this.left;}
    public TNode getRight(){return this.right;}
    public TNode getParent(){return this.parent;}
    public int getBalance(){return this.balance;}
    public int getHeight(){return this.height;}

    public void setData(int data){this.data = data;}
    public void setLeft(TNode left){this.left = left;}
    public void setRight(TNode right){this.right = right;}
    public void setParent(TNode parent){this.parent = parent;}
    public void setBalance(int balance){this.balance = balance;}
    public void setHeight(int height){this.height = height;}
    
    public void print(){
        System.out.println("Data: " + this.data);
        System.out.println("Balance: " + this.balance);
        System.out.println("Left: " + this.left);
        System.out.println("Right: " + this.right);
        System.out.println("Parent: " + this.parent);
        System.out.println("Height: " + this.height);
    }

    public String toString(){
        return " "+this.data;
    }
}
