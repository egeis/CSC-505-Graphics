package main.java.com.graphics.images;

/**
 *
 * @author Richard Coan
 */
public class Filter {
    
    
    public static int[][][] getYPbPr(int img[][][])
    {        
        double[][] matrix = {
            {0.299, 0.587, 0.114},
            {-0.168, -0.331, 0.500},
            {0.500, -0.418, -0.081}
        };
        
        int[][][] YPbPr = new int[3][img[0].length][img[0][0].length];

        System.out.println(img.length + " " + img[0].length);
        
        for(int x = 0; x < img[0].length; ++x)
        {
            for (int y = 0; y < img[0][x].length; ++y)
            {
                YPbPr[0][x][y] = (int) ((matrix[0][0] * img[0][x][y]) + (matrix[0][1] * img[1][x][y]) + (matrix[0][2] * img[2][x][y]));
                YPbPr[1][x][y] = 127 + (int) ((matrix[1][0] * img[0][x][y]) + (matrix[1][1] * img[1][x][y]) + (matrix[1][2] * img[2][x][y]));
                YPbPr[2][x][y] = 127 + (int) ((matrix[2][0] * img[0][x][y]) + (matrix[2][1] * img[1][x][y]) + (matrix[2][2] * img[2][x][y]));
            }
        }
        
        return YPbPr;
    }
    
    public static int[][][] convertToRGB(int[][][] img)
    {
        double[][] matrix = {
            {1.0, 0.0, 1.402},
            {1.0, -0.344, -0.714},
            {1.0, 1.772, 0.0}
        };
        
        int[][][] color = new int[4][img.length][img[0].length];
                
        for(int x = 0; x < img[0].length; ++x)
        {
            for (int y = 0; y < img[0][x].length; ++y)
            {
                color[0][x][y] = (int) ((matrix[0][0] * img[0][x][y]) + (matrix[0][1] * img[1][x][y]) + (matrix[0][2] * img[2][x][y]));
                color[1][x][y] = (int) ((matrix[1][0] * img[0][x][y]) + (matrix[1][1] * img[1][x][y]) + (matrix[1][2] * img[2][x][y]));
                color[2][x][y] = (int) ((matrix[2][0] * img[0][x][y]) + (matrix[2][1] * img[1][x][y]) + (matrix[2][2] * img[2][x][y]));
            }
        }        
        
        System.out.println(color);        
                
        return color;
    }
    
    public static int[][][] converToDither(int[][] img)
    {
        int[][][] color = new int[4][img.length][img[0].length];
        
        //Write Alpha Channel
        for(int x = 0; x < img.length; ++x)
        {
            for (int y = 0; y < img[x].length; ++y)
            {
                color[3][x][y] = 255;
            }
        }
        
        //Color Data
        for(int x = 0; x < img.length; ++x)
        {
            for (int y = 0; y < img[x].length; ++y)
            {
                int threshold = 127;
                int pixel = (img[x][y] < threshold)?0:255;
                int error = img[x][y] - pixel;
                
                color[0][x][y]    += pixel;
                
                if(x+1 < img.length) 
                    img[x+1][y]    += (int) ((7.0*error)/16.0);
                if(x-1 > 0 && y+1 < img[x].length) 
                    img[x-1][y+1]  += (int) ((3.0*error)/16.0);
                if(y+1 < img[x].length) 
                    img[x][y+1]    += (int) ((5.0*error)/16.0);
                if(x+1 < img.length && y+1 < img[x].length) 
                    img[x+1][y+1]  += (int) ((1.0*error)/16.0);
            }
        }
        
        //Write other channels
        for(int x = 0; x < img.length; ++x)
        {
            for (int y = 0; y < img[x].length; ++y)
            {
                color[1][x][y] = color[0][x][y];
                color[2][x][y] = color[0][x][y];
            }
        }
        
        return color;
    }
    
    public static int[][][] converToThreshold(int[][] img)
    {
        int[][][] color = new int[4][img.length][img[0].length];
        
        for(int x = 0; x < img.length; ++x)
        {
            for (int y = 0; y < img[x].length; ++y)
            {
               int threshold = 127;
               int g = (img[x][y] < threshold)?0:255;
                
                color[0][x][y] = g;
                color[1][x][y] = g;
                color[2][x][y] = g;
                
                color[3][x][y] = 255;
            }
        }
        
        return color;
    }
    
    
    public static int[][][] converToGamma(int[][] img)
    {
        int[][][] color = new int[4][img.length][img[0].length];
        
        for(int x = 0; x < img.length; ++x)
        {
            for (int y = 0; y < img[x].length; ++y)
            {
                double Y = 1.6;
                int g = (int) (255 * Math.pow(((1.0 * img[x][y]) / 255.0), (1.0/Y)));
                
                color[0][x][y] = g;
                color[1][x][y] = g;
                color[2][x][y] = g;
                
                color[3][x][y] = 255;
            }
        }
        
        return color;
    }
    
    public static int[][][] convertToRGB(int[][] img)
    {
        int[][][] color = new int[4][img.length][img[0].length];
        
        for(int x = 0; x < img.length; ++x)
        {
            for (int y = 0; y < img[x].length; ++y)
            {
                color[0][x][y] = img[x][y];
                color[1][x][y] = img[x][y];
                color[2][x][y] = img[x][y];
                color[3][x][y] = 255;
            }
        }
               
        return color;
    }
    
}
