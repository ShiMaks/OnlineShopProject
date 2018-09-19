package by.epam.shop.web.commands.impl.user;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class PageChangePassCommandInformation implements BaseCommand {

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        return "/jsp/pages/change-password.jsp";
    }
}
