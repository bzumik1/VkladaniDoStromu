/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpClasses;

import Algorithm.*;

/**
 *
 * @author jakub
 */
public abstract class BubbleSort {
    
    public static void sort(DataElement[] array,int max) {  
        int n = max;  
        DataElement temp;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(array[j-1].getIdentifier() > array[j].getIdentifier()){  
                                 //swap elements  
                                 temp = array[j-1];  
                                 array[j-1] = array[j];  
                                 array[j] = temp;  
                         }  
                          
                 }  
         }  
    }
    
    public static void sort(Node[] array,int max) {  
        int n = max;  
        Node temp;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(array[j-1].maxDataElement().getIdentifier() > array[j].maxDataElement().getIdentifier()){  
                                 //swap elements  
                                 temp = array[j-1];  
                                 array[j-1] = array[j];  
                                 array[j] = temp;  
                         }  
                          
                 }  
         }  
    }
    
}
