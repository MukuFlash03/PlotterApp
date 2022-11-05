package view;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.AverageEvaluator;
import model.Coordinate;
import model.DataSource;

import java.awt.Color;
import java.awt.*;

import java.util.Observer;
import java.util.Observable;

import java.util.ArrayList;

public class PlotPanel extends JPanel implements Observer {
    
    private PlotComponent component;
    
    JLabel label = new JLabel();
    JLabel captionLabel = new JLabel();

    private ArrayList<Coordinate> coordinates;
    private double averageLineValue;

    public PlotPanel(String caption, PlotComponent component) {
        this.component = component;
        this.setBackground(Color.white);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
        captionLabel.setText(caption);
        add(captionLabel);
        add(label);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.coordinates = ((DataSource) o).getCoordinates();
        
        // Singleton objects
        AverageEvaluator average = AverageEvaluator.getInstance();
        average.calculate(coordinates);
        this.averageLineValue = average.getAverage();
        repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        plotAverageLine(g);
        this.component.operation(g, this.coordinates);
    }

    private void plotAverageLine(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.drawLine(0, (int) this.averageLineValue, 1920, (int) this.averageLineValue);
    }
}