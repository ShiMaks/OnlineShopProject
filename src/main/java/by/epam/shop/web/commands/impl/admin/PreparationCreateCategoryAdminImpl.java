package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class PreparationCreateCategoryAdminImpl implements BaseCommand{
    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        return "/jsp/creatCatAdmin.jsp";
    }
}
