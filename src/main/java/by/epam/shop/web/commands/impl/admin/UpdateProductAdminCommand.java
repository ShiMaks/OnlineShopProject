package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class UpdateProductAdminCommand implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parameter check
        int idProduct = Integer.parseInt(request.getParameter("productId"));
        int idCategory = Integer.parseInt(request.getParameter("category"));
        String description = request.getParameter("description");
        String name = request.getParameter("name");

        Product product  = new Product();
        product.setName(name);
        product.setIdCategory(idCategory);
        product.setId(idProduct);
        product.setDescription(description);

        try {
            productService.updateProductInfo(product);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return null;
    }
}
