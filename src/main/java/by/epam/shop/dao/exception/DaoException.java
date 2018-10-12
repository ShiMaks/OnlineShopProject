package by.epam.shop.dao.exception;

import by.epam.shop.service.exception.ServiceException;

/**
 * @author Maksim Shilvian
 *         <code>DAOException</code>
 *         <p/>
 *         Exception class created specifically to describe the exceptional
 *         situation arises in the DAO layer application.
 */
public class DaoException extends RuntimeException {

    public  DaoException(){
        super();
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
