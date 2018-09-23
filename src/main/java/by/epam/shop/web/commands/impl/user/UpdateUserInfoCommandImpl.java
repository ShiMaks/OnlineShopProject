package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_REGISTRATION;
import static by.epam.shop.web.util.WebConstantDeclaration.*;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_EMAIL;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_SURNAME;

public class UpdateUserInfoCommandImpl implements BaseCommand{

    private UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
//        User user = updateUser(request);
//        if (validateNewUser(user, request)) {
//            String message = "";
//            userService.createUser(user);
//            return resultPage(message, user, request);
//        } else {
//            request.setAttribute(REQUEST_PARAM_NEW_USER, user);
//            return PAGE_REGISTRATION;
//        }
        return PAGE_REGISTRATION;
    }

    private User updateUser(HttpServletRequest request) {
        String name = request.getParameter(REQUEST_PARAM_NAME);
        String surname = request.getParameter(REQUEST_PARAM_SURNAME);
        String email = request.getParameter(REQUEST_PARAM_EMAIL);
        String phone = request.getParameter(REQUEST_PARAM_PHONE);
        return new User(phone, name, surname, email);
    }
}
