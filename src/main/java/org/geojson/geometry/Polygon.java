package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Geometry {
	
	private List<List<double[]>> coordinates;

	public Polygon() {

	}
	
	public Polygon(List<LineString> coordinates) {
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<>();
			for ( LineString coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
		
		setType( Polygon.class.getSimpleName() );
		
	}
	
	// Should throw is not a polygon exception
	public List<List<double[]>> getCoordinates() {
		return coordinates;
	}
}