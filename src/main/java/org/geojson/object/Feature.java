package org.geojson.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import org.geojson.geometry.Geometry;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

	private final String type = "Feature";
	private Map<String, String> properties;
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

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
}
