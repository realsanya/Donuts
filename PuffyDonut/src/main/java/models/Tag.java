package models;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Tag {
    private Product id;
    private String tag;
}
