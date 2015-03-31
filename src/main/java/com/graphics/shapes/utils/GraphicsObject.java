package main.java.com.graphics.shapes.utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import main.java.com.graphics.Graphics;

/**
 *
 * @author Richard Coan
 */


public abstract class GraphicsObject {
    
    protected Set<Point> points = new HashSet<Point>();

    public Set<Point> getPoints() {
        return points;
    }
    
    public void draw()
    {        
        int t = 0;
        
        for(Point p : points) {
            //Handles Out of Bounds
            if(p.x < 0 || p.x > (Graphics.WIDTH - 1) 
                    || p.y < 0 || p.y > (Graphics.HEIGHT - 1)) continue;
            
            //Handles Depth (objects drawn from closest first).
            if( Graphics.img[3][p.y][p.x] == 255) 
            {
                System.out.println("a");
                continue;
            }
                       
            //Blending the old color with the new color.
//            double totalAlpha = Graphics.img[3][p.y][p.x] + p.color.getAlpha();
//            double weight0 =  Graphics.img[3][p.y][p.x] / totalAlpha;
//            double weight1 =  Graphics.img[3][p.y][p.x] / totalAlpha;
//
//            double r = weight0 *  Graphics.img[0][p.y][p.x] + weight1 * p.color.getRed();
//            double g = weight0 *  Graphics.img[1][p.y][p.x] + weight1 * p.color.getGreen();
//            double b = weight0 *  Graphics.img[2][p.y][p.x] + weight1 * p.color.getBlue();
//            double a = Math.max( Graphics.img[3][p.y][p.x], p.color.getAlpha());
//            
//            Color color = new Color((int) r, (int) g, (int) b, (int) a);
            
            Color color = p.color;
            
            //Setting the color data to the image.
            Graphics.img[0][p.y][p.x] = color.getRed();
            Graphics.img[1][p.y][p.x] = color.getGreen();
            Graphics.img[2][p.y][p.x] = color.getBlue();
            Graphics.img[3][p.y][p.x] = color.getAlpha();
        }
    }
    
}
