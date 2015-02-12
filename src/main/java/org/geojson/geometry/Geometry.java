package org.geojson.geometry;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;



@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "objectType")
@JsonSubTypes({ @Type(value = Point.class, name = "Point"),
		@Type(value = MultiPoint.class, name = "MultiPoint"),
		@Type(value = LineString.class, name = "LineString"),
		@Type(value = MultiLineString.class, name = "MultiLineString"),
		@Type(value = Polygon.class, name = "Polygon"),
		@Type(value = MultiPolygon.class, name = "MultiPolygon"),
		@Type(value = GeometryCollection.class, name = "GeometryCollection") })
public abstract class Geometry {

	protected String type;


	public String getType() {
		return type;
	}

	public void setType( String type ) {
		this.type = type;
	}
	
}
