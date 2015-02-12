package org.geojson.util;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.geojson.geometry.GeometryCollection;
import org.geojson.geometry.LineString;
import org.geojson.geometry.MultiLineString;
import org.geojson.geometry.MultiPoint;
import org.geojson.geometry.MultiPolygon;
import org.geojson.geometry.Point;
import org.geojson.geometry.Polygon;

/**
 * Use this mixin with ObjectMapper when deserializing GeoJSON strings, and
 * avoid it while serializing.
 *
 * This is a temporary workaround to the Polymorphic handling of Geometry
 * subtypes while serializing with the JsonTypeInfo and JsonSubTypes annotations
 * enabled.
 *
 * @author kenny
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Point.class, name = "Point"),
	@JsonSubTypes.Type(value = MultiPoint.class, name = "MultiPoint"),
	@JsonSubTypes.Type(value = LineString.class, name = "LineString"),
	@JsonSubTypes.Type(value = MultiLineString.class, name = "MultiLineString"),
	@JsonSubTypes.Type(value = Polygon.class, name = "Polygon"),
	@JsonSubTypes.Type(value = MultiPolygon.class, name = "MultiPolygon"),
	@JsonSubTypes.Type(value = GeometryCollection.class, name = "GeometryCollection")})
public class GeometryMixin {

}
