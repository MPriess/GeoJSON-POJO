package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {
	
	protected final String type;

	@JsonCreator
	public Geometry(@JsonProperty("type") String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
