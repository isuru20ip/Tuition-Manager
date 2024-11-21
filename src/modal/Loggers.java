
package modal;

import java.util.logging.*;

public class Loggers {
 
    public static Logger logger = Logger.getLogger("tutionClass");
    static {
        try {
            FileHandler fileHandler = new FileHandler("tutionClass.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Erorr", e);
        }
    }
}

