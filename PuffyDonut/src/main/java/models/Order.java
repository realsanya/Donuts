package models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long order_id;
    private Long user_id;
    private Long product_id;
    private Float total_price;
    private Integer payment;

    public Order(Long order_id, Long user_id, Long product_id, Float total_price, Integer payment) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.total_price = total_price;
        this.payment = payment;
    }

}
