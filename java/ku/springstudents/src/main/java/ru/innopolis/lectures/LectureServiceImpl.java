package ru.innopolis.lectures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.dao.LectureDAO;

import java.sql.SQLException;
import java.util.List;

@Component
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureDAO lectureDAO;

    public List<Lecture> getLecturesFromDB() throws SQLException{
        return lectureDAO.getListFromDB();
    }

    @Override
    public void addLecture(Lecture lecture) throws SQLException {
        lectureDAO.addLecture(lecture);
    }

    @Override
    public void deleteLecture(Lecture lecture) throws SQLException {
        lectureDAO.deleteLecture(lecture);
    }

    @Override
    public void editLecture(Lecture lecture) throws SQLException {
        lectureDAO.editLecture(lecture);
    }
}
