package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private String type;
    private String dateProduction;
    private String image;

    public Product(){};

    public Product(int id, String name, String description, String type, String dateProduction) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.dateProduction = dateProduction;
        this.image = "/img/defaultAvatar.png";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(String dateProduction) {
        this.dateProduction = dateProduction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
