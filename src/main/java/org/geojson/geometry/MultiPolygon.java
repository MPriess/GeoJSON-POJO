package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("MultiPolygon")
public class MultiPolygon extends Geometry {

	private List<List<List<double[]>>> coordinates;

	public MultiPolygon() {
		super(MultiPolygon.class.getSimpleName());
	}

	public MultiPolygon(List<Polygon> coordinates) {
		this();
		if (coordinates != null) {
			this.coordinates = new ArrayList<>();

			for (Polygon coordinate : coordinates) {
				this.coordinates.add(coordinate.getCoordinates());
			}
		}

	}

	public List<List<List<double[]>>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<List<double[]>>> coordinates) {
		this.coordinates = coordinates;
	}

}
