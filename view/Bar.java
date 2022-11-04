package view;
public class Bar extends PlotDecorator {
    @Override
    public void operation() {
        super.operation();
        System.out.println("Bar: operation()");
    }
}
