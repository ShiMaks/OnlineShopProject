package by.epam.shop.web.util;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.commands.impl.admin.*;
import by.epam.shop.web.commands.impl.all.*;
import by.epam.shop.web.commands.impl.user.AddProductToCartCommandImpl;
import by.epam.shop.web.commands.impl.user.CreateOrderCommandImpl;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.CommandDeclaration.*;

public class ActionManager {

    private ActionManager(){
        throw new IllegalStateException("Utility class");
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        BaseCommand command = null;
        String inputCommand =  request.getParameter("command");
        switch(inputCommand) {
            case "start_page": //all
                command = new StartPageCommandImpl();
                break;
            case "start_page_admin":
                command = new PreparationAdminPageCommandImpl();
                break;
            case COMMAND_TO_PRODUCTS:
                command = new PreparationProductsAdminCommandImpl();
                break;
            case COMMAND_TO_ORDERS:
                command = new PreparationOrdersAdminCommandImpl();
                break;
            case COMMAND_TO_CATEGORIES:
                command = new PreparationCategoriesAdminCommandImpl();
                break;
            case COMMAND_PREPARE_CREATE_CATEGORY:
                command = new PreparationCreateCategoryAdminImpl();
                break;
            case COMMAND_CREATE_CATEGORY:
                command = new AddCategoryCommandImpl();
                break;
            case COMMAND_DELETE_CATEGORY:
                command = new DeleteCategoryAdminCommandImpl();
                break;
            case COMMAND_PREPARE_UPDATE_CATEGORY:
                command = new PreparationUpdateCategoryAdminCommandImpl();
                break;
            case COMMAND_UPDATE_CATEGORY:
                command = new UpdateCategoryAdminCommandImpl();
                break;
            case COMMAND_DELETE_PRODUCT:
                command = new DeleteProductAdminCommandImpl();
                break;
            case COMMAND_PREPARE_UPDATE_PRODUCT:
                command = new PreparationUpdateProductAdminCommandImpl();
                break;
            case "update_product": //admin
                command = new UpdateProductAdminCommandImpl();
                break;
            case "prepare_create_product": //admin
                command = new PageCreateProductCommandImpl();
                break;
            case "create_product": //admin
                command = new AddProductCommandImpl();
                break;
            case "show_detail_order": //admin
                command = new ShowDetailOrderCommandImpl();
                break;
            case "update_order": //admin
                command = new UpdateOrderAdminCommandImpl();
                break;
            case "sort_order_by_status": //admin
                command = new SortOrderByStatusAdnibCommandImpl();
                break;
            case COMMAND_TO_LOG_IN: //all
                command = new SingInPageCommandImpl();
                break;
            case "log_in": //all
                command = new AuthorizationCommandImpl();
                break;
            case "to_log_out": //all
                command = new LogOutCommandImpl();
                break;
            case "show_products_category": //all
                command = new DisplayCategoryProdCommandImpl();
                break;
            case "show_products_info": //all
                command = new DisplayingProductInfoCommandImpl();
                break;
            case "add_product_to_cart": //user
               command = new AddProductToCartCommandImpl();
               break;
            case "сheckout": //user
                command = new CreateOrderCommandImpl();
                break;
            default:
                //command = new StartPageCommandImpl();
                break;
        }
        return command;
    }
}
