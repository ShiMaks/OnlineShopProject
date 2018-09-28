package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CREATE_PRODUCT;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_CATEGORIES_ADMIN;

public class PageCreateProductCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        return PAGE_CREATE_PRODUCT;
    }
}
