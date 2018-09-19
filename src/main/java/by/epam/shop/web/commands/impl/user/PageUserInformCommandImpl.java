package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER;

public class PageUserInformCommandImpl implements BaseCommand {

    UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {

        User sessionUser = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);

        System.out.println(sessionUser.getId());

        User user = userService.getUser(sessionUser.getId());

        System.out.println(user.getId());
        request.setAttribute("userInform", user);
        return "/jsp/pages/profile-account.jsp";
    }
}
