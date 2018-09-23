package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.User;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ADMIN;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USERS;

public class PageAdminCommandImpl implements BaseCommand {

    private UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        List<User> users = userService.getUsers();
        request.setAttribute(REQUEST_PARAM_USERS, users);
        return PAGE_ADMIN;
    }
}
