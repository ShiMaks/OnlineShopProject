package by.epam.shop.service.util;

import by.epam.shop.service.exception.ServiceException;

public final class ServiceInputParamNullValidator {

    private static final String ERROR_EMPTY_PARAMETER = "Empty parameter recieved";

    private ServiceInputParamNullValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static void validateInputParamNotNull(Object... object) throws ServiceException {
        for (Object o : object) {
            if (o == null) {
                throw new ServiceException(ERROR_EMPTY_PARAMETER);
            }
        }

    }
}
