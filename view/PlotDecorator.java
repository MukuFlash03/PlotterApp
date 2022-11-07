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
public abstract class PlotDecorator implements PlotComponent {
    private PlotComponent component;
    
    /**
     * 
     * @param
     */
    public void setComponent(PlotComponent component) {
        this.component = component;
    }

    /**
     * 
     * @param
     */
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        if (component != null)
            component.operation(g, coordinates);
    }
}