package model;

import java.util.Observable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import view.PlotComponent;

public class DataSource extends Observable {
    
    private PlotComponent component;
    private String data;

    private ArrayList<Coordinate> coordinates;
    private final int numberCoordinates = 15;

    private int minLimit = 100;
    private int maxLimit = 500;


    public String getData() {
        return data;
    }

    public ArrayList<Coordinate> getCoordinates() {
        return this.coordinates;
    }

    public void setData(String data) {
        this.data = data;
        setChanged();
        notifyObservers();
    }

    public void setData(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
        setChanged();
        notifyObservers();
    }

    public void generateCoordinates() {
        coordinates = new ArrayList<Coordinate>();
        double x,y;
        int count = 0;

        for (int i = 1; i <= numberCoordinates; i++) {
            count++;
            // System.out.println(count);
            
            x = Math.round(ThreadLocalRandom.current().nextInt(minLimit,maxLimit) * 100) / 100.0;
            y = Math.round(ThreadLocalRandom.current().nextInt(minLimit,maxLimit) * 100) / 100.0;

            Coordinate xy = new Coordinate();
            xy.setX(x);
            xy.setY(y);
            
            boolean flag = checkPointExists(xy);
            if (flag)
                i--;
            else
                coordinates.add(xy);

            if (count > numberCoordinates + 5) 
                break;
        }
        coordinates = NormalizeCoordinates.scaleCoordinates(coordinates);
        System.out.println("Size = " + this.coordinates.size());

    }

    private boolean checkPointExists(Coordinate xy) {
        boolean checkX, checkY;
        for (Coordinate coordinate : this.coordinates) {
            checkX = coordinate.getX() == xy.getX();
            checkY = coordinate.getY() == xy.getY();
            if (checkX && checkY) {
                return true;
            }
        }
        return false;
    }

    public void printPoints() {
        for (int i = 0; i < this.coordinates.size(); i++)
            System.out.println("Key = " + (i+1) + ", Value = " + this.coordinates.get(i).getX() + ", " + this.coordinates.get(i).getY());
    }

}
