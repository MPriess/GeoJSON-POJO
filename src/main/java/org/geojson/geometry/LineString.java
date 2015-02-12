package org.geojson.geometry;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("LineString")
public class LineString extends Geometry {

	private List<double[]> coordinates;

	public LineString() {
		super(LineString.class.getSimpleName());
	}

	public LineString(List<Point> coordinates) {
		this();
		if (coordinates != null) {
			this.coordinates = new ArrayList<>();

			for (Point point : coordinates) {
				this.coordinates.add(point.getCoordinates());
			}
		}

	}

	public List<double[]> getCoordinates() {
		return coordinates;
	}

}
