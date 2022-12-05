/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: The POJO for the shopping list class. It is used to connect to H2 database for data handling.
*/

package ca.georgebrown.assigment2_cyllenian_group.model;

import javax.persistence.*;

@Entity
@Table(name = "SHOPPINGLIST")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lid;
    private String lname;
    private String lingredients;
    private Integer quantity;
    private boolean purchased;

    private boolean cart;

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLingredients() {
        return lingredients;
    }

    public void setLingredients(String lingredients) {
        this.lingredients = lingredients;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public boolean isCart() {
        return cart;
    }

    public void setCart(boolean addCart) {
        this.cart = addCart;
    }
}
