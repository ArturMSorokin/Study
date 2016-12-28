package ru.innopolis.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.dao.StudentDAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDao;

    public List<Student> getStudentsFromDB() throws SQLException{
        return studentDao.getListFromDB();
    }

    public Map<Student, Integer> getStudentsVisitCount(List<Student> students) throws SQLException{

        Map<Student, Integer> studentsWithVisits = new HashMap<>();

        for (Student student : students) {
            studentsWithVisits.put(student, studentDao.getStudentVisitCount(student));
        }

        return studentsWithVisits;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        studentDao.deleteStudent(student);
    }

    @Override
    public void editStudent(Student student) throws SQLException{
        studentDao.editStudent(student);
    }
}
