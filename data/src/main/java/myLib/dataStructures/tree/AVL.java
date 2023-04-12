package myLib.dataStructures.tree;
import myLib.dataStructures.nodes.TNode;

public class AVL extends BST {
    public AVL(){super();}
    public AVL(int data){super(data);}

    public AVL(TNode node){// iterate the insert node from original BST and balance the new AVL tree created
        super(node);
        adjustBalance(node);
        if (node.getLeft() != null || node.getRight() != null){
            this.root = fullTreeBalance(this.root);
        }
        adjustBalance(node);
    }

    private TNode fullTreeBalance(TNode node){
        if(node==null){
            return null;
        }
        else{
            AVL balance = new AVL(node.getData());
            TNode left=node.getLeft();
            TNode right=node.getRight();
            if(left!=null){
                balance.Insert(fullTreeBalance(left));
            }
            if(right!=null){
                balance.Insert(fullTreeBalance(right));
            }
            return balance.getRoot();
        }
    }

    @Override
    public void setRoot(TNode node){
        super.setRoot(node);
        adjustBalance(this.root);
        this.root = fullTreeBalance(this.root);
        adjustBalance(this.root);
    }

    public int height(TNode node){
        if(node==null){return 0;}
        else{return node.getHeight();}
    }

    public TNode rotateRight(TNode node){
        TNode left=node.getLeft();
        TNode centre=(left!=null)?left.getRight():null;
        TNode parent=node.getParent();
        left.setRight(node);
        node.setLeft(centre);
        left.setParent(parent);
        if (parent != null){
            if (parent.getLeft() == node){
                parent.setLeft(left);
            }
            else{
                parent.setRight(left);
            }
        }else if (this.root == node){
            this.root = left;
        }
        node.setParent(left);
        if (centre != null){centre.setParent(node);}
        adjustHeight(left.getRight());
        return left;
    }
    public TNode rotateLeft(TNode node){
        TNode right=node.getRight();
        TNode centre=(right!=null)?right.getLeft():null;
        TNode parent=node.getParent();
        right.setLeft(node);
        node.setRight(centre);
        right.setParent(parent);
        if (parent != null){
            if (parent.getLeft() == node){
                parent.setLeft(right);
            }
            else{
                parent.setRight(right);
            }
        }else if (this.root == node){
            this.root = right;
        }
        node.setParent(right);
        if (centre != null){centre.setParent(node);}
        adjustHeight(right.getLeft());
        return right;
    }
    public int getBalance(TNode node){
        if(node==null){
            return 0;
        }
        else{
            return node.getBalance();
        }
    }
    @Override
    public void Insert(TNode node){
        super.Insert(node);
        adjustBalance(this.root);
        TNode i;
        for(i=node;(i!=null && Math.abs(i.getBalance())<=1);i=i.getParent()){}
        if(i!=null){
            i=doRotate(i);
        }
        adjustBalance(this.root);
    }
    @Override
    public void Delete(int item){
        super.Delete(item);
        adjustBalance(this.root);
    }

    public TNode doRotate(TNode node){
        int balance=node.getBalance();
        if(balance>1){
            if(node.getLeft().getBalance()<0){
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        else if(balance<-1){

            if (node.getRight().getBalance()>0){
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }
    private void adjustBalance(TNode node){
        if (node == null) {
            return;
        }
        TNode left=node.getLeft();
        TNode right=node.getRight();
        adjustBalance(left);
        adjustBalance(right);
        node.setBalance((!(left==null)? left.getHeight():0)-(!(right==null)? right.getHeight():0));
    }
}

