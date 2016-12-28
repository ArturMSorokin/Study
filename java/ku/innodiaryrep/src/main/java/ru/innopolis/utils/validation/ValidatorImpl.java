package ru.innopolis.utils.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Класс для совместной работы с несколькими валидаторами.
 */
@Component
public class ValidatorImpl implements Validator {

    private static Logger logger = LoggerFactory.getLogger(ValidatorImpl.class);

    private StringBuilder errorMessageBuilder = new StringBuilder();

    public ValidatorImpl() {
    }

    public String pollErrors() {
        String errors = errorMessageBuilder.toString();
        errorMessageBuilder = new StringBuilder();
        return errors;
    }

    @Override
    public void validateLogin(String login) throws SQLException {
        DiscreteValidator validator = new DiscreteValidatorLogin(login);
        runDiscreteValidator(validator);
    }

    @Override
    public void validateEmail(String email) throws SQLException {
        DiscreteValidator validator = new DiscreteValidatorEmail(email);
        runDiscreteValidator(validator);
    }

    @Override
    public void validatePassword(String password, String confirmedPassword) {

        DiscreteValidator validator = new DiscreteValidatorPassword(password, confirmedPassword);

        try {
            runDiscreteValidator(validator);
        } catch (SQLException e) {
            logger.error("", e);
        }
    }

    private void runDiscreteValidator(DiscreteValidator discreteValidator) throws SQLException {
        if (!discreteValidator.validate()) {
            errorMessageBuilder.append(discreteValidator.getErrorString()).append(" ");
        }
    }
}
