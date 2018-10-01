package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.User;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_INDEX;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER;

public class LogOutCommandImpl implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(LogOutCommandImpl.class);

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        request.getSession().invalidate();
        LOGGER.info("User login={} finished the session", user.getLogin());
        return PAGE_INDEX;
    }
}
