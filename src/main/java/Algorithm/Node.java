package Algorithm;

//IMPORT
import MyExceptions.*;
import HelpClasses.BubbleSort;

/**
 *
 * @author jakub
 */
public class Node {
//ATTRIBUTES
    static final int ORDER = 4;
    private int childrenNumber;
    private int dataElementsNumber;
    private Node[] children;
    private Node parent;
    private DataElement[] dataElements;
    
//CONSTRUCOR
    public Node(DataElement dataElement){
        childrenNumber = 0;
        dataElementsNumber = 0;
        children = new Node[ORDER];
        parent = null; ///vážně možná upravit
        dataElements = new DataElement[ORDER -1];
        
        addDataElement(dataElement);
    }
    
    
//METHODS
    private void addDataElement(DataElement dataElement){
        if(!isFull()){
            dataElements[dataElementsNumber] = dataElement;
            dataElementsNumber++;
            BubbleSort.sort(dataElements,dataElementsNumber);
            
         }
        else{
            throw new DataElementAddException("Can not add data, node is full.");
        }
    }
    
    public void add(DataElement dataElement){
        addDataElement(dataElement);
    }
    
    public void addChild(Node child){
        if(!childrenIsFull()){
            children[childrenNumber] = child;
            children[childrenNumber].setParent(this); //nastaví rodiče
            childrenNumber++;
            BubbleSort.sort(children, childrenNumber);
        }
        //DÁT SEM KONTROLU ŽE POČET DĚTÍ MUSÍ BÝT MAX POČET DAT + 1
        else{
            throw new ChildAddException("Node has already "+ORDER+" children!");
        }
    }
    
    public boolean hasChildren(){
        if(childrenNumber == 0){
            return false;
        }
        else if (childrenNumber >=0){
            return true;
        }
        else{
            throw new NodeHasChildrenException("Number of children is lover than 0!");
        }
    }
    
    public boolean hasParent(){
        if(parent == null){
            return false;
        }
        else{
            return true;
        }
        
    }
    
    public Node[] getChildren(){
        return children;
    }
    
    public void connectChild(int childNumber, Node child) {
	children[childNumber] = child;
	if (child != null){
            child.parent = this;
            childrenNumber++;
        }
	
	}
    
    public Node deleteLastChild() {
        
        //EXCEPTION NEEDED
        var tempNode = children[childrenNumber-1];
        children[childrenNumber-1] = null;
        childrenNumber--;
        return tempNode;
    }
    
    public Node choseChild(DataElement dataElement){
        switch(childrenNumber){
            case 4:
                if(dataElement.getIdentifier() > dataElements[2].getIdentifier()){
                    return children[3];
                }
            case 3:
                if(dataElement.getIdentifier() > dataElements[1].getIdentifier()){
                    return children[2];
                }
            case 2:
                if(dataElement.getIdentifier() > dataElements[0].getIdentifier()){
                    return children[1];
                }
            case 1:
                if(dataElement.getIdentifier() < dataElements[0].getIdentifier()){
                    return children[0];
                }
        }
        
        throw new ChoseChildException("The correct child was not chosent!");
    }
    
    public DataElement[] getDataElements(){
        return dataElements;
    }
    
    public Node getParent(){
        return parent;
    }
    
    private void setParent(Node parent){
        this.parent = parent;
    }

    
    public boolean isFull(){
        return dataElementsNumber >= (ORDER-1);
    }
    
    public boolean isEmpty(){
        return dataElementsNumber == 0;
    }
    
    private boolean childrenIsFull(){
        return childrenNumber >= (ORDER);
    }
    
    public int getChildrenNumber(){
        return childrenNumber;
    }
    
    public DataElement maxDataElement(){
        return dataElements[dataElementsNumber-1];
    }
    
    public DataElement deleteLastDataElement(){
        if(!isEmpty()){
            var temp = dataElements[dataElementsNumber - 1]; // save item
            dataElements[dataElementsNumber - 1] = null; // disconnect it
            dataElementsNumber--; // one less item
            return temp; // return item
        }
        throw new DeleteLastDataElementException("Node is empty!");
    }
    
    public DataElement promote(){
        if(isFull()){
            var temp = dataElements[1];
            dataElements[1]=dataElements[2];
            dataElements[2]=null;
            dataElementsNumber--;
            return temp;
        }
        throw new PromoteException("Node is not full, can not be promoted!");
    }
    
    public String nodeDataElemnetsToString(){
        var temp = "";
        for(int i = 0;i<dataElementsNumber;i++){
            temp += "["+dataElements[i].identifier+"]";
        }
        return temp;
    }
    
    public Node[] getSiblings(){
        return getParent().children;
    }
    
    
    
    
    
    
    
    
    @Override
    public String toString(){
        String help = "";
        help += "Node [";
        help += "ORDER:"+ORDER+" , ";
        help += "childrenNumber:"+childrenNumber+" , ";
        help += "dataElementsNumber:"+dataElementsNumber+" , ";
        help += "dataElements:";
        for(int i = 0;i<dataElementsNumber;i++){
            help +="["+dataElements[i]+"]";
        }
        help += "]";
        
        return help;
    }
        
}
