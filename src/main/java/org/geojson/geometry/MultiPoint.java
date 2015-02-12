package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("MultiPoint")
public class MultiPoint extends Geometry {

	private List<double[]> coordinates;

	public MultiPoint() {
		super(MultiPoint.class.getSimpleName());
	}

	public MultiPoint(List<Point> coordinates) {
		this();
		if (coordinates != null) {
			this.coordinates = new ArrayList<>();

			for (Point coordinate : coordinates) {
				this.coordinates.add(coordinate.getCoordinates());
			}
		}

	}

	public List<double[]> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<double[]> coordinates) {
		this.coordinates = coordinates;
	}

}
