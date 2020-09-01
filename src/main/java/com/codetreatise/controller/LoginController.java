/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codetreatise.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.bean.Product;
import com.codetreatise.bean.User;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.ProduitService;
import com.codetreatise.service.UserService;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 *
 * @author dell
 */
@Controller
public class LoginController implements Initializable {
	@Autowired
	private ProduitService produitService;

	public LoginController() {
	}

	@FXML
	public void some() {
		Product p = produitService.findByNom("Partie 2");
		title.setText(p.getPrice() + " espace " + p.getNom());
	}

	@FXML
	private JFXTextField username;

	@FXML
	private JFXPasswordField password;
	@Autowired
	private UserService userService;
	@FXML
	private JFXButton login;
	@FXML
	private Label title;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@FXML
	private void initialize(ActionEvent event) {

		String user = username.getText();
		String pass = password.getText();
		User userselected = userService.findByEmail(user);
if(userService.authenticate(userselected.getEmail(), pass)) {
	if (userselected.getRole().equalsIgnoreCase("Serveur")) {
			stageManager.switchScene(FxmlView.Serveur);
		} else if (userselected.getRole().equalsIgnoreCase("Admin")) {
			stageManager.switchScene(FxmlView.USER);
		} else if (userselected.getRole().equalsIgnoreCase("Comptable")) {      
			stageManager.switchScene(FxmlView.Comptable);
		}
}
		 else {
//			some();
			Alert l = new Alert(Alert.AlertType.ERROR);
			l.setContentText("Wa si mohamed rakk ghi tat5rrb9 asMeyttk -> " + user);
			l.setHeaderText("Chi 7ajja Wsf ");
			l.setTitle("Erreur de Login");
			l.showAndWait();
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	public JFXTextField getUsername() {
		return username;
	}

	public void setUsername(JFXTextField username) {
		this.username = username;
	}

	public JFXPasswordField getPassword() {
		return password;
	}

	public void setPassword(JFXPasswordField password) {
		this.password = password;
	}

	public JFXButton getLogin() {
		return login;
	}

	public void setLogin(JFXButton login) {
		this.login = login;
	}

}
