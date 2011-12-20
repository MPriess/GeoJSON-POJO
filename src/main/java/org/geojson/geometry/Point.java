package org.geojson.geometry;

public class Point implements Geometry {
	
	private String type = "Point";
	private double[] coordinates;
	
	public Point(double longtitude, double latitude) {
		coordinates = new double[2];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;
	}
	
	public Point(double longtitude, double latitude, double altitude) {
		coordinates = new double[3];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;
		coordinates[2] = latitude;
	}
	
	public double[] getCoordinates() {
		return coordinates;
	}
	
	public String getType() {
		return type;
	}
}
