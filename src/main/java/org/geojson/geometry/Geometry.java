package org.geojson.geometry;

public abstract class Geometry {

	protected String type;

	public Geometry(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
