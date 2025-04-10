package com.bridelabz.json.converttoxml;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Class to convert Json object format to xml format
public class ConvertJSONToXML {
    public static void main(String[] args) {
        // Use try-catch to handle exceptions
        try {
            // Read file content as String
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/com/bridelabz/json/converttoxml/users.json")));

            // Convert content to JSONArray
            JSONArray usersArray = new JSONArray(content);

            // Prepare a StringBuilder to hold the final XML content
            StringBuilder xmlData = new StringBuilder();
            xmlData.append("<users>\n"); // Start root element

            // Iterate over the JSON array
            for (int i = 0; i < usersArray.length(); i++) {
                // Get each JSON object from the array
                JSONObject user = usersArray.getJSONObject(i);

                // Convert the JSON object to an XML string with "user" as the root tag
                String userXml = XML.toString(user, "user", 1);

                // Append this user’s XML data to the XML output
                xmlData.append(userXml).append("\n");
            }

            xmlData.append("</users>"); // Close root element

            // Write the final XML string to an output file
            FileWriter fileWriter = new FileWriter("src/main/java/com/bridelabz/json/converttoxml/users.xml");
            fileWriter.write(xmlData.toString());
            fileWriter.close();

            System.out.println("XML file created successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Sample Output ->
//XML file created successfully!