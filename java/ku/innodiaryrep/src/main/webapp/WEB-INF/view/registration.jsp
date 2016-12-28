<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.11.2016
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InnoDiary - Регистрация</title>
</head>
<body>

<table align="center" width="100%" height="100%">
    <tr valign="top">
        <td></td>
        <td align="center"></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td align="center"><h2>Регистрация</h2></td>
        <td></td>
    </tr>
    <tr valign="middle">
        <td></td>
        <td align="center">
            <form action="${pageContext.request.contextPath}/registration_process" method=post>

                <p align="center"><strong>Введите логин</strong>
                <p align="center">(от 4 до 32 символов, можно использовать русские и английские буквы, а также цифры)
                <p align="center"><input type="text" name="login" size="25">
                <p><p>
                <p align="center"><strong>Введите пароль</strong>
                <p align="center">(от 8 до 32 символов, можно использовать русские и английские буквы, а также цифры и знаки препинания)
                <p align="center"><input type="password" size="25" name="password">
                <p><p>
                <p align="center"><strong>Повторно введите пароль: </strong>
                <p align="center"><input type="password" size="25" name="confirmedPassword">
                <p><p>
                <p align="center"><strong>Введите адрес электронной почты: </strong>
                <p align="center"><input type="text" size="25" name="email">
                <p><p>
                <input type="submit" value="Зарегистрироваться">
                <input type="reset" value="Сбросить">

                <% if (request.getAttribute("RegError") != null) { %>
                <p><%=request.getAttribute("RegError")%>
                <% } %>
            </form>
        </td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/index">Назад на главную</a>
        </td>
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
