package org.geojson.object;

import org.geojson.geometry.Geometry;

public class Feature {
	
	private final String type = "Feature";
	private Map<String, String> properties;
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
	
	public Map<String, String> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
}
