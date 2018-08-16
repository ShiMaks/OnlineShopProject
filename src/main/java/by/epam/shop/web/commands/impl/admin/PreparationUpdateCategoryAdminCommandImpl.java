package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.service.CategoryService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class PreparationUpdateCategoryAdminCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parameter check
        int idCategory = Integer.parseInt(request.getParameter("categoryId"));
        request.setAttribute("categoryId", idCategory);
        return null;
    }
}
