package by.epam.shop.web.commands.impl.user;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_CHANGE_PASSWORD;

public class PageChangePassCommandInformation implements BaseCommand {

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        return PAGE_SHOP_CHANGE_PASSWORD;
    }
}
