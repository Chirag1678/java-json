package com.bridelabz.json.generatereport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Class to make data objects
class Person {
    public int id;
    public String name;
    public int age;
    public String gender;

    // Constructor
    public Person(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

// Class to generate a JSON report from database file
public class GenerateJSONReport {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        // Use try-catch to handle exceptions
        try {
            // Read lines from the text file
            List<String> lines = Files.readAllLines(Paths.get("src/main/java/com/bridelabz/json/generatereport/Database.txt"));

            // Process each line and convert it into a Person object
            for (String line : lines) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0].split(":")[1].trim());
                String name = parts[1].split(":")[1].trim();
                int age = Integer.parseInt(parts[2].split(":")[1].trim());
                String gender = parts[3].split(":")[1].trim();

                people.add(new Person(id, name, age, gender));
            }

            // Use Jackson to write List to JSON file
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty print

            mapper.writeValue(new File("src/main/java/com/bridelabz/json/generatereport/people.json"), people);

            System.out.println("JSON report created successfully: people.json");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Sample output ->
// JSON report created successfully: people.json