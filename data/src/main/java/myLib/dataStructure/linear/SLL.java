package myLib.dataStructure.linear;

import myLib.dataStructure.nodes.SNode;

public class SLL {
    protected SNode head;
    protected SNode tail;
    protected int size;

    //constructors
    public SLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;  
    }
    public SLL(SNode node){
        this.head = node;
        this.tail = node;
        this.size = 1;
    }
    public SLL(int data){
        this.head = new SNode(data);
        this.tail = this.head;
        this.size = 1;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int getSize(){
        return this.size;
    }
    public SNode gethead(){
        return this.head;
    }
    public SNode gettail(){
        return this.tail;
    }
    //Insertion to head
    public void InsertHead(SNode node){
        node.next = this.head;
        this.head = node;
        this.size++;
        if (this.size == 1){
            this.tail = this.head;
        }
    }
    public void InsertHead(int data){
        SNode node = new SNode(data);
        InsertHead(node);
    }
    //Insertion to tail
    public void InsertTail(SNode node){
        if (this.size == 0){
            this.InsertHead(node);
            return;
        }
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }
    public void InsertTail(int data){
        SNode node = new SNode(data);
        InsertTail(node);
    }

    //Insertion to index
    public void Insert(SNode node, int position) throws IllegalArgumentException{
        if(position == 0){
            this.InsertHead(node);
        }else if(position == this.size){
            this.InsertTail(node);
        }else if(position > this.size){
            throw new IllegalArgumentException("Position is out of range");
        }else{
            SNode temp = this.head;
            for(int i = 0; i < position - 1; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            this.size++;
        }
    }
    public void Insert(int data, int position) throws IllegalArgumentException{
        SNode node = new SNode(data);
        Insert(node, position);
    }
    
    //Sorted Insertion
    public void SortedInsert(SNode node){
        if (this.size == 0){
            this.InsertHead(node);
            return;
        }
        if(this.isSorted()){
            int i = 0;
            for (SNode temp = this.head; temp != this.tail.next && node.data>temp.data; temp = temp.next) {
                i++;
            }
            this.Insert(node, i);
            return;
        }
        this.InsertTail(node);
        this.sort();
    }
    public void SortedInsert(int data){
        SNode node = new SNode(data);
        this.SortedInsert(node);
    }

    //Search function
    public SNode Search(SNode node){
        if (this.size == 0){
            return null;
        }
        SNode temp = this.head;
        if (temp==node){
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
    public SNode Search(int data){
        SNode node = new SNode(data);
        return this.Search(node);
    }

    //Deletion from head
    public SNode DeleteHead(){
        if (this.size == 0){
            return null;
        }
        SNode temp = this.head;
        this.head = this.head.next;
        this.size--;
        if (this.size == 0){
            this.tail = null;
        }
        return temp;
    }

    //Deletion from tail
    public SNode DeleteTail(){
        if (this.size == 1){
            return this.DeleteHead();
        }
        SNode temp = this.head;
        for(int i = 0; i < this.size - 2; i++){
            temp = temp.next;
        }
        temp.next = null;
        SNode temp2 = this.tail;
        this.tail = temp;
        this.size--;
        return temp2;
    }

    //Delete the node
    public SNode Delete(SNode node){
        if (this.size == 0){return null;}
        if(this.head.data == node.data){
            return this.DeleteHead();
        }else if(this.tail.data == node.data){
            return this.DeleteTail();
        }else{
            SNode temp = this.head;
            for(int i = 0; i < this.size - 1; i++){
                if(temp.next.data == node.data){
                    SNode temp2 = temp.next;
                    temp.next = temp.next.next;
                    this.size--;
                    return temp2;
                }
                temp = temp.next;
            }
            return null;
        }
    }
    public SNode Delete(int data){
        SNode node = new SNode(data);
        return this.Delete(node);
    }

    //Sort the list (insertion sort)
    public void sort(){
        if (this.size == 0 || this.size == 1){
            return;
        }
        SNode temp = this.head;
        SLL sorted = new SLL(temp);

        for(temp = temp.next; temp != this.tail.next; temp = temp.next){
            if (temp.data <= sorted.gethead().data) {
                SNode node=new SNode(temp.data);
                sorted.InsertHead(node);
            }else if (temp.data >= sorted.gettail().data) {
                SNode node=new SNode(temp.data);
                sorted.InsertTail(node);
            }else{
                int i=1;
                for(SNode temp2 = sorted.head; temp.data >= temp2.next.data; temp2 = temp2.next){
                    i++;
                }
                SNode node=new SNode(temp.data);
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
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Print
    public void Print(){
        String print="";
        print+="List length: "+this.size+"\n";
        print+="List sorted: "+this.isSorted()+"\n";
        print+="List: ";
        if (this.size == 0){
            System.out.println(print);
            return;
        }
        for (SNode temp = this.head; temp != this.tail.next; temp = temp.next) {
            print+=temp.data+", ";
        }
        System.out.println(print);
    }

    //private check sort methods
    protected boolean isSorted(){
        SNode temp = this.head;
        for(int i = 0; i < this.size - 1; i++){
            if(temp.data > temp.next.data){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    //private search method
    private int binarySearch(int data, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        SNode slow = this.head;
        SNode fast = this.head;
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
