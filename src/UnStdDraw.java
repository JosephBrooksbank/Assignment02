import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

/**
 * @author Joseph Brooksbank
 * @version 1/20/2018
 * Adds new methods to the StdDraw class
 */
public class UnStdDraw {
    /** New color, "neon carrot". bright orangish */
    public static final Color NEON_CARROT = new Color(255, 163, 67);
    /** New color "chartreuse", a really awful neon green */
    public static final Color CHARTREUSE = new Color(127, 255,0);
    /** New color "periwinkle", a nice light blue */
    public static final Color PERIWINKLE = new Color(49, 140, 206);

    /** Count for number of Ngons created */
    private static int numberofNgons = 0;
    /** Count for number of Spirals created */
    private static int numberOfSpirals = 0;

    /**
     * Getter for number of Ngons
     * @return  Number of Ngons
     */
    public static int getNumberofNgons(){
        return numberofNgons;
    }

    /**
     * Getter for number of Spirals
     * @return  number of Spirals
     */
    public static int getNumberOfSpirals(){
        return  numberOfSpirals;
    }

    /**
     * A method which creates polygons of any size
     * @param centerX   The center X value of the polygon
     * @param centerY   The center Y value of the polygon
     * @param radius    The radius of the polygon
     * @param n         The number of sides of the polygon
     */
    void RegularNgon(double centerX, double centerY, double radius, int n){
        // Shapes under 3 sides are impossible
        if (n < 3){
            throw new IllegalArgumentException("Not a valid number of sides!");
        }
        /* Angle for each corner */
        double angle = 360 / n;
        /* Array for X coordinates */
        double[] xValues = new double[n];
        /* Array for Y coordinates */
        double[] yValues = new double[n];

        for (int i = 0; i < n; i++){
            //  Using RADIANS (degree to rad = degree * pi / 180)
            xValues[i] = centerX + radius*Math.cos((angle* (i+1))*Math.PI /180);
            yValues[i] = centerY + radius*Math.sin((angle * (i+1)) * Math.PI / 180);
        }

        StdDraw.filledPolygon(xValues, yValues);
        // increasing count of how many Ngons have been made */
        numberofNgons++;
    }

    /**
     * Method to create a spiral design
     * @param centerX       The X value of the center
     * @param centerY       The Y value of the center
     * @param maxRadius     The outer radius of the spiral
     * @param spinRate      How fast the spiral curves
     * @param numSegments   How many lines there are in the spiral
     */
    void spiral(double centerX, double centerY, double maxRadius, double spinRate, int numSegments){
        //NOTE things might get weird with high spin rates

        /* X coordinates */
        double[] xValues = new double[numSegments+1];
        /* Y coordinates */
        double[] yValues = new double[numSegments+1];

        /* Radius of smallest "circle" for creating spiral points */
        double radius =  maxRadius / numSegments;

        /* Creating points, based off of circles with increasing radii up to the max radius */
        for (int i  = 0; i <= numSegments; i++){
            xValues[i] = centerX + i*radius*Math.cos((spinRate * (i+1)) * Math.PI / 180);
            yValues[i] = centerY + i*radius*Math.sin((spinRate * (i+1)) * Math.PI / 180);
         }

        /* Creating first segment from the center */
        StdDraw.line(centerX, centerY, xValues[0], yValues[0]);
        /* Creating rest of line segments, from point to point */
        for (int i = 1; i <= numSegments; i++){
            StdDraw.line(xValues[i-1], yValues[i-1], xValues[i], yValues[i]);
        }
        numberOfSpirals++;
    }


}
