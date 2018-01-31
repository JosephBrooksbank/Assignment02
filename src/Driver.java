import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Joseph Brooksbank
 * @version 1/20/2018
 * Driver class for new StdDraw methods 
 */
public class Driver {

    /** Number of pixels for canvas */
    private static final int CANVAS_SIZE = 500;
    /** Scale of canvas, number of squares in grid */
    private static final int CANVAS_SCALE = 5;

    /**
     * Main Method for driver
     * @param args  commandline arguments
     */
    public static void main(String[] args) {
        UnStdDraw test = new UnStdDraw();

        StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
        StdDraw.setXscale(0, CANVAS_SCALE);
        StdDraw.setYscale(0, CANVAS_SCALE);

        StdDraw.setPenColor(UnStdDraw.CHARTREUSE);
        test.RegularNgon(1,1, 0.5, 4);
        StdDraw.setPenColor(UnStdDraw.NEON_CARROT);
        test.spiral(3, 3, 0.5, 90, 10);

        System.out.println(UnStdDraw.getNumberofNgons());
        System.out.println(UnStdDraw.getNumberOfSpirals());

    }
}
