package ru.innopolis.dao;

import org.springframework.stereotype.Component;
import ru.innopolis.lectures.Lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.constants.DataBaseProperties.DATA_SOURCE;
import static ru.innopolis.constants.DataBaseProperties.LECTURES_TABLE_NAME;
import static ru.innopolis.constants.DataBaseProperties.STUDENTS_TABLE_NAME;

@Component
public class LectureDAOImpl implements LectureDAO {

    @Override
    public List<Lecture> getListFromDB() throws SQLException {
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM ").append(LECTURES_TABLE_NAME);
        List<Lecture> lecturesList = new ArrayList<>();

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Lecture newLecture = new Lecture();
                newLecture.setLectureId(resultSet.getLong(1));
                newLecture.setDate(resultSet.getDate(2));
                newLecture.setSubject(resultSet.getString(3));
                lecturesList.add(newLecture);
            }
        }
        return lecturesList;
    }

    @Override
    public void addLecture(Lecture lecture) throws SQLException {

        StringBuilder sqlQuery = new StringBuilder("INSERT INTO ")
                .append(LECTURES_TABLE_NAME)
                .append(" (date, subject) VALUES (?, ?)");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            preparedStatement.setDate(1, lecture.getDate());
            preparedStatement.setString(2, lecture.getSubject());

            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void deleteLecture(Lecture lecture) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder("DELETE FROM ")
                .append(LECTURES_TABLE_NAME)
                .append(" WHERE lecture_id=?");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            preparedStatement.setLong(1, lecture.getLectureId());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void editLecture(Lecture lecture) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder("UPDATE ").
                append(LECTURES_TABLE_NAME).
                append(" SET date=?, subject=? WHERE lecture_id=?");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())){

            preparedStatement.setDate(1, lecture.getDate());
            preparedStatement.setString(2, lecture.getSubject());
            preparedStatement.setLong(3, lecture.getLectureId());

            preparedStatement.executeUpdate();
        }
    }
}
