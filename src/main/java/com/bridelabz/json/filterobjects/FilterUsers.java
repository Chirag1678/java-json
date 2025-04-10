package com.bridelabz.json.filterobjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;

// Class to filter users from a JSON file where each age of each>25
public class FilterUsers {
    public static void main(String[] args) {
        // USe try-catch to handle exceptions
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON array as ArrayNode
            ArrayNode arrayNode = (ArrayNode) mapper.readTree(new File("src/main/java/com/bridelabz/json/filterobjects/users.json"));

            // Filter and print users with age > 25
            System.out.println("Users with age > 25:");
            for (JsonNode user : arrayNode) {
                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println(user.toPrettyString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Sample output->
// Users with age > 25:
// {
//   "id" : 102,
//   "name" : "Bhanu",
//   "age" : 35,
//   "email" : "bhanu@example.com"
// }
// {
//   "id" : 104,
//   "name" : "Dinesh",
//   "age" : 45,
//   "email" : "dinesh@example.com"
// }