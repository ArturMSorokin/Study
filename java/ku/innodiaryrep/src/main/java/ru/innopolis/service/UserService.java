package ru.innopolis.service;

import ru.innopolis.pojo.User;

import java.sql.SQLException;

public interface UserService {

    String registerUser (User user, String confirmedPassword) throws SQLException;

    boolean userIsRegistered(User user) throws SQLException;

    String changeEmail(User user, String newEmail) throws SQLException;

    String changeLogin(User user, String newLogin) throws SQLException;

    String changePassword(User user, String newPassword, String confirmedPassword) throws SQLException;
}
