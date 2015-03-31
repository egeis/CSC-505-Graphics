package main.java.com.graphics.shapes.utils;

import java.awt.Color;

/**
 *
 * @author Richard Coan
 */

public class Point extends java.awt.Point {
    public Color color = Color.red;
    
    public Point(int x, int y, Color color)
    {
        super(x, y);
        this.color = color;
    }
}
