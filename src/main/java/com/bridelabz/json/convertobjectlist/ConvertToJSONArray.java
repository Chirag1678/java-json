package com.bridelabz.json.convertobjectlist;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Convert a list of java objects to json array
public class ConvertToJSONArray {
    public static void main(String[] args) {
        // Use try-catch to handle exceptions
        try {
            // Create a list of java objects
            List<User> javaObjects = new ArrayList<>();
            javaObjects.add(new User(101,"Amit",25,"amit@example.com"));
            javaObjects.add(new User(102,"Bhanu",35,"bhanu@example.com"));
            javaObjects.add(new User(103,"Chaitanya",22,"chaitanya@example.com"));
            javaObjects.add(new User(104,"Dinesh",45,"dinesh@example.com"));

            // Load objectmapper
            ObjectMapper mapper = new ObjectMapper();

            // Create a JSONArray
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(javaObjects);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/com/bridelabz/json/convertobjectlist/user.json"), javaObjects);

            System.out.println("Java objects as JSONArray:-");
            System.out.println(jsonArray);

            System.out.println("JSON Array written successfully to file!!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Sample output->
// Java objects as JSONArray:-
// [ {
//   "id" : 101,
//   "name" : "Amit",
//   "age" : 25,
//   "email" : "amit@example.com"
// }, {
//   "id" : 102,
//   "name" : "Bhanu",
//   "age" : 35,
//   "email" : "bhanu@example.com"
// }, {
//   "id" : 103,
//   "name" : "Chaitanya",
//   "age" : 22,
//   "email" : "chaitanya@example.com"
// }, {
//   "id" : 104,
//   "name" : "Dinesh",
//   "age" : 45,
//   "email" : "dinesh@example.com"
// } ]
// JSON Array written successfully to file!!