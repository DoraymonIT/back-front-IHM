/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codetreatise.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;

import com.codetreatise.bean.Commande;
import com.codetreatise.bean.Product;
import com.codetreatise.config.StageManager;
import com.codetreatise.repository.CommandeDao;
import com.codetreatise.repository.ProduitDao;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * FXML Controller class
 *
 * @author dell
 */
@Controller
public class ComptableSideController implements Initializable {
	@Lazy
	@Autowired
	private StageManager stageManager;
	private LoginController documentController;

	public LoginController getDocumentController() {
		return documentController;
	}

	public void setDocumentController(LoginController documentController) {
		this.documentController = documentController;
	}

	@FXML
	private TableView<Commande> tableCommandes;

	@FXML
	private TableColumn<Commande, Integer> numCmd;

	@FXML
	private TableColumn<Commande, Integer> numTable;

	@FXML
	private TableColumn<Commande, String> entree;

	@FXML
	private TableColumn<Commande, String> plat;

	@FXML
	private TableColumn<Commande, String> drink;

	@FXML
	private Label date;

	@FXML
	private Label adresse;

	@FXML
	private Label phone;

	@FXML
	private Label entreeDemande;

	@FXML
	private Label platDemande;

	@FXML
	private Label DrinkDemande;

	@FXML
	private Label prixE;

	@FXML
	private Label prixP;

	@FXML
	private Label prixD;

	@FXML
	private Label totalCalculer;

	@FXML
	private JFXButton imprimer;
	@Autowired
	private CommandeDao commandeDao;
	@Autowired
	private ProduitDao produitDao;
	ObservableList<Commande> commandes = FXCollections.observableArrayList();

	private ObservableList<Commande> products() {
//        commandes.addAll(new Commande(1, 12, "Entree1", "Plat1", "Drink1"),
//                new Commande(2, 8, "Entree2", "Plat2", "Drink2"));
		return commandes;
	}

	Commande commandesSelected = null;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		numCmd.setCellValueFactory(new PropertyValueFactory<>("id"));
		numTable.setCellValueFactory(new PropertyValueFactory<>("NumTable"));
		entree.setCellValueFactory(new PropertyValueFactory<>("Entree"));
		plat.setCellValueFactory(new PropertyValueFactory<>("Plat"));
		drink.setCellValueFactory(new PropertyValueFactory<>("Boire"));
		tableCommandes.getItems().addAll(commandeDao.findAll());
		tableCommandes.setOnMousePressed((MouseEvent event) -> {
			commandesSelected = tableCommandes.getSelectionModel().getSelectedItem();
		});

	}

	@FXML
    void detailles(ActionEvent event) {
        if (commandesSelected != null) {
        	Long idSelected = commandesSelected.getId();
        	Commande c = commandeDao.findOne(idSelected);
            Date d = new Date();
            date.setText(d.toString());
            adresse.setText("1030,Rue Marrakech");
            prixE.setText(produitDao.findByNom(c.getEntree()).getPrice()+" DH ") ;
            prixP.setText(produitDao.findByNom(c.getPlat()).getPrice()+" DH ");
            prixD.setText(produitDao.findByNom(c.getBoire()).getPrice()+" DH ");
            
            Double a = Double.parseDouble(produitDao.findByNom(c.getEntree()).getPrice())  +
            		 Double.parseDouble(produitDao.findByNom(c.getPlat()).getPrice()) +
            		 Double.parseDouble(produitDao.findByNom(c.getBoire()).getPrice());
            
            
            totalCalculer.setText(a.toString()+" DH ");
            phone.setText("+212-6-66-66-66");
            entreeDemande.setText(c.getEntree());
            platDemande.setText(c.getPlat());
            DrinkDemande.setText(c.getBoire());
        }
    }

	@FXML
	void deconnecter(ActionEvent event) {
		stageManager.switchScene(FxmlView.LOGIN);

	}

	void setParentController(LoginController aThis) {
		documentController = aThis;
	}
@FXML
public void imprimer() throws FileNotFoundException, JRException {
	exportReport("pdf");
}
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users";
		Commande employees = commandesSelected;
		// load file and compile it
		File file = ResourceUtils.getFile("classpath:produits.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource((Collection<?>) employees);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Bendrimou Ayoub");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\" + "produits" + ".html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\" + "produits" + ".pdf");
		}

		return "report generated in path : " + path;
	}

}
