package controller;

import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.*;

import model.DataSource;
import view.Bar;
import view.PlotPanel;
import view.Point;
import view.Square;

public class PlotterApp extends JFrame implements ActionListener {

    // Observable objects
    DataSource source;

    public PlotterApp() {
        JButton run = new JButton("Generate Plots");

        // Decorator objects
        Point point = new Point();
        Square square = new Square();
        Bar bar = new Bar();

        square.setComponent(point);
        bar.setComponent(square);
        
        // Observer objects
        PlotPanel simplePlot = new PlotPanel("Simple Plot", point);
        PlotPanel squarePlot = new PlotPanel("Square Plot", square);
        PlotPanel barPlot = new PlotPanel("Bar Plot", bar);

        this.source = new DataSource();
        this.source.addObserver(simplePlot);
        this.source.addObserver(squarePlot);
        this.source.addObserver(barPlot);

        System.out.println("Height: " + simplePlot.getSize().getHeight());
        System.out.println("Width: " + simplePlot.getSize().getHeight());
    
        setLayout(new GridLayout(4,1));
        add(barPlot);
        add(squarePlot);
        add(simplePlot);
        add(run);
        run.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        JFrame window = new PlotterApp();
        window.setSize(500,500);
        window.setVisible(true);
    }

    public void setTimer() {
        Timer sleepTimer = new Timer(2500, this);
        sleepTimer.start(); 
        sleepTimer.setRepeats(true);
        sleepTimer.setCoalesce(true);
        sleepTimer.setInitialDelay(0); 
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setTimer();
        this.source.generateCoordinates();
        this.source.setCoordinates(this.source.getCoordinates());
        this.source.printPoints();    
    }
}