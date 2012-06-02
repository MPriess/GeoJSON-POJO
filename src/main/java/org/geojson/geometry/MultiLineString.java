package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiLineString extends Geometry {
	
	private List<LineString> coordinates;
	
	public MultiLineString(List<LineString> coordinates) {
		super(MultiLineString.class.getSimpleName());
		this.coordinates = coordinates;
	}
	
	public List<List<double[]>> getCoordinates() {
		List<List<double[]>> multiLineString = new ArrayList<List<double[]>>();
		for (LineString coordinate : coordinates) {
			multiLineString.add(coordinate.getCoordinates());
		}
		return multiLineString;
	}
	
	public String getType() {
		return this.getClass().getSimpleName();
	}
}
