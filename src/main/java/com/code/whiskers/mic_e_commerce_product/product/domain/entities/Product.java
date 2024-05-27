package com.code.whiskers.mic_e_commerce_product.product.domain.entities;

public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public Product() {

    }

    public Product(String name, String description, Double price, Integer stock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(long id, String name, String description, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
}
