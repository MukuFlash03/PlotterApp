package model;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class NormalizeCoordinates {
	private Map<Integer,Coordinate> cityCoordinates;


	public Map<Integer,Coordinate> getCityCoordinates() {
		return cityCoordinates;
	}

	public static ArrayList<Coordinate> scaleCoordinates(ArrayList<Coordinate> coordinateList) {
		HashMap<String, Double> minMax = findCoordinateRange(coordinateList);
		double x, y;
		ArrayList<Coordinate> cityCoordinateList = new ArrayList<>();

		for(Coordinate mapElement : coordinateList){
			// x = ((800 - 100) * (mapElement.getX() - minMax.get("minX"))) / (minMax.get("maxX") - minMax.get("minX"));
			// y = ((800 - 100) * (mapElement.getY() - minMax.get("minY"))) / (minMax.get("maxY") - minMax.get("minY"));
			x = 400 + (1000 *(mapElement.getX() - 100)) / (500 - 100);
			y = (250 *(mapElement.getY() - 100)) / (500 - 100);
			Coordinate coordinate = new Coordinate();
			coordinate.setX(x);
			coordinate.setY(y);
			cityCoordinateList.add(coordinate);
		}
		return cityCoordinateList;
	}

	/**
	 * Find the range of X and Y corodinates to calculate the scale
	 * @param coordinateList Coordinates of all cities
	 */
	private static HashMap<String, Double> findCoordinateRange(ArrayList<Coordinate> coordinateList) {

		double[] xList = new double[coordinateList.size()];
		double[] yList = new double[coordinateList.size()];
		HashMap<String, Double> range = new HashMap<>();
		int i=0;

		for(Coordinate mapElement : coordinateList){
			xList[i] = mapElement.getX();
			yList[i] = mapElement.getY();
			i++;
		}

		Arrays.sort(xList);
		Arrays.sort(yList);
		range.put("minX", xList[0]);
		range.put("minY", yList[0]);
		range.put("maxX", xList[coordinateList.size() - 1]);
		range.put("maxY", yList[coordinateList.size() - 1]);

		return range;

	}
}