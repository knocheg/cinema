/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;

import static com.mycompany.cinema.FXMLDateController.dayPicked;
import static com.mycompany.cinema.FXMLDateController.todayString;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author rgonz
 */
public class FXMLMovieController implements Initializable {

    //Buttons 
    @FXML
    public Button backButton, movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9;
    public static String moviePicked, movie1String, movie2String, movie3String, movie4String, movie5String, movie6String, movie7String, movie8String, movie9String;
    //TITLE LABEL
    public Label todayTitle = new Label();

    //Class Communication
    MainApp mainApp = new MainApp();//LOAD
    FXMLDateController date = new FXMLDateController();//get DATE

    //Action Buttons
    @FXML
    private void startAction(ActionEvent event) throws Exception {
        mainApp.initialLayout("/fxml/Scene.fxml");
    }

    @FXML
    private void goBack(ActionEvent event) throws Exception {
        mainApp.initialLayout("/fxml/Date.fxml");
    }

    @FXML
    private void movieOne(ActionEvent event) throws Exception {
        moviePicked = movie1String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieTwo(ActionEvent event) throws Exception {
        moviePicked = movie2String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieThree(ActionEvent event) throws Exception {
        moviePicked = movie3String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieFour(ActionEvent event) throws Exception {
        moviePicked = movie4String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieFive(ActionEvent event) throws Exception {
        moviePicked = movie5String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieSix(ActionEvent event) throws Exception {
        moviePicked = movie6String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieSeven(ActionEvent event) throws Exception {
        moviePicked = movie7String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieEight(ActionEvent event) throws Exception {
        moviePicked = movie8String;
        mainApp.viewTimeScene();//to timeScene
    }

    @FXML
    private void movieNine(ActionEvent event) throws Exception {
        moviePicked = movie9String;
        mainApp.viewTimeScene();//to timeScene
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        //set title
        todayTitle.setText("SHOWING MOVIES FOR : " + getDate()); //set main title for movieScene
        //doad
        databaseSourceGarrett();//Load data from server

    }

    //Retrieving Data from the database
    public void databaseSourceGarrett() {
        int count = 0;
        String movieTitle;
        //Registering the Driver
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Driver Not Registered - Check you mysql-connector file is located under the CLASSPATH OF JDK");
        }
        ///Connecting to the Garrett server -database-
        try {
            //database credentials
            String URL = "jdbc:mysql://group-g.g-knoche.com/CINEMA";
            String USER = "rafael";
            String PASS = "rafaelcmsc495";
            String SQLTORUN = ""; //this is the string we will build the query in            
            //stablish connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement(); //set statements
            SQLTORUN = "SELECT MOVIE_TITLE FROM MOVIES,SHOWS WHERE MOVIE_ID = SHOW_MOVIE_ID AND SHOW_DATE_ONLY = ";//sq; statement with all but date
            SQLTORUN = SQLTORUN + "'" + getDate() + "'" + ";"; // need to get the date selected in the DateController in dd mm yyyy format into this statement  help!!!!
            System.out.println(SQLTORUN);
            ResultSet rs = stmt.executeQuery(SQLTORUN);//compile and execute statements
            //setting the button texts with movies as it scans the database;
            while (rs.next()) {
                count += 1;
                movieTitle = rs.getString("MOVIE_TITLE");
                //setting text to buttons and movie texts
                if (count == 1) {
                    movie1.setText(movieTitle);
                    movie1String = movieTitle;
                } else if (count == 2) {
                    movie2.setText(movieTitle);
                    movie2String = movieTitle;
                } else if (count == 3) {
                    movie3.setText(movieTitle);
                    movie3String = movieTitle;
                } else if (count == 4) {
                    movie4.setText(movieTitle);
                    movie4String = movieTitle;
                } else if (count == 5) {
                    movie5.setText(movieTitle);
                    movie5String = movieTitle;
                } else if (count == 6) {
                    movie6.setText(movieTitle);
                    movie6String = movieTitle;
                } else if (count == 7) {
                    movie7.setText(movieTitle);
                    movie7String = movieTitle;
                } else if (count == 8) {
                    movie8.setText(movieTitle);
                    movie8String = movieTitle;
                } else if (count == 9) {
                    movie9.setText(movieTitle);
                    movie9String = movieTitle;
                }

            }
            System.out.println("count is" + count);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    //get day picked
    public String getDate() {
        //getDate that the customer picked   
        return date.getDateString();
    }

    //getter method for movie picked
    public String getMovieString() {
        String movie = moviePicked;

        return movie;//return the day that the user picked
    }

}
