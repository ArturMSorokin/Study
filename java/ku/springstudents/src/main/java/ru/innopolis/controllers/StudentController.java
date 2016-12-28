package ru.innopolis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.students.Student;
import ru.innopolis.students.StudentService;

import java.sql.SQLException;
import java.util.List;

@Controller
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("/students_list")
    public String getStudentList(Model model){
        try {
            List<Student> students = studentService.getStudentsFromDB();
            model.addAttribute("students", students);
            model.addAttribute("visits", studentService.getStudentsVisitCount(students));
        } catch (SQLException e) {
            logger.error("", e);
        }
        return "students_list";
    }

    @RequestMapping("/add_student_form")
    public String addStudentForm(Model model){
        model.addAttribute("add_student", true);
        getStudentList(model);
        return "students_list";
    }

    @RequestMapping(value = "/add_student_process", method = RequestMethod.POST)
    public String addStudentProcess(@RequestParam (value = "fio") String fullName,
                                    @RequestParam (value = "sex") String sex,
                                    @RequestParam (value = "group") String group,
                                    Model model){

        Student newStudent = new Student();
        newStudent.setFullName(fullName);
        newStudent.setSex(sex);
        newStudent.setGroup(group);

        try {
            studentService.addStudent(newStudent);
        } catch (SQLException e) {
            logger.error("", e);
        }

        getStudentList(model);
        return "students_list";
    }

    @RequestMapping(value = "/delete_student", method = RequestMethod.POST)
    public String deleteStudent(@RequestParam (value = "id") Long id,
                                       Model model){

        Student student = new Student();
        student.setStudentId(id);

        try {
            studentService.deleteStudent(student);
        } catch (SQLException e) {
            logger.error("", e);
        }

        getStudentList(model);
        return "students_list";
    }

    @RequestMapping(value = "/edit_student_form", method = RequestMethod.POST)
    public String editStudent(@RequestParam (value = "id") Long id,
                                Model model){

        model.addAttribute("editStudent", id);

        getStudentList(model);
        return "students_list";
    }

    @RequestMapping(value = "/edit_student_process", method = RequestMethod.POST)
    public String editStudentProcess(@RequestParam (value = "id") Long id,
                                     @RequestParam (value = "fio") String fullName,
                                     @RequestParam (value = "sex") String sex,
                                     @RequestParam (value = "group") String group,
                                     Model model){

        Student student = new Student();
        student.setStudentId(id);
        student.setFullName(fullName);
        student.setSex(sex);
        student.setGroup(group);

        try {
            studentService.editStudent(student);
        } catch (SQLException e) {
            logger.error("", e);
        }

        getStudentList(model);
        return "students_list";
    }

}
