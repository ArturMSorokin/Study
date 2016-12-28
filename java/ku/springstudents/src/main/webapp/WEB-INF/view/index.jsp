<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.11.2016
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Spring Students</title>
  </head>
  <body>

  <h2 align="center">Система по учёту студентов</h2>

  <table align="center">
      <tr><td>
          <a href="${pageContext.request.contextPath}/students_list">Список студентов</a>
      </td></tr>
      <tr><td>
          <a href="${pageContext.request.contextPath}/lectures_list">Список лекций</a>
      </td></tr>
      <tr><td>
          <a href="${pageContext.request.contextPath}/add_visit">Добавление посещения</a>
      </td></tr>
  </table>

  </body>
</html>
