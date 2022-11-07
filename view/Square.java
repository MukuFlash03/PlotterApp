package view;

import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is one of the concrete class for Plot Decorator. It plots the randomly generated
 * points in square shape in the GUI.
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
 * */
public class Square extends PlotDecorator {
    private static final int GRAPH_SQUARE_WIDTH = 8;

    /**
     * Overrides the method operation in parent class. This function draws the plotted points in square shape.
     * @param g object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
     */
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        super.operation(g, coordinates);

        if (coordinates != null) {
            g.setColor(Color.BLUE);
            for (int i = 0; i < coordinates.size(); i++) {
                int x = coordinates.get(i).getX() - GRAPH_SQUARE_WIDTH / 2;
                int y = coordinates.get(i).getY() - GRAPH_SQUARE_WIDTH / 2;
                g.fillRect(x, y, GRAPH_SQUARE_WIDTH, GRAPH_SQUARE_WIDTH);
            }
        }
    }
}
