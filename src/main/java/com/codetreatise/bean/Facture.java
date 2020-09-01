package com.codetreatise.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Facture")
public class Facture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
    Long id;
	String libelle;
	String entree;
	String plat;
	String drink;
	String prixE;
	String prixP;
	String prixD;
	String total;
	Date time;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(Long id, String libelle, String entree, String plat, String drink, String prixE, String prixP,
			String prixD, String total, Date time) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.entree = entree;
		this.plat = plat;
		this.drink = drink;
		this.prixE = prixE;
		this.prixP = prixP;
		this.prixD = prixD;
		this.total = total;
		this.time = time;
	}
	public Facture( String libelle, String entree, String plat, String drink, String prixE, String prixP,
			String prixD, String total, Date time) {
		super();
		
		this.libelle = libelle;
		this.entree = entree;
		this.plat = plat;
		this.drink = drink;
		this.prixE = prixE;
		this.prixP = prixP;
		this.prixD = prixD;
		this.total = total;
		this.time = time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getPrixE() {
		return prixE;
	}
	public void setPrixE(String prixE) {
		this.prixE = prixE;
	}
	public String getPrixP() {
		return prixP;
	}
	public void setPrixP(String prixP) {
		this.prixP = prixP;
	}
	public String getPrixD() {
		return prixD;
	}
	public void setPrixD(String prixD) {
		this.prixD = prixD;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Facture [id=" + id + ", libelle=" + libelle + ", entree=" + entree + ", plat=" + plat + ", drink="
				+ drink + ", prixE=" + prixE + ", prixP=" + prixP + ", prixD=" + prixD + ", total=" + total + ", time="
				+ time + "]";
	}
	
	
}
