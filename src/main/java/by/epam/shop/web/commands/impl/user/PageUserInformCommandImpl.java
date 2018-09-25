package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.WebConstantDeclaration.PAGE_TYPE_USER_ORDERS;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER;
import static by.epam.shop.web.util.WebConstantDeclaration.SESSION_PAGE_TYPE;

public class PageUserInformCommandImpl implements BaseCommand {

    UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User sessionUser = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        try{
            User user = userService.getUser(sessionUser.getId());
            System.out.println(user.getId());
            request.setAttribute("userInform", user);
            return "/jsp/pages/profile-account.jsp";
        } catch (ServiceException e){
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_USER_ORDERS);
            return REDIRECT_USER_URL;
        }
    }
}
