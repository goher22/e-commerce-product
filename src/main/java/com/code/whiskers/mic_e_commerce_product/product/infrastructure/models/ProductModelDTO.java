package com.code.whiskers.mic_e_commerce_product.product.infrastructure.models;

import com.code.whiskers.mic_e_commerce_product.product.domain.entities.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductModelDTO extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public ProductModelDTO(){
        super();
    }

    public ProductModelDTO(String name, String description, Double price, Integer stock){
        super(name, description, price,stock);
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public ProductModelDTO(long id, String name, String description, Double price, Integer stock){
        super(id, name, description, price,stock);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
