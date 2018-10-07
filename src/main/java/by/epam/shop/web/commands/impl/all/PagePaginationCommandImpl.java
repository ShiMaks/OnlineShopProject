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
import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_MAIN_PAGE;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class PagePaginationCommandImpl implements BaseCommand{

    private CategoryService categoryService = ServiceFactory.getCategoryService();
    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String action = request.getParameter(REQUEST_PARAM_ACTION_PAGE);
        int startPosition = Integer.parseInt(request.getParameter(REQUEST_PARAM_POSITION));
        int page = Integer.parseInt((request.getParameter(REQUEST_PARAM_PAGE)));
        if(page <= 0 || startPosition < 0){
            return PAGE_ERROR;
        }
        int stepPosition = 9;
        int stepPage = 1;
        if(action.equals(REQUEST_PARAM_ACTION_NEXT)){
            startPosition = (startPosition + stepPosition) - 1;
            List<Product> products = productService.getProductForPage(startPosition);
            List<Category> categories = categoryService.getCategories();
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
            request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, products);
            request.setAttribute(REQUEST_PARAM_POSITION, (startPosition + 1));
            request.setAttribute(REQUEST_PARAM_PAGE, page = page + stepPage);
            return PAGE_SHOP_MAIN_PAGE;
        } else if(action.equals(REQUEST_PARAM_ACTION_PERV) & (page - stepPage) <= 1){
            List<Category> categories = categoryService.getCategories();
            List<Product> products = productService.getProductForPage(0);
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
            request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, products);
            request.setAttribute(REQUEST_PARAM_POSITION, 0);
            request.setAttribute(REQUEST_PARAM_PAGE, 1);
            return PAGE_SHOP_MAIN_PAGE;
        } else if(action.equals(REQUEST_PARAM_ACTION_PERV)){
            page = page - stepPage;
            startPosition = (startPosition - stepPosition) - 1;
            List<Category> categories = categoryService.getCategories();
            List<Product> products = productService.getProductForPage(startPosition);
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
            request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, products);
            request.setAttribute(REQUEST_PARAM_POSITION, (startPosition + 1));
            request.setAttribute(REQUEST_PARAM_PAGE, page);
            return PAGE_SHOP_MAIN_PAGE;
        } else {
            return PAGE_ERROR;
        }
    }
}
