<%@ page import="ru.innopolis.students.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.11.2016
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список студентов</title>
</head>
<body>

    <h2 align="center">Список студентов</h2>

    <p align="center"><a href="${pageContext.request.contextPath}/add_student_form">Добавить студента</a>
    <% if(request.getAttribute("add_student") != null && request.getAttribute("add_student").equals(true)) { %>
        <p>
        <form action="${pageContext.request.contextPath}/add_student_process" method="post">

            <p align="center"> Введите ФИО
            <input type="text" size="25" name="fio">
            <p><p>

            <p align="center"> Введите пол
            <input type="text" size="25" name="sex">
            <p><p>

            <p align="center"> Введите группу
            <input type="text" size="25" name="group">

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
            <td><strong>ФИО</strong></td>
            <td><strong>Пол</strong></td>
            <td><strong>Группа</strong></td>
            <td><strong>Посещения</strong></td>
            <td colspan="2"><strong>Действия</strong></td>
        </tr>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");
    Map<Student, Integer> visits = (Map<Student, Integer>) request.getAttribute("visits");
    if (students != null){
        for (Student student : students) {
            if(request.getAttribute("editStudent") != null &&
                    request.getAttribute("editStudent").equals(student.getStudentId())) {
%>

        <tr>
            <form action="${pageContext.request.contextPath}/edit_student_process" method="post">
            <td><%= student.getStudentId()%></td>
            <td><input type="text" size="25" name="fio" value="<%= student.getFullName()%>"></td>
            <td><input type="text" size="25" name="sex" value="<%= student.getSex()%>"></td>
            <td><input type="text" size="25" name="group" value="<%= student.getGroup()%>"></td>
            <td><%= visits.get(student)%></td>
            <td>
                <input type="hidden" value="<%= student.getStudentId()%>" name="id">
                <input type="submit" value="Изменить">
            </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/students_list">
                    <input type="submit" value="Отмена">
                </form>
            </td>
        </tr>

        <% } else { %>
        <tr>
            <td><%= student.getStudentId()%></td>
            <td><%= student.getFullName()%></td>
            <td><%= student.getSex()%></td>
            <td><%= student.getGroup()%></td>
            <td><%= visits.get(student)%></td>
            <td>
                <form action="${pageContext.request.contextPath}/delete_student" method="post">
                    <input type="hidden" value="<%= student.getStudentId()%>" name="id">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/edit_student_form" method="post">
                    <input type="hidden" value="<%= student.getStudentId()%>" name="id">
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