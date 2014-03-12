package org.geojson.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.codehaus.jackson.map.ObjectMapper;
import org.geojson.geometry.Geometry;
import org.geojson.geometry.GeometryCollection;
import org.geojson.geometry.LineString;
import org.geojson.geometry.MultiLineString;
import org.geojson.geometry.MultiPoint;
import org.geojson.geometry.MultiPolygon;
import org.geojson.geometry.Point;
import org.geojson.geometry.Polygon;
import org.junit.Test;

public class FeatureCollectionTest {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testPointGeometry() throws Exception {

		Geometry point = new Point(100.0, 0.0);

		String result = mapper.writeValueAsString(point);
		String expect = "{\"type\":\"Point\",\"coordinates\":[100.0,0.0]}";

		Assert.assertEquals(expect, result);
	}

	@Test
	public void testLineStringGeometry() throws Exception {

		List<Point> posList = new ArrayList<Point>();
		posList.add(new Point(100.0, 0.0));
		posList.add(new Point(101.0, 1.0));
		Geometry geom = new LineString(posList);

		String result = mapper.writeValueAsString(geom);
		String expect = "{\"type\":\"LineString\",\"coordinates\":[[100.0,0.0],[101.0,1.0]]}";

		Assert.assertEquals(expect, result);
	}

	@Test
	public void testPolygonGeometry() throws Exception {
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(100.0, 0.0));		
		points.add(new Point(101.0, 0.0));
		points.add(new Point(101.0, 1.0));
		points.add(new Point(100.0, 1.0));
		points.add(new Point(100.0, 0.0));
		
		LineString lineString = new LineString(points);

		List<LineString> lineStrings = new ArrayList<LineString>();
		lineStrings.add(lineString);
		
		Geometry geom = new Polygon(lineStrings);

		String result = mapper.writeValueAsString(geom);
		String expect = "{\"type\":\"Polygon\",\"coordinates\":[[[100.0,0.0],[101.0,0.0],[101.0,1.0],[100.0,1.0],[100.0,0.0]]]}";

