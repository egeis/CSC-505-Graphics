package main.java.com.graphics.shapes;

import main.java.com.graphics.shapes.utils.GraphicsObject;
import java.awt.Color;
import main.java.com.graphics.shapes.utils.Point;

/**
 *
 * @author Richard Coan
 */
public class Circle extends GraphicsObject {    
    public Circle(int cx, int cy, int r, Color color1) {
        this(cx, cy, 0, r, color1);
    }
    
    public Circle(int cx, int cy, int cz, int r, Color color1) {
        int d = 5 / 4 - r;
        int x = 0;
        int y = r;
       
        do {
            //North South East West Points
            points.add(new Point( cx + x, cy + y, color1 ));
            points.add(new Point( cx + x, cy - y, color1 ));
            points.add(new Point( cx - x, cy + y, color1 ));
            points.add(new Point( cx - x, cy - y, color1 ));
            
            //North-East, North-West, South-East, South-West points
            points.add(new Point( cx + y, cy + x, color1 ));
            points.add(new Point( cx + y, cy - x, color1 ));
            points.add(new Point( cx - y, cy + x, color1 ));
            points.add(new Point( cx - y, cy - x, color1 ));
            
            if(d < 0) {
               d += 2 * x + 1;
            } else {
                d += 2 * (x - y) + 1;
                y--;
            }
            x++;
        } while(x <= y);
    }    
}