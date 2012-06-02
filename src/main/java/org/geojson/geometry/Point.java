package org.geojson.geometry;

public class Point extends Geometry {
	
	private double[] coordinates;
	
	public Point(double longtitude, double latitude) {		
		super(Point.class.getSimpleName());

		coordinates = new double[2];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;
	}

	public Point(double longtitude, double latitude, double altitude) {
		super(Point.class.getSimpleName());

		coordinates = new double[3];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;
		coordinates[2] = latitude;
	}

	public double[] getCoordinates() {
		return coordinates;
	}
}