package ru.innopolis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.lectures.Lecture;
import ru.innopolis.lectures.LectureService;

import java.sql.Date;
import java.sql.SQLException;

@Controller
public class LecturesController {

    private static Logger logger = LoggerFactory.getLogger(LecturesController.class);

    @Autowired
    private LectureService lectureService;

    @RequestMapping("/lectures_list")
    public String getLecturesList(Model model){

        try {
            model.addAttribute("lectures", lectureService.getLecturesFromDB());
        } catch (SQLException e) {
            logger.error("", e);
        }

        return "lectures_list";
    }

    @RequestMapping("/add_lecture_form")
    public String addLectureForm(Model model){
        model.addAttribute("add_lecture", true);
        getLecturesList(model);
        return "lectures_list";
    }

    @RequestMapping(value = "/add_lecture_process", method = RequestMethod.POST)
    public String addLectureProcess(@RequestParam (value = "date") String dateString,
                                    @RequestParam (value = "subject") String subject,
                                    Model model){
        Lecture newLecture = new Lecture();
        newLecture.setDate(Date.valueOf(dateString));
        newLecture.setSubject(subject);

        try {
            lectureService.addLecture(newLecture);
        } catch (SQLException e) {
            logger.error("", e);
        }

        getLecturesList(model);
        return "lectures_list";
    }

    @RequestMapping(value = "/delete_lecture", method = RequestMethod.POST)
    public String deleteLecture(@RequestParam (value = "id") Long id,
                                Model model){
        Lecture lecture = new Lecture();
        lecture.setLectureId(id);

        try {
            lectureService.deleteLecture(lecture);
        } catch (SQLException e) {
            logger.error("", e);
        }

        getLecturesList(model);
        return "lectures_list";
    }

    @RequestMapping(value = "/edit_lecture_form", method = RequestMethod.POST)
    public String editLecture(@RequestParam (value = "id") Long id,
                              Model model){

        model.addAttribute("editLecture", id);

        getLecturesList(model);
        return "lectures_list";
    }

    @RequestMapping(value = "/edit_lecture_process", method = RequestMethod.POST)
    public String editLectureProcess(@RequestParam (value = "id") Long id,
                                     @RequestParam (value = "date") String dateString,
                                     @RequestParam (value = "subject") String subject,
                                     Model model){

        Lecture lecture = new Lecture();
        lecture.setLectureId(id);
        lecture.setDate(Date.valueOf(dateString));
        lecture.setSubject(subject);

        try {
            lectureService.editLecture(lecture);
        } catch (SQLException e) {
            logger.error("", e);
        }

        getLecturesList(model);
        return "lectures_list";
    }

}
