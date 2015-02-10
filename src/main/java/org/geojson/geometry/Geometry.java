package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "@Class")
@JsonSubTypes({ @Type(value = Point.class, name = "Point"),
		@Type(value = MultiPoint.class, name = "MultiPoint"),
		@Type(value = LineString.class, name = "LineString"),
		@Type(value = MultiLineString.class, name = "MultiLineString"),
		@Type(value = Polygon.class, name = "Polygon"),
		@Type(value = MultiPolygon.class, name = "MultiPolygon"),
		@Type(value = GeometryCollection.class, name = "GeometryCollection") })
public class Geometry {

	protected String type;

	public Geometry() {
	}

	@JsonCreator
	public Geometry( @JsonProperty("type") String type ) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
