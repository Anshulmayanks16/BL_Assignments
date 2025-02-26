package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.util.*;

public class IPLCensorAnalyzer {
    public static void main(String[] args) throws IOException {
        String jsonInputFile = "ipl_matches.json";
        String csvInputFile = "ipl_matches.csv";
        String jsonOutputFile = "ipl_matches_censored.json";
        String csvOutputFile = "ipl_matches_censored.csv";

        // Process JSON
        processJson(jsonInputFile, jsonOutputFile);

        // Process CSV
        processCsv(csvInputFile, csvOutputFile);
    }

    private static void processJson(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode matches = (ArrayNode) objectMapper.readTree(new File(inputFile));

        for (JsonNode match : matches) {
            ((ObjectNode) match).put("team1", censorTeamName(match.get("team1").asText()));
            ((ObjectNode) match).put("team2", censorTeamName(match.get("team2").asText()));
            ((ObjectNode) match).put("winner", censorTeamName(match.get("winner").asText()));
            ((ObjectNode) match).put("player_of_match", "REDACTED");
        }

        objectMapper.writeValue(new File(outputFile), matches);
        System.out.println("Censored JSON data written to " + outputFile);
    }

    private static void processCsv(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        String header = reader.readLine();
        writer.write(header + "\n");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            data[1] = censorTeamName(data[1]); // team1
            data[2] = censorTeamName(data[2]); // team2
            data[5] = censorTeamName(data[5]); // winner
            data[6] = "REDACTED"; // player_of_match
            writer.write(String.join(",", data) + "\n");
        }

        reader.close();
        writer.close();
        System.out.println("Censored CSV data written to " + outputFile);
    }

    private static String censorTeamName(String teamName) {
        if (teamName.contains(" ")) {
            return teamName.substring(0, teamName.indexOf(" ")) + " ***";
        }
        return teamName;
    }
}
