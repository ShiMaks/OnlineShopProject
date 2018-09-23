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

public class PageCategoryProductsCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();
    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parametr check
        int idCategory = Integer.parseInt(request.getParameter("category_id"));
        List<Product> products = productService.getProductsByCategory(idCategory);
        List<Category> categories = categoryService.getCategories();
       request.setAttribute("listProduct", products);
        request.setAttribute("listCategory", categories);
        return "/jsp/pages/indexNew.jsp";
    }
}
