package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class MultiPolygon extends Geometry {
	
	private List<List<List<double[]>>> coordinates;

	public MultiPolygon() {

	}
	
	public MultiPolygon(List<Polygon> coordinates) {
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<>();
			
			for ( Polygon coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
		
		setType( MultiPolygon.class.getSimpleName() );
		
	}
	
	public List<List<List<double[]>>>  getCoordinates() {
		return coordinates;
	}

	public void setCoordinates( List<List<List<double[]>>> coordinates ) {
		this.coordinates = coordinates;
	}
	
}
