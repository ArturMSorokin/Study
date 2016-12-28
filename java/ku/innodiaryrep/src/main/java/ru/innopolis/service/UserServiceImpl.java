package ru.innopolis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.innopolis.dao.UserDAO;
import ru.innopolis.pojo.User;
import ru.innopolis.utils.validation.Validator;

import java.sql.SQLException;

@Service
@Scope (value = "singleton")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Validator validator;

    public String registerUser (User user, String confirmedPassword) throws SQLException{
        validator.validateLogin(user.getLogin());
        validator.validatePassword(user.getPassword(), confirmedPassword);
        validator.validateEmail(user.getEmail());

        String errors = validator.pollErrors();

        if (errors.isEmpty()){
            userDAO.registerUser(user);
        }

        return errors;
    }

    public boolean userIsRegistered(User user) throws SQLException{
        if(user.getLogin().isEmpty() || user.getPassword().isEmpty()){
            return false;
        } else {
            return userDAO.userIsRegistered(user);
        }
    }

    @Override
    public String changeEmail(User user, String newEmail) throws SQLException {
        validator.validateEmail(newEmail);
        String errors = validator.pollErrors();

        if (errors.isEmpty()){
            userDAO.changeAccountData(user, "email", newEmail);
        }

        return errors;
    }

    @Override
    public String changeLogin(User user, String newLogin) throws SQLException {
        validator.validateLogin(newLogin);
        String errors = validator.pollErrors();

        if (errors.isEmpty()){
            userDAO.changeAccountData(user, "login", newLogin);
        }

        return errors;
    }

    @Override
    public String changePassword(User user, String newPassword, String confirmedPassword) throws SQLException {
        validator.validatePassword(newPassword, confirmedPassword);
        String errors = validator.pollErrors();

        if (errors.isEmpty()){
            userDAO.changeAccountData(user, "password", newPassword);
        }

        return errors;
    }
}
