package myLib.dataStructures.linear.LinkedLists;

import myLib.dataStructures.nodes.DNode;

public class CDLL extends DLL {
    public CDLL() {
        super.head = null;
        super.tail = null;
        super.size = 0;
    }
    @Override 
    public int getSize(){
        return super.size;
    }
    @Override
    public DNode getHead(){
        return super.head;
    }
    public DNode getTail(){
        return super.tail;
    }

    public CDLL(DNode data) {
        super(data);
        super.head.next = super.head;
        super.head.prev = super.head;

    }

    @Override
    public void InsertHead(DNode node) {
        if (super.head == null) {
            super.head = node;
            super.tail = node;
            node.next = node;
            node.prev = node;
        } else {
            DNode temp = super.head;
            while (temp.next != super.head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = super.head;
            super.head.prev = node;
            node.prev = temp;
            super.head = node;
            super.tail.next = super.head;
        }
        super.size++;
    }

    @Override
    public void InsertTail(DNode node) {
        if (super.head == null) {
            super.head = node;
            super.tail = node;
            node.next = node;
            node.prev = node;
        } else {
            DNode temp = super.head;
            while (temp.next != super.head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = super.head;
            super.head.prev = node;
            node.prev = temp;
        }
        super.size++;
    }

    @Override
    public void Insert(DNode node, int index) {
        if (index < 0 || index > this.getSize()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            InsertHead(node);
            return;
        }
        if (index == super.size) {
            InsertTail(node);
            return;
        }
        DNode temp = super.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        node.next.prev = node;
        super.size++;
    }

    @Override
    public void SortedInsert(DNode node) {
        if (!isSorted()) {
            System.out.println("List is not sorted");
            return;
        }
        DNode temp = super.head;
        while (temp.next != super.head && temp.next.data < node.data) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        node.next.prev = node;
        super.size++;
    }

    @Override
    public DNode Search(DNode node) {
        if (super.head == null) {
            return null;
        }
        DNode temp = super.head;
        while (temp.next != super.head && temp.data != node.data) {
            temp = temp.next;
        }
        if (temp.data == node.data) {
            return temp;
        }
        return null;
    }

    @Override
    public void Delete(DNode node) {
        if(Search(node) == null){
            throw new IllegalArgumentException();
        }
        if (super.head == null) {
            throw new IllegalArgumentException();
        }
        if (super.head == node) {
            DeleteHead();
            return;
        }
        DNode temp = super.head;
        while (temp.next != super.head && temp.next != node) {
            temp = temp.next;
        }
        if (temp.next == node) {
            temp.next = temp.next.next;
            temp.next.prev = temp;
            super.size--;
        }
    }

    @Override
    public void DeleteHead() {
        if(super.head == null){
            throw new IllegalArgumentException();
        }
        DNode temp = super.head;
        while (temp.next != super.head) {
            temp = temp.next;
        }
        temp.next = super.head.next;
        super.head.next.prev = temp;
        super.head = super.head.next;
        super.size--;
    }

    @Override
    public void DeleteTail() {
        if(super.head == null){
            throw new IllegalArgumentException();
        }
        DNode temp = super.head;
        while (temp.next.next != super.head) {
            temp = temp.next;
        }
        temp.next = super.head;
        super.head.prev = temp;
        super.size--;
    }

    @Override
    public void Clear() {
        super.head = null;
        super.tail = null;
        super.size = 0;
    }

    @Override
    public boolean isSorted() {
        DNode temp = super.head;
        while (temp.next != super.head) {
            if (temp.data > temp.next.data) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public boolean isCircular() {
        DNode slow = head;
        DNode fast = head;

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
    public void Print() {
        if(super.head == null){
            System.out.println("List is empty");
            return;
        }
        System.out.println("List length: " + super.size);
        System.out.println("List status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.println("Circular Doubly Linked List Content: ");
        DNode temp = super.head;
        while (temp.next != super.head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    @Override
    public boolean isDoublyLinkedList() {
        DNode temp = super.head;
        while (temp.next != super.head) {
            if (temp.next.prev != temp) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

   @Override
   public void Sort(){
         if(super.head == null){
              return;
         }
         DNode temp = super.head;
         while(temp.next != super.head){
              DNode temp2 = temp.next;
              while(temp2 != super.head){
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


    public static void main(String[] args) {
        CDLL CDLL = new CDLL();
        CDLL.InsertHead(new DNode(1));
        CDLL.InsertHead(new DNode(2));
        CDLL.InsertHead(new DNode(3));
        CDLL.InsertTail(new DNode(4));
        CDLL.Print();
        System.out.println("Circular: " + CDLL.isCircular());
        System.out.println("DLL:" + CDLL.isDoublyLinkedList());

        CDLL.Insert(new DNode(5), 2);
        CDLL.Print();

        CDLL.DeleteHead();
        CDLL.Print();

        CDLL.DeleteTail();
        CDLL.Print();

        DNode node = new DNode(1000);
        CDLL.InsertHead(node);
        CDLL.Print();
        CDLL.Delete(node);
        CDLL.Print();

        // CDLL.SortedInsert(new Dnode(100));
        CDLL.Sort();
        CDLL.Print();
        System.out.println("Circular: " + CDLL.isCircular());
        System.out.println("DLL:" + CDLL.isDoublyLinkedList());

        // CDLL.Clear();
        // CDLL.Print();

    }

}
