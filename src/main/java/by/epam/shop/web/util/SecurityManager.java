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
