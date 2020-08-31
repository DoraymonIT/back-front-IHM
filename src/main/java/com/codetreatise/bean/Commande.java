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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dell
 */
@Entity
@Table(name="Commande")
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
    int numTable;
    String entree;
    String plat;
    String boire;
   
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(long id, int numTable, String entree, String plat, String boire) {
		super();
		this.id = id;
		this.numTable = numTable;
		this.entree = entree;
		this.plat = plat;
		this.boire = boire;
	}

	public Commande(int c, String c1, String c2, String c3) {
		// TODO Auto-generated constructor stub
		super();
		
		this.numTable = c;
		this.entree = c1;
		this.plat = c2;
		this.boire = c3;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumTable() {
		return numTable;
	}

	public void setNumTable(int numTable) {
		this.numTable = numTable;
	}

	public String getEntree() {
		return entree;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getBoire() {
		return boire;
	}

	public void setBoire(String boire) {
		this.boire = boire;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numTable=" + numTable + ", entree=" + entree + ", plat=" + plat + ", boire="
				+ boire + "]";
	}

	
	

    
}
