package myLib.dataStructure.linear;
import myLib.dataStructure.nodes.SNode;
public class LLQueue extends SLL{
    public LLQueue(){
        super();
    }
    public LLQueue(SNode node){
        super(node);
    }
    public LLQueue(int data){
        super(data);
    }

    public void Enqueue(SNode node){
        this.InsertTail(node);
    }
    public void Enqueue(int data){
        this.InsertTail(data);
    }

    public SNode Dequeue(){
        return this.DeleteHead();
    }
    //Overriding the methods of singlyLList
    @Override
    public void InsertHead(SNode node) throws UnsupportedOperationException{
        if (this.size == 0){
            super.InsertHead(node);
            return;
        }else{
            throw new UnsupportedOperationException("InsertHead is not supported in LLQueue");
        }
    }
    @Override
    public void Insert(SNode node, int index){
        throw new UnsupportedOperationException("Insert is not supported in LLQueue");
    }
    @Override
    public void SortedInsert(SNode node){
        throw new UnsupportedOperationException("SortedInsert is not supported in LLQueue");
    }
    @Override
    public SNode DeleteTail(){
        throw new UnsupportedOperationException("DeleteTail is not supported in LLQueue");
    }
    @Override
    public SNode Delete(SNode node){
        throw new UnsupportedOperationException("Delete is not supported in LLQueue");
    }
    @Override
    public void sort(){
        throw new UnsupportedOperationException("sort is not supported in LLQueue");
    }
    @Override
    protected boolean isSorted(){
        throw new UnsupportedOperationException("isSorted is not supported in LLQueue");
    }
}
