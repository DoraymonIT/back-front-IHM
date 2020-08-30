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
public class Employee {

    String iD;
    String nomComplet;
    String fonction;

    public Employee(String nomComplet, String fonction) {
        this.nomComplet = nomComplet;
        this.fonction = fonction;
    }

    public Employee(String iD, String nomComplet, String fonction) {
        this.iD = iD;
        this.nomComplet = nomComplet;
        this.fonction = fonction;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return "Employee{" + "iD=" + iD + ", nomComplet=" + nomComplet + ", fonction=" + fonction + '}';
    }

}
