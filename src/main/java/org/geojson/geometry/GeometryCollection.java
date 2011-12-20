package org.geojson.geometry;

import java.util.List;

public class GeometryCollection implements Geometry {
	
	private String type = "GeometryCollection";
	private List<Geometry> geometry;
	
	public GeometryCollection(List<Geometry> geometry) {
		this.geometry = geometry;
	}
	
	public List<Geometry> getGeometries() {
		return geometry;
	}
	
	public String getType() {
		return type;
	}
}
