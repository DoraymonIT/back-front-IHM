/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codetreatise.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.bean.Commande;
import com.codetreatise.bean.Product;
import com.codetreatise.config.StageManager;
import com.codetreatise.repository.CommandeDao;
import com.codetreatise.service.ProduitService;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author dell
 */
@Controller
public class ServeurSideController implements Initializable {
	@Lazy
	@Autowired
	private StageManager stageManager;
	@FXML
	TableColumn<Commande, Integer> numCmd;
	@FXML
	TableColumn<Commande, Integer> numTable;
	@FXML
	TableColumn<Commande, String> entree;
	@FXML
	TableColumn<Commande, String> plat;
	@FXML
	TableColumn<Commande, String> drink;
//
//    @FXML
//    private Label what;
	ObservableList<Commande> commandes = FXCollections.observableArrayList();

	@FXML
	private JFXTextField numeroTable;

	@FXML
	private JFXComboBox<Product> comboBoxEntree;

	@FXML
	private JFXComboBox<Product> comboBoxPlat;

	@FXML
	private JFXComboBox<Product> comboBoxDrink;

	@FXML
	private TableView<Commande> tableCommandes;

	@FXML
	private JFXButton save;

	@FXML
	private JFXButton exitButton;

	@Autowired
	private CommandeDao commandeDao;
	
	@FXML
	void deconnecter(ActionEvent event) {
		stageManager.switchScene(FxmlView.LOGIN);

	}

	@Autowired
	private ProduitService produitService;


	@FXML
	void enregitrer(ActionEvent e) {

		int c = Integer.parseInt(numeroTable.getText());
//        System.out.println(numeroTable.getText());
		String c1 = comboBoxEntree.getSelectionModel().getSelectedItem().getNom();
		String c2 = comboBoxPlat.getSelectionModel().getSelectedItem().getNom();
		String c3 = comboBoxDrink.getSelectionModel().getSelectedItem().getNom();
		if (e.getSource() == save) {
			if (numeroTable.getText() == null) {
				Alert l = new Alert(Alert.AlertType.WARNING);
				l.setContentText("Veuillez Entrez d abord un numero de table SVP !!");
				l.setTitle("Ouuups !!!");
				l.showAndWait();
			} else {
				Commande saveCommande = new Commande(c, c1, c2, c3);
				commandeDao.save(saveCommande);
				tableCommandes.getItems().setAll(commandeDao.findAll());
//				commandes = (ObservableList<Commande>) commandeDao.findAll();
//				commandes.add(new Commande(generateProductsID(), c, c1, c2, c3));
				
//				tableCommandes.getItems().clear();
//				tableCommandes.getItems().setAll(products());
				comboBoxEntree.getSelectionModel().clearSelection();
				comboBoxPlat.getSelectionModel().clearSelection();
				comboBoxDrink.getSelectionModel().clearSelection();
				numeroTable.setText("");

			}

		}
	}

	void setParentController(LoginController documentController) {
	}
// @FXML
//    private void initialize() {
//               what.setText(documentController.getUsername().toString());
//    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		/*-------------------Entree-------------------- */
//		commandes = (ObservableList<Commande>) commandeService.findAll();
		comboBoxEntree.setConverter(new StringConverter<Product>() {
			@Override
			public String toString(Product object) {
				return object.getNom();
			}

			@Override
			public Product fromString(String string) {
				return null;
			}

		});
		List<Product> entrees = produitService.findByCategorieLibelle("Entree");

        comboBoxEntree.setItems(FXCollections.observableArrayList(
                entrees)
        		);
		/*-------------------Plat principale-------------------- */
		comboBoxPlat.setConverter(new StringConverter<Product>() {
			@Override
			public String toString(Product object) {
				return object.getNom();
			}

			@Override
			public Product fromString(String string) {
				return null;
			}

		});
		List<Product> platsPrinciples = produitService.findByCategorieLibelle("Plat principale");
        comboBoxPlat.setItems(FXCollections.observableArrayList(platsPrinciples));
		/*-------------------Drinks-------------------- */
		comboBoxDrink.setConverter(new StringConverter<Product>() {
			@Override
			public String toString(Product object) {
				return object.getNom();
			}

			@Override
			public Product fromString(String string) {
				return null;
			}

		});
		List<Product> boires = produitService.findByCategorieLibelle("Boire");
        comboBoxDrink.setItems(FXCollections.observableArrayList(
                boires));
		/*--------------Table -----------*/
//        tableCommandes.getItems().setAll((Collection<Product>) commandes());

// Setting table collumn controller variables
		numCmd.setCellValueFactory(new PropertyValueFactory<>("id"));
		numTable.setCellValueFactory(new PropertyValueFactory<>("numTable"));
		entree.setCellValueFactory(new PropertyValueFactory<>("Entree"));
		plat.setCellValueFactory(new PropertyValueFactory<>("Plat"));
		drink.setCellValueFactory(new PropertyValueFactory<>("Boire"));
		tableCommandes.getItems().setAll(commandeDao.findAll());
	}

	private ObservableList<Commande> products() {
//		loadCommndes();
		return commandes;
	}
private void loadCommndes() {
	commandes = (ObservableList<Commande>) commandeDao.findAll();
	
}
	

}
