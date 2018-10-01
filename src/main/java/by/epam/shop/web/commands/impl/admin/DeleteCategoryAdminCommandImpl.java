package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class DeleteCategoryAdminCommandImpl implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(DeleteCategoryAdminCommandImpl.class);

    private static final String MESSAGE_VALUE = "success_delete_category";
    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idCategory = request.getParameter(REQUEST_PARAM_CATEGORY_ID);
        if(validatePositiveInt(idCategory)) {
            categoryService.deleteCategory(Integer.parseInt(idCategory));
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_CATEGORY);
            request.getSession().setAttribute(REQUEST_PARAM_SESSION_MESSAGE, MESSAGE_VALUE);
            LOGGER.info("category id={} delete from database", idCategory);
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_ERROR;
        }
    }
}
