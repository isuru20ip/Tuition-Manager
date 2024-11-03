package modal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author isuru priyamntha
 */
public class DB {

    private static enum DBState {
        Local, Cloud;
    }

    // Set DB state
    private static final DBState STATE = DBState.Local;

    // DB Connection
    private static Connection connection;

    private static void setConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            if (STATE == DBState.Cloud) {
                connection = DriverManager.getConnection("jdbc:mysql://final-project-final-project.i.aivencloud.com:19332/tution_db", "avnadmin", "AVNS_1AEuyZC9iNXKbvo72Mv");
            } else if (STATE == DBState.Local) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tuition_db", "root", "Kaveesh3841k");
            }

        }
    }

    public static Integer IUD(String q) throws ClassNotFoundException, SQLException {
        setConnection();
        return connection.createStatement().executeUpdate(q);
    }

    public static ResultSet search(String q) throws ClassNotFoundException, SQLException {
        setConnection();
        return connection.createStatement().executeQuery(q);
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
