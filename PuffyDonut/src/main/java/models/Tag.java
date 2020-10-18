package models;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Tag {
    private Donut donut_id;
    private String tag;
}
