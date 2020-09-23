package models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Donut {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Float price;
    private Boolean availability;
    private Integer quantity;
    private Integer weight;
    private String tag;

    public Donut() {

    }

    public Donut(Long id, String name, String description, String image, Float price,
                 Boolean availability, Integer quantity, Integer weight, String tag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.availability = availability;
        this.quantity = quantity;
        this.weight = weight;
        this.tag = tag;
    }

    public Donut(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("product_id");
            this.name = resultSet.getString("product_name");
            this.description = resultSet.getString("product_description");
            this.image = resultSet.getString("image");
            this.price = resultSet.getFloat("price");
            this.availability = resultSet.getBoolean("availability");
            this.quantity = resultSet.getInt("quantity");
            this.weight = resultSet.getInt("weight");
            this.tag = resultSet.getString("tag");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String toString() {
        return "Donut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ", availability='" + availability + '\'' +
                ", quantity='" + quantity + '\'' +
                ", weight='" + weight + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}