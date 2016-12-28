package ru.innopolis.constants;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * Класс, содержащий константы, относящиеся к работе с базой данных.
 */
public class DataBaseProperties {

    private DataBaseProperties() {
    }

    /**
     * Пул соединений к БД.
     */
    public static final DataSource DATA_SOURCE = new DataSource();

    /**
     * Название таблицы, содержащей информацию о пользователях
     */
    public static final String USERS_TABLE_NAME = "users";


    static {

        PoolProperties POOL_PROPERTIES = new PoolProperties();

        POOL_PROPERTIES.setUrl("jdbc:postgresql://stc02-ku.cjunmeusckp0.us-west-2.rds.amazonaws.com:5432/ForStudies");
        POOL_PROPERTIES.setDriverClassName("org.postgresql.Driver");
        POOL_PROPERTIES.setUsername("xincognitox");
        POOL_PROPERTIES.setPassword("qwerty!1");
        POOL_PROPERTIES.setJmxEnabled(true);
        POOL_PROPERTIES.setTestWhileIdle(false);
        POOL_PROPERTIES.setTestOnBorrow(true);
        POOL_PROPERTIES.setValidationQuery("SELECT 1");
        POOL_PROPERTIES.setTestOnReturn(true);
        POOL_PROPERTIES.setValidationInterval(3000);
        POOL_PROPERTIES.setTimeBetweenEvictionRunsMillis(5000);
        POOL_PROPERTIES.setMaxActive(5);
        POOL_PROPERTIES.setMaxIdle(5);
        POOL_PROPERTIES.setInitialSize(1);
        POOL_PROPERTIES.setMinIdle(1);
        POOL_PROPERTIES.setMaxWait(10000);
        POOL_PROPERTIES.setRemoveAbandonedTimeout(30);
        POOL_PROPERTIES.setMinEvictableIdleTimeMillis(30000);
        POOL_PROPERTIES.setLogAbandoned(true);
        POOL_PROPERTIES.setRemoveAbandoned(true);
        POOL_PROPERTIES.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

        DATA_SOURCE.setPoolProperties(POOL_PROPERTIES);
    }

}
