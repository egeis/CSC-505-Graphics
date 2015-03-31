package main.java.com.graphics.shapes.utils;

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import main.java.com.graphics.Graphics;
import main.java.com.graphics.shapes.Line;

/**
 * Parent Abstract Shape Class to all shapes.
 * Handle drawing of the shape object.
 * @author Richard Coan
 */
public abstract class GraphicsObject {
    
    protected Set<Point> points = new HashSet();

    public Set<Point> getPoints() {
        return points;
    }
    
    public void draw(boolean fill)
    {
       if(fill)
       {
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
                    if(s1.y == p.y)
                    {
                        s2 = p;
                        //points.remove(p);
                        sP = true;
                        break;
                    }
                }

                if(sP)
                {
                    completed.addAll(new Line(s1, s2).getPoints());
                } else {
                    System.out.println(s1 + " : was alone...");
                    completed.add(s1);
                }
            }

            points.clear();
            points.addAll(completed);
       }
       
       this.draw();
    }
    
    public void draw()
    {        
        int t = 0;
        double r, g, b, a;
        Color color;
        
        System.out.println(Graphics.img[3][300][300]);
        
        for(Point p : points) {
            //Handles Out of Bounds
            if(p.x < 0 || p.x > (Graphics.WIDTH - 1) 
                    || p.y < 0 || p.y > (Graphics.HEIGHT - 1)) continue;
            
            //Handles Depth (objects drawn from closest first).
            if( Graphics.img[3][p.y][p.x] == 255) 
            {
                System.out.println(p + " : is already used...");
                continue;
            } else if(Graphics.img[3][p.y][p.x] != 0)
            {
                //Blending the old color with the new color.
                //Source for blending: http://www.java2s.com/Code/Java/2D-Graphics-GUI/Blendtwocolors.htm
                double totalAlpha = Graphics.img[3][p.y][p.x] + p.color.getAlpha();
                double weight0 =  Graphics.img[3][p.y][p.x] / totalAlpha;
                double weight1 =  p.color.getAlpha() / totalAlpha;

                r = weight0 *  Graphics.img[0][p.y][p.x] + weight1 * p.color.getRed();
                g = weight0 *  Graphics.img[1][p.y][p.x] + weight1 * p.color.getGreen();
                b = weight0 *  Graphics.img[2][p.y][p.x] + weight1 * p.color.getBlue();
                a = Math.max( Graphics.img[3][p.y][p.x], p.color.getAlpha());
                
                if(a == 0) System.out.println("error");
                
                color = new Color((int) r, (int) g, (int) b, (int) a);
            } else {
                color = p.color;
            }

            //Setting the color data to the image.
            Graphics.img[0][p.y][p.x] = color.getRed();
            Graphics.img[1][p.y][p.x] = color.getGreen();
            Graphics.img[2][p.y][p.x] = color.getBlue();
            Graphics.img[3][p.y][p.x] = color.getAlpha();
        }
    }
    
}
