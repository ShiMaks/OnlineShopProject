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

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_ITEM;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_CATEGORY;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_PRODUCT;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_PRODUCT_ID;

public class PageProductInfoCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();
    private CategoryService categoryService =ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idProduct = request.getParameter(REQUEST_PARAM_PRODUCT_ID);
        if(validatePositiveInt(idProduct)) {
            Product product = productService.getProduct(Integer.parseInt(request.getParameter(REQUEST_PARAM_PRODUCT_ID)));
            List<Category> categories = categoryService.getCategories();
            request.setAttribute(REQUEST_PARAM_PRODUCT, product);
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
            return PAGE_SHOP_ITEM;
        } else {
            return PAGE_ERROR;
        }
    }
}
