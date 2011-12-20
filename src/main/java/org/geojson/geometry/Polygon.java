package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements Geometry {
	
	private String type = "Polygon";
	private List<LineString> coordinates;
	
	public Polygon(List<LineString> coordinates) {
		this.coordinates = coordinates;
	}
	
	// Should throw is not a polygon exception
	public List<List<double[]>> getCoordinates() {
		List<List<double[]>> polygon = new ArrayList<List<double[]>>();
		for (LineString lineString : coordinates) {
			polygon.add(lineString.getCoordinates());
		}
		return polygon;
	}
	
	public String getType() {
		return type;
	}
}
