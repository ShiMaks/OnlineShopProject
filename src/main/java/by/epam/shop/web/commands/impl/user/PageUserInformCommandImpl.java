package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_USER_INFORMATION;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class PageUserInformCommandImpl implements BaseCommand {

    UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User sessionUser = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        try{
            User user = userService.getUser(sessionUser.getId());
            System.out.println(user.getId());
            request.setAttribute(REQUEST_PARAM_USERS_INFO, user);
            return PAGE_SHOP_USER_INFORMATION;
        } catch (ServiceException e){
            return PAGE_ERROR;
        }
    }
}
