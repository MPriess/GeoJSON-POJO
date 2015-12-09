package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Point")
public class Point extends Geometry {

	private double[] coordinates;

	public Point() {
		super(Point.class.getSimpleName());
	}

	public Point(double longtitude, double latitude) {
		this();
		coordinates = new double[2];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;

	}

	public Point(double longtitude, double latitude, double altitude) {
		this();
		coordinates = new double[3];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;
		coordinates[2] = altitude;

	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

}
