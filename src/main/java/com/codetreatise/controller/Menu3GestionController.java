/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.bean.Categorie;
import com.codetreatise.bean.Product;
import com.codetreatise.config.StageManager;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author pc
 */
@Controller
public class Menu3GestionController implements Initializable {
	@Lazy
    @Autowired	
    private StageManager stageManager;
    @FXML
    private JFXTextField prixPlat;

    @FXML
    private JFXTextField nomPlat;

    @FXML
    private JFXComboBox<Categorie> categoriePlat;

    @FXML
    private JFXTextArea descriptionArea;

    @FXML
    private TableView<Product> tableProduits;

    @FXML
    private TableColumn<Product, String> nomTable;

    @FXML
    private TableColumn<Product, String> prixTable;
    ObservableList<Product> plats = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Categorie, String> categorieTable;
    Product platSelected = null;

    @FXML
    protected void locateFile(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("choisir une image ...");
        
        ExtensionFilter x = new ExtensionFilter("png", "png,jpg,jpeg");
        chooser.setSelectedExtensionFilter(x);
        Node node = (Node) event.getSource();
        chooser.showOpenDialog(node.getScene().getWindow());
    }

    @FXML
    void ajouter(ActionEvent event) {
        String c1 = nomPlat.getText();
        String c2 = prixPlat.getText();
        Categorie c3 = categoriePlat.getSelectionModel().getSelectedItem();

//        plats.add(new Product(c1, c2, c3));
        tableProduits.getItems().clear();
        tableProduits.getItems().setAll(plats());
        nomPlat.setText("");
        prixPlat.setText("");
        categoriePlat.getSelectionModel().clearSelection();

    }

    @FXML
    void deconnecter(ActionEvent event) {
    	stageManager.switchScene(FxmlView.USER);
    }

    @FXML
    void supprimer(ActionEvent event) {
        if (platSelected != null) {
            Alert l = new Alert(Alert.AlertType.WARNING);
            l.setContentText("Voulez-Vous vraiment supprimer ce plat ?");

            l.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    plats.remove(platSelected);
                    tableProduits.getItems().remove(platSelected);
                }
            });

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomTable.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prixTable.setCellValueFactory(new PropertyValueFactory<>("price"));
        categorieTable.setCellValueFactory(new PropertyValueFactory<>("categorie"));

        tableProduits.getItems().setAll(plats());

        tableProduits.setOnMousePressed((MouseEvent event) -> {
            platSelected = tableProduits.getSelectionModel().getSelectedItem();
        });
        categoriePlat.setConverter(new StringConverter<Categorie>() {
            @Override
            public String toString(Categorie object) {
                return object.getLibelle();
            }

            @Override
            public Categorie fromString(String string) {
                return null;
            }

        });
//        categoriePlat.setItems(FXCollections.observableArrayList(
//                new Categorie("Entree"),
//                new Categorie("Plat Principale"),
//                new Categorie("Drink")));
    }

    private ObservableList<Product> plats() {
//employes.add(new Employee("12-24", "Mohmmad", "moulL-7anouta"));
        return plats;
    }
}
