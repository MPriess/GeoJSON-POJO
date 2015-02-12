package org.geojson.object;

import java.util.List;

public class FeatureCollection {

	private final String type = "FeatureCollection";
	private List<Feature> features;

	public FeatureCollection() {
	}

	public FeatureCollection(List<Feature> features) {
		this.features = features;
	}

	public String getType() {
		return this.type;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
}
