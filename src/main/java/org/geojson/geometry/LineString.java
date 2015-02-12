package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

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
		
//		setType( LineString.class.getSimpleName() );
		
	}
	
	public List<double[]> getCoordinates() {
		return coordinates;
	}

	@Override
	public String getType() {
		return LineString.class.getSimpleName();
	}
	
}
