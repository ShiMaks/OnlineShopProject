package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.ShopCart;
import by.epam.shop.domain.User;
import by.epam.shop.domain.UserRoleEnum;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_SIGN_IN;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class AuthorizationCommandImpl implements BaseCommand {

    private static final String MESSAGE_VALUE = "message_incorrect_login_password";
    private UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(REQUEST_PARAM_LOGIN);
        String pass = request.getParameter(REQUEST_PARAM_PASS);
        validateParamNotNull(login);
        validateParamNotNull(pass);
        User user = userService.getUserByLoginPassword(login, pass);
        return checkRecivedUser(user, request);
    }

    private String checkRecivedUser(User user, HttpServletRequest request) {
        if (user != null) {
            request.getSession().setAttribute(REQUEST_PARAM_USER, user);
            request.getSession().setAttribute("shopCart", new ShopCart());
            return identifyUserRole(user, request);
        } else {
            return PAGE_SIGN_IN;
        }
    }

    private String identifyUserRole(User user, HttpServletRequest request) {
        if (user.isAdmin()) {
            request.getSession().setAttribute(REQUEST_PARAM_USER_ROLE, UserRoleEnum.ADMIN);
            return REDIRECT_ADMIN_URL;
        } else {
            request.getSession().setAttribute(REQUEST_PARAM_USER_ROLE, UserRoleEnum.USER);
            return REDIRECT_USER_URL;
        }
    }
}
