package mylib.datastructures.linear.LinkedLists;

import mylib.datastructures.nodes.Snode;

public class CSLL extends SLL{
    public CSLL(){
        super();

    }
    public CSLL(Snode data){
        super(data);
        super.head.next=super.head;
    }
    @Override
    public void InsertTail(Snode node){
        if(super.head==null){
            super.head=node;
            node.next=node;}
        else{
        Snode temp =super.head;
        while(temp.next!=super.head){
            temp=temp.next;
        }
        temp.next=node;
        node.next=super.head;}
        super.size++;
    }
    @Override
    public void InsertHead(Snode node){
        Snode temp =super.head;
        while(temp.next!=super.head){
            temp=temp.next;
        }
        temp.next=node;
        node.next=super.head;
        super.head=node;
        super.size++;
    }

    @Override
    public void Insert(Snode node,int index){
        if(index<0 || index>super.size){
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
        Snode temp =super.head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        super.size++;


        
    }

    @Override
    public void DeleteHead(){
        Snode temp =super.head;
        while(temp.next!=super.head){
            temp=temp.next;
        }
        temp.next=super.head.next;
        super.head=super.head.next;
        super.size--;
    }

    @Override
    public void DeleteTail(){
        Snode temp =super.head;
        while(temp.next.next!=super.head){
            temp=temp.next;
        }
        temp.next=super.head;
        super.size--;
    }

    @Override
    public boolean isSorted(){
        Snode temp =super.head;
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
        Snode temp =super.head;
        while(temp.next!=super.head){
            Snode temp2 =temp.next;
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
    public void Delete(Snode node){
        if(Search(node)==null){
            throw new NullPointerException();
        }
        Snode temp =super.head;
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
        Snode slow = head;
        Snode fast = head;
    
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
    public Snode Search(Snode node){
        Snode temp =super.head;
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
        Snode temp =super.head;
        System.out.println("Sorted status:"+isSorted());
        System.out.println("List content:   ");
        while(temp.next!=super.head){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.println(temp.data);
        System.out.println("--------------------");
    }
    public static void main (String[] args){
        CSLL list =new CSLL();
        list.InsertTail(new Snode(1));
        list.InsertTail(new Snode(2));
        list.InsertTail(new Snode(4));
        list.InsertTail(new Snode(3));
        list.Print();
        list.InsertHead(new Snode(0));
        list.Print();
        list.Sort();
        list.Print();
        System.out.println("isCircular: "+list.isCircular());

        System.out.println("Delete Head");
        list.DeleteHead();
        list.Print();

        System.out.println("Delete Tail");
        list.DeleteTail();
        list.Print();
        Snode nodeWantToBeDeleted=new Snode(5);
        list.Insert(nodeWantToBeDeleted, 1);
        list.Print();

        
        System.out.println("Search node: "+nodeWantToBeDeleted.data);
        System.out.println("Found node: "+list.Search(nodeWantToBeDeleted).data);



        System.out.println("Delete node: "+nodeWantToBeDeleted.data);
        list.Delete(nodeWantToBeDeleted);
        list.Print();
        System.out.println("is it circular?: "+list.isCircular());//check if it is circular

        System.out.println("List clear");
        list.Clear();
        list.Print();





    }


    
}
