package com.bridelabz.json.coverttoobject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

// Class to convert a Java Object to Json Object
public class ConvertToJsonObject {
    public static void main(String[] args) {
        // Use try catch to handle exceptions
        try {
            // Create Object mapper to map java object to json string
            ObjectMapper mapper = new ObjectMapper();

            // Create Car Object and set values
            Car car = new Car();
            car.setCapacity(4);
            car.setMileage(25.5);
            car.setYear(2024);
            car.setModel("Swift Dzire");

            // Convert Java Object to JSON
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/com/bridelabz/json/coverttoobject/car.json"), car);
            System.out.println("JSON file created successfully!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
