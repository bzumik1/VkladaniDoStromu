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


public class TreeGUI extends Group {
    double xDimension;
    double yDimension;
    double dataElementHight = 40; // HAS TO BE DINAMIC NOT STATIC EDIT
    double xSpacing = 40; //HAS TO BE DIMAMIC NOT STATIC EDIT
    double ySpacing = 70; //HAS TO BE DIMAMIC NOT STATIC EDIT

    public TreeGUI (Node root){
        super();
        Node parent = root;
        NodeGUI parentGUI = new NodeGUI(parent);
        xDimension = 0;
        //var group = new Group();



        if(parent.hasChildren()){
            for(Node child:parent.getChildren()){
                var childTree = new TreeGUI(child); //create new tree
                super.getChildren().add(childTree); //add new tree to tree above it
                childTree.setLayoutX(xDimension); //set xDimension (for the first child O)
                childTree.setLayoutY(dataElementHight + ySpacing); //set yDimension
                xDimension += childTree.getxDimension(); //add width of current child
                xDimension += xSpacing;

            }
            xDimension -=xSpacing; //delete last spacing

        }
        // give parent in the group
        super.getChildren().add(parentGUI);
        if(xDimension!=0){
            parentGUI.setLayoutX((xDimension-parentGUI.getXDimension())/2);
        }

        parentGUI.setLayoutY(0);
        xDimension+=parentGUI.getXDimension(); //MISTAKE?!?






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




    public double getxDimension() {
        return xDimension;
    }

    public void setxDimension(double xDimension) {
        this.xDimension = xDimension;
    }

    public double getyDimension() {
        return yDimension;
    }

    public void setyDimension(double yDimension) {
        this.yDimension = yDimension;
    }

    public double getDataElementHight() {
        return dataElementHight;
    }

    public void setDataElementHight(double dataElementHight) {
        this.dataElementHight = dataElementHight;
    }

    public double getxSpacing() {
        return xSpacing;
    }

    public void setxSpacing(double xSpacing) {
        this.xSpacing = xSpacing;
    }

    public double getySpacing() {
        return ySpacing;
    }

    public void setySpacing(double ySpacing) {
        this.ySpacing = ySpacing;
    }
}

