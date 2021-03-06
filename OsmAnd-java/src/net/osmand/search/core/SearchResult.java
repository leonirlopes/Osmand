package net.osmand.search.core;

import java.util.Collection;

import net.osmand.binary.BinaryMapIndexReader;
import net.osmand.data.LatLon;
import net.osmand.util.MapUtils;

public class SearchResult {
	// search phrase that makes search result valid 
	public SearchPhrase requiredSearchPhrase;
	
	public Object object;
	public ObjectType objectType;
	public BinaryMapIndexReader file;
	
	public double priority;
	public double priorityDistance;
	public String wordsSpan ;
	public SearchResult parentSearchResult;
	public Collection<String> otherWordsMatch = null;
	
	
	
	public SearchResult(SearchPhrase sp) {
		this.requiredSearchPhrase = sp;
	}
	
	public int getFoundWordCount() {
		if(otherWordsMatch != null) {
			return otherWordsMatch.size() + 1;
		}
		return 1;
	}

	public double getSearchDistance(LatLon location) {
		double distance = 0;
		if (location != null && this.location != null) {
			distance = MapUtils.getDistance(location, this.location);
		}
		return priority - 1 / (1 + priorityDistance * distance);
	}
	
	public double getSearchDistance(LatLon location, double pd) {
		double distance = 0;
		if (location != null && this.location != null) {
			distance = MapUtils.getDistance(location, this.location);
		}
		return priority - 1 / (1 + pd * distance);
	}
	
	public LatLon location;
	public int preferredZoom = 15;
	public String localeName;
	
	public Collection<String> otherNames;
	
	public String localeRelatedObjectName;
	public Object relatedObject;
	public double distRelatedObjectName;
	
	
	

	
	

}
