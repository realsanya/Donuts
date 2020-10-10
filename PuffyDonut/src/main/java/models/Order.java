package models;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Order {
    private Long order_id;
    private Long user_id;
    private Long product_id;
    private Float total_price;
    private Integer payment;
}
