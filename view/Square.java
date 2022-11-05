package view;

import java.awt.*;
import java.util.ArrayList;
import model.Coordinate;

public class Square extends PlotDecorator {
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        super.operation(g, coordinates);
        System.out.println("Square: operation()");

        g.setColor(Color.RED);
        if (coordinates != null) {
            for(int i = 0; i < coordinates.size()-1; i++) {
                Coordinate a = coordinates.get(i);
                Coordinate b = coordinates.get(i+1);
                g.fillRect((int) a.getX(), (int) a.getY(), 5, 5);
                if (i == coordinates.size()-2)
                    g.fillRect((int) b.getX(), (int) b.getY(), 5, 5);
            }
        }
    }
}
