package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CATEGORY_ADMIN;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_CATEGORY_URL;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_NAME_CATEGORY;

public class AddCategoryCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String nameCategory = request.getParameter(REQUEST_PARAM_NAME_CATEGORY);
        validateParamNotNull(nameCategory);
        Category category = new Category();
        category.setName(nameCategory);
        try {
            categoryService.addCategoryToShop(category);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return REDIRECT_ADMIN_CATEGORY_URL;
    }
}
