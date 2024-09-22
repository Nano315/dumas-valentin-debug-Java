package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves the list of symptoms from the reader
	 *
	 * @return List of symptoms
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom
	 *
	 * @param symptoms List of symptoms to count
	 * @return Map with symptoms as keys and their occurrences as values
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	/**
	 * Sorts the symptoms alphabetically
	 *
	 * @param symptoms Map of symptoms and their occurrences
	 * @return Sorted map of symptoms
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms); // TreeMap automatically sorts the keys
	}

	/**
	 * Writes the symptoms and their counts to a file
	 *
	 * @param symptoms Map of symptoms and their counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
