/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import java.util.ArrayList;

/**
 *
 * @author jakub
 */
public class Tree {
//ATTRIBUTES
    private Node root;
    private int depth;
    

//CONSTRUCTOR
    public Tree(Node root){
        this.root = root;
        depth = 0;
    }
    public Tree(DataElement dataElement){
        this.root = new Node(dataElement);
        depth = 0;
    }
    
//METHODS
    public void add(DataElement dataElement){
        var currentNode = root;
        while(currentNode.hasChildren()){ //finds last corect node
            currentNode = currentNode.choseChild(dataElement);
        }
        //current node is not full
        if(!currentNode.isFull()){ //adds dataElement into corect node
            currentNode.add(dataElement);
        }
        //current node is full, promote algorithm have to start
        else{
            split(currentNode,dataElement);
        }
        
    }
    
    private void split(Node thisNode, DataElement data){ // split the node
        
        //Node is root
	if(!thisNode.hasParent()){ 
            root = new Node(thisNode.promote()); // create new node (root) with dataElement promote (middle dataElement from old Node is deleted)
            depth++;
            var rightNode = new Node(thisNode.deleteLastDataElement()); //Copy and delete last dataElement from current node
            //Connect Nodes to new Root;
            root.addChild(thisNode);
            root.addChild(rightNode);
            //Connect Children to right node and disconect them from thisNode
            for(int i = thisNode.getChildrenNumber();i>2;i--){ //Maximal last two children from first Node are deleted and moved to new one
                rightNode.addChild(thisNode.deleteLastChild());
            }
            //Add dataElement to tree
            root.choseChild(data).add(data);
        }
        //Node is not root
        else{
            //Parent of thisNode is not full, so promote can be saved to it
            if(!thisNode.getParent().isFull()){ 
               thisNode.getParent().add(thisNode.promote()); //Promote is saved to parent
               var rightNode = new Node(thisNode.deleteLastDataElement()); //last element is used to create right node
               //Connect new Node to parent
               thisNode.getParent().addChild(rightNode);
               //Reconect children to rightNode
               for(int i = thisNode.getChildrenNumber();i>1;i--){ //Maximal last two children (2,3) from first Node are deleted and moved to new one
                   rightNode.addChild(thisNode.deleteLastChild());
               }
               //Add dataElement to tree
                thisNode.getParent().choseChild(data).add(data); //chyba
               
            }
            //Parent of thisNode is full, needs to be splited -> recursive use of split function
            else{
                split(thisNode.getParent(),thisNode.promote());
                var rightNode = new Node(thisNode.deleteLastDataElement()); //last element is used to create right node
               //Connect new Node to parent
               thisNode.getParent().addChild(rightNode);
               //Reconect children to rightNode
               for(int i = thisNode.getChildrenNumber();i>1;i--){ //Maximal last two children from first Node are deleted and moved to new one
                   rightNode.addChild(thisNode.deleteLastChild());
               }
               //Add dataElement to tree
                thisNode.getParent().choseChild(data).add(data);
                
            }
        }
    }
    
    
    public String getOneLevelAsString(int depth){
        Node[] parents;
        String tempString = "";
        var temp = root;
        int ch = 0;
        int p =0;
        if(depth==0){
            return root.nodeDataElemnetsToString();
        }
        else if(depth==1){
            for(Node child:temp.getChildren()){
                ch++;
                tempString += (child.nodeDataElemnetsToString()+"     ");
                if(ch>=temp.getChildrenNumber()){
                        break;
                }
             }
            return tempString;
        }
        else if(depth>1) {
            for(int i = 0;i<(depth-2);i++){ //looks for grandparents in depth - 2
                temp = temp.getChildren()[0];
            }
            parents = temp.getChildren();
            for(Node parent:parents){ //Could be done more effitiently
                ch=0;
                p++;
                for(Node child:parent.getChildren()){
                    ch++;
                    tempString += (child.nodeDataElemnetsToString()+"     ");
                    if(ch>=parent.getChildrenNumber()){
                        break;
                    }
                }
                if(p>=temp.getChildrenNumber()){
                    break;
                }
            }
            return tempString;    
        }
        return "PROBLEM";
    }
    
    public Node getRoot(){
        return root;
    }
    
    @Override
    public String toString(){
        String tempString = "";
        
        for(int i=0;i<=depth;i++){
            tempString += (getOneLevelAsString(i)+"\n");
        }
        return tempString;
    }
    
}
