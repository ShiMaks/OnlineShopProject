package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CREATE_CATEGORY;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;
import static by.epam.shop.web.util.RequestParamValidator.validateProductNameOrCategory;
import static by.epam.shop.web.util.WebConstantDeclaration.PAGE_TYPE_ADMIN_CATEGORY;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_NAME_CATEGORY;
import static by.epam.shop.web.util.WebConstantDeclaration.SESSION_PAGE_TYPE;

public class AddCategoryCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String nameCategory = request.getParameter(REQUEST_PARAM_NAME_CATEGORY);
        if(validateCategoryInputData(nameCategory)) {
            Category category = new Category();
            category.setName(nameCategory);
            categoryService.addCategoryToShop(category);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_CATEGORY);
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_CREATE_CATEGORY;
        }
    }

    private boolean validateCategoryInputData(String nameCategory) throws ValidateNullRequestParamException {
        boolean result = true;
        if (!validateProductNameOrCategory(nameCategory)) {
            System.out.println("error name");
            result = false;
        } else {

        }
        return result;
    }
}


