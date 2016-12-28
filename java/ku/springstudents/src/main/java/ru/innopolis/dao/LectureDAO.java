package ru.innopolis.dao;

import ru.innopolis.lectures.Lecture;

import java.sql.SQLException;
import java.util.List;

public interface LectureDAO {

    List<Lecture> getListFromDB() throws SQLException;

    void addLecture(Lecture lecture) throws SQLException;

    void deleteLecture(Lecture lecture) throws SQLException;

    void editLecture(Lecture lecture) throws SQLException;

}
