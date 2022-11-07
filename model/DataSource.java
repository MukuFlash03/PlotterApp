package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class DataSource extends Observable {
    private List<Integer> scores;
    private final int numberCoordinates = 30;
    private final int minLimit = 0;
    private final int maxLimit = 50;


    public List<Integer> getCoordinates() {
        return this.scores;
    }

    public void setCoordinates(List<Integer> scores) {
        this.scores = scores;
        setChanged();
        notifyObservers();
    }

    public int getMaximumValue() {
        return this.maxLimit;
    }

    public void generateCoordinates() {
        scores = new ArrayList<>();

        for (int i = 1; i <= numberCoordinates; i++) {
            scores.add(ThreadLocalRandom.current().nextInt(minLimit,maxLimit));
        }
    }

    public void printPoints() {
        for (int i = 0; i < scores.size(); i++)
            System.out.print(scores.get(i) + " ");
        System.out.println();
    }
}
