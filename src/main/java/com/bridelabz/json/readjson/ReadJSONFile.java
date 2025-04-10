package com.bridelabz.json.readjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

// Class to read json file and extract specific fields like name and email
public class ReadJSONFile {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(new File("src/main/java/com/bridelabz/json/readjson/user.json"));

            // Display specific fields
            System.out.println("User name: " + jsonNode.get("name").asText());
            System.out.println("User email: " + jsonNode.get("email").asText());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
