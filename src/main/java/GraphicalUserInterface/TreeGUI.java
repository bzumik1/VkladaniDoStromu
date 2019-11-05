package GraphicalUserInterface;

import Algorithm.Node;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;
import Algorithm.Tree;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class TreeGUI extends VBox {

    public TreeGUI (Tree tree){
        super();


        /*
        //Create and configure VBox
        super(30);
        super.setAlignment(Pos.CENTER);


        //Create root
        List<HBox> rows = new ArrayList<>();
        rows.add(new NodeGUI(tree.getRoot()));
        rows.get(rows.size()-1).setAlignment(Pos.CENTER);


        List<Node> childrenAtOneLevel = new ArrayList<>(tree.getRoot().getChildren());
        List<Node> tempChildrenAtOneLevel = new ArrayList<>();

        for(int i=0;i<tree.getDepth();i++){ //MISTAKE DEFINE DEPTH ON SEPARATE ROW
            rows.add(new HBox(20));
            rows.get(rows.size()-1).setAlignment(Pos.CENTER);
            for(Node child: childrenAtOneLevel){
                rows.get(rows.size()-1).getChildren().add(new NodeGUI(child));
                for(Node grandChild: child.getChildren()){
                    tempChildrenAtOneLevel.add(grandChild);
                }
            }
            childrenAtOneLevel = tempChildrenAtOneLevel;
            tempChildrenAtOneLevel = new ArrayList<>();
        }



        for(HBox row: rows){
            super.getChildren().add(row);
        }

         */
    }

    public VBox createTree(Node root){
        //create temporary vbox and hbox
        VBox vbox = new VBox(70); //spacing between rows
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(40); //spacing between nodes
        hbox.setAlignment(Pos.CENTER);


        if(root.hasChildren()){

            for(Node child:root.getChildren()){
                hbox.getChildren().add(createTree(child)); //create row of children
            }
            vbox.getChildren().addAll(new NodeGUI(root),hbox);

        }
        else {
            vbox.getChildren().add(new NodeGUI(root));
        }


        return vbox;
    }

    public Group createFamilyTree(Node parent){
        NodeGUI parentGUI = new NodeGUI(parent);
        var group = new Group();
        double maxWidth = 0;
        double dataElementHight = 40; // HAS TO BE DINAMIC NOT STATIC EDIT
        double xSpacing = 40; //HAS TO BE DIMAMIC NOT STATIC EDIT
        double ySpacing = 70; //HAS TO BE DIMAMIC NOT STATIC EDIT


        if(parent.hasChildren()){
            for(Node child:parent.getChildren()){
                var childGUI = new NodeGUI(child);
                group.getChildren().add(childGUI);
                childGUI.setLayoutX(maxWidth);
                childGUI.setLayoutY(dataElementHight + ySpacing);
                maxWidth += childGUI.getXDimension(); //add width of current child
                maxWidth += xSpacing;

            }
            maxWidth -=xSpacing; //delete last spacing

        }

        group.getChildren().add(parentGUI);
        parentGUI.setLayoutX((maxWidth-parentGUI.getXDimension())/2);
        parentGUI.setLayoutY(0);


        return group;
    }


    }

