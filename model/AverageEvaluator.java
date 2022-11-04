package model;
public class AverageEvaluator {
    private static AverageEvaluator instance;
    
    protected AverageEvaluator() {}

    public static AverageEvaluator getInstance() {
        if (instance == null)
            instance = new AverageEvaluator();
        return instance;
    }    
}
