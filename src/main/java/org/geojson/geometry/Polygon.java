package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Geometry {
	
	private List<List<double[]>> coordinates;

	public Polygon() {
		super(Polygon.class.getSimpleName());
	}
	
	public Polygon(List<LineString> coordinates) {
		super(Polygon.class.getSimpleName());
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<List<double[]>>();
			for ( LineString coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
		
	}
	
	// Should throw is not a polygon exception
	public List<List<double[]>> getCoordinates() {
		return coordinates;
	}
}