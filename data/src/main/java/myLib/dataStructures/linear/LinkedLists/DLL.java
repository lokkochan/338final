package myLib.dataStructures.linear.LinkedLists;

import myLib.dataStructures.nodes.DNode;

public class DLL {
    protected DNode head;
    protected DNode tail;
    protected int size;
    public int getSize(){
        return size;
    }
    public DNode getHead(){
        return head;
    }
    public DNode getTail(){
        return tail;
    }
    //Default constructor
    public DLL(){
        this.head=null;
        this.tail=null;
        size=0;
    }
    //Constructor with head node
    public DLL(DNode head){
        this.head=head;
        this.tail=head;
        size=1;
    }
    //Insert at head
    //Check if the head is null
    //If it is null, then the head and tail are the same node
    //If it is not null, then the head is the new node and the next node is the old head
    public void InsertHead(DNode insertHeadNode){
        if(head == null){
            head = insertHeadNode;
            tail = insertHeadNode;
        }else{
            insertHeadNode.next = head;
            head.prev = insertHeadNode;
            head = insertHeadNode;
        }
        this.size++;
    }
    //Insert at tail
    //Check if the head is null
    //If it is null, then the head and tail are the same node
    //If it is not null, then the tail is the new node and the previous node is the old tail
    public void InsertTail(DNode insertTailNode){
        if(head == null){
            head = insertTailNode;
            tail = insertTailNode;
        }else{
            tail.next = insertTailNode;
            insertTailNode.prev = tail;
            tail = insertTailNode;
        }
        this.size++;
    }
    //Insert at index
    public void Insert(DNode insertNode, int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index == 0){
            InsertHead(insertNode);
        }else if(index == size){
            InsertTail(insertNode);
        }else{
            DNode temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            insertNode.next = temp.next;
            temp.next.prev = insertNode;
            temp.next = insertNode;
            insertNode.prev = temp;
            size++;
            
        }
        

    }
    //Insert new node with the data in sorted order
    public void SortedInsert(DNode insertNode){
        if(!isSorted()){
            Sort();
        }
        if(head == null){
            head = insertNode;
            tail = insertNode;

            size++;
        }else if(insertNode.data < head.data){
            InsertHead(insertNode);
        }else if(insertNode.data > tail.data){
            InsertTail(insertNode);
        }else{
            DNode temp = head;
            while(temp.next != null && temp.next.data < insertNode.data){
                temp = temp.next;
            }
            insertNode.next = temp.next;
            temp.next.prev = insertNode;
            temp.next = insertNode;
            insertNode.prev = temp;
            this.size++;
        }
    }
    //Check if the list is sorted
    public boolean isSorted(){
        if(head == null){
            return true;
        }
        DNode temp = head;
        while(temp.next != null){
            if(temp.data > temp.next.data){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
    //Search for a node
    //Return the node if found
    //Return null if not found
    public DNode Search(DNode searchNode){
        if(head == null){
            return null;
        }
        DNode temp = head;
        while(temp != null){
            if(temp.data == searchNode.data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //Delete head
    public void DeleteHead(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    //Delete tail
    public void DeleteTail(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    //Sort the list
    public void Sort(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        if(head == tail){
            return;
        }
        DNode temp = head;
        while(temp != null){
            DNode temp2 = temp.next;
            while(temp2 != null){
                if(temp.data > temp2.data){
                    int tempData = temp.data;
                    temp.data = temp2.data;
                    temp2.data = tempData;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
    }
    //Delete a randome node-must assign the node first before pass in the parameter

    public void Delete(DNode deleteNode){
        if(Search(deleteNode) == null){
            throw new IllegalStateException("Node not found");
        }
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
        }else if(head.data == deleteNode.data){
            DeleteHead();
        }else if(tail.data == deleteNode.data){
            DeleteTail();
        }else{
            DNode temp = head;
            while(temp.next != null){
                if(temp.next.data == deleteNode.data){
                    temp.next = temp.next.next;
                    temp.next.prev = temp;
                    size--;
                    return;
                }
                temp = temp.next;
            }
        }
    }
    public void Clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public void Print(){
        System.out.println("List length: " + size);
        System.out.println("Stored status:"+isSorted());
        System.out.println("List contents:");
        DNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    //Bonus:Check if the list is doubly linked
    public boolean isDoublyLinkedList(){
        if(head == null){
            return true;
        }
        DNode temp = head;
        //Because the double linked list have two pointers next and prev 
        //So if next.prev != temp then the list is not doubly linked
        while(temp.next != null){
            if(temp.next.prev != temp){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        DLL list =new DLL();
        list.InsertHead(new DNode(1));
        list.InsertHead(new DNode(2));
        list.InsertTail(new DNode(9));
        list.Insert(new DNode(5), 2);
        list.Print();
        list.DeleteHead();
        list.Print();
        list.DeleteTail();
        list.Print();
        list.Insert(new DNode(100), 1);
        list.InsertTail(new DNode(101));
        list.Print();
        // list.Delete(new Dnode(102));//Throw exception
        System.out.println("List is doubly linked list: " + list.isDoublyLinkedList());
    }








    
}
