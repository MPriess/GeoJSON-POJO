package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends Geometry {
	
	private List<double[]> coordinates;

	public LineString() {
		super( LineString.class.getSimpleName() );
	}
	
	public LineString(List<Point> coordinates) {
		super(LineString.class.getSimpleName());
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<double[]>();
			
			for ( Point point : coordinates ) {
				this.coordinates.add( point.getCoordinates() );
			}
		}
		
	}
	
	public List<double[]> getCoordinates() {
		return coordinates;
	}
	
}

