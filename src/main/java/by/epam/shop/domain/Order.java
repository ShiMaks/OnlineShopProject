package by.epam.shop.domain;

import java.util.Date;

/**
 * Class describing Order entity from database
 *
 * @author Maksim Shilvian
 */
public class Order extends Entity {

    /**
     * Id of user who made the order
     */
    private int idClient;

    /**
     * Status of order
     */
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
}
