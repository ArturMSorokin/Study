package ru.innopolis.dao;

import ru.innopolis.pojo.User;

import java.sql.SQLException;

public interface UserDAO{

    void registerUser(User user) throws SQLException;

    boolean userIsRegistered(User user) throws SQLException;

    String getEmail(User user) throws SQLException;

    void changeAccountData(User user, String parameterName, String newValue) throws SQLException;

}