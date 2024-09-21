package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {

	public static void main(String[] args) {
		int headacheCount = 0;
		int rashCount = 0;
		int pupilCount = 0;

		String currentDirectory = System.getProperty("user.dir");

		// Reading the input file
		try (BufferedReader reader = new BufferedReader(new FileReader(currentDirectory + "/../symptoms.txt"))) {
			String line = reader.readLine();

			while (line != null) {
				// Counting occurrences of symptoms
				if (line.equals("headache")) {
					headacheCount++; // Increments the correct variable
				} else if (line.equals("rash")) {
					rashCount++; // Increments the correct variable
				} else if (line.contains("pupils")) {
					pupilCount++; // Increments the correct variable
				}
				line = reader.readLine(); // Read next symptom
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Writing the output file
		try (FileWriter writer = new FileWriter("result.out")) {
			writer.write("headache: " + headacheCount + "\n"); // Writes the correct variable
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
