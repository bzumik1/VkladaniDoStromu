package GraphicalUserInterface;

import Algorithm.DataElement;
import javafx.geometry.Pos;
import javafx.scene.Group;
import Algorithm.Node;
import javafx.scene.layout.HBox;

import java.util.List;

public class NodeGUI extends HBox {


    public NodeGUI(Node node){
        super();
        super.setAlignment(Pos.CENTER);
        for(DataElement dataElement: node.getDataElements()){
            super.getChildren().add(new DataElementGUI(dataElement));
        }
    }
}
