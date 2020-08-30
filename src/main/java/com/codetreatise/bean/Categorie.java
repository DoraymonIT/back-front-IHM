/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codetreatise.bean;

/**
 *
 * @author pc
 */
public class Categorie {
    Long id;
    String libelle;

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public Categorie(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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
    @Override
    public String toString() {
        return  libelle ;
    } 
    
}
