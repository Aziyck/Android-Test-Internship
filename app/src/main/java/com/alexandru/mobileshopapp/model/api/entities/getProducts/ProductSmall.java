package com.alexandru.mobileshopapp.model.api.entities.getProducts;

import com.alexandru.mobileshopapp.model.api.entities.Category;
import com.google.gson.annotations.SerializedName;

public class ProductSmall {
    @SerializedName("id")
    private int id;
    @SerializedName("category")
    private Category category;
    @SerializedName("name")
    private String name;
    @SerializedName("details")
    private String details;
    @SerializedName("size")
    private String size;
    @SerializedName("colour")
    private String colour;
    @SerializedName("price")
    private double price;
    @SerializedName("main_image")
    private String mainImageLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }

    public void setMainImageLink(String mainImageLink) {
        this.mainImageLink = mainImageLink;
    }
}
