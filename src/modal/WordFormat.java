package modal;

/**
 *
 * @author isuru priyamntha
 */
public class WordFormat {

    public static String capitalizeFirstLetter(String input) {
        return Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
    }
}
