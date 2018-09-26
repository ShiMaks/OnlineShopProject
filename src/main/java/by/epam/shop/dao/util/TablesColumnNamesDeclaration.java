package by.epam.shop.dao.util;

/**
 * Utility class where declared all columns names
 * database tables
 *
 * @author Maksim Shilvian
 */
public final class TablesColumnNamesDeclaration {

    private TablesColumnNamesDeclaration() {
        throw new IllegalStateException("Utility class");
    }

    public static final String PRODUCT_COLUMN_ID = "id";
    public static final String PRODUCT_COLUMN_NAME = "name";
    public static final String PRODUCT_COLUMN_CATEGORY_ID = "category_id";
    public static final String PRODUCT_COLUMN_PRICE = "price";
    public static final String PRODUCT_COLUMN_PICTURE = "picture";
    public static final String PRODUCT_COLUMN_DESCRIPTION = "description";
    public static final String PRODUCT_COLUMN_QUANTITY = "quantity";

    public static final String CATEGORY_COLUMN_ID = "id";
    public static final String CATEGORY_COLUMN_NAME = "name";

    public static final String ORDER_ID = "id";
    public static final String ORDER_CLIENT_ID = "client_id";
    public static final String ORDER_PRODUCT_ID = "product_id";
    public static final String ORDER_DATE = "dataOrder";
    public static final String ORDER_PRICE = "price";
    public static final String ORDER_STATUS = "status";
    public static final String ORDER_PRODUCT_QUANTITY = "quantity";

    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_NAME = "name";
    public static final String USER_COLUMN_SURNAME = "surname";
    public static final String USER_COLUMN_LOGIN = "login";
    public static final String USER_COLUMN_EMAIL = "email";
    public static final String USER_COLUMN_PHONE = "phone";
    public static final String USER_COLUMN_PASSWORD = "password";
    public static final String USER_COLUMN_IS_ADMIN = "isAdmin";
}

