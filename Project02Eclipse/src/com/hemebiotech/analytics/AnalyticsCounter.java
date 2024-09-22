package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String[] args) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		String currentDirectory = System.getProperty("user.dir");

		// Reading the input file
		try (BufferedReader reader = new BufferedReader(new FileReader(currentDirectory + "/../symptoms.txt"))) {
			String line = reader.readLine();

			while (line != null) {
				symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Writing the output file using ISymptomWriter
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomCounts);
	}
}
