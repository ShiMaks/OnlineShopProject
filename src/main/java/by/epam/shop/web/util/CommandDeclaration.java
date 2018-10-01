package by.epam.shop.web.util;

public class CommandDeclaration {

    private CommandDeclaration(){
        throw new IllegalStateException("Utility class");
    }

    public static final String COMMAND_TO_START_PAGE = "start_page";
    public static final String COMMAND_TO_START_PAGE_ADMIN = "start_page_admin";
    public static final String COMMAND_TO_REDIRECT_ADMIN = "redirect_admin";
    public static final String COMMAND_TO_REDIRECT_USER = "redirect_user";
    public static final String COMMAND_TO_PRODUCTS = "to_products";
    public static final String COMMAND_TO_ORDERS = "to_orders";
    public static final String COMMAND_SHOW_USER_DETAIL = "show_user_detail";
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
    public static final String COMMAND_UPDATE_PRODUCT = "update_product";
    public static final String COMMAND_PREPARE_CREATE_PRODUCT = "prepare_create_product";
    public static final String COMMAND_CREATE_PRODUCT = "create_product";
    public static final String COMMAND_SHOW_DETAIL_ORDER = "show_detail_order";
    public static final String COMMAND_UPDATE_ORDER = "update_order";
    public static final String COMMAND_SORT_BY_STATUS = "sort_order_by_status";
    public static final String COMMAND_LOG_IN = "log_in";
    public static final String COMMAND_TO_REGISTRATION = "to_registration";
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_LOG_OUT = "to_log_out";
    public static final String COMMAND_SHOW_PRODUCTS_CATEGORY = "show_products_category";
    public static final String COMMAND_PRODUCT_INFO = "show_products_info";
    public static final String COMMAND_TO_CART = "to_cart";
    public static final String COMMAND_ADD_PRODUCT_TO_CART = "add_product_to_cart";
    public static final String COMMAND_REMOVE_PRODUCT_FROM_CART = "remove_from_cart";
    public static final String COMMAND_SHOW_DETAILS = "show_details";
    public static final String COMMAND_TO_CHANGE_PASSWORD = "to_change_password";
    public static final String COMMAND_TO_USER_INFORMATION = "to_my_information";
    public static final String COMMAND_UPDATE_USER_INFORMATION = "update_user_inform";
    public static final String COMMAND_UPDATE_USER_PASSWORD = "update_user_password";
    public static final String COMMAND_CREATE_ORDER = "create_order";
    public static final String COMMAND_PAGINATION = "to_pagin";
    public static final String COMMAND_LOCALE = "change_locale";

}
