package view;

import java.awt.*;
import java.util.ArrayList;
import model.Coordinate;

public class Point implements PlotComponent {
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        System.out.println("Point: operation()");

        g.setColor(Color.BLUE);
        if (coordinates != null) {
            for(int i = 0; i < coordinates.size()-1; i++) {
                Coordinate a = coordinates.get(i);
                Coordinate b = coordinates.get(i+1);
                g.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
            }
        }
    }
}