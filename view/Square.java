package view;

import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

public class Square extends PlotDecorator {
    private static final int GRAPH_SQUARE_WIDTH = 8;
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
