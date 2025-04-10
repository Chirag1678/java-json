package com.bridelabz.json.converttojson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Class to convert CSV file to JSON
public class ConvertCSVToJSON {
    public static void main(String[] args) {
        // Define file paths
        String CSVinput = "src/main/java/com/bridelabz/json/converttojson/CSVinput.csv";
        String JSONouptut = "src/main/java/com/bridelabz/json/converttojson/JSONoutput.json";
        // List to store json object
        List<Map<String, String>> jsonList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(CSVinput))) {
            String[] headers = reader.readLine().split(","); // read header
            String line;

            while((line=reader.readLine())!=null) {
                String[] values = line.split(",");
                Map<String, String> jsonObject = new LinkedHashMap<>();
                for(int i=0;i<headers.length;i++) {
                    jsonObject.put(headers[i],values[i]);
                }
                jsonList.add(jsonObject);
            }

            // Convert list to JSON file
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(JSONouptut), jsonList);

            System.out.println("CSV successfully converted to JSON!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
