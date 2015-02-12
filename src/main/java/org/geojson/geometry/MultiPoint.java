package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPoint extends Geometry {
	
	private List<double[]> coordinates;

	public MultiPoint() {

	}
	
	public MultiPoint(List<Point> coordinates) {
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<>();
			
			for ( Point coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
		
//		setType( MultiPoint.class.getSimpleName() );
	}
	
	public List<double[]> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates( List<double[]> coordinates ) {
		this.coordinates = coordinates;
	}

	@Override
	public String getType() {
		return MultiPoint.class.getSimpleName(); 
	}
	
	
	
}
