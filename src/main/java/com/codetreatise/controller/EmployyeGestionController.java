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

import com.codetreatise.bean.Categorie;
import com.codetreatise.bean.Commande;
import com.codetreatise.bean.Role;
import com.codetreatise.bean.User;
import com.codetreatise.config.StageManager;
import com.codetreatise.repository.RoleDao;
import com.codetreatise.repository.UserRepository;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author dell
 */
@Controller
public class EmployyeGestionController implements Initializable {
	@Lazy
    @Autowired	
    private StageManager stageManager;

    @FXML
    private JFXTextField nomPrenom;
@Autowired
private UserRepository userRepo;

    @FXML
    private TableView<User> tableEmployes;

    @FXML
    private TableColumn<User, String> fonctionTable;

    @FXML
    private TableColumn<User, String> cne;

    @FXML
    private TableColumn<User, String> nomTable;

    @FXML
    private TableColumn<User, String> prenomTable;
    @FXML
    private JFXComboBox<Role> fonctionComboBox;
    
    ObservableList<User> employes = FXCollections.observableArrayList();

    @Autowired
    private RoleDao roleDao ;
    
    @FXML
    void enregitrer(ActionEvent e) {

        String c2 = nomPrenom.getText();
//        String 
//        String c3 = fonction.getText();
        Role c4 = fonctionComboBox.getSelectionModel().getSelectedItem();

        if ( c2 == null) {
            Alert l = new Alert(Alert.AlertType.WARNING);
            l.setContentText("Veuillez Entrez d abord tous les informations !!");
            l.setTitle("Ouuups !!!");
            l.showAndWait();

        } else {
//        	User userNew = new User(c, c1, c2, c3);
//			roleDao.save(userNew);
//            employes.add(new Employee( c2, c3));
            tableEmployes.getItems().clear();
            tableEmployes.getItems().setAll(employes());

            nomPrenom.setText("");
//            fonction.setText("");

        }

    }
    User employeeSelected = null;



    @FXML
    void delete(ActionEvent event) {
        if (employeeSelected != null) {
            Alert l = new Alert(Alert.AlertType.WARNING);
            l.setContentText("Voulez-Vous vraiment supprimer cet employe ?");

            l.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    employes.remove(employeeSelected);
                    tableEmployes.getItems().remove(employeeSelected);
                }
            });

        }
    }

    @FXML
    void deconnecter(ActionEvent event) {
    	stageManager.switchScene(FxmlView.USER);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO


        cne.setCellValueFactory(new PropertyValueFactory<>("cne"));
        nomTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        prenomTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        fonctionTable.setCellValueFactory(new PropertyValueFactory<>("role"));
        tableEmployes.getItems().setAll(userRepo.findAll());

        tableEmployes.setOnMousePressed((MouseEvent event) -> {
            employeeSelected = tableEmployes.getSelectionModel().getSelectedItem();
        });
        fonctionComboBox.setConverter(new StringConverter<Role>() {

			@Override
			public Role fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String toString(Role object) {
				// TODO Auto-generated method stub
				return object.getLibelle();
			}
		});
        fonctionComboBox.setItems(FXCollections.observableArrayList(
               roleDao.findAll()));
    }

    private ObservableList<User> employes() {
//employes.add(new Employee("12-24", "Mohmmad", "moulL-7anouta"));
        return employes;
    }

//    int generateEmployeeID() {
//        int a = 1;
//   
//        for (Employee o : employes) {
//            if (Integer.parseInt(o.getiD())  >= a) {
//                a = Integer.parseInt(o.getiD())  + 1;
//            }
//        }
//
//        return a;
//    }
}
