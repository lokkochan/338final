package myLib.dataStructures.linear.LinkedLists;

import java.rmi.StubNotFoundException;

import myLib.dataStructures.nodes.SNode;

public class SLL {
    //implement the singly linked list
    protected SNode head ;
    protected SNode tail;
    protected int size;
    public SNode gethead(){
        return head;
    }
    public SNode gettail(){
        return tail;
        
    }
    public int getsize(){
        return size;
    }
    public SLL(){
        head = null;
        tail = null;
        size = 0;
    }
    public SLL(SNode head){
        this.head = head;
        tail = head;
        size = 1;
    }
    public void InsertHead(SNode insertHeadNode){
        if(head == null){
            head = insertHeadNode;
            tail = insertHeadNode;
        }else{
            insertHeadNode.next = head;
            head = insertHeadNode;
        }
        size++;
        
    }
    public void InsertTail(SNode insertTailNode){
        if(head == null){
            head = insertTailNode;
            tail = insertTailNode;
        }else{
            tail.next = insertTailNode;
            tail = insertTailNode;
        }
        size++;
    }
    public void Insert(SNode insertNode, int index){
        if(head == null && index != 0){
            throw new IllegalArgumentException("List is empty");
        }
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index == 0){
            InsertHead(insertNode);
        }else if(index == size){
            InsertTail(insertNode);
        }else{
            SNode temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            insertNode.next = temp.next;
            temp.next = insertNode;
            size++;
        }
    }
    public void SortedInsert(SNode insertNode){
        if(!isSorted()){
            Sort();
        }
        if(head == null){
            head = insertNode;
            tail = insertNode;
        }else if(head.data > insertNode.data){
            insertNode.next = head;
            head = insertNode;
        }else{
            SNode temp = head;
            while(temp.next != null && temp.next.data < insertNode.data){
                temp = temp.next;
            }
            insertNode.next = temp.next;
            temp.next = insertNode;
        }
        size++;
    }
    public boolean isSorted(){
        if(head == null){
            return true;
        }
        SNode temp = head;
        while(temp.next != null){
            if(temp.data > temp.next.data){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
    public SNode Search(SNode searchNode){
        SNode temp = head;
        while(temp != null){
            if(temp.data == searchNode.data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void DeleteHead(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        size--;
    }
    public void DeleteTail(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        SNode temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }
    public void Delete(SNode node){
        if(Search(node)==null){
            throw new IllegalArgumentException();
        }
        if(Search(node)==null){
            throw new IllegalArgumentException();
        }
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        if(head == node){
            DeleteHead();
        }else if(tail == node){
            DeleteTail();
        }else{
            SNode temp = head;
            while(temp.next != node){
                temp = temp.next;
            }
            temp.next = node.next;
            size--;
        }

    }
    public void Sort(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        SNode temp = head;
        while(temp.next != null){
            SNode temp2 = temp.next;
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
    public void Clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public void Print(){
        System.out.println("List length: "+ size);
        System.out.println("Sorted status: "+ isSorted());
        System.out.println("List contents:");
        SNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }


    }
    public static void main(String[] args) {
        SLL list = new SLL();
        list.InsertHead(new SNode(1));//Test insert head
        list.InsertHead(new SNode(2));
        list.InsertHead(new SNode(3));
        list.InsertTail(new SNode(4));
        SNode node = new SNode(5);
        list.Insert(node, 2);   //Test inset at index
        list.Delete(node);    //Test delete node
        list.Print();           //Test print
        list.Sort();            //Test sort-th list will be sorted after this
        System.out.println("After sorted");
        list.Print();
        list.SortedInsert(new SNode(8));    //Test sorted insert
        list.SortedInsert(new SNode(7));        //Test sorted insert
        list.Print();

        System.out.println("---------------------");
        SLL list2 = new SLL();
        list2.InsertTail(new SNode(10)); //Test insert tail
        list2.InsertTail(new SNode(9));
        list2.InsertHead(new SNode(8));
        list2.InsertHead(new SNode(2));
        SNode nodeDelete = new SNode(5);
        list2.Insert(nodeDelete, 2);    //Test insert at index
        list2.Print();
        list2.Delete(nodeDelete);   //Test delete node
        list2.Print();
        list2.Sort();        //Test sort
        System.out.println("After sorted");
        list2.Print();
        list2.Clear();    //Test clear
        list2.Print();  //the list should be empty


    }
}
