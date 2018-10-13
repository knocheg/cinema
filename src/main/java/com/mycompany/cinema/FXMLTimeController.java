/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author rgonz
 */
public class FXMLTimeController implements Initializable {

    MainApp mainApp = new MainApp();//LOAD
    FXMLDateController date = new FXMLDateController();//get DATE
    FXMLMovieController movie = new FXMLMovieController();//get MOVIE

    //Buttons
    @FXML
    public Button time1, time2, time3, time4, time5, time6;
    public static String time1String, time2String, time3String, time4String, time5String, time6String, timePicked;
    //TITLES
    public Label moviePicked = new Label();
    public Label datePicked = new Label();

    @FXML
    private void startAction(ActionEvent event) throws Exception {

        mainApp.initialLayout("/fxml/Scene.fxml");

    }

    @FXML
    private void goBack(ActionEvent event) throws Exception {

        mainApp.initialLayout("/fxml/Movie.fxml");

    }

    @FXML
    private void timeOne(ActionEvent event) throws Exception {
        timePicked = time1String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");

    }

    @FXML
    private void timeTwo(ActionEvent event) throws Exception {
        timePicked = time2String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");

    }

    @FXML
    private void timeThree(ActionEvent event) throws Exception {
        timePicked = time3String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");

    }

    @FXML
    private void timeFour(ActionEvent event) throws Exception {
        timePicked = time4String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");

    }

    @FXML
    private void timeFive(ActionEvent event) throws Exception {
        timePicked = time5String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");

    }

    @FXML
    private void timeSix(ActionEvent event) throws Exception {
        timePicked = time6String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");

    }

    //getters--------------================+++++++++++++++++++
    public String getDate() {
        //getDate that the customer picked   
        return date.getDateString();
    }

    //getter method for day picked
    public String getMovie() {
        //getMoviePicked the customer
        return movie.getMovieString();//return the day that the user picked
    }

    // get time picked
    public String getTimeString() {
        String time = timePicked;
        return time;
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {

        datePicked.setText(date.getTitleDate());
        moviePicked.setText(getMovie());
        setTimeTitles();

    }

    public void setTimeTitles() {

        time1String = "7:30PM";
        time1.setText(time1String);
        time2String = "7:30PM";
        time2.setText(time2String);
        time3String = "7:30PM";
        time3.setText(time3String);
        time4String = "7:30PM";
        time4.setText(time4String);
        time5String = "7:30PM";
        time5.setText(time5String);
        time6String = "7:30PM";
        time6.setText(time6String);

    }

}
