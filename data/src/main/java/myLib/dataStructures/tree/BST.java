package myLib.dataStructures.tree;
import java.util.Queue;

import myLib.dataStructures.nodes.TNode;

public class BST {
    protected TNode root;
    protected int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }
    public BST(int data){
        this.root = new TNode(data);
        this.root.setHeight(1);
        this.size = 1;
    }
    public BST(TNode node){
        this.root = node;
        adjustHeight(this.root);
        //iterate the insert function to get the size
        this.size = 0;
        Queue<TNode> queue = new java.util.LinkedList<TNode>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            TNode current = queue.remove();
            this.size++;
            if (current.getLeft() != null){
                queue.add(current.getLeft());
            }
            if (current.getRight() != null){
                queue.add(current.getRight());
            }
        }
    }

    public boolean isEmpty(){return this.size == 0;}
    public int getSize(){return this.size;}

    public void setRoot(TNode node){
        this.root = node;
        adjustHeight(this.root);
        //iterate the insert function to get the size
        this.size = 0;
        Queue<TNode> queue = new java.util.LinkedList<TNode>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            TNode current = queue.remove();
            this.size++;
            if (current.getLeft() != null){
                queue.add(current.getLeft());
            }
            if (current.getRight() != null){
                queue.add(current.getRight());
            }
        }
    }
    public TNode getRoot(){return this.root;}

    public void Insert(int data){
        TNode node = new TNode(data);
        Insert(node);
    }
    public void Insert(TNode node){
        if (this.isEmpty()){
            this.setRoot(node);
            this.size=1;
            return;
        }
        TNode current = this.root;
        while (true){
            if (node.getData() <= current.getData()){
                if (current.getLeft() == null){
                    current.setLeft(node);
                    node.setParent(current);
                    node.setHeight(1);
                    this.size++;
                    adjustHeight(node);
                    return;
                }
                current = current.getLeft();
            }
            else{
                if (current.getRight() == null){
                    current.setRight(node);
                    node.setParent(current);
                    node.setHeight(1);
                    this.size++;
                    adjustHeight(node);
                    return;
                }
                current = current.getRight();
            }
        }
    }

    public void Delete(int val){
        TNode remove=Search(val);
        if (remove == null){
            return;
        }else if (this.size==1){
            this.root = null;
            this.size = 0;
            return;
        } else if (remove.getLeft()==null&&remove.getRight()==null){
            if (remove.getParent().getLeft()==remove){
                remove.getParent().setLeft(null);
            }else{
                remove.getParent().setRight(null);
            }
            this.size--;
            adjustHeight(remove.getParent());
            return;
        } else if (remove.getLeft()==null){
            adjustHeight(remove.getRight());
            if (remove.getParent().getLeft()==remove){
                remove.getParent().setLeft(remove.getRight());
            }else{
                remove.getParent().setRight(remove.getRight());
            }
            this.size--;
            adjustHeight(remove.getParent());
            return;
        } else if (remove.getRight()==null){
            adjustHeight(remove.getLeft());
            if (remove.getParent().getLeft()==remove){
                remove.getParent().setLeft(remove.getLeft());
            }else{
                remove.getParent().setRight(remove.getLeft());
            }
            this.size--;
            adjustHeight(remove.getParent());
            return;
        } else{
            TNode successor = remove.getRight();
            while (successor.getLeft()!=null){
                successor = successor.getLeft();
            }
            remove.setData(successor.getData());
            if (successor.getParent().getLeft()==successor){
                successor.getParent().setLeft(successor.getRight());
            }else{
                successor.getParent().setRight(successor.getRight());
            }
            this.size--;
            adjustHeight(successor.getParent());
            return;
        }

    }

    public void adjustHeight(TNode currentNode) {
        if (currentNode == null) {
            return;
        }
        while (currentNode != null) {
            int leftHeight = currentNode.getLeft() == null ? 0 : currentNode.getLeft().getHeight();
            int rightHeight = currentNode.getRight() == null ? 0 : currentNode.getRight().getHeight();
            currentNode.setHeight(max(leftHeight, rightHeight) + 1);
            currentNode = currentNode.getParent();
        }
    }   
    

    protected int max(int a, int b){
        return a>b?a:b;
    }

    public TNode Search(int val){
        TNode current = this.root;
        while (current != null){
            if (current.getData() == val){
                return current;
            }
            else if (current.getData() > val){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }
        }
        return null;
    }

    public void printInOrder(){
        printOrder(this.root);
    }
    protected void printOrder(TNode node){
        if (node == null){
            return;
        }
        printOrder(node.getLeft());
        System.out.println(node);
        printOrder(node.getRight());
    }

    public void printBF(){
        Queue<TNode> queue = new java.util.LinkedList<TNode>();
        queue.add(this.root);
        int currentLevel = 1, nextLevel = 0;
        while (!queue.isEmpty()){
            TNode current = queue.remove();
            System.out.print(current.getData() + " ");
            currentLevel--;
            if (current.getLeft() != null){
                queue.add(current.getLeft());
                nextLevel++;
            }
            if (current.getRight() != null){
                queue.add(current.getRight());
                nextLevel++;
            }
            if (currentLevel == 0){
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

}
