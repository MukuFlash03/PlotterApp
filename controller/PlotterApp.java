package controller;

import model.DataSource;
import view.Bar;
import view.PlotPanel;
import view.Point;
import view.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class serves as the starting point for the programming logic flow
 * for the Plotter App software developed.
 * Objects for relevant classes have been used to achieve this in an efficient manner.
 * 
 * The following Software Design Patterns have been used with their respective classes mentioned:
 * 1. Observable - DataSource, PlotPanel
 * 2. Decorator - PlotComponent, PlotDecorator, Point, Square, Bar
 * 3. Singleton - AverageEvaluator
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
 */

public class PlotterApp extends JFrame implements ActionListener {

    DataSource source;

    public PlotterApp() {
        JButton run = new JButton("Generate Plots");

        Point point = new Point();
        Square square = new Square();
        Bar bar = new Bar();

        square.setComponent(point);
        bar.setComponent(square);
        
        PlotPanel simplePlot = new PlotPanel("Simple Plot", point);
        PlotPanel squarePlot = new PlotPanel("Square Plot", square);
        PlotPanel barPlot = new PlotPanel("Bar Plot", bar);

        this.source = new DataSource();
        source.addObserver(simplePlot);
        source.addObserver(squarePlot);
        source.addObserver(barPlot);
    
        setLayout(new GridLayout(4,1));
        add(barPlot);
        add(squarePlot);
        add(simplePlot);
        add(run);
        run.addActionListener(this);
    }
    
    /**
     * Starting point of Plotter App software programming logic flow.
     * Generates a GUI application window where user can execute plotting mechanism.
     * @param args Stores input data file path passed as command line argument
     */
    public static void main(String[] args) {
        JFrame window = new PlotterApp();
        window.setSize(700,1000);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes a Timer to introduce delay.
     * Implements repetitive application execution.
     * Used to achieve synchronization between generating and plotting them.
     */
    public void setTimer() {
        Timer sleepTimer = new Timer(2500, this);
        sleepTimer.start(); 
        sleepTimer.setRepeats(true);
        sleepTimer.setCoalesce(true);
        sleepTimer.setInitialDelay(0); 
    }

    /**
     * Defines instructions to be executed when GUI button-click event is triggered by user:
     * 1. Datasource generates random coordinates.
     * 2. Observable class Datasource calls its setter method with generated coordinates.
     * 3. This results in a call to Observer class PlotPanel to draw plots on GUI.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        setTimer();
        source.generateCoordinates();
        source.setCoordinates(source.getCoordinates());
        source.printPoints();
    }
}