package database;

import java.sql.*;

/**
 * Created by olymp on 22.11.2016.
 */
public class Main {
    public static final String INSERT = "insert into Product (id name) values (1,'Ivan');";
    public static void main(String[] arg) {
        try {
            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test2");
                 Statement statement = connection.createStatement()
        )  {
            statement.execute("create table product(id integer primary key, name VARCHAR(255));");
            int count = statement.executeUpdate(INSERT);
            ResultSet result = statement.executeQuery("SELECT  * FROM PRODUCT");
            while (result.next()) {
                System.out.println("id = "+result.getInt(1)+"    "+result.getString(2));
            }
            System.out.println("Succes, added ="+count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
