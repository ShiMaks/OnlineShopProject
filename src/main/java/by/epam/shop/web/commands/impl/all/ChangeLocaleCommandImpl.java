package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.UserRoleEnum;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_GUEST_URL;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class ChangeLocaleCommandImpl implements BaseCommand {

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String locale = request.getParameter(REQUEST_PARAM_LOCALE);
        request.getSession().setAttribute(REQUEST_PARAM_LOCALE, locale);
        UserRoleEnum userType = (UserRoleEnum) request.getSession().getAttribute(REQUEST_PARAM_USER_ROLE);
        if (userType == UserRoleEnum.ADMIN) {
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN);
            return REDIRECT_ADMIN_URL;
        } else if (userType == UserRoleEnum.USER) {
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_USER_MAIN);
            return REDIRECT_USER_URL;
        } else {
            return REDIRECT_GUEST_URL;
        }
    }
}
