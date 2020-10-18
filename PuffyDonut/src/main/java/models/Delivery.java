package models;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Delivery {
    private Order order_id;
    private Date delivery_date;
    private String delivery_status;
}
