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

public class StartPageCommandImpl implements BaseCommand {

    private CategoryService categoryService = ServiceFactory.getCategoryService();
    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        List<Category> categories = categoryService.getCategories();
        List<Product> products = productService.getProducts();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listProduct", products);
        return "/jsp/pages/startPage.jsp";
    }
}
