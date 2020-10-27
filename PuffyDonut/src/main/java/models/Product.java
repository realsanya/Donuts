package models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Product {
    private Integer id;
    private String name;
    private String description;
    @Builder.Default
    private String image = "default.png";
    private Float price;
    @Builder.Default
    private Boolean availability = true;
    private Integer weight;
    private Tag tag;
}
