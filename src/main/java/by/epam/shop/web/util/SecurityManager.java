package by.epam.shop.web.util;

import by.epam.shop.domain.UserRoleEnum;

import java.util.HashMap;
import java.util.Map;

import static by.epam.shop.web.util.CommandDeclaration.*;

public class SecurityManager {

    private Map<String, UserRoleEnum> accessRights = new HashMap<>();

    {
        accessRights.put(COMMAND_TO_PRODUCTS,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_TO_ORDERS,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_TO_CATEGORIES,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_PREPARE_CREATE_CATEGORY,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_CREATE_CATEGORY,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_DELETE_CATEGORY,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_PREPARE_UPDATE_CATEGORY,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_UPDATE_CATEGORY,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_DELETE_PRODUCT,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_PREPARE_UPDATE_PRODUCT,UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_ADD_PRODUCT_TO_CART,UserRoleEnum.USER);
        accessRights.put(COMMAND_TO_MY_ACCOUNT, UserRoleEnum.USER);
        accessRights.put(COMMAND_TO_START_PAGE, UserRoleEnum.ALL);
        accessRights.put(COMMAND_TO_START_PAGE_ADMIN, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_TO_REDIRECT_ADMIN, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_TO_REDIRECT_USER, UserRoleEnum.USER);
        accessRights.put(COMMAND_SHOW_USER_DETAIL, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_UPDATE_PRODUCT, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_PREPARE_CREATE_PRODUCT, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_CREATE_PRODUCT, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_SHOW_DETAIL_ORDER, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_UPDATE_ORDER, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_SORT_BY_STATUS, UserRoleEnum.ADMIN);
        accessRights.put(COMMAND_TO_LOG_IN, UserRoleEnum.ALL);
        accessRights.put(COMMAND_LOG_IN, UserRoleEnum.ALL);
        accessRights.put(COMMAND_TO_REGISTRATION, UserRoleEnum.ALL);
        accessRights.put(COMMAND_REGISTER, UserRoleEnum.ALL);
        accessRights.put(COMMAND_LOG_OUT, UserRoleEnum.ALL);
        accessRights.put(COMMAND_SHOW_PRODUCTS_CATEGORY, UserRoleEnum.ALL);
        accessRights.put(COMMAND_PRODUCT_INFO, UserRoleEnum.ALL);
        accessRights.put(COMMAND_TO_CART, UserRoleEnum.USER);
        accessRights.put(COMMAND_ADD_PRODUCT_TO_CART, UserRoleEnum.USER);
        accessRights.put(COMMAND_REMOVE_PRODUCT_FROM_CART, UserRoleEnum.USER);
        accessRights.put(COMMAND_TO_MY_ACCOUNT, UserRoleEnum.USER);
        accessRights.put(COMMAND_SHOW_DETAILS, UserRoleEnum.USER);
        accessRights.put(COMMAND_TO_CHANGE_PASSWORD, UserRoleEnum.USER);
        accessRights.put(COMMAND_TO_USER_INFORMATION, UserRoleEnum.USER);
        accessRights.put(COMMAND_UPDATE_USER_INFORMATION, UserRoleEnum.USER);
        accessRights.put(COMMAND_UPDATE_USER_PASSWORD, UserRoleEnum.USER);
        accessRights.put(COMMAND_CREATE_ORDER, UserRoleEnum.USER);
        accessRights.put(COMMAND_PAGINATION, UserRoleEnum.ALL);
        accessRights.put(COMMAND_LOCALE, UserRoleEnum.ALL);
        accessRights.put(COMMAND_SORT_PRODUCTS, UserRoleEnum.ADMIN);
    }

    public SecurityManager(){

    }

    public UserRoleEnum getRoles(String command){
        UserRoleEnum role = UserRoleEnum.ALL;
        for (Map.Entry entry : accessRights.entrySet()) {
            String commandMap = (String) entry.getKey();
            if(command.equals(commandMap)){
                role = (UserRoleEnum) entry.getValue();
            }
        }
        return role;
    }
}
