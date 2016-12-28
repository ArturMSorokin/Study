package ru.innopolis.dao;

import ru.innopolis.students.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    List<Student> getListFromDB() throws SQLException;

    int getStudentVisitCount(Student student) throws SQLException;

    void addStudent(Student student) throws SQLException;

    void deleteStudent(Student student) throws SQLException;

    void editStudent(Student student) throws SQLException;

}
