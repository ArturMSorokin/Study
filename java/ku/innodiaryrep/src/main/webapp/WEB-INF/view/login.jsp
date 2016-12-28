<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.11.2016
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>InnoDiary - Вход</title>
</head>

<table align="center" width="100%" height="100%">
    <tr valign="top">
        <td></td>
        <td align="center"></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td align="center">
            <h2>Вход</h2>

            <% if (request.getAttribute("RegSuccess") != null){ %>
            <p><%=request.getAttribute("RegSuccess")%>
            <% } %>
        </td>
        <td></td>
    </tr>
    <tr valign="middle">
        <td></td>
        <td align="center">
            <form action="${pageContext.request.contextPath}/login_process" method=post>
                <p align="center"><strong>Ваш логин: </strong>
                <p align="center"><input type="text" name="username" size="25">
                <p><p>
                <p align="center"><strong>Ваш пароль: </strong>
                <p align="center"><input type="password" size="25" name="password">
                <p><p>
                <input type="submit" value="Войти">
                <input type="reset" value="Сбросить">

                <p>
                    <% if (request.getAttribute("Error") != null){ %>
                        <%=request.getAttribute("Error")%>
                    <% } %>

            </form>
        </td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/registration_form">Регистрация</a>
            <p><a href="${pageContext.request.contextPath}/index">Назад на главную</a>
        </td>
        <td></td>
    </tr>
    <tr valign="bottom">
        <td></td>
        <td align="center"></td>
        <td></td>
    </tr>
</table>


</html>
