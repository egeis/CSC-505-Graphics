package main.java.com.graphics.shapes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import main.java.com.graphics.shapes.utils.GraphicsObject;
import main.java.com.graphics.shapes.utils.Point;

/**
 *
 * @author Richard Coan
 */

public class Triangle extends GraphicsObject {
    
    public Triangle(Point p1, Point p2, Point p3)
    {        
        points.addAll(new Line(p1, p2).getPoints());
        points.addAll(new Line(p2, p3).getPoints());
        points.addAll(new Line(p1, p3).getPoints());
        
        Set<Point> completed = new HashSet();
               
        while(points.size() > 0)
        {
            Iterator iter = points.iterator();
            Point s1 = (Point) iter.next();
            points.remove(s1);
            
            Point s2 = null;
            
            boolean sP = false;
            for(Point p : points)
            {
                if(s1.x == p.x)
                {
                    s2 = p;
                    points.remove(p);
                    sP = true;
                    break;
                }
            }
            
            if(sP)
            {
                completed.addAll(new Line(s1, s2).getPoints());
            } else {
                completed.add(s1);
            }
        }
        
        points.clear();
        points.addAll(completed);
    }
    
}