package by.epam.shop.domain;

/**
 * Class describing Product entity from database
 *
 * @author Maksim Shilvian
 */
public class Product extends Entity {

    private static final long serialVersionUID = -2767880649754437588L;
    /**
     * Name of product
     */
    private String name;

    /**
     * Id of product
     */
    private int idCategory;

    /**
     * Description of product
     */
    private String description;

    /**
     * Variable to check
     * the availability of goods
     */
    private boolean inStock;

    /**
     * Quantity of product
     * that is available
     */
    private int quantity;

    /**
     * Price of product
     */
    private int price;

    /**
     * Link to product photo
     */
    private String picture;

    public Product(){

    }

    public Product(int id, String name){
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCatrgory) {
        this.idCategory = idCatrgory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (idCategory != product.idCategory) return false;
        if (inStock != product.inStock) return false;
        if (quantity != product.quantity) return false;
        if (price != product.price) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return picture != null ? picture.equals(product.picture) : product.picture == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idCategory;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (inStock ? 1 : 0);
        result = 31 * result + quantity;
        result = 31 * result + price;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product:" +
                " id=" + getId() +
                " , name=" + name +
                ", idCategory=" + idCategory +
                ", description='" + description +
                ", inStock=" + inStock +
                ", quantity=" + quantity +
                ", price=" + price +
                ", picture='" + picture;
    }
}
