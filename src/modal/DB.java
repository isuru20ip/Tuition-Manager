package modal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import modal.beans.Home;

/**
 *
 * @author isuru priyamntha
 */
public class DB {

    // DB Connection
    private static Connection connection;

    private static void setConnection() throws ClassNotFoundException, SQLException, IOException {
        if (connection == null) {
            // set Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // get Host data
            Home dbc = new HomeInfo().getHome();
            String host = dbc.getHost();
            String port = dbc.getPort();
            String dataBase = dbc.getDatabase();
            String admin = dbc.getAdmin();
            String password = dbc.getPassword();

            // set onnection 
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dataBase, admin, password);
        }
    }

    public static Integer IUD(String q) throws ClassNotFoundException, SQLException, IOException {
        setConnection();
        return connection.createStatement().executeUpdate(q);
    }

    public static ResultSet search(String q) throws ClassNotFoundException, SQLException, IOException {
        setConnection();
        return connection.createStatement().executeQuery(q);
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
