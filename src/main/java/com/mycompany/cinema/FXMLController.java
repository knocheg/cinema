package com.mycompany.cinema;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;

public class FXMLController implements Initializable {

    //Date Buttons-------------
    public Button todayButton;

    public Button startButton; //Start Button

    MainApp mainApp = new MainApp();

    //Buttons Action Events
    @FXML
    private void startAction(ActionEvent event) throws Exception {

         mainApp.initialLayout("/fxml/Scene.fxml");

    }

    @FXML
    private void goDate(ActionEvent event) throws Exception {

        mainApp.initialLayout("/fxml/Date.fxml");
    }
    
    
    //This buttons need to remove

    @FXML
    private void goThank(ActionEvent event) throws Exception {

    }

    @FXML
    private void goMovie(ActionEvent event) throws Exception {

    }

    @FXML
    private void goTicket(ActionEvent event) throws Exception {

    }

    @FXML
    private void goTime(ActionEvent event) throws Exception {

    }

    @FXML
    private void goPayment(ActionEvent event) throws Exception {

    }

    //Payment Button*******************************************************************************
    @FXML
    protected void paymentButtonAction(ActionEvent event) {

        // Window owner = submitPaymentButton.getScene().getWindow();
        /*
        
        if(nameField.getText().isEmpty()){
            //Alert.showAlert(Alert.AlertType.ERROR,owner, "Form Error");
            
        }
         */
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        //startButton.setText("helloito");
    }

}
