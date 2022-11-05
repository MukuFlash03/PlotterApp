package model;

import java.util.Observable;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DataSource extends Observable implements Comparator<Coordinate> {

    private ArrayList<Coordinate> coordinates;
    private final int numberCoordinates = 20;

    private int xScale[];

    private int minLimit = 100;
    private int maxLimit = 500;

    public DataSource() {
        this.xScale = new int[this.numberCoordinates];
        for(int i = 0; i < this.numberCoordinates; i++)
            this.xScale[i] = 160 + 80*(i);
    }

    public ArrayList<Coordinate> getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
        setChanged();
        notifyObservers();
    }

    public void generateCoordinates() {
        this.coordinates = new ArrayList<Coordinate>();
        // double x,y;
        double y;
        int count = 0;

        for (int i = 1; i <= numberCoordinates; i++) {
            count++;
            
            // x = Math.round(ThreadLocalRandom.current().nextInt(minLimit,maxLimit) * 100) / 100.0;
            y = Math.round(ThreadLocalRandom.current().nextInt(minLimit,maxLimit) * 100) / 100.0;

            Coordinate xy = new Coordinate();
            xy.setX(xScale[i-1]);
            xy.setY(y);
            
            boolean flag = checkPointExists(xy);
            if (flag)
                i--;
            else
                this.coordinates.add(xy);

            if (count > numberCoordinates + 5) 
                break;
        }
        this.coordinates = NormalizeCoordinates.scaleCoordinates(this.coordinates);
        Collections.sort(this.coordinates, new DataSource());

    }

    private boolean checkPointExists(Coordinate xy) {
        // boolean checkX, checkY;
        boolean checkY;
        for (Coordinate coordinate : this.coordinates) {
            // checkX = coordinate.getX() == xy.getX();
            checkY = coordinate.getY() == xy.getY();
            // if (checkX && checkY) {
                if (checkY) {
                return true;
            }
        }
        return false;
    }

    public void printPoints() {
        for (int i = 0; i < this.coordinates.size(); i++)
            System.out.println("Key = " + (i+1) + ", Value = " + this.coordinates.get(i).getX() + ", " + this.coordinates.get(i).getY());
    }

    public int compare(Coordinate a, Coordinate b)
    {
        if (a.getX() == b.getX())
            return 0;
        else if (a.getX() > b.getX())
            return 1;
        else
            return -1;
    }

}
