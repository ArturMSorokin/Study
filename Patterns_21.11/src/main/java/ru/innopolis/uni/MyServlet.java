package ru.innopolis.uni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

/**
 * Created by olymp on 18.11.2016.
 */
public class MyServlet  extends HttpServlet {
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            getServletContext().getRequestDispatcher("/manTable.jsp").forward(req, resp);
            StringBuilder html = new StringBuilder();
            html.append("<html>\n" +
                    "<head>\n" +
                    "  <title>HTML Editor - Full Version</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Workers</h1>\n" +
                    "<p><a title=\"Add new\" href=\"localhost/addNew\">add new </a></p>\n" +
                    "<table border=\"1\">\n" +
                    "<tbody>\n");
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test4");
                 Statement statement = connection.createStatement();) {
                ResultSet resultSet = statement.executeQuery("select * from workers;");
                while (resultSet.next())
                    html.append("<tr>\n" +
                            "<td>"+resultSet.getString(1)+"</td>\n" +
                            "<td>"+resultSet.getString(2)+"</td>\n" +
                            "</tr>\n");
                html.append("</tbody>\n" +
                        "</table>  \n" +
                        "  <h1>&nbsp;</h1>\n" +
                        "</body>\n" +
                        "</html>\n");


            } catch (SQLException e) {
                e.printStackTrace();
            }


     html.append("<html>\n" +
                    "<head>\n" +
                    "  <title>HTML Editor - Full Version</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Workers</h1>\n" +
                    "<p><a title=\"Add new\" href=\"localhost/addNew\">add new </a></p>\n" +
                    "<table border=\"1\">\n" +
                    "<tbody>");
            OutputStream outputStream = resp.getOutputStream();
            outputStream.write(html.toString().getBytes());
        }
}
