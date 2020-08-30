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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Controller
public class AdminSideController implements Initializable {
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

    void setParentController(LoginController documentController) {
        this.documentController = documentController;
    }

    @FXML
    private JFXButton addUpdatePlat;

    @FXML
    private JFXButton addUpdateStaffs;

    @FXML
    private JFXButton deletePlat;

    @FXML
    private JFXButton exitButton;
    @FXML
    void employees(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EmployyeGestionController.class.getResource("../view/Employee-Gestion.fxml"));
            Parent root;
            root = (Parent) loader.load();

            Stage stage = new Stage();
                    stage.setResizable(false);

            stage.setScene(new Scene(root));
            Node node = (Node) event.getSource();
            Stage stage1 = (Stage) node.getScene().getWindow();
            stage1.hide();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    void menu(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/Menu3Gestion.fxml"));
            Parent root;
            root = (Parent) loader.load();

            Stage stage = new Stage();
                    stage.setResizable(false);

            stage.setScene(new Scene(root));
            Node node = (Node) event.getSource();
            Stage stage1 = (Stage) node.getScene().getWindow();
            stage1.hide();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void exit(ActionEvent event) {
    	stageManager.switchScene(FxmlView.LOGIN);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
