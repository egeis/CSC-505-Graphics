package main.java.com.graphics.shapes;

import java.awt.Color;
import main.java.com.graphics.shapes.utils.GraphicsObject;
import main.java.com.graphics.shapes.utils.Point;

/**
 * 
 * @author Richard Coan
 */
public class Line extends GraphicsObject {    
    public Line(Point start, Point end)
    {
        //Distances
        int dx = Math.abs(end.x - start.x);
        int dy = Math.abs(end.y - start.y);
        
        //Step increase or decrease
        int sx = (start.x<end.x)?1:-1;
        int sy = (start.y<end.y)?1:-1;
        
        int error = dx - dy;
        
        int x = start.x;
        int y = start.y;
        
        while(true) {
            
            double r, g, b, a;
            
            if(start.x == end.x)
            {
                r = (int) ( ((float) y - start.y) / ((float) end.y - start.y)  * (end.color.getRed() - start.color.getRed()) + start.color.getRed() );
                g = (int) ( ((float) y - start.y) / ((float) end.y - start.y)  * (end.color.getBlue() - start.color.getBlue()) + start.color.getBlue() );
                b = (int) ( ((float) y - start.y) / ((float) end.y - start.y)  * (end.color.getGreen() - start.color.getGreen()) + start.color.getGreen() );
                a = (int) ( ((float) y - start.y) / ((float) end.y - start.y)  * (end.color.getAlpha() - start.color.getAlpha()) + start.color.getAlpha());
            } else {
                r = (int) ( ((float) x - start.x) / ((float) end.x - start.x)  * (end.color.getRed() - start.color.getRed()) + start.color.getRed() );
                g = (int) ( ((float) x - start.x) / ((float) end.x - start.x)  * (end.color.getBlue() - start.color.getBlue()) + start.color.getBlue() );
                b = (int) ( ((float) x - start.x) / ((float) end.x - start.x)  * (end.color.getGreen() - start.color.getGreen()) + start.color.getGreen() );
                a = (int) ( ((float) x - start.x) / ((float) end.x - start.x)  * (end.color.getAlpha() - start.color.getAlpha()) + start.color.getAlpha() );
            }
       
            Color color = new Color((int) r, (int) g, (int) b, (int) a);
            
            points.add(new Point(x,y, color));
            if(x == end.x && y == end.y) break;
           
            int e2 = 2 * error;
            
            if( e2 > (-dy) ) {
               error -= dy;
               x += sx;
            }
            if( e2 < dx ) {
                error += dx;
                y += sy;
            }
        }
            
    }
}
