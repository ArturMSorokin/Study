package ru.innopolis.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.innopolis.constants.DataBaseProperties.DATA_SOURCE;

@Component
@Scope(value = "singleton")
public class CommonDAOImpl implements CommonDAO {

    /**
     * Метод проверяет, содержится ли значение в определённом столбце в БД.
     * @param table название таблицы в БД.
     * @param parameterName название столбца в БД.
     * @param parameterValue искомое значение.
     * @return true - если записи нет, false - если такая запись уже есть.
     * @throws SQLException при ошибках, связанных с работой БД.
     */
    @Override
    public boolean valueNotInDB(String table, String parameterName, String parameterValue) throws SQLException {
        {
            StringBuilder sqlQueryBuilder = new StringBuilder("SELECT * FROM ").append(table).append(" WHERE ").
                    append(parameterName).append(" = ?");

            try (Connection connection = DATA_SOURCE.getConnection();
                 PreparedStatement existsCheckStatement = connection.prepareStatement(sqlQueryBuilder.toString())){

                existsCheckStatement.setString(1, parameterValue);

                ResultSet existsResultSet = existsCheckStatement.executeQuery();

                return !existsResultSet.isBeforeFirst();
            }
        }
    }
}
