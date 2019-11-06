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

        launch(args);

        
    }

    @Override
    public void start(Stage stage) throws Exception {
        //var treeGUI = new TreeGUI();
        var text1 = new Label();
        var square1 = new Square(100,2);
        square1.setOnMouseDragged(e -> {
                                            square1.setX(e.getX());
                                            square1.setY(e.getY());
        });
        var square2 = new Square(100,2);
        square2.setOnMouseDragged(e -> {
                                            square2.setX(e.getX());
                                            square2.setY(e.getY());
        });

        var line = new Line();
        var line1 = new Line(0,0,100,100);
        line.startXProperty().bind(square1.centerXProperty);
        line.startYProperty().bind(square1.centerYProperty);
        line.endXProperty().bind(square2.centerXProperty);
        line.endYProperty().bind(square2.centerYProperty);
        text1.setText("");

        var root = new VBox(20);
        var vbox = new VBox(40);
        var group = new Group();
        group.maxWidth(300);
        group.maxHeight(300);
        root.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(square1,square2);
        group.getChildren().addAll(vbox,line1);
        vbox.setLayoutX(100);
        vbox.setLayoutY(100);


        //root.getChildren().addAll(group);



        //var scene = new Scene(treeGUI.createTree(tree.getRoot()),600,600);
        var scene = new Scene(new TreeGUI(tree.getRoot()),1200,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("pokus");
     }
}