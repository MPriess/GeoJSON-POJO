package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPoint extends Geometry {
	
	private List<Point> coordinates;
	
	public MultiPoint(List<Point> coordinates) {
		super(MultiPoint.class.getName());
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
		return this.getClass().getSimpleName();
	}
}
