package org.geojson.geometry;

import java.util.List;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("GeometryCollection")
public class GeometryCollection extends Geometry {
	
	private List<Geometry> geometries;
	
	public GeometryCollection() {
		
	}
	
	public GeometryCollection(List<Geometry> geometry) {
		this.geometries = geometry;
		setType( GeometryCollection.class.getSimpleName() );
	}
	
	public List<Geometry> getGeometries() {
		return geometries;
	}
}
