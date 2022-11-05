package view;

import java.awt.*;
import java.util.ArrayList;
import model.Coordinate;

public interface PlotComponent {
    public void operation(Graphics g, ArrayList<Coordinate> coordinates);
}