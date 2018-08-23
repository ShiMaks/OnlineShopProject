package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_REGISTRATION;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_GUEST_URL;
import static by.epam.shop.web.util.RequestParamValidator.*;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class RegisterCommandImpl implements BaseCommand {

    private static final String MESSAGE_VALUE = "success_registration";
    private static final String SUCCESS = "success";
    private UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User user = createNewUser(request);
        if (validateNewUser(user, request)) {
            String message = "";
                    userService.createUser(user);
            return resultPage(message, user, request);
        } else {
            request.setAttribute(REQUEST_PARAM_NEW_USER, user);
            return PAGE_REGISTRATION;
        }
    }

    private User createNewUser(HttpServletRequest request) {
        String login = request.getParameter(REQUEST_PARAM_LOGIN);
        String password = request.getParameter(REQUEST_PARAM_PASS);
        String name = request.getParameter(REQUEST_PARAM_NAME);
        String surname = request.getParameter(REQUEST_PARAM_SURNAME);
        String email = request.getParameter(REQUEST_PARAM_EMAIL);
        return new User(login, password, name, surname, email);
    }

    private String resultPage(String message, User user, HttpServletRequest request) {
        if (SUCCESS.equals(message)) {
            return REDIRECT_GUEST_URL;
        } else {
            request.setAttribute(REQUEST_PARAM_DUPLICATE_MESSAGE, message);
            return PAGE_REGISTRATION;
        }
    }

    protected boolean validateNewUser(User user, HttpServletRequest request) throws ValidateNullRequestParamException {

        boolean result = true;
        if (!validateLogin(user.getLogin())) {
            request.setAttribute(REQUEST_PARAM_INVALID_LOGIN, "");
            result = false;
        }
        if (!validatePassword(user.getPassword())) {
            request.setAttribute(REQUEST_PARAM_INVALID_PASS, "");
            result = false;
        }
        if (!validateName(user.getName())) {
            request.setAttribute(REQUEST_PARAM_INVALID_NAME, "");
            result = false;
        }
        if (!validateSurname(user.getSurname())) {
            request.setAttribute(REQUEST_PARAM_INVALID_SURNAME, "");
            result = false;
        }
        if (!validateEmail(user.getEmail())) {
            request.setAttribute(REQUEST_PARAM_INVALID_EMAIL, "");
            result = false;
        }
        return result;
    }
}
