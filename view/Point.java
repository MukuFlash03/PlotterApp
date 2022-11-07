package view;

import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class plots the randomly generated points in the GUI and connects them with the line
 * forming line graph for the points.
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
 * */
public class Point implements PlotComponent {
    private static final Color GRAPH_COLOR = Color.black;
    private static final Color GRAPH_POINT_COLOR = Color.blue;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final int GRAPH_POINT_WIDTH = 4;

    /**
     * Overrides the method operation in parent class. This function draws the plotted points
     * and connects them with a line graph.
     * @param g object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
     */
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        if (coordinates != null) {
            Graphics2D g2 = (Graphics2D) g;

            Stroke oldStroke = g2.getStroke();
            g2.setColor(GRAPH_COLOR);
            g2.setStroke(GRAPH_STROKE);
            for (int i = 0; i < coordinates.size() - 1; i++) {
                int x1 = coordinates.get(i).getX();
                int y1 = coordinates.get(i).getY();
                int x2 = coordinates.get(i + 1).getX();
                int y2 = coordinates.get(i + 1).getY();
                g2.drawLine(x1, y1, x2, y2);
            }

            g2.setStroke(oldStroke);
            g2.setColor(GRAPH_POINT_COLOR);
            for (int i = 0; i < coordinates.size(); i++) {
                int x = coordinates.get(i).getX() - GRAPH_POINT_WIDTH / 2;
                int y = coordinates.get(i).getY() - GRAPH_POINT_WIDTH / 2;
                g2.fillOval(x, y, GRAPH_POINT_WIDTH, GRAPH_POINT_WIDTH);
            }
        }
    }
}