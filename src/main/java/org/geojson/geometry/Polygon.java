package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("Polygon")
public class Polygon extends Geometry {

	private List<List<double[]>> coordinates;

	public Polygon() {
		super(Polygon.class.getSimpleName());
	}

	public Polygon(List<LineString> coordinates) {
		this();

		if (coordinates != null) {
			this.coordinates = new ArrayList<>();
			for (LineString coordinate : coordinates) {
				this.coordinates.add(coordinate.getCoordinates());
			}
		}

	}

	// Should throw is not a polygon exception
	public List<List<double[]>> getCoordinates() {
		return coordinates;
	}

	@Override
	public String getType() {
		return Polygon.class.getSimpleName();
	}

}
