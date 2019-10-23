package znamenacek.jakub.fs.cvut.semestralniprace;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import Algorithm.Node;
import Algorithm.DataElement;
import Algorithm.Tree;

/**
 * JavaFX App
 */
public class App {//extends Application {

    

    public static void main(String[] args) {
        
        //TEST NODE
        System.out.println("TEST");
        System.out.println("CREATE TREE");
        var tree = new Tree(new DataElement(3));
        tree.add(new DataElement(7));
        tree.add(new DataElement(4));
        tree.add(new DataElement(9));
        tree.add(new DataElement(10));
        tree.add(new DataElement(0));
        tree.add(new DataElement(5));
        tree.add(new DataElement(6));
        tree.add(new DataElement(8));
        tree.add(new DataElement(2));
        tree.add(new DataElement(1));
        tree.add(new DataElement(20));
        tree.add(new DataElement(15));
        tree.add(new DataElement(14));
        tree.add(new DataElement(12));
        
        
        //System.out.println(tree.getRoot().getChildren()[1].getChildren()[0].getSiblings()[0].nodeDataElemnetsToString());
        
        
        System.out.println("PRINT TREE");
        //System.out.println(tree.getRoot().getChildren()[0]);
        System.out.println(tree);
    }

}