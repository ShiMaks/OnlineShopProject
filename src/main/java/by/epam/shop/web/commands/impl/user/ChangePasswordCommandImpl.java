package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.User;
import by.epam.shop.service.UserService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_CHANGE_PASSWORD;
import static by.epam.shop.web.util.PagePathConstant.PAGE_SIGN_IN;
import static by.epam.shop.web.util.RequestParamValidator.validatePassword;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class ChangePasswordCommandImpl implements BaseCommand{

    private UserService userService = ServiceFactory.getUserService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String oldPass = request.getParameter(REQUEST_PARAM_OLD_PASS);
        String newPass = request.getParameter(REQUEST_PARAM_NEW_PASS);
        String confirmNewPass = request.getParameter(REQUEST_PARAM_CONFIRM_NEW_PASS);
        if (validateNewPassword(newPass, request)) {
            return changePassMainLogic(oldPass, newPass, confirmNewPass, request);
        } else {
            return PAGE_SHOP_CHANGE_PASSWORD;
        }
    }

    private boolean validateNewPassword(String newPass, HttpServletRequest request)
            throws ValidateNullRequestParamException {
        if (!validatePassword(newPass)) {
//            request.setAttribute(REQUEST_PARAM_INVALID_PASS,
//                    Resource.getStrLocale(REQUEST_PARAM_INVALID_PASS, request));
            return false;
        }
        return true;
    }

    private String changePassMainLogic(String oldPass, String newPass, String confirmNewPass,
                                       HttpServletRequest request) throws ServiceException {
        User sessionUser = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        String sessionUserPass = userService.getUserPassword(sessionUser.getId());
        if (checkPassword(sessionUserPass, oldPass, newPass, confirmNewPass, request)) {
            User user = new User(sessionUser.getId());
            user.setPassword(newPass);
            userService.changeUserPassword(user);
            request.getSession().invalidate();
//            request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
//                    Resource.getStrLocale(MESSAGE_PASS_CHANGED, request));
            return PAGE_SIGN_IN;
        } else {
            return PAGE_SHOP_CHANGE_PASSWORD;
        }

    }

    private boolean checkPassword(String sessionUserPass, String oldPass, String newPass, String confirmNewPass,
                                      HttpServletRequest request) {
        if (!sessionUserPass.equals(oldPass)) {
//            request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_PASS);
//            request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
//                    Resource.getStrLocale(MESSAGE_WRONG_OLD_PASS, request));
            return false;
        } else if (!newPass.equals(confirmNewPass)) {
//            request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_PASS);
//            request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
//                    Resource.getStrLocale(MESSAGE_WRONG_CONFIRMATION, request));
            return false;
        } else {
            return true;
        }
    }
}
