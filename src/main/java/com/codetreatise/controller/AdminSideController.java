package com.codetreatise.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.config.StageManager;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    	stageManager.switchScene(FxmlView.HrMangement);
    }


    @FXML
    void menu(ActionEvent event) {

    	stageManager.switchScene(FxmlView.MenuMangement);
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
