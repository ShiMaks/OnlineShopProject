package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.*;
import static by.epam.shop.web.util.RequestParamValidator.*;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class RegisterCommandImpl implements BaseCommand {

    private static final Logger lOGGER = LogManager.getLogger(RegisterCommandImpl.class);

    private static final String MESSAGE_VALUE = "success_registration";
    private static final String SUCCESS = "success";
    private UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User user = createNewUser(request);
        if (validateNewUser(user, request)) {
            String message = userService.createUser(user);
            return resultPage(message, request);
        } else {
            return PAGE_REGISTRATION;
        }
    }

    private User createNewUser(HttpServletRequest request) {
        String login = request.getParameter(REQUEST_PARAM_LOGIN);
        String password = request.getParameter(REQUEST_PARAM_PASS);
        String name = request.getParameter(REQUEST_PARAM_NAME);
        String surname = request.getParameter(REQUEST_PARAM_SURNAME);
        String email = request.getParameter(REQUEST_PARAM_EMAIL);
        String phone = request.getParameter(REQUEST_PARAM_PHONE);
        return new User(login, password, name, surname, email, phone);
    }

    private String resultPage(String message, HttpServletRequest request) {
        if (SUCCESS.equals(message)) {
            request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_VALUE);
            return PAGE_SIGN_IN;
        } else {
            request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, message);
            return PAGE_REGISTRATION;
        }
    }

    protected boolean validateNewUser(User user, HttpServletRequest request) throws ValidateNullRequestParamException {
        boolean result = true;
        if (!validateLogin(user.getLogin())) {
            request.setAttribute(REQUEST_PARAM_INVALID_LOGIN, REQUEST_PARAM_INVALID_LOGIN);
            lOGGER.info("An invalid login is entered. Login: {}", user.getLogin());
            result = false;
        }
        if (!validatePassword(user.getPassword())) {
            request.setAttribute(REQUEST_PARAM_INVALID_PASS, REQUEST_PARAM_INVALID_PASS);
            lOGGER.info("An invalid password has been entered. Password: {}", user.getPassword());
            result = false;
        }
        if (!validateName(user.getName())) {
            request.setAttribute(REQUEST_PARAM_INVALID_NAME, REQUEST_PARAM_INVALID_NAME);
            lOGGER.info("An invalid name has been entered. Name: {}", user.getName());
            result = false;
        }
        if (!validateSurname(user.getSurname())) {
            request.setAttribute(REQUEST_PARAM_INVALID_SURNAME, REQUEST_PARAM_INVALID_SURNAME);
            lOGGER.info("An invalid surname has been entered. Surname: {}", user.getSurname());
            result = false;
        }
        if (!validateEmail(user.getEmail())) {
            request.setAttribute(REQUEST_PARAM_INVALID_EMAIL, REQUEST_PARAM_INVALID_EMAIL);
            lOGGER.info("An invalid email has been entered. Email: {}", user.getEmail());
            result = false;
        }
        if (!validatePhone(user.getPhone())) {
            request.setAttribute(REQUEST_PARAM_INVALID_PHONE, REQUEST_PARAM_INVALID_PHONE);
            lOGGER.info("An invalid phone number has been entered. Email: {}", user.getPhone());
            result = false;
        }
        if (!user.getPassword().equals(request.getParameter(REQUEST_PARAM_CONFIRM_NEW_PASS))) {
            request.setAttribute(REQUEST_PARAM_INVALID_CONFIRM_PASS, REQUEST_PARAM_INVALID_CONFIRM_PASS);
            lOGGER.info("Entered passwords do not match. Password: {}, Confirm password {}",
                    user.getPassword(), request.getParameter(REQUEST_PARAM_CONFIRM_NEW_PASS));
            result = false;
        } else {
            lOGGER.info("Validation of registration data was successful.");
        }
        return result;
    }
}
