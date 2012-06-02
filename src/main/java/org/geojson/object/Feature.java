package org.geojson.object;

import org.geojson.geometry.Geometry;

public class Feature {
	
	private String type = "Feature";
	private Object properties;
	private Geometry geometry;

	public Feature(Geometry geometry) {
		this.geometry = geometry;
	}
	
	public String getType() {
		return type;
	}

	public Geometry getGeometry() {
		return geometry;
	}
	
	public Object getProperties() {
		return properties;
	}
	
	public void setProperties(Object properties) {
		this.properties = properties;
	}
}