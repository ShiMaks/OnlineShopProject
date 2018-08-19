package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PreparationCategoriesAdminCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
//        List<Category> categories;
//        try {
//            categories = categoryService.getCategories();
//            request.setAttribute("categoriesAdmin", categories);
//        } catch (ServiceException e) {
//            throw new CommandException(e);
//        }
        return "/jsp/categoryAdmin.jsp";
    }
}
