package ru.innopolis.spring.Ioc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by olymp on 24.11.2016.
 */
public class Servlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(Servlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet????");
        try {
            Class.forName("org.h2.Driver");

            try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test7");
                 Statement statement = connection.createStatement();) {
                ForTest:
                {
                    statement.execute("CREATE TABLE IF NOT EXISTS student(name VARCHAR(255) primary key, sex bool,groupNum INT );");
                    statement.execute("insert into Product (surname, name) values ('sdf',true,22);");
                    statement.execute("insert into Product (surname, name) values ('ter',false,33);");
                }


                ResultSet resultSet = statement.executeQuery("select * from workers;");
                StringBuilder tableContent = new StringBuilder().append("\n");
                while (resultSet.next())
                    tableContent.append("<tr>\n" +
                            "<td>"+resultSet.getString(1)+"</td>\n" +
                            "<td>"+resultSet.getString(2)+"</td>\n" +
                            "</tr>\n");
                req.setAttribute("tableContent",tableContent.toString());
                System.out.println(tableContent.toString());



            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/StudentTable.jsp").forward(req,resp);
//        OutputStream os = resp.getOutputStream();
//        os.write("<html><body>Hello, world!</body></html>".getBytes());
    }

}
