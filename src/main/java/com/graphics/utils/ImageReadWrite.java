package main.java.com.graphics.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Richard Coan
 */
public class ImageReadWrite {
    
    public static int[][][] ImageRead(String filename) {
        try {
            // -- read input image
            File infile = new File(filename);
            BufferedImage bi = ImageIO.read(infile);
            // -- separate image into RGB components
            int img[][][] = new int[3][bi.getHeight()][bi.getWidth()];
            for (int i = 0; i < img[0].length; ++i) {
                for (int j = 0; j < img[0][i].length; ++j) {
                    img[0][i][j] = bi.getRGB(j, i) >> 16 & 0xFF;
                    img[1][i][j] = bi.getRGB(j, i) >> 8 & 0xFF;
                    img[2][i][j] = bi.getRGB(j, i) & 0xFF;
                }
            }
           return img;
        } catch (IOException e) {
            System.out.println("image I/O error");
            return null;
        }
    }
    
    public static void ImageWrite(int img[][][], String filename) {
        try {
            BufferedImage bi = new BufferedImage(img[0][0].length, img[0].length, BufferedImage.TYPE_INT_ARGB);

            // -- prepare output image
            for (int i = 0; i < bi.getHeight(); ++i) {
                for (int j = 0; j < bi.getWidth(); ++j) {
                            //int pixel =	(img[0][i][j] << 16) | (img[1][i][j] << 8) | (img[2][i][j]);
                            int pixel =	(img[0][i][j] << 16) | (img[1][i][j] << 8) | (img[2][i][j]) | (img[3][i][j] << 24);
                            bi.setRGB(j, i, pixel);
                    }
            }

            // -- write output image
            File outputfile = new File(filename);
            ImageIO.write(bi, "png", outputfile);	
        } catch (IOException e) {}
    }
}