		Assert.assertEquals(expect, result);
	}
	
	@Test
	public void testPolygonWithHoles() throws Exception {
		
		List<Point> points1 = new ArrayList<Point>();
		points1.add(new Point(100.0, 0.0));		
		points1.add(new Point(101.0, 0.0));
		points1.add(new Point(101.0, 1.0));
		points1.add(new Point(100.0, 1.0));
		points1.add(new Point(100.0, 0.0));
		
		List<Point> points2 = new ArrayList<Point>();
		points2.add(new Point(100.2, 0.2));		
		points2.add(new Point(100.8, 0.2));
		points2.add(new Point(100.8, 0.8));
		points2.add(new Point(100.2, 0.8));
		points2.add(new Point(100.2, 0.2));
		
		LineString lineString1 = new LineString(points1);
		LineString lineString2 = new LineString(points2);

		List<LineString> lineStrings = new ArrayList<LineString>();
		lineStrings.add(lineString1);
		lineStrings.add(lineString2);
		
		Geometry geom = new Polygon(lineStrings);

		String result = mapper.writeValueAsString(geom);
		String expect = "{\"type\":\"Polygon\",\"coordinates\":[[[100.0,0.0],[101.0,0.0],[101.0,1.0],[100.0,1.0],[100.0,0.0]],[[100.2,0.2],[100.8,0.2],[100.8,0.8],[100.2,0.8],[100.2,0.2]]]}";
		Assert.assertEquals(expect, result);
	}

	@Test
	public void testMultiPoint() throws Exception {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(100.0, 0.0));
		points.add(new Point(101.0, 1.0));

		Geometry geom = new MultiPoint(points);

		String result = mapper.writeValueAsString(geom);
		String expect = "{\"type\":\"MultiPoint\",\"coordinates\":[[100.0,0.0],[101.0,1.0]]}";

		Assert.assertEquals(expect, result);
	}

	@Test
	public void testMultiLineString() throws Exception {
		
		List<Point> points1 = new ArrayList<Point>();
		points1.add(new Point(100.0, 0.0));
		points1.add(new Point(101.0, 1.0));
		LineString lineString1 = new LineString(points1);
		
		List<Point> points2 = new ArrayList<Point>();
		points2.add(new Point(102.0, 2.0));
		points2.add(new Point(103.0, 3.0));
		LineString lineString2 = new LineString(points2);
		
		List<LineString> lineStringList = new ArrayList<LineString>();
		lineStringList.add(lineString1);
		lineStringList.add(lineString2);
		
		MultiLineString geom3 = new MultiLineString(lineStringList);

		String result = mapper.writeValueAsString(geom3);
		String expect = "{\"type\":\"MultiLineString\",\"coordinates\":[[[100.0,0.0],[101.0,1.0]],[[102.0,2.0],[103.0,3.0]]]}";

		Assert.assertEquals(expect, result);
	}
	
	@Test
	public void testMultiPolygon() throws Exception {
		
		List<Point> points1 = new ArrayList<Point>();
		points1.add(new Point(102.0,2.0));		
		points1.add(new Point(103.0,2.0));
		points1.add(new Point(103.0,3.0));
		points1.add(new Point(102.0,3.0));
		points1.add(new Point(102.0,2.0));
		
		List<LineString> lineStrings1 = new ArrayList<LineString>();
		lineStrings1.add(new LineString(points1));
		
		List<LineString> lineStrings2 = new ArrayList<LineString>();
		
		List<Point> points2 = new ArrayList<Point>();
		points2.add(new Point(100.0,0.0));		
		points2.add(new Point(101.0,0.0));
		points2.add(new Point(101.0,1.0));
		points2.add(new Point(100.0,1.0));
		points2.add(new Point(100.0,0.0));
		
		lineStrings2.add(new LineString(points2));
				
		List<Point> points3 = new ArrayList<Point>();
		points3.add(new Point(100.2,0.2));		
		points3.add(new Point(100.8,0.2));
		points3.add(new Point(100.8,0.8));
		points3.add(new Point(100.2,0.8));
		points3.add(new Point(100.2,0.2));
		
		lineStrings2.add(new LineString(points3));
		
		List<Polygon> polygons = new ArrayList<Polygon>();
		polygons.add(new Polygon(lineStrings1));
		polygons.add(new Polygon(lineStrings2));
		
		MultiPolygon multiPolygon = new MultiPolygon(polygons);
		
		String result = mapper.writeValueAsString(multiPolygon);
		String expect = "{\"type\":\"MultiPolygon\",\"coordinates\":[[[[102.0,2.0],[103.0,2.0],[103.0,3.0],[102.0,3.0],[102.0,2.0]]],[[[100.0,0.0],[101.0,0.0],[101.0,1.0],[100.0,1.0],[100.0,0.0]],[[100.2,0.2],[100.8,0.2],[100.8,0.8],[100.2,0.8],[100.2,0.2]]]]}";
		
		Assert.assertEquals(expect, result);
	}
	
	@Test
	public void testGeometryCollection() throws Exception {
		List<Geometry> geometrys = new ArrayList<Geometry>();
		
		Geometry point = new Point(100.0, 0.0);
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(101.0,0.0));
		points.add(new Point(102.0, 1.0));
		
		Geometry lineString = new LineString(points);
		
		geometrys.add(point);
		geometrys.add(lineString);
		
		GeometryCollection geometryCollection = new GeometryCollection(geometrys);
		
		String result = mapper.writeValueAsString(geometryCollection);
		String expected = "{\"type\":\"GeometryCollection\",\"geometries\":[{\"type\":\"Point\",\"coordinates\":[100.0,0.0]},{\"type\":\"LineString\",\"coordinates\":[[101.0,0.0],[102.0,1.0]]}]}";
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testFeatureCollection() throws Exception {

		List<Feature> features = new ArrayList<Feature>();

		Geometry geometry1 = new Point(38.7471494, -122.1298241);
		Feature feature1 = new Feature(geometry1);
		Map<String, Serializable> properties = new HashMap<String, Serializable>();
		properties.put("popupContent", "Hi!");
		feature1.setProperties(properties);

		features.add(feature1);

		Geometry geometry2 = new Point(38.1502833, -122.1283545);
		Feature feature2 = new IdentifiedFeature(geometry2, "Something");
		Map<String, Serializable> properties2 = new HashMap<String, Serializable>();
		properties2.put("popupContent", "I am Something.");
		feature2.setProperties(properties2);
		
		features.add(feature2);

		FeatureCollection featureCollection = new FeatureCollection(features);


		String result = mapper.writeValueAsString(featureCollection);
		String expected = "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":{\"popupContent\":\"Hi!\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[38.7471494,-122.1298241]}},{\"type\":\"Feature\",\"properties\":{\"popupContent\":\"I am Something.\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[38.1502833,-122.1283545]},\"id\":\"Something\"}]}";
		Assert.assertEquals(expected, result);
	}

}
