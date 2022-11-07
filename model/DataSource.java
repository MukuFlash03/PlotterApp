package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class serves as the source that generates data points 
 * which are used to plot coordinates in the GUI.
 * It is an extension of the built-in Observable class and implements the Observer design pattern.
 * It is used to achieve the functionality of notifying the Observer class PlotPanel 
 * as soon as it has finished generating data points.
 * 
 * @author Mukul Mahadik
 * @version 1.0
 */
public class DataSource extends Observable {
    private List<Integer> scores;
    private final int numberCoordinates = 30;
    private final int minLimit = 0;
    private final int maxLimit = 50;


     /** 
     * Returns list of randomly generated data values
     */  
    public List<Integer> getCoordinates() {
        return this.scores;
    }

    /** 
     * Sets list of randomly generated data values
     * Calls the inherited methods from parent Observable class 
     * which triggers the update() method in corresponding Observer class
     * to draw plots on GUI
     */
    public void setCoordinates(List<Integer> scores) {
        this.scores = scores;
        setChanged();
        notifyObservers();
    }

     /** 
     * Returns maximum upper limit of randomly generated data values
     */ 
    public int getMaximumValue() {
        return this.maxLimit;
    }

     /** 
     * Generates data values randomly within the specified lower and upper limits.
     * These values serve as coordinates to be plotted on GUI.
     */ 
    public void generateCoordinates() {
        scores = new ArrayList<Integer>();

        for (int i = 1; i <= numberCoordinates; i++) {
            scores.add(ThreadLocalRandom.current().nextInt(minLimit,maxLimit));
        }
    }

     /** 
     * Prints data values in console.
     */ 
    public void printPoints() {
        for (int i = 0; i < scores.size(); i++)
            System.out.print(scores.get(i) + " ");
        System.out.println();
    }
}
