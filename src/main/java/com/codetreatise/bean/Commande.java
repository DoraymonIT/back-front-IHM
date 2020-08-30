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
public class Commande {
    int numCmd;
    int numTable;
    String entree;
    String plat;
    String drink;

    public Commande(int numCmd, int numTable, String entree, String plat, String drink) {
        this.numCmd = numCmd;
        this.numTable = numTable;
        this.entree = entree;
        this.plat = plat;
        this.drink = drink;
    }


    public int getNumCmd() {
        return numCmd;
    }

    public void setNumCmd(int idCmd) {
        this.numCmd = idCmd;
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

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Commande{" + "numCmd=" + numCmd + ", numTable=" + numTable + ", entree=" + entree + ", plat=" + plat + ", drink=" + drink + '}';
    }
    
    
}
