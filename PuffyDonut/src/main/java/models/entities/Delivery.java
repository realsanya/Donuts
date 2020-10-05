package models.entities;

import java.sql.Date;

public class Delivery {
    private Order order_id;
    private Date delivery_date;
    private String delivery_status;

    public Delivery(Order order_id, Date delivery_date, String delivery_status) {
        this.order_id = order_id;
        this.delivery_date = delivery_date;
        this.delivery_status = delivery_status;
    }

    public Order getOrder_id() {
        return order_id;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public String getDelivery_status() {
        return delivery_status;
    }
}
