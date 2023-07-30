package com.mycompany.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class MyOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column private Long product_id;
    @Column private float price;

    @ManyToOne
    @JoinColumn(
        name = "user_id"
    )
    private MyUser user;


    public MyOrder(){}

    public MyOrder( Long product, float price, MyUser user){
        this.product_id = product;
        this.price = price;
        this.user = user;
    }
    public Long getId() {
        return id;
    }

    public Long getProduct() {
        return product_id;
    }
    public MyUser getUser() {
        return user;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setProduct(Long product) {
        this.product_id = product;
    }
    public void setUser(MyUser user) {
        this.user = user;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    
}
