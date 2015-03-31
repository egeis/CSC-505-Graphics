package main.java.com.graphics;

import java.awt.Color;
import main.java.com.graphics.shapes.Circle;
import main.java.com.graphics.shapes.Line;
import main.java.com.graphics.shapes.Triangle;
import main.java.com.graphics.shapes.utils.Point;
import main.java.com.graphics.utils.ImageReadWrite;

/**
 *
 * @author Richard Coan
 */
public class Graphics {

    public static int img[][][];
    public static int WIDTH = 800;
    public static int HEIGHT = 800;   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        img = new int[4][WIDTH][HEIGHT];
        
//         Circle c = new Circle(300,100,0,100, Color.RED);
//         c.draw();
//         
//         Line d = new Line(new Point(300,100, Color.RED), new Point(300,300, Color.WHITE) );
//         d.draw();
        
        //Reflection
         Triangle t1 = new Triangle(new Point(10,400, new Color(255,0,0,255)), new Point(10,700, new Color(255,0,0,255)), new Point(300,700, new Color(255,0,0,255)));
         t1.draw(true);
         
         Triangle t3 = new Triangle(new Point(301,700, new Color(255,0,0,255)), new Point(590,700, new Color(255,0,0,255)), new Point(590,400, new Color(255,0,0,255)));
         t3.draw(true);
         
         //Multiple Colors
         Triangle t2 = new Triangle(new Point(10,10, new Color(255,0,0,255)), new Point(10,300, new Color(0,0,255,255)), new Point(300,300, new Color(0,255,0,255)));
         t2.draw(true);
         
         //Transparent Test
         Triangle t4 = new Triangle(new Point(300,10, new Color(100,160,0,150)), new Point(300,300, new Color(100,160,0,150)), new Point(600,300, new Color(100,160,0,150)));
         t4.draw(true);
         
         Triangle t5 = new Triangle(new Point(120,10, new Color(255,0,0,50)), new Point(500,300, new Color(120,0,0,50)), new Point(300,300, new Color(120,0,0,50)));
         t5.draw(true);
         
         ImageReadWrite.ImageWrite(img, "graphics.png");
        
    }
    
}
