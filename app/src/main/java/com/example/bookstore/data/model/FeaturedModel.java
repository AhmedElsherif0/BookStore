
package com.example.bookstore.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturedModel {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("discount")
    @Expose
    private int discount;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("totalRating")
    @Expose
    private int totalRating;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("bookDescription")
    @Expose
    private String bookDescription;
    @SerializedName("aboutAuthor")
    @Expose
    private String aboutAuthor;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("upDated_at")
    @Expose
    private String upDated_at;
    @SerializedName("__v")
    @Expose
    private int v;


    public FeaturedModel(String image, int discount, String url, int rating,
                         int totalRating, Boolean isActive, String id, String name,
                         String author, String bookDescription, String aboutAuthor, double price,
                         String createdAt, String upDated_at, Integer v) {

        this.image = image;
        this.discount = discount;
        this.url = url;
        this.rating = rating;
        this.totalRating = totalRating;
        this.isActive = isActive;
        this.id = id;
        this.name = name;
        this.author = author;
        this.bookDescription = bookDescription;
        this.aboutAuthor = aboutAuthor;
        this.price = price;
        this.createdAt = createdAt;
        this.upDated_at = upDated_at;
        this.v = v;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public Integer getRating() {
        return rating;
    }

    public Integer getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpDated_at() {
        return upDated_at;
    }


    public void setUpDated_at(String upDated_at) {
        this.upDated_at = upDated_at;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
