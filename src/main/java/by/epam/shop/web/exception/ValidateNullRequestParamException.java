package by.epam.shop.web.exception;

public class ValidateNullRequestParamException extends CommandException {

    public ValidateNullRequestParamException() {
        super();
    }

    public ValidateNullRequestParamException(String message, Throwable cause, boolean enableSuppression,
                                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ValidateNullRequestParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateNullRequestParamException(String message) {
        super(message);
    }

    public ValidateNullRequestParamException(Throwable cause) {
        super(cause);
    }
}
