package ru.innopolis.utils.validation;

import ru.innopolis.dao.CommonDAO;
import ru.innopolis.dao.CommonDAOImpl;

import java.sql.SQLException;

/**
 * Абстрактный класс, который проверяет на корректность данные, полученные из БД.
 */
abstract class DiscreteValidatorDBEntry implements DiscreteValidator {

    private String table;
    private String parameterName;
    private String parameterValue;
    private String errorString;

    private CommonDAO commonDAO = new CommonDAOImpl();

    /**
     * Конструктор
     * @param table название таблицы в БД.
     * @param parameterName название столбца в БД.
     * @param parameterValue искомое значение.
     */
    DiscreteValidatorDBEntry(String table, String parameterName, String parameterValue) {
        this.table = table;
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    /**
     * Метод возвращает искомое значение.
     * @return искомое значение.
     */
    String getParameterValue() {
        return parameterValue;
    }

    /**
     * Метод для смены текста ошибки.
     * @param errorString текст ошибки.
     */
    void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    /**
     * Метод проверяет, не является ли переданное значение null или пустым.
     * @return true - если значение не null и не пустое, false - если null или пустое.
     */
    boolean valueIsNotNullAndNotEmpty(){
        return parameterValue != null && parameterValue.length() != 0;
    }

    /**
     * Метод проверяет, можно ли добавить такое значение в БД.
     * @return true - если записи нет, false - если такая запись уже есть.
     * @throws SQLException при ошибках, связанных с работой БД.
     */
    boolean okToAdd() throws SQLException{
        return commonDAO.valueNotInDB(table, parameterName, parameterValue);
    }

    /**
     * Метод проверки данных, нужно переопределить в наследниках.
     * @throws SQLException при ошибках, связанных с работой БД.
     */
    @Override
    public abstract boolean validate() throws SQLException;

    /**
     * Метод возвращает текст ошибки, если она возникла при валидации.
     * @return текст ошибки.
     */
    @Override
    public String getErrorString() {
        errorString = Character.toUpperCase(errorString.charAt(0)) + errorString.substring(1);
        return errorString;
    }
}
