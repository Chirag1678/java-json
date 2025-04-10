package com.bridelabz.json.printjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

// Read JSON file and display each key-value pair
public class DisplayKeyValue {
    public static void main(String[] args) {
        // Use try-catch to handle exceptions
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode node = mapper.readTree(new File("src/main/java/com/bridelabz/json/printjson/user.json"));

            System.out.println("Key value pairs in JSON Object ->");
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> field = it.next();
                System.out.println(field.getKey() + " : " + field.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Sample Output ->
// Key value pairs in JSON Object ->
// id : 101
// name : "Amit"
// age : 25
// email : "amit@example.com"