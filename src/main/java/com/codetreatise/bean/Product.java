/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codetreatise.bean;

/**
 *
 * @author dell
 */
public class Product {

    String nom;
    String price;
    Categorie categorie;
    String description;

    public Product(String nom, String price, Categorie categorie, String description) {
        this.nom = nom;
        this.price = price;
        this.categorie = categorie;
        this.description = description;
    }

    public Product(String nom, String price) {
        this.nom = nom;
        this.price = price;
    }

    public Product(String nom, String price, Categorie categorie) {
        this.nom = nom;
        this.price = price;
        this.categorie = categorie;
    }

    public Product(String nom) {
        this.nom = nom;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

 

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }

}
