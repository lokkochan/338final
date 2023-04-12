package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.SNode;

public class CSLL extends SLL{
    public CSLL(){
        super();

    }
    public CSLL(SNode data){
        super(data);
        super.head.next=super.head;
    }
    public int size(){
        return super.size;
    }
    @Override
    public void InsertTail(SNode node){
        if(super.head==null){
            super.head=node;
            node.next=node;}
        else{
        SNode temp =super.head;
        while(temp.next!=super.head){
            temp=temp.next;
        }
        temp.next=node;
        node.next=super.head;}
        super.size++;
    }
    @Override
    public void InsertHead(SNode node){
        if(super.head==null){
            super.head=node;
            node.next=node;
            super.size++;
        }
        else{
        SNode temp =super.head;
        while(temp.next!=super.head){
            temp=temp.next;
        }
        temp.next=node;
        node.next=super.head;
        super.head=node;
        super.size++;}
    }

    @Override
    public void Insert(SNode node,int index){
        if(index<0 || index>this.getsize()){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            InsertHead(node);
            return;
        }
        if(index==super.size){
            InsertTail(node);
            return;
        }
        SNode temp =super.head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        super.size++;


        
    }

    @Override
    public void DeleteHead(){
        SNode temp =super.head;
        while(temp.next!=super.head){
            temp=temp.next;
        }
        temp.next=super.head.next;
        super.head=super.head.next;
        super.size--;
    }

    @Override
    public void DeleteTail(){
        SNode temp =super.head;
        while(temp.next.next!=super.head){
            temp=temp.next;
        }
        temp.next=super.head;
        super.size--;
    }

    @Override
    public boolean isSorted(){
        SNode temp =super.head;
        while(temp.next!=super.head){
            if(temp.data>temp.next.data){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }

    @Override
    public void Sort(){
        SNode temp =super.head;
        while(temp.next!=super.head){
            SNode temp2 =temp.next;
            while(temp2!=super.head){
                if(temp.data>temp2.data){
                    int temp3 =temp.data;
                    temp.data=temp2.data;
                    temp2.data=temp3;
                }
                temp2=temp2.next;
            }
            temp=temp.next;
        }
    }

    @Override
    public void Delete(SNode node){
        if(Search(node)==null){
            throw new NullPointerException();
        }
        SNode temp =super.head;
        while(temp.next!=super.head){
            if(temp.next.data==node.data){
                temp.next=temp.next.next;
                super.size--;
                return;
            }
            temp=temp.next;
        }
    }
    
    
    public boolean isCircular() {
        SNode slow = head;
        SNode fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // found a cycle
            }
        }
        return false; // no cycle found
    }

    @Override
    public void Clear(){
        super.head=null;
        super.tail=null;
        super.size=0;
    }

    @Override 
    public SNode Search(SNode node){
        SNode temp =super.head;
        while(temp.next!=super.head){
            if(temp.data==node.data){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }


    @Override
    public void Print(){
        if(super.head==null){
            System.out.println("List is empty");
            return;
        }
        System.out.println("List Length: "+super.size);
        SNode temp =super.head;
        System.out.println("Sorted status:"+isSorted());
        System.out.println("List content:   ");
        while(temp.next!=super.head){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.println(temp.data);
        System.out.println("--------------------");
    }
    
}
