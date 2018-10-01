package by.epam.shop.web.util;

public final class PagePathConstant {

    private PagePathConstant(){
        throw new IllegalStateException("Utility class");
    }

    public static final String PAGE_START_PAGE = "/WEB-INF/start_page.jsp";
    public static final String PAGE_INDEX = "/jsp/index.jsp";
    public static final String PAGE_SIGN_IN = "/jsp/pages/page-login.jsp";
    public static final String PAGE_REGISTRATION = "/jsp/pages/page-reg-page.jsp";
    public static final String PAGE_CART = "/jsp/pages/shop-cart.jsp";
    public static final String PAGE_ERROR = "/jsp/pages/error.jsp";
    public static final String PAGE_SHOP_ITEM = "/jsp/pages/shop-item.jsp";
    public static final String PAGE_SHOP_MAIN_PAGE = "/jsp/pages/indexNew.jsp";
    public static final String PAGE_SHOP_CHANGE_PASSWORD = "/jsp/pages/change-password.jsp";
    public static final String PAGE_SHOP_USER_INFORMATION = "/jsp/pages/profile-account.jsp";
    public static final String PAGE_SHOP_USER_ORDER_DETAIL = "/jsp/pages/order-details.jsp";
    public static final String PAGE_SHOP_ACCOUNT = "/jsp/pages/shop-account.jsp";

    public static final String PAGE_CATEGORY_ADMIN = "/jsp/categoryAdmin.jsp";
    public static final String PAGE_ADMIN = "/jsp/admin.jsp";
    public static final String PAGE_CREATE_CATEGORY = "/jsp/creatCatAdmin.jsp";
    public static final String PAGE_UPDATE_CATEGORY = "/jsp/updateCatAdmin.jsp";
    public static final String PAGE_PRODUCTS_ADMIN = "/jsp/productsAdmin.jsp";
    public static final String PAGE_UPDATE_PRODUCT = "/jsp/updateProdAdmin.jsp";
    public static final String PAGE_CREATE_PRODUCT = "/jsp/creatProdAdmin.jsp";
    public static final String PAGE_ORDERS_ADMIN = "/jsp/ordersAdmin.jsp";
    public static final String PAGE_ORDER_DETAIL = "jsp/updateOrderAdmin.jsp";
    public static final String PAGE_USER_DETAIL = "jsp/adminUser.jsp";

    public static final String REDIRECT_ADMIN_URL = "/FrontController?command=redirect_admin";
    public static final String REDIRECT_USER_URL = "/FrontController?command=redirect_user";
    public static final String REDIRECT_GUEST_URL = "/FrontController?command=start_page";
}
