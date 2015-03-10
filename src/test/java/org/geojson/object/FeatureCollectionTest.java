package org.geojson.object;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.geojson.geometry.Geometry;
import org.geojson.geometry.GeometryCollection;
import org.geojson.geometry.LineString;
import org.geojson.geometry.MultiLineString;
import org.geojson.geometry.MultiPoint;
import org.geojson.geometry.MultiPolygon;
import org.geojson.geometry.Point;
import org.geojson.geometry.Polygon;
import org.geojson.util.GeometryMixin;
import org.junit.Before;
import org.junit.Test;

public class FeatureCollectionTest {

	private  ObjectMapper serializer;
	private  ObjectMapper deserializer;
	
	@Before
	public void setUp(){
		serializer = new ObjectMapper();
		deserializer = new ObjectMapper();
		deserializer.addMixInAnnotations( Geometry.class, GeometryMixin.class);
	}

	@Test
	public void testPointGeometry() throws Exception {

		Geometry point = new Point(100.0, 0.0);

		String result = serializer.writeValueAsString(point);
		String expect = "{\"type\":\"Point\",\"coordinates\":[100.0,0.0]}";

		Assert.assertEquals(expect, result);
		
		Point readValue = ( Point ) deserializer.readValue(expect, Point.class);
		Assert.assertEquals("[100.0, 0.0]", Arrays.toString( readValue.getCoordinates() ) );
		Assert.assertEquals("Point", readValue.getType() );
	}

