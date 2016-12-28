package ru.innopolis.dao;

import java.sql.SQLException;

public interface CommonDAO {

    /**
     * Метод проверяет, содержится ли значение в определённом столбце в БД.
     * @param table название таблицы в БД.
     * @param parameterName название столбца в БД.
     * @param parameterValue искомое значение.
     * @return true - если записи нет, false - если такая запись уже есть.
     * @throws SQLException при ошибках, связанных с работой БД.
     */
    boolean valueNotInDB(String table, String parameterName, String parameterValue) throws SQLException;

}
