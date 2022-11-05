package model;

import java.util.ArrayList;

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
        return this.average;
    }

    public void calculate(ArrayList<Coordinate> coordinates) {
        double sum = 0;
        for (Coordinate xy : coordinates) {
            sum += xy.getY();
        }
        this.average = sum/coordinates.size();
    }


}
