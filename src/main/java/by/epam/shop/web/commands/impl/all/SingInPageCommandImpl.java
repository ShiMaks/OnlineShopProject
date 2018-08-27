package by.epam.shop.web.commands.impl.all;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_SIGN_IN;

public class SingInPageCommandImpl implements BaseCommand {

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        return PAGE_SIGN_IN;
    }
}
