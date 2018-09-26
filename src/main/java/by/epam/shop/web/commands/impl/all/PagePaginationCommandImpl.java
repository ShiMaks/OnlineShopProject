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
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_CATEGORY;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_PRODUCT;

public class PagePaginationCommandImpl implements BaseCommand{

    private CategoryService categoryService = ServiceFactory.getCategoryService();
    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String action = request.getParameter("action");
        int startPosition = Integer.parseInt(request.getParameter("position"));
        int page = Integer.parseInt((request.getParameter("page")));
        System.out.println("Position: " + startPosition);
        System.out.println("Page: " + page);
        int stepPosition = 3;
        int stepPage = 1;
        if(action.equals("next")){
            System.out.println("Enter next");
            startPosition = (startPosition + stepPosition) - 1;
            List<Product> products = productService.getProductForPage(startPosition);
            List<Category> categories = categoryService.getCategories();
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
            request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, products);
            request.setAttribute("position", (startPosition + 1));
            request.setAttribute("page", page = page + stepPage);
            System.out.println("Return page: " + page);      
            return PAGE_SHOP_MAIN_PAGE;
        } else if(action.equals("perv") & (page - stepPage) <= 1){
            System.out.println("Enter page 1");
            List<Category> categories = categoryService.getCategories();
            List<Product> products = productService.getProductForPage(0);
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
            request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, products);
            request.setAttribute("position", 0);
            request.setAttribute("page", 1);
            return PAGE_SHOP_MAIN_PAGE;
        } else if(action.equals("perv")){
            System.out.println("Enter perv");
            page = page - stepPage;
            System.out.println(page);
            startPosition = (startPosition - stepPosition) - 1;
            System.out.println("Position pevr: " + startPosition);
            List<Category> categories = categoryService.getCategories();
            List<Product> products = productService.getProductForPage(startPosition);
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORY, categories);
            request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, products);
            request.setAttribute("position", (startPosition + 1));
            request.setAttribute("page", page);
            return PAGE_SHOP_MAIN_PAGE;
        } else {
            return PAGE_ERROR;
        }
    }
}
