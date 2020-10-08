package models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Delivery {
    private Order order_id;
    private Date delivery_date;
    private String delivery_status;

    public Delivery(Order order_id, Date delivery_date, String delivery_status) {
        this.order_id = order_id;
        this.delivery_date = delivery_date;
        this.delivery_status = delivery_status;
    }
}
