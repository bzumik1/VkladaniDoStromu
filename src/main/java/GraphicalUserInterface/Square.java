package GraphicalUserInterface;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Square extends Rectangle {
    private double side;
    private Point2D center;



    public Square(double size, double stroke){
        super(0,0,size,size);
        center = new Point2D(super.getX()+size/2,super.getY()+size/2);
        super.setArcHeight(size/3);
        super.setArcWidth(size/3);
        super.setStrokeType(StrokeType.INSIDE);
        super.setStroke(Color.BLACK);
        super.setFill(Color.rgb(0, 0, 0, 0));
        super.setStrokeWidth(stroke);
    }

    public double getSide(){
        return side;
    }

    public void setSide(double side){
        this.side = side;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public Point2D getCenter() {
        return center;
    }
}
