package GraphicalUserInterface;

import Algorithm.DataElement;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import Algorithm.Node;
import javafx.scene.layout.HBox;

import java.util.List;

public class NodeGUI extends HBox {
    Point2D parrentConnection;
    List<Point2D> childrenConnections;




    public NodeGUI(Node node){
        super();
        super.setAlignment(Pos.CENTER);
        double widht = 0;
        for(DataElement dataElement: node.getDataElements()){
            var dataElementGUI = new DataElementGUI(dataElement);
            widht += dataElementGUI.getWidth();
            super.getChildren().add(dataElementGUI);
        }




    }
}
