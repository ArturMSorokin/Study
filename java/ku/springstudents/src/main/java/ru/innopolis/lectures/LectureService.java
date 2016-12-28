package ru.innopolis.lectures;

import java.sql.SQLException;
import java.util.List;

public interface LectureService {

    List<Lecture> getLecturesFromDB() throws SQLException;

    void addLecture(Lecture lecture) throws SQLException;

    void deleteLecture(Lecture lecture) throws SQLException;

    void editLecture(Lecture lecture) throws SQLException;

}
