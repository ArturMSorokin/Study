package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by olymp on 22.11.2016.
 */
public class Main {
    public static void main(String[] arg) {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test")) {
            System.out.println("Succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
