package by.epam.shop.web.util;

public final class PagePathConstant {

    private PagePathConstant(){
        throw new IllegalStateException("Utility class");
    }

    public static final String PAGE_INDEX = "/jsp/index.jsp";
    public static final String PAGE_SIGN_IN = "/WEB-INF/pages/user/page-login.jsp";
    public static final String PAGE_REGISTRATION = "/WEB-INF/pages/user/page-reg-page.jsp";
    public static final String PAGE_CART = "/WEB-INF/pages/user/shop-cart.jsp";
    public static final String PAGE_ERROR = "/WEB-INF/pages/user/error.jsp";
    public static final String PAGE_SHOP_ITEM = "/WEB-INF/pages/user/shop-item.jsp";
    public static final String PAGE_SHOP_MAIN_PAGE = "/WEB-INF/pages/user/main-page.jsp";
    public static final String PAGE_SHOP_CHANGE_PASSWORD = "/WEB-INF/pages/user/change-password.jsp";
    public static final String PAGE_SHOP_USER_INFORMATION = "/WEB-INF/pages/user/profile-account.jsp";
    public static final String PAGE_SHOP_USER_ORDER_DETAIL = "/WEB-INF/pages/user/order-details.jsp";
    public static final String PAGE_SHOP_ACCOUNT = "/WEB-INF/pages/user/shop-account.jsp";

    public static final String PAGE_CATEGORY_ADMIN = "/WEB-INF/pages/admin/categoryAdmin.jsp";
    public static final String PAGE_ADMIN = "/WEB-INF/pages/admin/admin.jsp";
    public static final String PAGE_CREATE_CATEGORY = "/WEB-INF/pages/admin/creatCatAdmin.jsp";
    public static final String PAGE_UPDATE_CATEGORY = "/WEB-INF/pages/admin/updateCatAdmin.jsp";
    public static final String PAGE_PRODUCTS_ADMIN = "/WEB-INF/pages/admin/productsAdmin.jsp";
    public static final String PAGE_UPDATE_PRODUCT = "/WEB-INF/pages/admin/updateProdAdmin.jsp";
    public static final String PAGE_CREATE_PRODUCT = "/WEB-INF/pages/admin/creatProdAdmin.jsp";
    public static final String PAGE_ORDERS_ADMIN = "/WEB-INF/pages/admin/ordersAdmin.jsp";
    public static final String PAGE_ORDER_DETAIL = "/WEB-INF/pages/admin/updateOrderAdmin.jsp";
    public static final String PAGE_USER_DETAIL = "/WEB-INF/pages/admin/adminUser.jsp";

    public static final String REDIRECT_ADMIN_URL = "/FrontController?command=redirect_admin";
    public static final String REDIRECT_USER_URL = "/FrontController?command=redirect_user";
    public static final String REDIRECT_GUEST_URL = "/FrontController?command=start_page";
}
