package by.epam.shop.web.commands.impl.all;

import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class DisplayingProductInfoCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parametr check
        int idProduct = Integer.parseInt(request.getParameter("product_id"));
        Product product = productService.getProduct(idProduct);
        request.setAttribute("product", product);
        return "/jsp/pages/shop-item.jsp";
    }
}
