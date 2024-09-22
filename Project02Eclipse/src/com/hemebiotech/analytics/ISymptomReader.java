package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for reading symptom data from a source.
 */
public interface ISymptomReader {
	/**
	 * Retrieves a list of symptoms from the data source.
	 * 
	 * @return A list of symptoms, which may contain duplicates.
	 */
	List<String> getSymptoms();
}
