package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPoint implements Geometry {
	
	private String type = "MultiPoint";
	private List<Point> coordinates;
	
	public MultiPoint(List<Point> coordinates) {
		this.coordinates = coordinates;
	}
	
	public List<double[]> getCoordinates() {
		List<double[]> points = new ArrayList<double[]>();
		for (Point point : coordinates) {
			points.add(point.getCoordinates());
		}
		return points;
	}
	
	public String getType() {
		return type;
	}
}
