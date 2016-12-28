package database;

import java.sql.*;

/**
 * Created by olymp on 22.11.2016.
 */
public class Main {
    public static final String INSERT = "insert into Product (id, name) values (1,'Ivan');";
    public static final String PREPARED_INSERT = "insert into Product (id, name) values (?,?);";
    public static void main(String[] arg) {
        try {
            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test6");
                 Statement statement = connection.createStatement();
                PreparedStatement  pStatement = connection.prepareStatement(PREPARED_INSERT);
                Statement statement1 = connection.createStatement();
        )  {
            statement.execute("CREATE TABLE IF NOT EXISTS PRODUCT(ID  INT primary key, name VARCHAR(255));");
//            int count = statement.executeUpdate(INSERT);
            ResultSet result = statement.executeQuery("SELECT  * FROM PRODUCT");
            while (result.next()) {
                System.out.println("id = "+result.getInt(1)+"    "+result.getString(2));
            }
//            System.out.println("Succes, added ="+count);

            for (int i=2; i<100; ++i) {
                pStatement.setInt(1,i);
                pStatement.setString(2,"name"+i);
                pStatement.executeUpdate();
            }
            ResultSet resultSet = statement1.executeQuery("SELECT *FROM PRODUCT;");
            while (resultSet.next())
                System.out.println("id:"+resultSet.getInt(1)+"    name:"+resultSet.getString(2));
//            connection.commit();
//            connection.rollback();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
