package view;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.Coordinate;
import model.DataSource;

import java.awt.Color;
import java.awt.*;

import java.util.Observer;
import java.util.Observable;

import java.util.ArrayList;

public class PlotPanel extends JPanel implements Observer {
    JLabel label = new JLabel();
    JLabel captionLabel = new JLabel();

    private ArrayList<Coordinate> coordinates;

    public PlotPanel(String caption) {
        // Initialize JPanel
        this.setBackground(Color.lightGray);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
        captionLabel.setText(caption);
        add(captionLabel);
        add(label);
    }

    @Override
    public void update(Observable o, Object arg) {
        // String data = ((DataSource) o).getData();
        // label.setText(data);
        this.coordinates = ((DataSource) o).getCoordinates();
        repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        pointPlot(g);
    }
    

    private void pointPlot(Graphics g) {

        if (this.coordinates != null) {
            // System.out.println("I am here");
            for (Coordinate xy : this.coordinates) {
                g.fillOval((int) xy.getX(), (int) xy.getY(), 5, 5);
                g.setColor(Color.RED);
            }
        }
        /*
        else {
            g.fillOval((int)333.0, (int)324.0,  5, 5);
            g.setColor(Color.RED);
        }
        */
    }
}
