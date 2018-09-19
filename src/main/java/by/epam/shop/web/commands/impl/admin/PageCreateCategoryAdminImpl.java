package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CREATE_CATEGORY;

public class PageCreateCategoryAdminImpl implements BaseCommand{
    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        return PAGE_CREATE_CATEGORY;
    }
}
