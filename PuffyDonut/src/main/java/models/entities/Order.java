package models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    private int order_id;
    private User user_id;
    private Donut product_id;
    private Float total_price;
    private int payment;

    public Order(int order_id, User user_id, Donut product_id, Float total_price, int payment) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.total_price = total_price;
        this.payment = payment;
    }

    public int getOrder_id() {
        return order_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public Donut getProduct_id() {
        return product_id;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public int getPayment() {
        return payment;
    }
}
