package ru.innopolis.utils.validation;

import java.sql.SQLException;

public interface Validator {
    String pollErrors();
    void validateLogin(String login) throws SQLException;
    void validateEmail(String email) throws SQLException;
    void validatePassword(String password, String confirmedPassword) throws SQLException;
}
