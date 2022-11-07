package view;

import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is the abstract class for implementing Decorator pattern. The decorators over the
 * concrete class Point is extending this class.
 * It overrides the function operation which is modified by other Decorator child classes
 * according to their use case.
 *
 * @author Mukul Mahadik
 * @version 1.0
 * */
public abstract class PlotDecorator implements PlotComponent {
    private PlotComponent component;

    /**
     * This function set the component/ child decorator class.
     */
    public void setComponent(PlotComponent component) {
        this.component = component;
    }

    /**
     * This function implements operation of a particular child class on basis of the component called.
     * @param g object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
     */
    @Override
    public void operation(Graphics g, ArrayList<Coordinate> coordinates) {
        if (component != null)
            component.operation(g, coordinates);
    }
}