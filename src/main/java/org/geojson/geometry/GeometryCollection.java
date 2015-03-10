package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

@JsonTypeName("GeometryCollection")
public class GeometryCollection extends Geometry {

	private List<Geometry> geometries;

	public GeometryCollection() {
		super(GeometryCollection.class.getSimpleName());
	}

	public GeometryCollection(List<Geometry> geometry) {
		this();
		this.geometries = geometry;
	}

	public List<Geometry> getGeometries() {
		return geometries;
	}

}
