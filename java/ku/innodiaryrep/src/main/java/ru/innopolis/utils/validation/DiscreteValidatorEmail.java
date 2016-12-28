package ru.innopolis.utils.validation;

import ru.innopolis.constants.AccountFormatConstraints;

import java.sql.SQLException;

import static ru.innopolis.constants.AccountFormatConstraints.MAX_EMAIL_LENGTH;
import static ru.innopolis.constants.DataBaseProperties.USERS_TABLE_NAME;

/**
 * Класс для валидации адреса электронной почты.
 */
class DiscreteValidatorEmail extends DiscreteValidatorDBEntry {

    /**
     * Конструктор
     *
     * @param email проверяемый адрес электронной почты
     */
    DiscreteValidatorEmail(String email) {
        super(USERS_TABLE_NAME, "email", email);
    }

    /**
     * Метод для проверки корректности адреса электронной почты.
     * @return true - email корректен, false - нет.
     * @throws SQLException  при ошибках, связанных с работой БД.
     */
    @Override
    public boolean validate() throws SQLException{

        if (valueIsNotNullAndNotEmpty()){

            if (getParameterValue().length() <= MAX_EMAIL_LENGTH) {

                if (getParameterValue().matches(AccountFormatConstraints.EMAIL_REGEX)) {

                    if (okToAdd()){

                        return true;

                    } else {
                        setErrorString ("Такой адрес электронной почты уже используется.");
                        return false;
                    }

                } else {
                    setErrorString("Неверный формат адреса электронной почты.");
                    return false;
                }

            } else {
                setErrorString("Недопустимая длина адреса электронной почты.");
                return false;
            }

        } else {
            setErrorString("Адрес электронной почты не введён.");
            return false;
        }
    }
}
