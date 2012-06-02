package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPolygon extends Geometry {
	
	private List<Polygon> coordinates;
	
	public MultiPolygon(List<Polygon> coordinates) {
		super(MultiPolygon.class.getSimpleName());
		this.coordinates = coordinates;
	}
	
	public List<List<List<double[]>>>  getCoordinates() {
		List<List<List<double[]>>> multiPolygon = new ArrayList<List<List<double[]>>>();
		for (Polygon polygon: coordinates) {
			multiPolygon.add(polygon.getCoordinates());
		}
		return multiPolygon;
	}
	
	public String getType() {
		return this.getClass().getSimpleName();
	}
}
