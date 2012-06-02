package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends Geometry {
	
	private List<Point> coordinates;
	
	public LineString(List<Point> coordinates) {
		super(LineString.class.getSimpleName());
		this.coordinates = coordinates;
	}
	
	public List<double[]> getCoordinates() {
		List<double[]> doubleArray = new ArrayList<double[]>();
		for (Point coords: coordinates) {
			doubleArray.add(coords.getCoordinates());
		}
		return doubleArray;
	}
}

