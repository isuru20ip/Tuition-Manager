package modal;

/**
 *
 * @author isuru Priyamantha
 */
import java.util.regex.Pattern;

public enum Validator {

    NAME {
        @Override
        public boolean validate(String value) {
            // Check if the name is not empty and doesn't contain any numbers
            return value != null && !value.trim().isEmpty() && value.matches("^[A-Za-z\\s]+$");
        }
    },
    MOBILE_NUMBER {
        @Override
        public boolean validate(String value) {
            // Validate if the mobile number (starts with +94 or 07 and has 9 digits)
            return value != null && value.matches("^(\\+94|0)?7[01245678]\\d{7}$");
        }
    },
    AMOUNT {
        @Override
        public boolean validate(String value) {
            // Validate if the amount is a non-negative number
            try {
                double amount = Double.parseDouble(value);
                return amount >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    },
    EMAIL {
        @Override
        public boolean validate(String value) {
            // Validate email format using a regex pattern
            String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            return value != null && Pattern.compile(emailPattern).matcher(value).matches();
        }
    };

    public abstract boolean validate(String value);
}
