package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

@JsonTypeName("GeometryCollection")
public class GeometryCollection extends Geometry {
	
	private List<Geometry> geometries;
	
	public GeometryCollection() {
		
	}
	
	public GeometryCollection(List<Geometry> geometry) {
		this.geometries = geometry;
//		setType( GeometryCollection.class.getSimpleName() );
	}
	
	public List<Geometry> getGeometries() {
		return geometries;
	}

	@Override
	public String getType() {
		return GeometryCollection.class.getSimpleName();
	}
	
	
}
