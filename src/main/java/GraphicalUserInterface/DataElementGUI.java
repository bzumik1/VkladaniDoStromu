package GraphicalUserInterface;

import Algorithm.DataElement;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class DataElementGUI extends StackPane {
    private Text identifier;
    private Square boundary;

    public DataElementGUI (DataElement dataElement){
        super();
        super.setAlignment(Pos.CENTER);
        boundary = new Square(50,2);
        identifier = new Text(dataElement.identifierToString());
        super.getChildren().addAll(identifier,boundary);

    }

    public Text getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Text identifier) {
        this.identifier = identifier;
    }

    public Square getBoundary() {
        return boundary;
    }

    public void setBoundary(Square boundary) {
        this.boundary = boundary;
    }


}
