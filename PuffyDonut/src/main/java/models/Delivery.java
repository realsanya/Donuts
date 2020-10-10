package models;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Delivery {
    private Long order_id;
    private Date delivery_date;
    private String delivery_status;
}
