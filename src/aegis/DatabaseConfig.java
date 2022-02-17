package aegis;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

    public static Connection connect() {

        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/mydb";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, userName, password);
            return con;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }
}
