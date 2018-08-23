package by.epam.shop.web.util;

import by.epam.shop.web.exception.ValidateNullRequestParamException;

public class RequestParamValidator {

    private static final String ERROR_REQUEST_PARAMETER_IS_NULL = "Request parameter is not initialized!";

    private  RequestParamValidator(){
        throw new IllegalStateException("Utility class");
    }

    public static void validateParamNotNull(String s) throws ValidateNullRequestParamException {
        if (s == null) {
            throw new ValidateNullRequestParamException(ERROR_REQUEST_PARAMETER_IS_NULL);
        }
    }
}
