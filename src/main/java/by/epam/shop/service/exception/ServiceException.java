package by.epam.shop.service.exception;

import by.epam.shop.web.exception.CommandException;

/**
 * @author Maksim Shilvian
 *         <code>ServiceException</code>
 *         <p/>
 *         Exception class created specifically to describe the exceptional
 *         situation arises in the service layer application.
 */
public class ServiceException extends CommandException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
