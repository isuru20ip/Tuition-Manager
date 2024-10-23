package modal;

import java.util.Random;
import java.util.Vector;

public class IDGenarator {

    public static String generateID(String startText, Vector IDS) {
        final String Text = startText;
        final Vector vector = IDS;
        String ID = CoockID(Text);

        for (int i = 0; i < vector.size(); i++) {
            if (ID == vector.get(i)) {
                generateID(startText, IDS);
            }
        }

        return ID;
    }
    
    private static String CoockID(String startText) {
        // Startig Letter
        String prefix = startText;
        
        // Generate a random number with 6 digits (100000 to 999999)
        Random random = new Random();
        int number = 100000 + random.nextInt(999999);

        return prefix + number;
    }
    
}
