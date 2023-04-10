package myLib.dataStructure.linear;
import myLib.dataStructure.nodes.SNode;
public class LLStack extends SLL{
    public LLStack(){
        super();
    }
    public LLStack(SNode node){
        super(node);
    }
    public LLStack(int data){
        super(data);
    }
    public void push(SNode node){
        this.InsertHead(node);
    }
    public void push(int data){
        this.InsertHead(data);
    }
    public SNode pop(){
        return this.DeleteHead();
    }
    public SNode peek(){
        return this.head;
    }

    //Insertion to tail
    @Override
    public void InsertTail(SNode node) throws IllegalArgumentException{
        throw new IllegalArgumentException("InsertTail is not allowed in a stack");
    }

    //Insertion to index
    @Override
    public void Insert(SNode node, int position) throws IllegalArgumentException{
        throw new IllegalArgumentException("Insert is not allowed in a stack");
    }
    
    //Sorted Insertion
    @Override
    public void SortedInsert(SNode node) throws IllegalArgumentException{
        throw new IllegalArgumentException("SortedInsert is not allowed in a stack");
    }

    //Search function
    public SNode Search(SNode node){
        SNode temp = this.head;
        for(int i = 0; i < this.size; i++){
            if(temp.data == node.data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //Deletion from tail
    @Override
    public SNode DeleteTail() throws IllegalArgumentException{
        throw new IllegalArgumentException("DeleteTail is not allowed in a stack");
    }

    //Delete the node
    @Override
    public SNode Delete(SNode node) throws IllegalArgumentException{
        throw new IllegalArgumentException("Delete is not allowed in a stack");
    }

    //Sort the list (insertion sort)
    @Override
    public void sort() throws IllegalArgumentException{
        throw new IllegalArgumentException("Sort is not allowed in a stack");
    }

    //private check sort methods
    @Override
    protected boolean isSorted() throws IllegalArgumentException{
        throw new IllegalArgumentException("isSorted is not allowed in a stack");
    }
    
}
