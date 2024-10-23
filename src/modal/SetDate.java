package modal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetDate {
    
    public static String getDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }
}
