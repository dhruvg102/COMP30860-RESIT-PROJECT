package com.mycompany.app.entities;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="products")
public class MyProduct implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column private String name;
    @Column private float trainedPrice;
    @Column private float untrainedPrice;
    @Column(columnDefinition = "LONGTEXT") private String desc;
    @Column private float rating;
    @Column private String imgSrc;
    public Object prod;

    public MyProduct(){}
    public MyProduct( String name,float trainedPrice, float untrainedPrice, String desc, float rating, String imgSrc){
        this.desc = desc;
        this.trainedPrice = trainedPrice;
        this.untrainedPrice = untrainedPrice;
        this.rating = rating;
        this.name = name;
        this.imgSrc = imgSrc;

    }
   
    public String getImgSrc() {
        return imgSrc;
    }
    public String getDesc() {
        return desc;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public float getTrainedPrice() {
        return trainedPrice;
    }
    public float getUntrainedPrice() {
        return untrainedPrice;
    }
    public void setTrainedPrice(float trainedPrice) {
        this.trainedPrice = trainedPrice;
    }
    public void setUntrainedPrice(float untrainedPrice) {
        this.untrainedPrice = untrainedPrice;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public float getRating() {
        return rating;
    }

}