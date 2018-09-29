package by.epam.shop.web.util;

public final class WebConstantDeclaration {

    private WebConstantDeclaration() {
        throw new IllegalStateException("Utility class");
    }

    public static final String REQUEST_PARAM_NAME_CATEGORY = "name_category";
    public static final String REQUEST_PARAM_CATEGORY_ID = "category_id";
    public static final String REQUEST_PARAM_LIST_CATEGORIES_ADMIN = "categoriesAdmin";
    public static final String REQUEST_PARAM_CATEGORY = "category";
    public static final String REQUEST_PARAM_LIST_CATEGORY = "listCategory";

    public static final String REQUEST_PARAM_PRODUCT_NAME = "product_name";
    public static final String REQUEST_PARAM_PRODUCT_ID = "product_id";
    public static final String REQUEST_PARAM_LIST_PRODUCTS_ADMIN = "productsAdmin";
    public static final String REQUEST_PARAM_PRODUCT = "product";
    public static final String REQUEST_PARAM_DESCRIPTION = "description";
    public static final String REQUEST_PARAM_QUANTITY = "quantity";
    public static final String REQUEST_PARAM_PRODUCT_PRICE = "price";
    public static final String REQUEST_PARAM_PRODUCT_PICTURE = "picture";
    public static final String REQUEST_PARAM_SHOPPING_CART = "shopCart";
    public static final String REQUEST_PARAM_LIST_PRODUCT = "listProduct";

    public static final String REQUEST_PARAM_USER = "user";
    public static final String REQUEST_PARAM_USER_ID = "user_id";
    public static final String REQUEST_PARAM_PASS = "password";
    public static final String REQUEST_PARAM_LOGIN = "login";
    public static final String REQUEST_PARAM_NAME = "name";
    public static final String REQUEST_PARAM_SURNAME = "surname";
    public static final String REQUEST_PARAM_EMAIL = "email";
    public static final String REQUEST_PARAM_PHONE = "phone";
    public static final String REQUEST_PARAM_USER_ROLE = "user_type";
    public static final String REQUEST_PARAM_USERS = "users";
    public static final String REQUEST_PARAM_USERS_INFO = "userInform";
    public static final String REQUEST_PARAM_OLD_PASS = "old_password";
    public static final String REQUEST_PARAM_NEW_PASS = "new_password";
    public static final String REQUEST_PARAM_CONFIRM_NEW_PASS = "confirm_password";

    public static final String REQUEST_PARAM_ORDER = "order";
    public static final String REQUEST_PARAM_ORDER_ID = "order_id";
    public static final String REQUEST_PARAM_ORDER_STATUS = "order_status";
    public static final String REQUEST_PARAM_USER_ORDER = "userOrders";
    public static final String REQUEST_PARAM_LIST_ORDERS = "listOrders";

    public static final String REQUEST_PARAM_COMMAND = "command";
    public static final String REQUEST_PARAM_SESSION_MESSAGE = "session_message";
    public static final String REQUEST_PARAM_INFO_MESSAGE = "info_message";
    public static final String REQUEST_PARAM_LOCALE = "locale";

    public static final String REQUEST_PARAM_INVALID_LOGIN = "invalid_login";
    public static final String REQUEST_PARAM_INVALID_PASS = "invalid_password";
    public static final String REQUEST_PARAM_INVALID_CONFIRM_PASS = "invalid_confirm_password";
    public static final String REQUEST_PARAM_INVALID_OLD_PASS = "invalid_old_password";
    public static final String REQUEST_PARAM_INVALID_NAME = "invalid_name";
    public static final String REQUEST_PARAM_INVALID_SURNAME = "invalid_surname";
    public static final String REQUEST_PARAM_INVALID_EMAIL = "invalid_email";
    public static final String REQUEST_PARAM_INVALID_PHONE = "invalid_phone";
    public static final String REQUEST_PARAM_INVALID_CATEGORY_NAME = "invalid_category_name";
    public static final String REQUEST_PARAM_INVALID_PRODUCT_NAME = "invalid_product_name";
    public static final String REQUEST_PARAM_INVALID_QUANTITY = "invalid_quantity";
    public static final String REQUEST_PARAM_INVALID_PRODUCT_PRICE = "invalid_product_price";
    public static final String REQUEST_PARAM_INVALID_PICTURE_PATH = "invalid_picture_path";

    public static final String SESSION_PAGE_TYPE = "session_page_type";
    public static final String PAGE_TYPE_ADMIN_CATEGORY = "categories_page";
    public static final String PAGE_TYPE_ADMIN_PRODUCT = "products_page";
    public static final String PAGE_TYPE_ADMIN_ORDERS = "orders_page";
    public static final String PAGE_TYPE_ADMIN = "main_admin_page";

    public static final String PAGE_TYPE_USER_ORDERS = "user_orders_page";
    public static final String PAGE_TYPE_USER_CART = "user_cart_page";
    public static final String PAGE_TYPE_USER_INFO = "user_info_page";
    public static final String PAGE_TYPE_USER_MAIN = "user_main_page";
}
