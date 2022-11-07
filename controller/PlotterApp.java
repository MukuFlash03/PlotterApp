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
    
    public static void main(String[] args) {
        JFrame window = new PlotterApp();
        window.setSize(700,1000);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        source.generateCoordinates();
        source.setCoordinates(source.getCoordinates());
        source.printPoints();
    }
}