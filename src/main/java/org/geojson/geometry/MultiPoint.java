package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPoint extends Geometry {
	
	private List<double[]> coordinates;

	public MultiPoint() {
		super(MultiPoint.class.getName());
	}
	
	public MultiPoint(List<Point> coordinates) {
		super(MultiPoint.class.getName());
		
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<double[]>();
			
			for ( Point coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
	}
	
	public List<double[]> getCoordinates() {
		return coordinates;
	}
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
}
