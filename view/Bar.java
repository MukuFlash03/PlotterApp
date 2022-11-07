package view;

import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

public class Bar extends PlotDecorator {
    private static final int BORDER_GAP = 30;
    private final int width = 700;
    private final int height = 250;
    private static final Stroke GRAPH_BAR_STROKE = new BasicStroke(6f);
    private static final int GRAPH_POINT_WIDTH = 8;
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
                int x2 = i * (this.width - BORDER_GAP * 2) / (coordinates.size() - 1) + BORDER_GAP;
                int y2 =this.height - BORDER_GAP - GRAPH_POINT_WIDTH / 3;
                g2.drawLine(x1, y1, x2, y2);
            }
        }
    }
}
