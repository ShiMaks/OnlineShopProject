package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.service.CategoryService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ADMIN;
import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_CATEGORY_URL;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_CATEGORY_ID;

public class DeleteCategoryAdminCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idCategory = request.getParameter(REQUEST_PARAM_CATEGORY_ID);
        if(validatePositiveInt(idCategory)) {
            categoryService.deleteCategory(Integer.parseInt(idCategory));
            return REDIRECT_ADMIN_CATEGORY_URL;
        } else {
            return PAGE_ERROR;
        }
    }
}
