package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("MultiLineString")
public class MultiLineString extends Geometry {
	
	private List<List<double[]>> coordinates;

	public MultiLineString() {
		super( null );
	}
	
	public MultiLineString(List<LineString> coordinates) {
		super(MultiLineString.class.getSimpleName());
		if ( coordinates != null ) {
			this.coordinates = new ArrayList<List<double[]>>();
			
			for ( LineString coordinate : coordinates ) {
				this.coordinates.add( coordinate.getCoordinates() );
			}
		}
	}
	
	public List<List<double[]>> getCoordinates() {
		return coordinates;
	}
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
}
