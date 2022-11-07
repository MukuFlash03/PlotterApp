package model;

import java.util.List;

public class AverageEvaluator {
    private static AverageEvaluator instance;

    private double average;
    
    protected AverageEvaluator() {}

    public static AverageEvaluator getInstance() {
        if (instance == null)
            instance = new AverageEvaluator();
        return instance;
    }    

    public double getAverage() {
        return average;
    }

    public void calculate(List<Integer> scores) {
        double sum = 0;
        for (Integer i : scores) {
            sum += i;
        }
        average = sum/scores.size();
    }

}
