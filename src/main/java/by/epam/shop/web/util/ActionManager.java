package by.epam.shop.web.util;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.commands.impl.admin.*;
import by.epam.shop.web.commands.impl.all.*;
import by.epam.shop.web.commands.impl.user.*;

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
                command = new PageAdminCommandImpl();
                break;
            case COMMAND_TO_PRODUCTS:
                command = new PageProductsAdminCommandImpl();
                break;
            case COMMAND_TO_ORDERS:
                command = new PageOrdersAdminCommandImpl();
                break;
            case COMMAND_TO_CATEGORIES:
                command = new PageCategoriesAdminCommandImpl();
                break;
            case COMMAND_PREPARE_CREATE_CATEGORY:
                command = new PageCreateCategoryAdminImpl();
                break;
            case COMMAND_CREATE_CATEGORY:
                command = new AddCategoryCommandImpl();
                break;
            case COMMAND_DELETE_CATEGORY:
                command = new DeleteCategoryAdminCommandImpl();
                break;
            case COMMAND_PREPARE_UPDATE_CATEGORY:
                command = new PageUpdateCategoryAdminCommandImpl();
                break;
            case COMMAND_UPDATE_CATEGORY:
                command = new UpdateCategoryAdminCommandImpl();
                break;
            case COMMAND_DELETE_PRODUCT:
                command = new DeleteProductAdminCommandImpl();
                break;
            case COMMAND_PREPARE_UPDATE_PRODUCT:
                command = new PageUpdateProductAdminCommandImpl();
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
            case "to_cart": //user
                command = new PageShopCartCommandImpl();
                break;
            case "add_product_to_cart": //user
               command = new AddProductToCartCommandImpl();
               break;
            case "remove_from_cart": //user
                command = new DeleteProductFromCartCommandImpl();
                break;
            case COMMAND_TO_MY_ACCOUNT:
                command = new PageUserOrdersCommandImpl();
                break;
            case "show_details": //user
                command = new PageUserOrderDetailsCommandImpl();
                break;
            case "to_change_password": //user
                command = new PageChangePassCommandInformation();
                break;
            case "to_my_information": //user
                command = new PageUserInformCommandImpl();
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
