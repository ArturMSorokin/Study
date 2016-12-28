package ru.innopolis.dao;

import org.springframework.stereotype.Component;
import ru.innopolis.students.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.constants.DataBaseProperties.*;

@Component
public class StudentDAOImpl implements StudentDAO{

    public List<Student> getListFromDB() throws SQLException{
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM ").append(STUDENTS_TABLE_NAME);
        List<Student> studentsList = new ArrayList<>();

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Student newStudent = new Student();
                newStudent.setStudentId(resultSet.getLong(1));
                newStudent.setFullName(resultSet.getString(2));
                newStudent.setSex(resultSet.getString(3));
                newStudent.setGroup(resultSet.getString(4));
                studentsList.add(newStudent);
            }
            return studentsList;
        }
    }

    @Override
    public int getStudentVisitCount(Student student) throws SQLException {
        int visitCount = 0;
        StringBuilder sqlQuery = new StringBuilder("SELECT COUNT(student_id) FROM ")
                .append(VISITS_TABLE_NAME)
                .append(" WHERE student_id = ?");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            preparedStatement.setLong(1, student.getStudentId());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                visitCount = resultSet.getInt(1);
            }
        }
        return visitCount;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder("INSERT INTO ")
                .append(STUDENTS_TABLE_NAME)
                .append(" (full_name, sex, \"group\") VALUES (?, ?, ?)");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setString(3, student.getGroup());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder("DELETE FROM ")
                .append(STUDENTS_TABLE_NAME)
                .append(" WHERE student_id=?");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            preparedStatement.setLong(1, student.getStudentId());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void editStudent(Student student) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder("UPDATE ").
                append(STUDENTS_TABLE_NAME).
                append(" SET full_name=?, sex=?, \"group\"=? WHERE student_id=?");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setString(3, student.getGroup());
            preparedStatement.setLong(4, student.getStudentId());

            preparedStatement.executeUpdate();
        }
    }
}



