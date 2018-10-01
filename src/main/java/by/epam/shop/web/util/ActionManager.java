package by.epam.shop.web.util;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.commands.impl.admin.*;
import by.epam.shop.web.commands.impl.all.*;
import by.epam.shop.web.commands.impl.user.*;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.CommandDeclaration.*;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_COMMAND;

public class ActionManager {

    private ActionManager(){
        throw new IllegalStateException("Utility class");
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        BaseCommand command = null;
        String inputCommand =  request.getParameter(REQUEST_PARAM_COMMAND);
        if(inputCommand == null || inputCommand.isEmpty()) {
            inputCommand = COMMAND_TO_START_PAGE;
        }
        switch(inputCommand) {
            case COMMAND_TO_START_PAGE:
                command = new StartPageCommandImpl();
                break;
            case COMMAND_TO_START_PAGE_ADMIN:
                command = new PageAdminCommandImpl();
                break;
            case COMMAND_TO_REDIRECT_ADMIN:
                command = new RedirectAdminCommandImpl();
                break;
            case COMMAND_TO_REDIRECT_USER:
                command = new RedirectUserCommandImpl();
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
            case COMMAND_SHOW_USER_DETAIL:
                command = new PageUserDetailCommandImpl();
                break;
            case COMMAND_UPDATE_PRODUCT:
                command = new UpdateProductAdminCommandImpl();
                break;
            case COMMAND_PREPARE_CREATE_PRODUCT:
                command = new PageCreateProductCommandImpl();
                break;
            case COMMAND_CREATE_PRODUCT:
                command = new AddProductCommandImpl();
                break;
            case COMMAND_SHOW_DETAIL_ORDER:
                command = new ShowDetailOrderCommandImpl();
                break;
            case COMMAND_UPDATE_ORDER:
                command = new UpdateOrderAdminCommandImpl();
                break;
            case COMMAND_SORT_BY_STATUS:
                command = new SortOrderByStatusAdnibCommandImpl();
                break;
            case COMMAND_TO_LOG_IN:
                command = new SingInPageCommandImpl();
                break;
            case COMMAND_LOG_IN:
                command = new AuthorizationCommandImpl();
                break;
            case COMMAND_TO_REGISTRATION:
                command = new PageRegistrationCommandImpl();
                break;
            case COMMAND_REGISTER:
                command = new RegisterCommandImpl();
                break;
            case COMMAND_LOG_OUT:
                command = new LogOutCommandImpl();
                break;
            case COMMAND_SHOW_PRODUCTS_CATEGORY:
                command = new PageCategoryProductsCommandImpl();
                break;
            case COMMAND_PRODUCT_INFO:
                command = new PageProductInfoCommandImpl();
                break;
            case COMMAND_TO_CART:
                command = new PageShopCartCommandImpl();
                break;
            case COMMAND_ADD_PRODUCT_TO_CART:
               command = new AddProductToCartCommandImpl();
               break;
            case COMMAND_REMOVE_PRODUCT_FROM_CART:
                command = new DeleteProductFromCartCommandImpl();
                break;
            case COMMAND_TO_MY_ACCOUNT:
                command = new PageUserOrdersCommandImpl();
                break;
            case COMMAND_SHOW_DETAILS:
                command = new PageUserOrderDetailsCommandImpl();
                break;
            case COMMAND_TO_CHANGE_PASSWORD:
                command = new PageChangePassCommandInformation();
                break;
            case COMMAND_TO_USER_INFORMATION:
                command = new PageUserInformCommandImpl();
                break;
            case COMMAND_UPDATE_USER_INFORMATION:
                command = new UpdateUserInfoCommandImpl();
                break;
            case COMMAND_UPDATE_USER_PASSWORD:
                command = new ChangePasswordCommandImpl();
                break;
            case COMMAND_CREATE_ORDER:
                command = new CreateOrderCommandImpl();
                break;
            case COMMAND_PAGINATION:
                command = new PagePaginationCommandImpl();
                break;
            case COMMAND_LOCALE:
                command = new ChangeLocaleCommandImpl();
                break;
            default:
                command = new StartPageCommandImpl();
                break;
        }
        return command;
    }
}
