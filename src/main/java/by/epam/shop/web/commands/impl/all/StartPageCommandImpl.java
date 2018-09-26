package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.Category;
import by.epam.shop.domain.Product;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_MAIN_PAGE;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_CATEGORY;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_PRODUCT;

public class StartPageCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();
    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        List<Category> categories = categoryService.getCategories();
//        List<Product> products = productService.getProducts();
        List<Product> products = productService.getProductForPage(0);
        request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
        request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, products);
        request.setAttribute("position", 0);
        request.setAttribute("page", 1);
        return PAGE_SHOP_MAIN_PAGE;
    }
}
