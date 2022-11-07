package view;

import java.awt.*;
import java.util.ArrayList;
import model.Coordinate;

/**
 * Description
 * 
 * @author Shrinkhala Kayastha
 * @version 1.0
 */
public interface PlotComponent {
    public void operation(Graphics g, ArrayList<Coordinate> coordinates);
}