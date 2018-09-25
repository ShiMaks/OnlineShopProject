package by.epam.shop.web.util;

import by.epam.shop.web.exception.ValidateNullRequestParamException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestParamValidator {

    private static final String ERROR_REQUEST_PARAMETER_IS_NULL = "Request parameter is not initialized!";

    private static final String LOGIN_REGEX = "[0-9a-zA-Z_@$]{5,}"; /* мин 5 символов из тех что в скобках */

    private static final String PRODUCT_NAME_REGEX = "([\\wА-Яа-яЁё]{1,50})([\\-\\s]?)([\\wА-Яа-яЁё]{0,50})";

    private static final String PASS_REGEX = "(?=.*[a-zA-z])(?=.*[0-9]).{5,}";
                                                                                /*
                                                                                 * минимум 5 символов, мин одна лат
                                                                                 * буква и одно число и любые другие
                                                                                 * символы
                                                                                 */

    private static final String NAME_REGEX = "^[A-ZА-ЯЁ][A-Za-zА-Яа-яЁё]{1,50}";
                                                                                /*
                                                                                 * латин и кирил мин 2 буквы, первая
                                                                                 * заглавная
                                                                                 */

    private static final String SURNAME_REGEX = "(^[A-ZА-ЯЁ][A-Za-zА-Яа-яЁё]{0,50})([\\-]?)([A-Za-zА-Яа-яЁё]{0,50})";
                                                                                                                        /*
                                                                                                                         * возможно
                                                                                                                         * двойная
                                                                                                                         * фамилия
                                                                                                                         * через
                                                                                                                         * дефис
                                                                                                                         * (первая
                                                                                                                         * буква
                                                                                                                         * заглвная)
                                                                                                                         */

    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
                                                                                            /*
                                                                                             * Pattern.CASE_INSENSITIVE
                                                                                             */

    private static final String PHONE_REGEX = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    private static final String POSITIVE_NUMBER_REGEX = "([1-9])([0-9]*)";
    private static final String IMAGE_LINK_REGEX = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    private static final String PRICE_REGEX = "^([0-9]{0,2}((.)[0-9]{0,2}))$";

    private  RequestParamValidator(){
        throw new IllegalStateException("Utility class");
    }

    public static void validateParamNotNull(String s) throws ValidateNullRequestParamException {
        if (s == null) {
            throw new ValidateNullRequestParamException(ERROR_REQUEST_PARAMETER_IS_NULL);
        }
    }

    public static boolean validateProductNameOrCategory(String branNameOrModel) throws ValidateNullRequestParamException {
        validateParamNotNull(branNameOrModel);
        return matchToRegex(branNameOrModel, PRODUCT_NAME_REGEX);
    }

    public static boolean validateLogin(String login) throws ValidateNullRequestParamException {
        validateParamNotNull(login);
        return matchToRegex(login, LOGIN_REGEX);
    }

    public static boolean validatePassword(String pass) throws ValidateNullRequestParamException {
        validateParamNotNull(pass);
        return matchToRegex(pass, PASS_REGEX);
    }

    public static boolean validateName(String name) throws ValidateNullRequestParamException {
        validateParamNotNull(name);
        return matchToRegex(name, NAME_REGEX);
    }

    public static boolean validateSurname(String surname) throws ValidateNullRequestParamException {
        validateParamNotNull(surname);
        return matchToRegex(surname, SURNAME_REGEX);
    }

    public static boolean validateEmail(String email) throws ValidateNullRequestParamException {
        validateParamNotNull(email);
        return matchToRegexCaseIns(email, EMAIL_REGEX);
    }

    public static boolean validatePhone(String phone) throws ValidateNullRequestParamException {
        validateParamNotNull(phone);
        return matchToRegexCaseIns(phone, PHONE_REGEX);
    }

    public static boolean validateImageLink(String imageLink) throws ValidateNullRequestParamException {
        validateParamNotNull(imageLink);
        return matchToRegex(imageLink, IMAGE_LINK_REGEX);
    }
    public static boolean validatePrice(String price) throws ValidateNullRequestParamException {
        validateParamNotNull(price);
        return matchToRegex(price, PRICE_REGEX);
    }

    private static boolean matchToRegex(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }

    private static boolean matchToRegexCaseIns(String input, String regex) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        return m.matches();
    }

    public static boolean validatePositiveInt(String value) throws ValidateNullRequestParamException {
        validateParamNotNull(value);
        if (matchToRegex(value, POSITIVE_NUMBER_REGEX)) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
