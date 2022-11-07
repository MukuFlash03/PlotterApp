package model;
/**
 * This class models a Coordinate class based on inbuilt Point class.
 * It stores X and Y coordinate values of Integer type.
 * 
 * @author Mukul Mahadik
 * @version 1.0
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** 
     * Returns X coordinate of point
     */
    public int getX() {
        return x;
    }

    /** 
     * Sets X coordinate of point
     */
    public void setX(int x) {
        this.x = x;
    }

    /** 
     * Sets Y coordinate of point
     */
    public void setY(int y) { 
        this.y = y; 
    }

    /** 
     * Returns Y coordinate of point
     */
    public int getY() {
        return y;
    }
}