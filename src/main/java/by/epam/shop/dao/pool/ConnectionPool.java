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

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static volatile ConnectionPool instance;

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

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }


    private ConnectionPool() {
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
                e.printStackTrace();
            }
        }
    }


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

    public void returnConnection(Connection connection) throws ConnectionPoolException {
        try {
            freeСonnection.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConnectionPoolException(e);
        }
    }

    public void stop() throws ConnectionPoolException {
        for (int i = 0; i < CONNECTION_COUNT; i++) {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
