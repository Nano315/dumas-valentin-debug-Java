package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class to run the AnalyticsCounter application.
 */
public class Main {

    public static void main(String[] args) {
        // Get current working directory
        String currentDirectory = System.getProperty("user.dir");

        // Instantiate necessary objects
        ISymptomReader reader = new ReadSymptomDataFromFile(currentDirectory + "/../symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Execute the flow in the correct order
        List<String> symptoms = counter.getSymptoms(); // Read symptoms
        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms); // Count occurrences
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms); // Sort symptoms
        counter.writeSymptoms(sortedSymptoms); // Write results
    }
}
