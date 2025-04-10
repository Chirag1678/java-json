package com.bridelabz.json.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

// Class to validate json structure using Jackson
public class ValidateJSONStructure {
    public static void main(String[] args) {
        // Use try-catch to handle exceptions
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Load JSON Schema
            JsonNode schemaNode = mapper.readTree(new File("src/main/java/com/bridelabz/json/validatejson/schema.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Load JSON Data
            JsonNode jsonNode = mapper.readTree(new File("src/main/java/com/bridelabz/json/validatejson/user.json"));

            // Validate JSON
            if(schema.validate(jsonNode).isSuccess()) {
                System.out.println("JSON is valid");
            } else {
                System.out.println("JSON is invalid");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
