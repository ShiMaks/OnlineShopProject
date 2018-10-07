package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.domain.Product;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.PAGE_PRODUCTS_ADMIN;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class SortProductAdminCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();
    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idCategory = request.getParameter(REQUEST_PARAM_CATEGORY_ID);
        if(!validatePositiveInt(idCategory)){
            return PAGE_ERROR;
        }
        List<Category> categories = categoryService.getCategories();
        List<Product> products = productService.getProductsByCategory(Integer.parseInt(idCategory));
        request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
        request.setAttribute(REQUEST_PARAM_LIST_PRODUCTS_ADMIN, products);
        return PAGE_PRODUCTS_ADMIN;
    }
}
