package view;

import java.awt.*;
import java.util.ArrayList;
import model.Coordinate;

public abstract class PlotDecorator implements PlotComponent {
    private PlotComponent component;
    
    public void setComponent(PlotComponent component) {
        this.component = component;
    }

    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        if (component != null)
            component.operation(g, coordinates);
    }
}