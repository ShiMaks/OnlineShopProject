package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CREATE_CATEGORY;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;
import static by.epam.shop.web.util.RequestParamValidator.validateProductNameOrCategory;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class AddCategoryCommandImpl implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(AddCategoryCommandImpl.class);

    private static final String MESSAGE_VALUE = "success_add_category";
    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String nameCategory = request.getParameter(REQUEST_PARAM_NAME_CATEGORY);
        if(validateCategoryInputData(nameCategory, request)) {
            Category category = new Category();
            category.setName(nameCategory);
            categoryService.addCategoryToShop(category);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_CATEGORY);
            request.getSession().setAttribute(REQUEST_PARAM_SESSION_MESSAGE, MESSAGE_VALUE);
            LOGGER.info("category {} added to database", category.getName());
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_CREATE_CATEGORY;
        }
    }

    private boolean validateCategoryInputData(String nameCategory, HttpServletRequest request) throws ValidateNullRequestParamException {
        boolean result = true;
        if (!validateProductNameOrCategory(nameCategory)) {
            LOGGER.error("An invalid category name has been entered.");
            request.setAttribute(REQUEST_PARAM_INVALID_CATEGORY_NAME, REQUEST_PARAM_INVALID_CATEGORY_NAME);
            result = false;
        } else {
            LOGGER.info("Name category: {}", nameCategory);
            request.setAttribute(REQUEST_PARAM_NAME_CATEGORY, nameCategory);
        }
        return result;
    }
}


