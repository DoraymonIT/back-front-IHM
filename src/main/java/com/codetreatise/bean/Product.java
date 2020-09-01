/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codetreatise.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author dell
 */
@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
    String nom;
    String price;
    @ManyToOne
    Categorie categorie;
    String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long id, String nom, String price, Categorie categorie, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.price = price;
		this.categorie = categorie;
		this.description = description;
	}
	public Product( String nom, String price, Categorie categorie) {
		super();
		
		this.nom = nom;
		this.price = price;
		this.categorie = categorie;
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", price=" + price + ", categorie=" + categorie + ", description="
				+ description + "]";
	}

 

}
