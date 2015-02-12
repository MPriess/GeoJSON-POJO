package org.geojson.geometry;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("Point")
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Point extends Geometry {
	
	private double[] coordinates;

	public Point() {

	}
	
	public Point(double longtitude, double latitude) {		
		coordinates = new double[2];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;
		
		setType( Point.class.getSimpleName() );
	}

	public Point(double longtitude, double latitude, double altitude) {
		coordinates = new double[3];
		coordinates[0] = longtitude;
		coordinates[1] = latitude;
		coordinates[2] = latitude;
		
		setType( Point.class.getSimpleName() );
	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates( double[] coordinates ) {
		this.coordinates = coordinates;
	}

	
}