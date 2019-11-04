package znamenacek.jakub.fs.cvut.semestralniprace;

  import GraphicalUserInterface.NodeGUI;
  import GraphicalUserInterface.TreeGUI;
  import javafx.application.Application;
  import javafx.geometry.Pos;
  import javafx.scene.Scene;
  import javafx.scene.control.Button;
  import javafx.scene.control.Label;
  import javafx.scene.layout.HBox;
  import javafx.scene.layout.StackPane;
  import javafx.scene.layout.VBox;
  import javafx.stage.Stage;

import Algorithm.Node;
import Algorithm.DataElement;
import Algorithm.Tree;
import java.util.ArrayList;
  import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Tree tree;

    

    public static void main(String[] args) {
        var n1 = new Node(new DataElement(3));
        n1.add(new DataElement(2));
        var aL = new ArrayList<Integer>();
        System.out.println(aL.size());
        
        System.out.println("Priiiiiiiiint");
        System.out.println(n1);
        
        
        //TEST NODE
        System.out.println("TEST");
        System.out.println("CREATE TREE");
        var treeStatic = new Tree(new DataElement(3));
        treeStatic.add(new DataElement(7));
        treeStatic.add(new DataElement(4));
        treeStatic.add(new DataElement(9));
        treeStatic.add(new DataElement(10));
        treeStatic.add(new DataElement(0));
        treeStatic.add(new DataElement(5));
        treeStatic.add(new DataElement(6));
        treeStatic.add(new DataElement(8));
        treeStatic.add(new DataElement(2));
        treeStatic.add(new DataElement(1));
        treeStatic.add(new DataElement(20));
        treeStatic.add(new DataElement(15));
        treeStatic.add(new DataElement(14));
        treeStatic.add(new DataElement(12));
        
        tree = treeStatic;
        //System.out.println(tree.getRoot().getChildren()[1].getChildren()[0].getSiblings()[0].nodeDataElemnetsToString());
        
        
        System.out.println("PRINT TREE");
        //System.out.println(tree.getRoot().getChildren()[0]);
        System.out.println(treeStatic);
        var myNode = new NodeGUI(tree.getRoot());
        System.out.println("Sirka nodu "+ myNode.getWidth());

        launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        var treeGUI = new TreeGUI(tree);

        var scene = new Scene(treeGUI.createTree(tree.getRoot()),600,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("pokus");
     }
}