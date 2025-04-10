package com.bridelabz.json.createobject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

// Class to generate a json object of student with fields name, age, subjects
public class CreateJSONObject {
    public static void main(String[] args) {
        // USe try-catch to handle exceptions
        try {
            // Create Json array for subjects
            JSONArray subjectArray = new JSONArray();
            subjectArray.put("Java");
            subjectArray.put("Python");
            subjectArray.put("C++");

            // Create Json object
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Student 1");
            jsonObject.put("age", 21);
            jsonObject.put("subjects", subjectArray);

            // Write data to file using filewriter
            try(FileWriter fw = new FileWriter("src/main/java/com/bridelabz/json/createobject/student.json")) {
                fw.write(jsonObject.toString(4)); // for pretty-printing
                System.out.println("JSON Object created successfully!!");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
