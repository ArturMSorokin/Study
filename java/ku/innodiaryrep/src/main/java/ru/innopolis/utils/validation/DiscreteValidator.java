package ru.innopolis.utils.validation;

import java.sql.SQLException;

/**
 * Интерфейс, который должны использовать все валидаторы данных.
 */
interface DiscreteValidator {

    /**
     * Метод возвращает текст ошибки, если она возникла при валидации.
     * @return текст ошибки.
     */
    String getErrorString();

    /**
     * Метод для проверки данных.
     * @return true - если данные верны, false - если нет.
     * @throws SQLException  при ошибках, связанных с работой БД.
     */
    boolean validate() throws SQLException;
}