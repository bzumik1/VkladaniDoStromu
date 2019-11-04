package GraphicalUserInterface;

import Algorithm.Node;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;
import Algorithm.Tree;


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
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(30);
        hbox.setAlignment(Pos.CENTER);
        if(root.hasChildren()){
            for(Node child:root.getChildren()){
                hbox.getChildren().add(createTree(child));
            }
            vbox.getChildren().addAll(new NodeGUI(root),hbox);
        }
        else {
            vbox.getChildren().add(new NodeGUI(root));
        }


        return vbox;
    }
    }

