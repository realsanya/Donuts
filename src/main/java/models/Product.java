package models;

public class Product {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Integer price;
    private Boolean availability;
    private Integer quantity;
    private Integer weight;

    public Product(Long id, String name, String description, String image,
                   Integer price, Boolean availability, Integer quantity, Integer weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.availability = availability;
        this.quantity = quantity;
        this.weight = weight;
    }

}
