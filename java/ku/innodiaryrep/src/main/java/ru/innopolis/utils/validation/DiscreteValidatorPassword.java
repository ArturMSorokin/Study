package ru.innopolis.utils.validation;

import static ru.innopolis.constants.AccountFormatConstraints.*;

/**
 * Класс для проверки корректности пароля.
 */
class DiscreteValidatorPassword implements DiscreteValidator {

    private String password;
    private String confirmedPassword;
    private String errorString;

    /**
     * Конструктор.
     * @param password пароль.
     * @param confirmedPassword пароль, введённый в поле подтверждения.
     */
    DiscreteValidatorPassword(String password, String confirmedPassword) {
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    /**
     * Метод возвращает текст ошибки, если она возникла при валидации.
     * @return текст ошибки.
     */
    public String getErrorString() {
        return errorString;
    }

    /**
     * Метод для проверки корректности пароля при регистрации.
     * @return true пароль корректен и совпадает с тем, что введено в поле подтверждения, false - в других случаях.
     */
    @Override
    public boolean validate() {
        if (password != null && confirmedPassword != null && password.length() != 0){

            if(password.length() >= MIN_PASSWORD_LENGTH){

                if (password.length() <= MAX_PASSWORD_LENGTH){

                    if (!PASSWORD_UNAVAILABLE_SYMBOLS.matcher(password).find()){

                        if (password.equals(confirmedPassword)){

                            return true;

                        } else {
                            errorString = "Введенные пароли не совпадают.";
                            return false;
                        }

                    } else {
                        errorString = "Пароль содержит запрещённые символы.";
                        return false;
                    }

                } else {
                    errorString = "Пароль слишком длинный.";
                    return false;
                }

            } else {
                errorString = "Пароль слишком короткий.";
                return false;
            }

        } else {
            errorString = "Пароль не введён.";
            return false;
        }
    }
}
