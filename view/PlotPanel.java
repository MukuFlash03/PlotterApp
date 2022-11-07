package view;

import model.AverageEvaluator;
import model.Coordinate;
import model.DataSource;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PlotPanel extends JPanel implements Observer {
    
    private PlotComponent component;
    
    JLabel label = new JLabel();
    JLabel captionLabel = new JLabel();
    private static final int PREF_W = 700;
    private static final int PREF_H = 250;
    private static final int BORDER_GAP = 30;
    private int MAX_VALUE;

    private ArrayList<Coordinate> coordinates;
    private List<Integer> scores;
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
        this.scores = ((DataSource) o).getCoordinates();
        this.MAX_VALUE = ((DataSource) o).getMaximumValue();
        scaleCoordinates();
        // Singleton objects
        AverageEvaluator average = AverageEvaluator.getInstance();
        average.calculate(scores);
        this.averageLineValue = average.getAverage();
        repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        plotAverageLine(g);
        this.component.operation(g, this.coordinates);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private void plotAverageLine(Graphics g) {
        double yScale= ((double) getHeight() - 2 * BORDER_GAP) / MAX_VALUE;
        int y1 = (int) ((MAX_VALUE - this.averageLineValue) * yScale + BORDER_GAP);
        g.setColor(Color.MAGENTA);
        g.drawLine(0, y1, getWidth(), y1);
    }

    private void scaleCoordinates() {
        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (scores.size()-1);
        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / MAX_VALUE;

        this.coordinates = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((MAX_VALUE - scores.get(i)) * yScale + BORDER_GAP);
            Coordinate coordinate = new Coordinate(x1, y1);
            this.coordinates.add(coordinate);
        }
    }
}