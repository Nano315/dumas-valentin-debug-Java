package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Détermine le répertoire de travail courant
        String currentDirectory = System.getProperty("user.dir");

        // Instanciation des objets nécessaires
        ISymptomReader reader = new ReadSymptomDataFromFile(currentDirectory + "/../symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Appel des méthodes de AnalyticsCounter dans le bon ordre
        List<String> symptoms = counter.getSymptoms(); // Lecture des symptômes
        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms); // Comptage des occurrences
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms); // Tri des symptômes
        counter.writeSymptoms(sortedSymptoms); // Écriture des résultats
    }
}
