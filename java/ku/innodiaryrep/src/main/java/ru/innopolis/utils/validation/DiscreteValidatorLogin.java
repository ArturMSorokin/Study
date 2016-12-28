package ru.innopolis.utils.validation;

import java.sql.SQLException;

import static ru.innopolis.constants.AccountFormatConstraints.*;
import static ru.innopolis.constants.DataBaseProperties.USERS_TABLE_NAME;

/**
 * Класс для валидации логина.
 */
class DiscreteValidatorLogin extends DiscreteValidatorDBEntry {

    /**
     * Конструктор
     *
     * @param login проверяемый логин.
     */
    DiscreteValidatorLogin(String login) {
        super(USERS_TABLE_NAME, "login", login);
    }

    /**
     * Метод для проверки корректности логина.
     * @return true - логин корректен, false - нет.
     * @throws SQLException при ошибках, связанных с работой БД.
     */
    @Override
    public boolean validate() throws SQLException{

        if (valueIsNotNullAndNotEmpty()){

            if (getParameterValue().length() >= MIN_LOGIN_LENGTH){

                if (getParameterValue().length() <= MAX_LOGIN_LENGTH){

                    if (!LOGIN_UNAVAILABLE_SYMBOLS.matcher(getParameterValue()).find()){

                        if (okToAdd()){

                            return true;

                        } else {
                            setErrorString ("Такой логин уже используется.");
                            return false;
                        }

                    } else {
                        setErrorString ("Логин содержит запрещённые символы.");
                        return false;
                    }

                } else {
                    setErrorString ("Слишком длинный логин.");
                    return false;
                }

            } else {
                setErrorString ("Слишком короткий логин.");
                return false;
            }

        } else {
            setErrorString("Логин не введён.");
            return false;
        }

    }
}
