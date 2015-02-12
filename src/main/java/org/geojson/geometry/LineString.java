package org.geojson.geometry;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("LineString")
public class LineString extends Geometry {
	
	private List<double[]> coordinates;

	public LineString() {

	}
	
	public LineString(List<Point> coordinates) {
		
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<>();
			
			for ( Point point : coordinates ) {
				this.coordinates.add( point.getCoordinates() );
			}
		}
		
		setType( LineString.class.getSimpleName() );
		
	}
	
	public List<double[]> getCoordinates() {
		return coordinates;
	}
	
}
