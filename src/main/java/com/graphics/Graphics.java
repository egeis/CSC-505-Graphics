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
         
//        Line d1 = new Line(new Point(10,10, Color.RED), new Point(10,300, Color.BLUE));
//        Line d2 = new Line(new Point(10,300, Color.BLUE), new Point(300,300, Color.GREEN));
//        Line d3 = new Line(new Point(10,10, Color.RED), new Point(300,300, Color.GREEN));
//        
//        d1.draw();
//        d2.draw();
//        d3.draw();
        
         Triangle t1 = new Triangle(new Point(10,400, Color.RED), new Point(10,700, Color.RED), new Point(300,700, Color.RED));
         t1.draw();
         
         Triangle t2 = new Triangle(new Point(10,10, Color.RED), new Point(10,300, Color.BLUE), new Point(300,300, Color.GREEN));
         t2.draw();
         
         ImageReadWrite.ImageWrite(img, "test1.png");
        
    }
    
}
