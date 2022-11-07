package view;

import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is one of the concrete class for Plot Decorator. It adds bar to the
 * already plotted square points in the GUI.
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
* */
public class Bar extends PlotDecorator {
    private static final Stroke GRAPH_BAR_STROKE = new BasicStroke(6f);
    private static final int GRAPH_POINT_WIDTH = 8;

    /**
     * Overrides the method operation in parent class. This function draws the bar for the already plotted points.
     * @param g object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
     */
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        super.operation(g, coordinates);

        if (coordinates != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.GRAY);
            g2.setStroke(GRAPH_BAR_STROKE);
            for (int i = 0; i < coordinates.size(); i++) {
                int x1 = coordinates.get(i).getX();
                int y1 = coordinates.get(i).getY() + GRAPH_POINT_WIDTH - 1;
                g2.drawLine(x1, y1, x1, 250);
            }
        }
    }
}
