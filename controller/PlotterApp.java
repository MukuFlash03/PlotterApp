package controller;

import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.*;

import model.AverageEvaluator;
import model.DataSource;
import view.Bar;
import view.PlotPanel;
import view.Point;
import view.Square;

public class PlotterApp extends JFrame implements ActionListener {

    DataSource source;

    public PlotterApp() {
        JButton run = new JButton("Generate Plots");
        
        // Observer objects
        PlotPanel simplePlot = new PlotPanel("Simple Plot");
        PlotPanel squarePlot = new PlotPanel("Square Plot");
        PlotPanel barPlot = new PlotPanel("Bar Plot");

        source = new DataSource();
        source.addObserver(simplePlot);
        source.addObserver(squarePlot);
        source.addObserver(barPlot);
    
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

        
        // Decorator objects
        Point point = new Point();
        Square square = new Square();
        Bar bar = new Bar();

        square.setComponent(point);
        bar.setComponent(square);
        bar.operation();


        // Singleton objects
        AverageEvaluator average = AverageEvaluator.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        source.generateCoordinates();
        // source.setData("Data");
        source.setData(source.getCoordinates());
        source.printPoints();
    }
}