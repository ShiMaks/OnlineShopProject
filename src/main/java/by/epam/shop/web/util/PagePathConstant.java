package by.epam.shop.web.util;

public class PagePathConstant {

    private PagePathConstant(){
        throw new IllegalStateException("Utility class");
    }

    public static final String PAGE_START_PAGE = "/WEB-INF/start_page.jsp";
    public static final String PAGE_INDEX = "/jsp/index.jsp";
    public static final String PAGE_SIGN_IN = "/jsp/pages/page-login.jsp";
    public static final String PAGE_REGISTRATION = "";
    public static final String PAGE_CART = "/jsp/pages/shop-cart.jsp";
    public static final String PAGE_ERROR = "/jsp/pages/error.jsp";

    public static final String PAGE_CATEGORY_ADMIN = "/jsp/categoryAdmin.jsp";
    public static final String PAGE_ADMIN = "/jsp/admin.jsp";
    public static final String PAGE_CREATE_CATEGORY = "/jsp/creatCatAdmin.jsp";
    public static final String PAGE_UPDATE_CATEGORY = "/jsp/updateCatAdmin.jsp";
    public static final String PAGE_PRODUCTS_ADMIN = "/jsp/productsAdmin.jsp";
    public static final String PAGE_UPDATE_PRODUCT = "/jsp/updateProdAdmin.jsp";
    public static final String PAGE_CREATE_PRODUCT = "/jsp/creatProdAdmin.jsp";


    public static final String REDIRECT_ADMIN_PRODUCT_URL = "/FrontController?command=to_products";
    public static final String REDIRECT_ADMIN_URL = "/FrontController?command=start_page_admin";
    public static final String REDIRECT_ADMIN_CATEGORY_URL = "/FrontController?command=to_categories";
    public static final String REDIRECT_ADMIN_ORDER_URL = "/FrontController?command=to_orders";
    public static final String REDIRECT_USER_URL = "/FrontController?command=start_page";
    public static final String REDIRECT_GUEST_URL = "/FrontController?command=redirect_guest";
}
