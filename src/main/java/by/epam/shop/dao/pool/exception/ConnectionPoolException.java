package by.epam.shop.dao.pool.exception;

import by.epam.shop.dao.exception.DaoException;

public class ConnectionPoolException extends DaoException {

    public ConnectionPoolException()  {
    }

    public ConnectionPoolException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
