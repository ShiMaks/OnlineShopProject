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

    //product
    public static final String PRODUCT_COLUMN_ID = "id";
    public static final String PRODUCT_COLUMN_NAME = "name";
    public static final String PRODUCT_COLUMN_CATEGORY_ID = "category_id";
    public static final String PRODUCT_COLUMN_PRICE = "price";
    public static final String PRODUCT_COLUMN_PICTURE = "picture";
    public static final String PRODUCT_COLUMN_DESCRIPTION = "description";
    public static final String PRODUCT_COLUMN_QUANTITY = "quantity";

    //category
}
