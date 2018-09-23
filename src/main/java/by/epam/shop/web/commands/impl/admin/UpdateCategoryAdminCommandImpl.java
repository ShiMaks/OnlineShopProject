package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.*;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class UpdateCategoryAdminCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idCategory = request.getParameter(REQUEST_PARAM_CATEGORY_ID);
        String nameCategory = request.getParameter(REQUEST_PARAM_NAME_CATEGORY);
        validateParamNotNull(nameCategory);
        if(validatePositiveInt(idCategory)) {
            Category category = new Category();
            category.setId(Integer.parseInt(idCategory));
            category.setName(nameCategory);
            categoryService.updateCategoryInfo(category);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_CATEGORY);
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_ERROR;
        }
    }
}
