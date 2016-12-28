<%@ page import="ru.innopolis.lectures.Lecture" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.11.2016
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список лекций</title>
</head>
<body>

<h2 align="center">Список лекций</h2>

<p align="center"><a href="${pageContext.request.contextPath}/add_lecture_form">Добавить лекцию</a>

        <% if(request.getAttribute("add_lecture") != null && request.getAttribute("add_lecture").equals(true)) { %>
<p>
    <form action="${pageContext.request.contextPath}/add_lecture_process" method="post">

<p align="center"> Выберите дату
    <input type="date" size="25" name="date">
<p><p>

<p align="center"> Введите тему
    <input type="text" size="25" name="subject">

<p><p>
<p align="center">
    <input type="submit" value="Добавить">
    <input type="reset" value="Сбросить">
    </form>
        <% } %>

<p>

<table align="center" border="3" width="100%">
    <tr>
        <td><strong>ID</strong></td>
        <td><strong>Дата</strong></td>
        <td><strong>Тема</strong></td>
        <td colspan="2"><strong>Действия</strong></td>
    </tr>

    <%
        List<Lecture> lectures = (List<Lecture>) request.getAttribute("lectures");
        if (lectures != null){
        for (Lecture lecture : lectures) {
            if(request.getAttribute("editLecture") != null &&
                    request.getAttribute("editLecture").equals(lecture.getLectureId())) {
    %>

    <tr>
        <form action="${pageContext.request.contextPath}/edit_lecture_process" method="post">
        <td><%= lecture.getLectureId()%></td>
        <td><input type="date" size="25" name="date" value="<%= lecture.getDate()%>"></td>
        <td><input type="text" size="25" name="subject" value="<%= lecture.getSubject()%>"></td>
        <td>
            <input type="hidden" value="<%= lecture.getLectureId()%>" name="id">
            <input type="submit" value="Изменить">
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/lectures_list">
                <input type="submit" value="Отмена">
            </form>
        </td>
    </tr>

            <% } else {%>
    <tr>
        <td><%= lecture.getLectureId()%></td>
        <td><%= lecture.getDate()%></td>
        <td><%= lecture.getSubject()%></td>
        <td>
            <form action="${pageContext.request.contextPath}/delete_lecture" method="post">
                <input type="hidden" value="<%= lecture.getLectureId()%>" name="id">
                <input type="submit" value="Удалить">
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/edit_lecture_form" method="post">
                <input type="hidden" value="<%= lecture.getLectureId()%>" name="id">
                <input type="submit" value="Редактировать">
            </form>
        </td>
    </tr>
    <%
        }
        }
        }
    %>
</table>

<p align="center"><a href="${pageContext.request.contextPath}/index">Назад на главную</a>

</body>
</html>
