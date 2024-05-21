package com.example.keycloakbackend.produit.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name= "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String category;
    private String marque;
    private String description1;
    private String description2;
    private float prix;
    private String image;
    private float rate;

    // Constructors, getters, and setters
    // Omitted for brevity

    // Constructor
    public Product(String category, String marque, String description1, String description2, float prix, String image, float rate) {
        this.category = category;
        this.marque = marque;
        this.description1 = description1;
        this.description2 = description2;
        this.prix = prix;
        this.image = image;
        this.rate = rate;
    }

    // Getters and setters

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }


}
