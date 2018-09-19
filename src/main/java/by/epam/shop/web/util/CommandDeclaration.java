package by.epam.shop.web.util;

public class CommandDeclaration {

    private CommandDeclaration(){
        throw new IllegalStateException("Utility class");
    }

    public static final String COMMAND_TO_START_PAGE = "start_page";
    public static final String COMMAND_TO_PRODUCTS = "to_products";
    public static final String COMMAND_TO_ORDERS = "to_orders";
    public static final String COMMAND_TO_MY_ACCOUNT = "to_my_account";
    public static final String COMMAND_TO_CATEGORIES = "to_categories";
    public static final String COMMAND_TO_LOG_IN = "to_log_in";
    public static final String COMMAND_PREPARE_CREATE_CATEGORY = "prepare_create_category";
    public static final String COMMAND_CREATE_CATEGORY = "create_category";
    public static final String COMMAND_DELETE_CATEGORY = "delete_category";
    public static final String COMMAND_PREPARE_UPDATE_CATEGORY = "prepare_update_category";
    public static final String COMMAND_UPDATE_CATEGORY = "update_category";
    public static final String COMMAND_DELETE_PRODUCT = "delete_product";
    public static final String COMMAND_PREPARE_UPDATE_PRODUCT = "prepare_update_product";

}
