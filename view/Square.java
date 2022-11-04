package view;
public class Square extends PlotDecorator {
    @Override
    public void operation() {
        super.operation();
        System.out.println("Square: operation()");
    }
}
