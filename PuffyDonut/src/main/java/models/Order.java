package models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Order {
    private Integer order_id;
    private User user_id;
    private List<Product> products_id;
    @Builder.Default
    private Float total_price = Float.valueOf(0);
    @Builder.Default
    private Integer count = 0;
}
