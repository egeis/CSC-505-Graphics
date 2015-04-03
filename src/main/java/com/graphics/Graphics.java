package main.java.com.graphics;

import java.awt.Color;
import main.java.com.graphics.images.Filter;
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
        img = ImageReadWrite.ImageRead(args[0]);
        
        int[][][] lum = Filter.getYPbPr(img);
        ImageReadWrite.ImageWrite(Filter.convertToRGB(lum[0]), "luminance.png");
        ImageReadWrite.ImageWrite(Filter.convertToRGB(lum[1]), "bluechrominance.png");
        ImageReadWrite.ImageWrite(Filter.convertToRGB(lum[2]), "redchrominance.png");
         
    }
    
}
