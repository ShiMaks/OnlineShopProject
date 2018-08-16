package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class AddCategoryCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parameter check
        String nameCategory = request.getParameter("name");
        Category category = new Category();
        category.setName(nameCategory);
        try {
            categoryService.addCategoryToShop(category);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return null;
    }
}
