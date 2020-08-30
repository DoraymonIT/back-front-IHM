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

import com.codetreatise.bean.Employee;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class EmployyeGestionController implements Initializable {

    @FXML
    private JFXTextField fonction;

    @FXML
    private JFXTextField nomPrenom;



    @FXML
    private TableView<Employee> tableEmployes;


    @FXML
    private TableColumn<Employee, String> nomPrenomTable;

    @FXML
    private TableColumn<Employee, String> fonctionTable;

    ObservableList<Employee> employes = FXCollections.observableArrayList();

    @FXML
    void enregitrer(ActionEvent e) {

        String c2 = nomPrenom.getText();
        String c3 = fonction.getText();

        if ( c2 == null || c3 == null) {
            Alert l = new Alert(Alert.AlertType.WARNING);
            l.setContentText("Veuillez Entrez d abord tous les informations !!");
            l.setTitle("Ouuups !!!");
            l.showAndWait();

        } else {
            employes.add(new Employee( c2, c3));
            tableEmployes.getItems().clear();
            tableEmployes.getItems().setAll(employes());

            nomPrenom.setText("");
            fonction.setText("");

        }

    }
    Employee employeeSelected = null;



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
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminSideController.class.getResource("../view/Admin-side.fxml"));
            Parent root;
            root = (Parent) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Home");
            stage.setScene(new Scene(root));
                    stage.setResizable(false);

            Node node = (Node) event.getSource();
            Stage stage1 = (Stage) node.getScene().getWindow();
            stage1.hide();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminSideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO


        nomPrenomTable.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        fonctionTable.setCellValueFactory(new PropertyValueFactory<>("fonction"));

        tableEmployes.getItems().setAll(employes());

        tableEmployes.setOnMousePressed((MouseEvent event) -> {
            employeeSelected = tableEmployes.getSelectionModel().getSelectedItem();
        });
    }

    private ObservableList<Employee> employes() {
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
