package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DisplayCategoryProductsCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parametr check
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        List<Product> products = productService.getProductsByCategory(idCategory);
        request.setAttribute("products", products);
        return null;
    }
}
