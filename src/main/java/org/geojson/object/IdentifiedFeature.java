package org.geojson.object;

import org.geojson.geometry.Geometry;

/**
 * Make it possible to construct features that have an "id" identifier. From
 * http://geojson.org/geojson-spec.html: If a feature has a commonly used
 * identifier, that identifier should be included as a member of the feature
 * object with the name "id".
 */
public class IdentifiedFeature extends Feature {

	private String id;

	public IdentifiedFeature() {
	}

	public IdentifiedFeature(Geometry geometry, String identifier) {
		super(geometry);
		id = identifier;
	}

	public String getId() {
		return id;
	}

}
