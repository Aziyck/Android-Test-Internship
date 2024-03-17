package com.alexandru.mobileshopapp.model.api.entities.getProduct;

import com.alexandru.mobileshopapp.model.api.entities.Category;
import com.alexandru.mobileshopapp.model.api.entities.Image;
import com.alexandru.mobileshopapp.model.api.entities.Review;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class ProductBig {

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

    @SerializedName("id")
    private int id;

    @SerializedName("main_image")
    private String mainImage;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("reviews")
    private List<Review> reviews;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
