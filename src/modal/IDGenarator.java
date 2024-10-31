package modal;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class IDGenarator {

    // Generate a new ID based on prefix and validate against the database
    public static String generateID(String prefix) throws SQLException {
        Set<String> existingIDs = getExistingIDsFromDB(); // Fetch all existing IDs
        String lastID = getLastID(prefix, existingIDs);   // Get the latest used ID

        String newID = incrementID(lastID, prefix); // Generate the next ID

        // Handle ID limit case (if it exceeds 999999)
        if (newID == null) {
            throw new RuntimeException("ID limit reached. Cannot generate a new ID.");
        }

        return newID;
    }

    // Retrieve all employee IDs from the database to ensure uniqueness
    private static Set<String> getExistingIDsFromDB() throws SQLException {
        Set<String> existingIDs = new HashSet<>();

        try {
            String query = "SELECT id FROM employee"; // Update with your table name if needed

            ResultSet rs = DB.search(query);

            while (rs.next()) {
                existingIDs.add(rs.getString("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return existingIDs;
    }

// Find the highest existing ID based on the prefix
    private static String getLastID(String prefix, Set<String> existingIDs) {
        String lastID = prefix + "000000"; // Default ID if no IDs exist

        for (String id : existingIDs) {
            if (id.startsWith(prefix) && id.compareTo(lastID) > 0) {
                lastID = id;
            }
        }
        return lastID;
    }

    // Increment the numeric part of the ID
    private static String incrementID(String currentID, String prefix) {
        // Extract the numeric part (e.g., "EMP00123" -> "00123")
        String numericPart = currentID.substring(prefix.length());

        // Parse the numeric part and increment it
        int number = Integer.parseInt(numericPart) + 1;

        // If the number exceeds the limit, return null
        if (number > 999999) {
            return null;
        }

        // Format the new number with leading zeros (e.g., 123 -> "00123")
        String newNumericPart = String.format("%05d", number);

        // Return the new ID with the prefix
        return prefix + newNumericPart;
    }
}
