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

import com.codetreatise.config.StageManager;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
@Controller
public class LoginController implements Initializable {

    public LoginController() {
    }

  

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @Lazy
    @Autowired	
    private StageManager stageManager;
    
    @FXML
    private void initialize(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();
        
        if (user.equals("Serveur") && pass.equals("1234")) {
        	stageManager.switchScene(FxmlView.Serveur);
//            try {
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(ServeurSideController.class.getResource("../view/ServerSide.fxml"));
//                Parent root = (Parent) loader.load();
//
//                Stage stage = new Stage();
//                stage.setTitle("Serveur Side | LMAKLA.COM");
//                stage.setScene(new Scene(root));
//        
//
//                Node node = (Node) event.getSource();
//
//                Stage stage1 = (Stage) node.getScene().getWindow();
//                stage1.hide();
//                stage.show();
//
//            } catch (IOException ex) {
//                Logger.getLogger(ServeurSideController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else if (user.equals("Admin") && pass.equals("2468")) {
//            try {
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(AdminSideController.class.getResource("../view/Admin-side.fxml"));
//                Parent root = (Parent) loader.load();
//
//                Stage stage = new Stage();
//                stage.setTitle("Admin Side | LMAKLA.COM");
//                stage.setScene(new Scene(root));
//             stage.setResizable(false);
//
//                Node node = (Node) event.getSource();
//
//                Stage stage1 = (Stage) node.getScene().getWindow();
//                stage1.hide();
//                stage.show();
//
//            } catch (IOException ex) {
//                Logger.getLogger(AdminSideController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        	stageManager.switchScene(FxmlView.USER);
        }else if(user.equals("Comptable") && pass.equals("0369")){
//             try {
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(ComptableSideController.class.getResource("../view/Comptable-side.fxml"));
//                Parent root = (Parent) loader.load();
//
//                Stage stage = new Stage();
//                stage.setTitle("Comptable Side | LMAKLA.COM");
//                stage.setScene(new Scene(root));
//                      stage.setResizable(false);
//
//                Node node = (Node) event.getSource();
//
//                Stage stage1 = (Stage) node.getScene().getWindow();
//                stage1.hide();
//                stage.show();
//
//            } catch (IOException ex) {
//                Logger.getLogger(ComptableSideController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
        	stageManager.switchScene(FxmlView.Comptable);
        } else {
            Alert l = new Alert(Alert.AlertType.ERROR);
            l.setContentText("Wa si mohamed rakk ghi tat5rrb9 asMeyttk -> "+ user);
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