	@Test
	public void testLineStringGeometry() throws Exception {

		List<Point> posList = new ArrayList<>();
		posList.add(new Point(100.0, 0.0));
		posList.add(new Point(101.0, 1.0));
		Geometry geom = new LineString(posList);

		String result = serializer.writeValueAsString(geom);
		String expect = "{\"type\":\"LineString\",\"coordinates\":[[100.0,0.0],[101.0,1.0]]}";

		Assert.assertEquals(expect, result);
		
		LineString readValue = deserializer.readValue(expect, LineString.class);
		Assert.assertEquals(2,  readValue.getCoordinates().size() );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( readValue.getCoordinates().get(0) ) );
		Assert.assertEquals( "[101.0, 1.0]",  Arrays.toString( readValue.getCoordinates().get(1) ) );
		Assert.assertEquals("LineString", readValue.getType() );
	}

	@Test
	public void testPolygonGeometry() throws Exception {
		
		List<Point> points = new ArrayList<>();
		points.add(new Point(100.0, 0.0));		
		points.add(new Point(101.0, 0.0));
		points.add(new Point(101.0, 1.0));
		points.add(new Point(100.0, 1.0));
		points.add(new Point(100.0, 0.0));
		
		LineString lineString = new LineString(points);

		List<LineString> lineStrings = new ArrayList<>();
		lineStrings.add(lineString);
		
		Geometry geom = new Polygon(lineStrings);

		String result = serializer.writeValueAsString(geom);
		String expect = "{\"type\":\"Polygon\",\"coordinates\":[[[100.0,0.0],[101.0,0.0],[101.0,1.0],[100.0,1.0],[100.0,0.0]]]}";

		Assert.assertEquals(expect, result);
		
		Polygon readValue = deserializer.readValue(expect, Polygon.class);
		Assert.assertEquals(1,  readValue.getCoordinates().size() );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( readValue.getCoordinates().get(0).get(0) ) );
		Assert.assertEquals( "[101.0, 0.0]",  Arrays.toString( readValue.getCoordinates().get(0).get(1) ) );
		Assert.assertEquals( "[101.0, 1.0]",  Arrays.toString( readValue.getCoordinates().get(0).get(2) ) );
		Assert.assertEquals( "[100.0, 1.0]",  Arrays.toString( readValue.getCoordinates().get(0).get(3) ) );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( readValue.getCoordinates().get(0).get(4) ) );
		Assert.assertEquals("Polygon", readValue.getType() );
	}
	
	@Test
	public void testPolygonWithHoles() throws Exception {
		
		List<Point> points1 = new ArrayList<>();
		points1.add(new Point(100.0, 0.0));		
		points1.add(new Point(101.0, 0.0));
		points1.add(new Point(101.0, 1.0));
		points1.add(new Point(100.0, 1.0));
		points1.add(new Point(100.0, 0.0));
		
		List<Point> points2 = new ArrayList<>();
		points2.add(new Point(100.2, 0.2));		
		points2.add(new Point(100.8, 0.2));
		points2.add(new Point(100.8, 0.8));
		points2.add(new Point(100.2, 0.8));
		points2.add(new Point(100.2, 0.2));
		
		LineString lineString1 = new LineString(points1);
		LineString lineString2 = new LineString(points2);

		List<LineString> lineStrings = new ArrayList<>();
		lineStrings.add(lineString1);
		lineStrings.add(lineString2);
		
		Geometry geom = new Polygon(lineStrings);

		String result = serializer.writeValueAsString(geom);
		String expect = "{\"type\":\"Polygon\",\"coordinates\":[[[100.0,0.0],[101.0,0.0],[101.0,1.0],[100.0,1.0],[100.0,0.0]],[[100.2,0.2],[100.8,0.2],[100.8,0.8],[100.2,0.8],[100.2,0.2]]]}";
		Assert.assertEquals(expect, result);
		
		Polygon readValue = deserializer.readValue(expect, Polygon.class);
		Assert.assertEquals( 2,  readValue.getCoordinates().size() );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( readValue.getCoordinates().get(0).get(0) ) );
		Assert.assertEquals( "[100.2, 0.2]",  Arrays.toString( readValue.getCoordinates().get(1).get(0) ) );
		
		Assert.assertEquals("Polygon", readValue.getType() );
	}

	@Test
	public void testMultiPoint() throws Exception {
		List<Point> points = new ArrayList<>();
		points.add(new Point(100.0, 0.0));
		points.add(new Point(101.0, 1.0));

		Geometry geom = new MultiPoint(points);

		String result = serializer.writeValueAsString(geom);
		String expect = "{\"type\":\"MultiPoint\",\"coordinates\":[[100.0,0.0],[101.0,1.0]]}";

		Assert.assertEquals(expect, result);
		
		MultiPoint readValue = deserializer.readValue(expect, MultiPoint.class);
		Assert.assertEquals(2,  readValue.getCoordinates().size() );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( readValue.getCoordinates().get(0) ) );
		Assert.assertEquals( "[101.0, 1.0]",  Arrays.toString( readValue.getCoordinates().get(1) ) );
		Assert.assertEquals("MultiPoint", readValue.getType() );
	}

	@Test
	public void testMultiLineString() throws Exception {
		
		List<Point> points1 = new ArrayList<>();
		points1.add(new Point(100.0, 0.0));
		points1.add(new Point(101.0, 1.0));
		LineString lineString1 = new LineString(points1);
		
		List<Point> points2 = new ArrayList<>();
		points2.add(new Point(102.0, 2.0));
		points2.add(new Point(103.0, 3.0));
		LineString lineString2 = new LineString(points2);
		
		List<LineString> lineStringList = new ArrayList<>();
		lineStringList.add(lineString1);
		lineStringList.add(lineString2);
		
		MultiLineString geom3 = new MultiLineString(lineStringList);

		String result = serializer.writeValueAsString(geom3);
		String expect = "{\"type\":\"MultiLineString\",\"coordinates\":[[[100.0,0.0],[101.0,1.0]],[[102.0,2.0],[103.0,3.0]]]}";

		Assert.assertEquals(expect, result);
		
		MultiLineString readValue = deserializer.readValue(expect, MultiLineString.class);
		Assert.assertEquals( 2,  readValue.getCoordinates().size() );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( readValue.getCoordinates().get(0).get(0) ) );
		Assert.assertEquals( "[103.0, 3.0]",  Arrays.toString( readValue.getCoordinates().get(1).get(1) ) );
		Assert.assertEquals("MultiLineString", readValue.getType() );
	}
	
	@Test
	public void testMultiPolygon() throws Exception {
		
		List<Point> points1 = new ArrayList<>();
		points1.add(new Point(102.0,2.0));		
		points1.add(new Point(103.0,2.0));
		points1.add(new Point(103.0,3.0));
		points1.add(new Point(102.0,3.0));
		points1.add(new Point(102.0,2.0));
		
		List<LineString> lineStrings1 = new ArrayList<>();
		lineStrings1.add(new LineString(points1));
		
		List<LineString> lineStrings2 = new ArrayList<>();
		
		List<Point> points2 = new ArrayList<>();
		points2.add(new Point(100.0,0.0));		
		points2.add(new Point(101.0,0.0));
		points2.add(new Point(101.0,1.0));
		points2.add(new Point(100.0,1.0));
		points2.add(new Point(100.0,0.0));
		
		lineStrings2.add(new LineString(points2));
				
		List<Point> points3 = new ArrayList<>();
		points3.add(new Point(100.2,0.2));		
		points3.add(new Point(100.8,0.2));
		points3.add(new Point(100.8,0.8));
		points3.add(new Point(100.2,0.8));
		points3.add(new Point(100.2,0.2));
		
		lineStrings2.add(new LineString(points3));
		
		List<Polygon> polygons = new ArrayList<>();
		polygons.add(new Polygon(lineStrings1));
		polygons.add(new Polygon(lineStrings2));
		
		MultiPolygon multiPolygon = new MultiPolygon(polygons);
		
		String result = serializer.writeValueAsString(multiPolygon);
		String expect = "{\"type\":\"MultiPolygon\",\"coordinates\":[[[[102.0,2.0],[103.0,2.0],[103.0,3.0],[102.0,3.0],[102.0,2.0]]],[[[100.0,0.0],[101.0,0.0],[101.0,1.0],[100.0,1.0],[100.0,0.0]],[[100.2,0.2],[100.8,0.2],[100.8,0.8],[100.2,0.8],[100.2,0.2]]]]}";
		
		Assert.assertEquals(expect, result);
		
		MultiPolygon readValue = deserializer.readValue(expect, MultiPolygon.class);
		Assert.assertEquals( 2,  readValue.getCoordinates().size() );
		Assert.assertEquals( 2,  readValue.getCoordinates().get(1).size() );
		Assert.assertEquals( 5,  readValue.getCoordinates().get(1).get(0).size() );
		Assert.assertEquals("MultiPolygon", readValue.getType() );
	}
	
	@Test
	public void testGeometryCollection() throws Exception {
		List<Geometry> geometrys = new ArrayList<>();
		
		Geometry point = new Point(100.0, 0.0);
		
		List<Point> points = new ArrayList<>();
		points.add(new Point(101.0,0.0));
		points.add(new Point(102.0, 1.0));
		
		Geometry lineString = new LineString(points);
		
		geometrys.add(point);
		geometrys.add(lineString);
		
		GeometryCollection geometryCollection = new GeometryCollection(geometrys);
		
		String result = serializer.writeValueAsString(geometryCollection);
		String expected = "{\"type\":\"GeometryCollection\",\"geometries\":[{\"type\":\"Point\",\"coordinates\":[100.0,0.0]},{\"type\":\"LineString\",\"coordinates\":[[101.0,0.0],[102.0,1.0]]}]}";
		Assert.assertEquals(expected, result);
		
		GeometryCollection readValue = deserializer.readValue(expected, GeometryCollection.class);
		Assert.assertEquals( 2,  readValue.getGeometries().size() );
		Assert.assertTrue( readValue.getGeometries().get(1) instanceof LineString );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( ((Point)readValue.getGeometries().get(0)).getCoordinates() ) );
		Assert.assertEquals( "[101.0, 0.0]",  Arrays.toString( ((LineString)readValue.getGeometries().get(1)).getCoordinates().get(0)) );
		Assert.assertEquals( "[102.0, 1.0]",  Arrays.toString( ((LineString)readValue.getGeometries().get(1)).getCoordinates().get(1)) );
		Assert.assertEquals("GeometryCollection", readValue.getType() );
	}
	
	@Test
	public void testFeature() throws Exception {
		Feature feature = new Feature( new Point(100.0, 0.0) );
		feature.setProperties( Collections.<String,Serializable>singletonMap( "Place", "Radiation belt" ) );
		
		String result = serializer.writeValueAsString(feature);
		String expected = "{\"type\":\"Feature\",\"properties\":{\"Place\":\"Radiation belt\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[100.0,0.0]}}";
		Assert.assertEquals(expected, result);
		
		Feature readValue = deserializer.readValue(expected, Feature.class);
		Assert.assertEquals( "Feature",  readValue.getType() );
		Assert.assertTrue( "Should be a Point",  readValue.getGeometry() instanceof Point );
		Assert.assertEquals( "Point",  ((Point)readValue.getGeometry()).getType()  );
		Assert.assertEquals( "[100.0, 0.0]",  Arrays.toString( ((Point)readValue.getGeometry()).getCoordinates() ));
	}

	@Test
	public void testFeatureCollection() throws Exception {

		List<Feature> features = new ArrayList<>();

		Geometry geometry1 = new Point(38.7471494, -122.1298241);
		Feature feature1 = new Feature(geometry1);
		Map<String, Serializable> properties = new HashMap<>();
		properties.put("popupContent", "Hi!");
		feature1.setProperties(properties);

		features.add(feature1);

		Geometry geometry2 = new Point(38.1502833, -122.1283545);
		Feature feature2 = new IdentifiedFeature(geometry2, "Something");
		Map<String, Serializable> properties2 = new HashMap<>();
		properties2.put("popupContent", "I am Something.");
		feature2.setProperties(properties2);
		
		features.add(feature2);

		FeatureCollection featureCollection = new FeatureCollection(features);


		String result = serializer.writeValueAsString(featureCollection);
		String expected = "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":{\"popupContent\":\"Hi!\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[38.7471494,-122.1298241]}},{\"type\":\"Feature\",\"properties\":{\"popupContent\":\"I am Something.\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[38.1502833,-122.1283545]},\"id\":\"Something\"}]}";
		Assert.assertEquals(expected, result);
		
		FeatureCollection readValue = deserializer.readValue(expected, FeatureCollection.class);
		Assert.assertEquals( 2,  readValue.getFeatures().size()  );
		Assert.assertTrue( readValue.getFeatures().get( 0 ).getGeometry() instanceof Point );
		Assert.assertEquals( "[38.7471494, -122.1298241]", Arrays.toString( ((Point)readValue.getFeatures().get( 0 ).getGeometry()).getCoordinates() ) );
		Assert.assertEquals( "[38.1502833, -122.1283545]", Arrays.toString( ((Point)readValue.getFeatures().get( 1 ).getGeometry()).getCoordinates() ) );
		Assert.assertEquals("FeatureCollection", readValue.getType() );
	}
	
	public void testFeatureCollectionDeserializeFeatureWithJsonOrStringProperties() throws Exception {
		String input = "{ \"type\": \"FeatureCollection\",\n" + "    \"features\": [\n"
				+ "      { \"type\": \"Feature\",\n"
				+ "        \"geometry\": {\"type\": \"Point\", \"coordinates\": [102.0, 0.5]},\n"
				+ "        \"properties\": {\"prop0\": \"value0\"}\n" + "        },\n"
				+ "      { \"type\": \"Feature\",\n" + "        \"geometry\": {\n"
				+ "          \"type\": \"LineString\",\n" + "          \"coordinates\": [\n"
				+ "            [102.0, 0.0], [103.0, 1.0], [104.0, 0.0], [105.0, 1.0]\n"
				+ "            ]\n" + "          },\n" + "        \"properties\": {\n"
				+ "          \"prop0\": \"value0\",\n" + "          \"prop1\": 0.0\n" + "          }\n"
				+ "        },\n" + "      { \"type\": \"Feature\",\n" + "         \"geometry\": {\n"
				+ "           \"type\": \"Polygon\",\n" + "           \"coordinates\": [\n"
				+ "             [ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0],\n"
				+ "               [100.0, 1.0], [100.0, 0.0] ]\n" + "             ]\n"
				+ "         },\n" + "         \"properties\": {\n"
				+ "           \"prop0\": \"value0\",\n"
				+ "           \"prop1\": {\"this\": \"that\"}\n" + "           }\n" + "         }\n"
				+ "       ]\n" + " }";
		

		FeatureCollection readValue = deserializer.readValue( input, FeatureCollection.class );
		Assert.assertEquals( 3, readValue.getFeatures().size() );
		Assert.assertTrue( readValue.getFeatures().get( 0 ).getGeometry() instanceof Point );
		Assert.assertEquals( "[102.0, 0.5]", Arrays.toString( ((Point) readValue
				.getFeatures().get( 0 ).getGeometry()).getCoordinates() ) );
		Assert.assertTrue( readValue.getFeatures().get( 1 ).getGeometry() instanceof LineString );
		Assert.assertEquals( "[102.0, 0.0]", Arrays.toString( ((LineString) readValue
				.getFeatures().get( 1 ).getGeometry()).getCoordinates().get( 0 )) );
		Assert.assertEquals( "[103.0, 1.0]", Arrays.toString( ((LineString) readValue
				.getFeatures().get( 1 ).getGeometry()).getCoordinates().get( 1 )) );
		Assert.assertEquals( "[104.0, 0.0]", Arrays.toString( ((LineString) readValue
				.getFeatures().get( 1 ).getGeometry()).getCoordinates().get( 2 )) );
		Assert.assertTrue( readValue.getFeatures().get( 2 ).getGeometry() instanceof Polygon );
		Assert.assertEquals( 5, ((Polygon) readValue
				.getFeatures().get( 2 ).getGeometry()).getCoordinates().get( 0 ).size() );
		
		Assert.assertEquals( "FeatureCollection", readValue.getType() );
	}

}
