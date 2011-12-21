package org.geojson.object;

import java.util.List;

public class FeatureCollection {
	
	private List<Feature> features;
	
	public FeatureCollection(List<Feature> features) {
		this.features = features;
	}
	
	public Feature[] getFeatures() {
		return features.toArray(new Feature[0]);
	}
}