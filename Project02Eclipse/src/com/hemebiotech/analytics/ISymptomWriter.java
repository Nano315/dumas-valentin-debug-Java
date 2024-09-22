package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Writes the symptoms and their respective counts to a file.
     * 
     * @param symptoms A map where the key is the symptom name and the value is the
     *                 count of occurrences
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
