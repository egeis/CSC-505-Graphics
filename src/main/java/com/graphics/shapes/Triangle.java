package main.java.com.graphics.shapes;

import main.java.com.graphics.shapes.utils.GraphicsObject;
import main.java.com.graphics.shapes.utils.Point;

/**
 *
 * @author Richard Coan
 */

public class Triangle extends GraphicsObject {
      
    public Triangle(Point p1, Point p2, Point p3)
    {        
        Point[] p = {p1,p2,p3};
        calculateBounds(p);
        
        points.addAll(new Line(p1, p2).getPoints());
        points.addAll(new Line(p2, p3).getPoints());
        points.addAll(new Line(p1, p3).getPoints());
    }
}