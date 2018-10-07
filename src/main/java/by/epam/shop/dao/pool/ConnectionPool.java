package by.epam.shop.dao.pool;

import by.epam.shop.dao.pool.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Maksim Shulvian
 *         <p/>
 *         The class <code>ConnectionPool</code>
 *         provides connections to the database.
 */
public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    /**
     * Configuration constants for the need to create a pool
     */
    private static final String DB_CONNECT_PROPERTY = "db_config";
    private static final String RESOURCE_DRIVER_NAME = "db.driver.name";
    private static final String RESOURCE_URL = "db.url";
    private static final String RESOURCE_LOGIN = "db.login";
    private static final String RESOURCE_PASS = "db.pass";
    private static final int CONNECTION_COUNT = 10;


    private static String url;
    private static String login;
    private static String pass;
    private static String driverName;

    static {
        ResourceBundle rb = ResourceBundle.getBundle(DB_CONNECT_PROPERTY);
        url = rb.getString(RESOURCE_URL);
        login = rb.getString(RESOURCE_LOGIN);
        pass = rb.getString(RESOURCE_PASS);
        driverName = rb.getString(RESOURCE_DRIVER_NAME);
    }

    private LinkedBlockingQueue<Connection> freeСonnection = new LinkedBlockingQueue<Connection>();

    /**
     * The constructor creates an instance of the pool.
     * Initializes a constant number of connections = 10.
     */
    public ConnectionPool() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
        for (int i = 0; i < CONNECTION_COUNT; i++) {
            try {
                freeСonnection.put(DriverManager.getConnection(url, login, pass));
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            } catch (InterruptedException e) {
                LOGGER.error("InterruptedException in constructor in ConnectionPool class", e);
            }
        }
    }

    /**
     * The method provides the user with a copy of connection from pool
     *
     * @return Connection
     * @throws ConnectionPoolException
     */
    public Connection getConnection() throws ConnectionPoolException {

        Connection connection = null;
        try {
            connection = freeСonnection.poll(10, TimeUnit.SECONDS);
            if (connection == null) {
                throw new RuntimeException("No available connections");
            } else {
                return connection;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConnectionPoolException(e);
        }
    }

    /**
     * The method return the connection back to the pool
     * when you are finished work with him.
     *
     * @param connection
     * @throws ConnectionPoolException
     */
    public void returnConnection(Connection connection) throws ConnectionPoolException {
        try {
            freeСonnection.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConnectionPoolException(e);
        }
    }

    /**
     * The method closes all open connections
     *
     * @throws ConnectionPoolException
     */
    public void stop() throws ConnectionPoolException {
        for (int i = 0; i < CONNECTION_COUNT; i++) {
            try {
                getConnection().close();
            } catch (SQLException e) {
                LOGGER.error("SQLException in stop method in ConnectionPool class", e);
            }
        }
    }
}
