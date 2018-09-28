package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_REGISTRATION;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.RequestParamValidator.*;
import static by.epam.shop.web.util.RequestParamValidator.validateEmail;
import static by.epam.shop.web.util.RequestParamValidator.validatePhone;
import static by.epam.shop.web.util.WebConstantDeclaration.*;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_EMAIL;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_SURNAME;

public class UpdateUserInfoCommandImpl implements BaseCommand{

    private static final String MESSAGE_VALUE = "success_update_information";

    private UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User user = updateUser(request);
        if (validateNewUser(user, request)) {
            userService.updateUserInfo(user);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_USER_INFO);
            request.getSession().setAttribute(REQUEST_PARAM_SESSION_MESSAGE, MESSAGE_VALUE);
            return REDIRECT_USER_URL;
        } else {
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_USER_INFO);
            return REDIRECT_USER_URL;
        }
    }

    private User updateUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        user.setName(request.getParameter(REQUEST_PARAM_NAME));
        user.setSurname(request.getParameter(REQUEST_PARAM_SURNAME));
        user.setPhone(request.getParameter(REQUEST_PARAM_PHONE));
        return user;
    }

    protected boolean validateNewUser(User user, HttpServletRequest request) throws ValidateNullRequestParamException {
        boolean result = true;
        if (!validateName(user.getName())) {
            request.setAttribute(REQUEST_PARAM_INVALID_NAME, REQUEST_PARAM_INVALID_NAME);
            result = false;
        }
        if (!validateSurname(user.getSurname())) {
            request.setAttribute(REQUEST_PARAM_INVALID_SURNAME, REQUEST_PARAM_INVALID_SURNAME);
            result = false;
        }
        if (!validatePhone(user.getPhone())) {
            request.setAttribute(REQUEST_PARAM_INVALID_PHONE, REQUEST_PARAM_INVALID_PHONE);
            result = false;
        }
        return result;
    }
}
