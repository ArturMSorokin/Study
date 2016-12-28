<%@ page import="java.security.Principal" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.11.2016
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>InnoDiary - Главная</title>
    </head>
    <body>

    <table align="center" width="100%" height="100%">
        <tr valign="top">
            <td></td>
            <td align="center"></td>
            <td>
                <%String userName = (String) session.getAttribute("username");%>
                <%
                    if (userName != null){
                %>
                <a href="${pageContext.request.contextPath}/private"><%= userName%></a>
                <p><a href="${pageContext.request.contextPath}/logout">Выход</a>
                <%
                    } else{
                %>
                    <a href="${pageContext.request.contextPath}/private">Вход</a>
                    <p><a href="${pageContext.request.contextPath}/registration_form">Регистрация</a>
                <%
                        }
                %>

            </td>
        </tr>
        <tr>
            <td></td>
            <td align="center">Это главная страница.</td>
            <td></td>
        </tr>
        <tr valign="middle">
            <td></td>
            <td align="center"></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td align="center"></td>
            <td></td>
        </tr>
        <tr valign="bottom">
            <td></td>
            <td align="center"></td>
            <td></td>
        </tr>
    </table>

    </body>
</html>
