package mylib.datastructures.linear.LinkedLists;

import mylib.datastructures.nodes.Dnode;

public class CDLL extends DLL {
    public CDLL() {
        super();
    }

    public CDLL(Dnode data) {
        super(data);
        super.head.next = super.head;
        super.head.prev = super.head;

    }

    @Override
    public void InsertHead(Dnode node) {
        if (super.head == null) {
            super.head = node;
            node.next = node;
            node.prev = node;
        } else {
            Dnode temp = super.head;
            while (temp.next != super.head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = super.head;
            super.head.prev = node;
            node.prev = temp;
            super.head = node;
        }
        super.size++;
    }

    @Override
    public void InsertTail(Dnode node) {
        if (super.head == null) {
            super.head = node;
            node.next = node;
            node.prev = node;
        } else {
            Dnode temp = super.head;
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
    public void Insert(Dnode node, int index) {
        if (index < 0 || index > super.size) {
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
        Dnode temp = super.head;
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
    public void SortedInsert(Dnode node) {
        if (!isSorted()) {
            System.out.println("List is not sorted");
            return;
        }
        Dnode temp = super.head;
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
    public Dnode Search(Dnode node) {
        Dnode temp = super.head;
        while (temp.next != super.head && temp.data != node.data) {
            temp = temp.next;
        }
        if (temp.data == node.data) {
            return temp;
        }
        return null;
    }

    @Override
    public void Delete(Dnode node) {
        if (super.head == null) {
            return;
        }
        if (super.head == node) {
            DeleteHead();
            return;
        }
        Dnode temp = super.head;
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
        Dnode temp = super.head;
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
        Dnode temp = super.head;
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
        Dnode temp = super.head;
        while (temp.next != super.head) {
            if (temp.data > temp.next.data) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public boolean isCircular() {
        Dnode slow = head;
        Dnode fast = head;

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
        Dnode temp = super.head;
        while (temp.next != super.head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    @Override
    public boolean isDoublyLinkedList() {
        Dnode temp = super.head;
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
         Dnode temp = super.head;
         while(temp.next != super.head){
              Dnode temp2 = temp.next;
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
        CDLL.InsertHead(new Dnode(1));
        CDLL.InsertHead(new Dnode(2));
        CDLL.InsertHead(new Dnode(3));
        CDLL.InsertTail(new Dnode(4));
        CDLL.Print();
        System.out.println("Circular: " + CDLL.isCircular());
        System.out.println("DLL:" + CDLL.isDoublyLinkedList());

        CDLL.Insert(new Dnode(5), 2);
        CDLL.Print();

        CDLL.DeleteHead();
        CDLL.Print();

        CDLL.DeleteTail();
        CDLL.Print();

        Dnode node = new Dnode(1000);
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
