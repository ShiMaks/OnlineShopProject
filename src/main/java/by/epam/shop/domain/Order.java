package by.epam.shop.domain;

import java.util.Date;

/**
 * Class describing Order entity from database
 *
 * @author Maksim Shilvian
 */
public class Order extends Entity {

    private static final long serialVersionUID = -2492805031350769803L;
    /**
     * Id of user who made the order
     */
    private int idClient;

    /**
     * Status of order
     */
    private OrderStatusEnum status;

    /**
     * Date of order
     */
    private Date dataOrder;

    /**
     * Full cost of this order
     */
    private int orderCost;

    public  Order(){

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Date getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Date dataOrder) {
        this.dataOrder = dataOrder;
    }

    public int getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(int orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (idClient != order.idClient) return false;
        if (orderCost != order.orderCost) return false;
        if (status != order.status) return false;
        return dataOrder != null ? dataOrder.equals(order.dataOrder) : order.dataOrder == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + idClient;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + orderCost;
        return result;
    }

    @Override
    public String toString() {
        return "Order:" +
                " id=" + getId() +
                " , idClient=" + idClient +
                " , status=" + status +
                " , dataOrder=" + dataOrder +
                " , orderCost=" + orderCost;
    }
}
