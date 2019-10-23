/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

/**
 *
 * @author jakub
 */
public class DataElement {
//ATTRIBUTES
    int identifier;
//CONSTRUCTOR
    public DataElement(int identifier){
        this.identifier = identifier;
    }
    public DataElement(){
        this.identifier = 0;
    }
//METHODS
    public int getIdentifier(){
        return identifier;
    }
    
    @Override
    public String toString(){
        return "Data ["+identifier+"]";
    }
}
