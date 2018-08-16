package by.epam.shop.domain;

public class OrderItem extends Entity {

    private int idOrder;
    private int idProduct;
    private int quantity;
    private int price;

    public OrderItem(){

    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        if (!super.equals(o)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (idOrder != orderItem.idOrder) return false;
        if (idProduct != orderItem.idProduct) return false;
        if (quantity != orderItem.quantity) return false;
        return price == orderItem.price;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + idOrder;
        result = 31 * result + idProduct;
        result = 31 * result + quantity;
        result = 31 * result + price;
        return result;
    }
}
