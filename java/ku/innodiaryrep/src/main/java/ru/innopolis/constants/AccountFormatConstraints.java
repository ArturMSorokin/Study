package ru.innopolis.constants;

import java.util.regex.Pattern;

/**
 * Класс содержит константы, описывающие ограничения к данным учётной записи.
 */
public class AccountFormatConstraints {

    private AccountFormatConstraints() {
    }

    /**
     * Формат адреса электронной почты.
     */
    public static final String EMAIL_REGEX =
            "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";

    /**
     * Максимальная длина адреса электронной почты по описанию протокола SMTP, документу RFC 821.
     */
    public static final int MAX_EMAIL_LENGTH = 129;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Минимальная длина пароля.
     */
    public static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Максимальная длина пароля.
     */
    public static final int MAX_PASSWORD_LENGTH = 32;

    /**
     * Регулярное выражение, описывающее запрещённые в пароле символы (запрещены все, кроме перечисленных).
     */
    public static final Pattern PASSWORD_UNAVAILABLE_SYMBOLS =
            Pattern.compile("[^а-яА-Яa-zA-Z0-9~!@#$%&*()_+`\\-=:;<>.,?\\s]");

    /**
     * Соль для пароля.
     */
    public static final String PASSWORD_SALT = "Let us put a bit of salt on it.";

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Минимальная длина логина.
     */
    public static final int MIN_LOGIN_LENGTH = 4;

    /**
     * Максимальная длина логина.
     */
    public static final int MAX_LOGIN_LENGTH = 32;

    /**
     * Регулярное выражение, описывающее запрещённые в логине символы (запрещены все, кроме перечисленных).
     */
    public static final Pattern LOGIN_UNAVAILABLE_SYMBOLS = Pattern.compile("[^а-яА-Яa-zA-Z0-9]");

}
