package znamenacek.jakub.fs.cvut.semestralniprace;

  import GraphicalUserInterface.DataElementGUI;
  import GraphicalUserInterface.NodeGUI;
  import GraphicalUserInterface.Square;
  import GraphicalUserInterface.TreeGUI;
  import javafx.application.Application;
  import javafx.geometry.Bounds;
  import javafx.geometry.Pos;
  import javafx.scene.Group;
  import javafx.scene.Scene;
  import javafx.scene.control.Button;
  import javafx.scene.control.Label;
  import javafx.scene.layout.HBox;
  import javafx.scene.layout.StackPane;
  import javafx.scene.layout.VBox;
  import javafx.scene.shape.Line;
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
    private static int[]  dataElementArray ={3,7,4,9,10,0,5,6,8,2,1,20,15,14,12};
    private int currentState =1;

    

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
        /*
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

         */
        
        tree = treeStatic;
        //System.out.println(tree.getRoot().getChildren()[1].getChildren()[0].getSiblings()[0].nodeDataElemnetsToString());
        
        
        System.out.println("PRINT TREE");
        //System.out.println(tree.getRoot().getChildren()[0]);
        System.out.println(treeStatic);

        launch(args);

        
    }

    @Override
    public void start(Stage stage) throws Exception {
        var treeGUI = new TreeGUI(tree.getRoot());
        var root = new VBox(20);
        var hBox = new HBox(10);
        var nextButton = new Button ("další");
        var previousButton = new Button ("předchozí");
        var wholeButton = new Button("celý strom");
        var startButton = new Button("start");

        hBox.getChildren().addAll(startButton, wholeButton,nextButton,previousButton);
        hBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(treeGUI,hBox);
        root.setAlignment(Pos.CENTER);









        //var scene = new Scene(treeGUI.createTree(tree.getRoot()),600,600);
        var scene = new Scene(root,1200,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("pokus");



        nextButton.setOnAction(e -> {
            tree = new Tree(new DataElement(dataElementArray[0]));
            currentState++;
            for(int i=1;i< currentState;i++){
                tree.add(new DataElement(dataElementArray[i]));
            }
            treeGUI.getChildren().clear();
            treeGUI.getChildren().add(new TreeGUI(tree.getRoot()));

        });

        previousButton.setOnAction(e -> {
            tree = new Tree(new DataElement(dataElementArray[0]));
            currentState--;
            for(int i=1;i< currentState;i++){
                tree.add(new DataElement(dataElementArray[i]));
            }
            treeGUI.getChildren().clear();
            treeGUI.getChildren().add(new TreeGUI(tree.getRoot()));

        });

        wholeButton.setOnAction(e -> {
            tree = new Tree(new DataElement(dataElementArray[0]));
            currentState = dataElementArray.length;
            for(int i=1;i< currentState;i++){
                tree.add(new DataElement(dataElementArray[i]));
            }
            treeGUI.getChildren().clear();
            treeGUI.getChildren().add(new TreeGUI(tree.getRoot()));

        });
        startButton.setOnAction(e -> {
            tree = new Tree(new DataElement(dataElementArray[0]));
            currentState = 1;

            treeGUI.getChildren().clear();
            treeGUI.getChildren().add(new TreeGUI(tree.getRoot()));

        });
     }
}