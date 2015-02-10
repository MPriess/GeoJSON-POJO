package org.geojson.object;

import java.io.Serializable;
import java.util.Map;
import org.geojson.geometry.Geometry;

public class Feature {
	
	private final String type = "Feature";
	private Map<String, Serializable> properties;
	private Geometry geometry;

	public Feature() {
	}

	public Feature(Geometry geometry) {
		this.geometry = geometry;
	}
	
	public String getType() {
		return type;
	}

	public Geometry getGeometry() {
		return geometry;
	}
	
	public Map<String, Serializable> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, Serializable> properties) {
		this.properties = properties;
	}
}
