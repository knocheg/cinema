/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;

import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.util.*;

/**
 *
 * @author rgonz
 */
public class FXMLDateController implements Initializable {

    //Buttons 
    //@FXML
    public Button todayButton, topCenterButton, topRightButton, bottomLeftButton, bottomCenterButton, bottomRightButton;
    public static String todayString, topCenterString, topRightString, bottomLeftString, bottomCenterString, bottomRightString, dayPicked;
    //public String dayPicked;
    //Set Today's Date

    //Class Communication
    MainApp mainApp = new MainApp();

    //Action Buttons
    @FXML
    private void startAction(ActionEvent event) throws Exception {

        mainApp.initialLayout("/fxml/Scene.fxml");

    }

    //TodayButton
    @FXML
    private void todayButton(ActionEvent event) throws Exception {
        dayPicked = todayString; //get day that they picked must do for all buttons
        System.out.println(dayPicked);
        mainApp.viewMovieScene();//go to movie Scene
    }

    //topCenterButton
    @FXML
    private void topCenterButton(ActionEvent event) throws Exception {
        dayPicked = topCenterString; //get day that they picked must do for all buttons
        System.out.println(dayPicked);
        mainApp.viewMovieScene();//go to movie Scene
    }

    //topRightButton
    @FXML
    private void topRightButton(ActionEvent event) throws Exception {
        dayPicked = topRightString; //get day that they picked must do for all buttons
        mainApp.viewMovieScene();//go to movie Scene
    }

    //bottomLeftButton
    @FXML
    private void bottomLeftButton(ActionEvent event) throws Exception {
        dayPicked = bottomLeftString; //get day that they picked must do for all buttons
        mainApp.viewMovieScene();//go to movie Scene
    }

    //bottomCenterButton
    @FXML
    private void bottomCenterButton(ActionEvent event) throws Exception {
        dayPicked = bottomCenterString; //get day that they picked must do for all buttons
        mainApp.viewMovieScene();//go to movie Scene
    }

    //bottomRightButton
    @FXML
    private void bottomRightButton(ActionEvent event) throws Exception {
        dayPicked = bottomRightString; //get day that they picked must do for all buttons
        mainApp.viewMovieScene();//go to movie Scene
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        //set Titles
        setDateTitles();// get dates

    }
    //use if neccessary ==========++++++++++++++++++

    public void buttonListener() {
        //need additional buttons

        //Listening to button
        todayButton.setOnAction(new EventHandler<ActionEvent>() {
            //If buttom press... to the following.. handle()
            @Override
            public void handle(ActionEvent e) {
                try {
                    //if pressed do this...
                    dayPicked = todayString; //get day that they picked
                    System.out.println(getDateString());
                    mainApp.viewMovieScene();//go to movie Scene
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

    }

    //setting the titles of the buttons
    public void setDateTitles() {
        DateFormat df = new SimpleDateFormat("dd MM yyyy");

        Calendar todayDate = Calendar.getInstance();

        todayString = df.format(todayDate.getTime());

        //Date Button Titles
        todayButton.setText(todayString);
        //next
        todayDate.add(Calendar.DAY_OF_MONTH, 1);
        topCenterButton.setText(df.format(todayDate.getTime()));
        topCenterString = df.format(todayDate.getTime());
        //next
        todayDate.add(Calendar.DAY_OF_MONTH, 1);
        topRightButton.setText(df.format(todayDate.getTime()));
        topRightString = df.format(todayDate.getTime());
        //next
        todayDate.add(Calendar.DAY_OF_MONTH, 1);
        bottomLeftButton.setText(df.format(todayDate.getTime()));
        bottomLeftString = df.format(todayDate.getTime());
        //next
        todayDate.add(Calendar.DAY_OF_MONTH, 1);
        bottomCenterButton.setText(df.format(todayDate.getTime()));
        bottomCenterString = df.format(todayDate.getTime());
        //next
        todayDate.add(Calendar.DAY_OF_MONTH, 1);
        bottomRightButton.setText(df.format(todayDate.getTime()));
        bottomRightString = df.format(todayDate.getTime());
    }

    //getter method for day picked
    public String getDateString() {
        String date = dayPicked;
        return date;//return the day that the user picked
    }

}
