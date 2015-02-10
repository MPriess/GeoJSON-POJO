package org.geojson.geometry;

import java.util.List;

public class GeometryCollection extends Geometry {
	
	private List<Geometry> geometries;

	public GeometryCollection() {
		super(GeometryCollection.class.getSimpleName());
	}
	
	public GeometryCollection(List<Geometry> geometry) {
		super(GeometryCollection.class.getSimpleName());
		this.geometries = geometry;
	}
	
	public List<Geometry> getGeometries() {
		return geometries;
	}
}
