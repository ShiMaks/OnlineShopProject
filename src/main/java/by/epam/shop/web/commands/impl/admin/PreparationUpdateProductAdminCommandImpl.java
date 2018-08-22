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

public class PreparationUpdateProductAdminCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();
    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parameter check
        int idProduct = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.getProduct(idProduct);
        List<Category> categories = categoryService.getCategories();
        System.out.println(product.getName());
        for(Category category: categories){
            System.out.println(category.getName());
        }
        request.setAttribute("product", product);
        request.setAttribute("listCategory", categories);
        return "/jsp/updateProdAdmin.jsp";
    }
}
