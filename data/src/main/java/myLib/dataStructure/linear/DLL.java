package myLib.dataStructure.linear;

import myLib.dataStructure.nodes.DNode;

public class DLL{
    protected DNode head;
    protected DNode tail;
    protected int size;

    //constructors
    public DLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;  
    }
    public DLL(DNode node){
        this.head = node;
        this.tail = node;
        this.size = 1;
    }
    public DLL(int data){
        this.head = new DNode(data);
        this.tail = this.head;
        this.size = 1;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int getSize(){
        return this.size;
    }
    public DNode gethead(){
        return this.head;
    }
    public DNode gettail(){
        return this.tail;
    }

    //Insertion to head
    public void InsertHead(DNode node){
        if (this.size == 0){
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        node.prev = null;
        this.head = node;
        this.size++;
        if (this.size == 1){
            this.tail = this.head;
        }
    }
    public void InsertHead(int data){
        DNode node = new DNode(data);
        this.InsertHead(node);
    }
    
    //Insertion to tail
    public void InsertTail(DNode node){
        if (this.size == 0){
            this.InsertHead(node);
            return;
        }
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
        this.size++;
    }
    public void InsertTail(int data){
        DNode node = new DNode(data);
        this.InsertTail(node);
    }

    //Insertion to index
    public void Insert(DNode node, int position) throws IllegalArgumentException{
        if(position == 0){
            this.InsertHead(node);
        }else if(position == this.size){
            this.InsertTail(node);
        }else if(position > this.size){
            throw new IllegalArgumentException("Position is out of range");
        }else{
            DNode temp = this.head;
            for(int i = 0; i < position - 1; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            node.prev = temp;
            temp.next.prev = node;
            temp.next = node;
            this.size++;
        }
    }
    public void Insert(int data, int position) throws IllegalArgumentException{
        DNode node = new DNode(data);
        Insert(node, position);
    }

    //Sorted Insertion
    public void SortedInsert(DNode node){
        if (this.size == 0){
            this.InsertHead(node);
            return;
        }
        if(this.isSorted()){
            int i = 0;
            for (DNode temp = this.head; temp != this.tail.next && node.data>temp.data; temp = temp.next) {
                i++;
            }
            this.Insert(node, i);
            return;
        }
        this.InsertTail(node);
        this.sort();
    }
    public void SortedInsert(int data){
        DNode node = new DNode(data);
        this.SortedInsert(node);
    }

    //Search function
    public DNode Search(DNode node){
        if (this.size == 0){
            return null;
        }
        DNode temp = this.head;
        if (node.data == temp.data){
            return temp;
        }
        if (this.isSorted()){
            int position= this.binarySearch(node.data, 0, this.size - 1);
            if (position == -1){
                return null;
            }
            for(int i = 0; i < position; i++){
                temp = temp.next;
            }
            return temp;
        }
        for(int i = 0; i < this.size; i++){
            if(temp.data == node.data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public DNode Search(int data){
        DNode node = new DNode(data);
        return this.Search(node);
    }


    //Deletion from head
    public DNode DeleteHead(){
        if (this.size == 0){
            return null;
        }
        DNode temp = this.head;
        this.head = null;
        this.head = temp.next;
        try{
            this.head.prev = null;
        }catch(NullPointerException e){
            this.size=1;
        }
        this.size--;
        if (this.size == 0){
            this.tail = null;
        }
        return temp;
    }

    //Deletion from tail
    public DNode DeleteTail(){
        if (this.size == 1){
            return this.DeleteHead();
        }
        DNode temp = this.tail;
        this.tail = null;
        this.tail = temp.prev;
        this.size--;
        return temp;
    }

    //Delete the node
    public DNode Delete(DNode node){
        if(this.head.data == node.data){
            return this.DeleteHead();
        }else if(this.tail.data == node.data){
            return this.DeleteTail();
        }else{
            DNode temp = Search(node);
            if(temp != null){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                this.size--;
                return temp;
            }
            return null;
        }
    }
    public DNode Delete(int data){
        DNode node = new DNode(data);
        return this.Delete(node);
    }

    //Sort the list (insertion sort)
    public void sort(){
        DNode temp = this.head;
        DLL sorted = new DLL(temp);

        for(temp = temp.next; temp != this.tail.next; temp = temp.next){
            if (temp.data <= sorted.head.data) {
                DNode node= new DNode(temp.data);
                sorted.InsertHead(node);
            }else if (temp.data >= sorted.tail.data) {
                DNode node= new DNode(temp.data);
                sorted.InsertTail(node);
            }else{
                int i=1;
                for(DNode temp2 = sorted.head; temp.data >= temp2.next.data; temp2 = temp2.next){
                    i++;
                }
                DNode node= new DNode(temp.data);
                sorted.Insert(node, i);

            }
        }
        this.tail = sorted.tail;
        this.head = sorted.head;
        this.size = sorted.size;
    }

    //CLear the list
    public void Clear(){
        for (int i=this.size; i>0; i--) {
            this.DeleteHead();
        }
    }

    //Print
    public void Print(){
        String print="";
        print+="List length: "+this.size+"\n";
        print+="List sorted: "+this.isSorted()+"\n";
        print+="List: ";
        for (DNode temp = this.head; temp != this.tail.next; temp = temp.next) {
            print+=temp.data+", ";
        }
        System.out.println(print);
    }

    //private check sort methods
    protected boolean isSorted(){
        DNode temp = this.head;
        for(int i = 0; i < this.size - 1; i++){
            if(temp.data > temp.next.data){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    private int binarySearch(int data, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        DNode slow = this.head;
        DNode fast = this.head;
        for(int i = 0; i < start; i++){
            fast = fast.next;
            slow=slow.next;
        }
        for (int i = 0; i < (mid-start); i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.data == data) {
            return mid;
        } else if (slow.data > data) {
            return binarySearch(data, start, mid - 1);
        } else {
            return binarySearch(data, mid + 1, end);
        }
    }
    
}


