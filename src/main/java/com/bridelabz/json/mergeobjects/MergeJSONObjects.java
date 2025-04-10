package com.bridelabz.json.mergeobjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

// Class to merge two JSON Objects into one
public class MergeJSONObjects {
    public static void main(String[] args) {
        // Use try-catch to handle exceptions
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read from both files as JsonNode arrays
            ArrayNode array1 = (ArrayNode) mapper.readTree(new File("src/main/java/com/bridelabz/json/mergeobjects/json1.json"));
            ArrayNode array2 = (ArrayNode) mapper.readTree(new File("src/main/java/com/bridelabz/json/mergeobjects/json2.json"));

            // Map to store merged objects based on id
            Map<Integer, ObjectNode> mergeObjects = new LinkedHashMap<>();

            // Add all objects from array1
            for(JsonNode node:array1) {
                int id = node.get("id").asInt();
                mergeObjects.put(id,(ObjectNode) node);
            }

            // Merge from array2
            for(JsonNode node:array2) {
                int id = node.get("id").asInt();
                if(mergeObjects.containsKey(id)) {
                    ObjectNode existing = mergeObjects.get(id);
                    node.fields().forEachRemaining(field->existing.set(field.getKey(), field.getValue()));
                } else {
                    mergeObjects.put(id, (ObjectNode) node);
                }
            }

            // Convert map back to ArrayNode
            ArrayNode finalArray = mapper.createArrayNode();
            mergeObjects.values().forEach(finalArray::add);

            // write to new file
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/com/bridelabz/json/mergeobjects/json3.json"), finalArray);

            System.out.println("JSON Objects merged successfully!!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
