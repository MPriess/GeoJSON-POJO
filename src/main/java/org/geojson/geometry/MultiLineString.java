package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiLineString extends Geometry {
	
	private List<List<double[]>> coordinates;

	public MultiLineString() {
		
	}
	
	public MultiLineString(List<LineString> coordinates) {
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<>();
			
			for ( LineString coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
		
		setType( MultiLineString.class.getSimpleName() );
	}
	
	public List<List<double[]>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates( List<List<double[]>> coordinates ) {
		this.coordinates = coordinates;
	}
}
