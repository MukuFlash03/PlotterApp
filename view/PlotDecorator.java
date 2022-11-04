package view;
public abstract class PlotDecorator implements PlotComponent {
    private PlotComponent component;
    
    public void setComponent(PlotComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null)
            component.operation();
    }
}