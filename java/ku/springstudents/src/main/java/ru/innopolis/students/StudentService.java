package ru.innopolis.students;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> getStudentsFromDB() throws SQLException;

    Map<Student, Integer> getStudentsVisitCount(List<Student> students) throws SQLException;

    void addStudent(Student student) throws SQLException;

    void deleteStudent(Student student) throws SQLException;

    void editStudent(Student student) throws SQLException;
}
