package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPolygon extends Geometry {
	
	private List<List<List<double[]>>> coordinates;

	public MultiPolygon() {
		super(MultiPolygon.class.getSimpleName());
	}
	
	public MultiPolygon(List<Polygon> coordinates) {
		super(MultiPolygon.class.getSimpleName());
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<List<List<double[]>>>();
			
			for ( Polygon coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
		
	}
	
	public List<List<List<double[]>>>  getCoordinates() {
		return coordinates;
	}
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
}
