package view;

import java.awt.*;
import java.util.ArrayList;
import model.Coordinate;

public class Bar extends PlotDecorator {
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        super.operation(g, coordinates);
        System.out.println("Bar: operation()");

        g.setColor(Color.GRAY);
        if (coordinates != null) {
            for(int i = 0; i < coordinates.size()-1; i++) {
                Coordinate a = coordinates.get(i);
                Coordinate b = coordinates.get(i+1);
                g.fillRect((int) a.getX(), (int) a.getY(), 3, 270);

                if (i == coordinates.size()-2)
                    g.fillRect((int) b.getX(), (int) b.getY(), 3, 270);
            }
        }
    }
}
