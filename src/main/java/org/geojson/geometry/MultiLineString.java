package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("MultiLineString")
public class MultiLineString extends Geometry {

	private List<List<double[]>> coordinates;

	public MultiLineString() {
		super(MultiLineString.class.getSimpleName());
	}

	public MultiLineString(List<LineString> coordinates) {
		this();
		if (coordinates != null) {
			this.coordinates = new ArrayList<>();

			for (LineString coordinate : coordinates) {
				this.coordinates.add(coordinate.getCoordinates());
			}
		}

	}

	public List<List<double[]>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<double[]>> coordinates) {
		this.coordinates = coordinates;
	}

}
