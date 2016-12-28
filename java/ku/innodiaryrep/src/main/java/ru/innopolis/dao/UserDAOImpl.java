package ru.innopolis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.innopolis.pojo.User;
import ru.innopolis.utils.encryption.Encryptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.innopolis.constants.DataBaseProperties.DATA_SOURCE;
import static ru.innopolis.constants.DataBaseProperties.USERS_TABLE_NAME;

@Component
@Scope (value = "singleton")
public class UserDAOImpl implements UserDAO {

    @Autowired
    Encryptor encryptor;

    /**
     * Метод регистрирует пользователя в БД.
     * @param user пользователь, которого нужно зарегистрировать.
     * @throws SQLException при ошибках в работе с БД.
     */
    @Override
    public void registerUser(User user) throws SQLException {

        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ")
                .append(USERS_TABLE_NAME)
                .append(" VALUES (?, ?, ?)");

        try (Connection connection = DATA_SOURCE.getConnection();
             PreparedStatement userTableStatement = connection.prepareStatement(queryBuilder.toString())) {

            userTableStatement.setString(1, user.getLogin());
            userTableStatement.setString(2, encryptor.encrypt(user.getPassword()));
            userTableStatement.setString(3, user.getEmail());

            userTableStatement.executeUpdate();
        }
    }

    /**
     * Метод проверяет, зарегистрирован ли пользователь в БД.
     * @param user пользователь, которого нужно проверить.
     * @return true - зарегистрирован, false - нетю
     * @throws SQLException при ошибках в работе с БД.
     */
    @Override
    public boolean userIsRegistered(User user) throws SQLException {

        StringBuilder sqlQueryBuilder = new StringBuilder("SELECT * FROM ")
                .append(USERS_TABLE_NAME)
                .append(" WHERE login=? AND password=?");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryBuilder.toString())){

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, encryptor.encrypt(user.getPassword()));

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.isBeforeFirst();
        }
    }

    @Override
    public String getEmail(User user) throws SQLException {

        StringBuilder sqlQueryBuilder = new StringBuilder("SELECT email FROM ")
                .append(USERS_TABLE_NAME)
                .append(" WHERE login=?");

        try(Connection connection = DATA_SOURCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryBuilder.toString())){

            preparedStatement.setString(1, user.getLogin());

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getString(1);
        }
    }

    @Override
    public void changeAccountData(User user, String parameterName, String newValue) throws SQLException{
        StringBuilder queryBuilder = new StringBuilder("UPDATE ")
                .append(USERS_TABLE_NAME)
                .append(" SET ")
                .append(parameterName)
                .append("=? WHERE login=?");

        try (Connection connection = DATA_SOURCE.getConnection();
             PreparedStatement userTableStatement = connection.prepareStatement(queryBuilder.toString())) {

            userTableStatement.setString(1, encryptor.encrypt(newValue));
            userTableStatement.setString(2, user.getLogin());

            userTableStatement.executeUpdate();
        }
    }
}
