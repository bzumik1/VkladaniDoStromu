package GraphicalUserInterface;

import Algorithm.DataElement;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class DataElementGUI extends Group {
    Text identifier;
    Square boundary;

    public DataElementGUI (DataElement dataElement){
        super();
        boundary = new Square(50,2);
        identifier = new Text(dataElement.identifierToString());
        identifier.setTextAlignment(TextAlignment.CENTER);
        identifier.setX(boundary.getCenter().getX());
        identifier.setY(boundary.getCenter().getY());
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
