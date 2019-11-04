package GraphicalUserInterface;

import javafx.geometry.Point2D;

public class Square {
    private double side;
    private double stroke;
    private Point2D topLeftCorner;

    public Square (double side){
        this.side = side;
        stroke = 0;
        topLeftCorner = new Point2D(0,0);
    }


}
