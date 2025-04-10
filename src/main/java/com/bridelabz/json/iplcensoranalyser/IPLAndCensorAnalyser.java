package com.bridelabz.json.iplcensoranalyser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLAndCensorAnalyser {
    public static void main(String[] args) {
        String jsonInput = "src/main/java/com/bridelabz/json/iplcensoranalyser/matchInput.json";
        String csvInput = "src/main/java/com/bridelabz/json/iplcensoranalyser/matchInput.csv";
        String jsonOutput = "src/main/java/com/bridelabz/json/iplcensoranalyser/matchOutput.json";
        String csvOutput = "src/main/java/com/bridelabz/json/iplcensoranalyser/matchOutput.csv";
        processJsonInput(jsonInput, jsonOutput);
        processCsvInput(csvInput, csvOutput);
    }

    // Method to read from a JSON file, apply censorship rules, and write to a new JSON file
    public static void processJsonInput(String inputPath, String outputPath) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON input into a list of MatchDetails objects
            List<MatchDetails> matches = mapper.readValue(new File(inputPath), new TypeReference<List<MatchDetails>>() {});

            for (MatchDetails match : matches) {
                // Apply censorship to team names and winner
                match.team1 = censorTeamName(match.team1);
                match.team2 = censorTeamName(match.team2);
                match.winner = censorTeamName(match.winner);

                // Redact player of the match
                match.player_of_match = "REDACTED";

                // Censor keys inside the score map
                Map<String, Integer> newScore = new HashMap<>();
                for (Map.Entry<String, Integer> entry : match.score.entrySet()) {
                    newScore.put(censorTeamName(entry.getKey()), entry.getValue());
                }
                match.score = newScore;
            }

            // Write the updated list back to the JSON output file
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), matches);
            System.out.println("Censored JSON written to: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to read from a CSV file, apply censorship rules, and write to a new CSV file
    public static void processCsvInput(String inputPath, String outputPath) {
        try (
                CSVReader reader = new CSVReader(new FileReader(inputPath));
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath))
        ) {
            // Read and write headers
            String[] headers = reader.readNext();
            writer.writeNext(headers);

            String[] line;
            while ((line = reader.readNext()) != null) {
                // Apply censorship to relevant fields
                line[1] = censorTeamName(line[1]); // team1
                line[2] = censorTeamName(line[2]); // team2
                line[5] = censorTeamName(line[5]); // winner
                line[6] = "REDACTED";              // player_of_match

                // Write the modified row to output file
                writer.writeNext(line);
            }

            System.out.println("Censored CSV written to: " + outputPath);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Utility method to mask the last part of a team name
    private static String censorTeamName(String name) {
        if (name == null || name.trim().isEmpty()) return name;
        String[] parts = name.trim().split(" ");
        if (parts.length == 1) return "***"; // If only one word, replace fully
        return String.join(" ", Arrays.copyOf(parts, parts.length - 1)) + " ***";
    }
}
