/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;

import static com.mycompany.cinema.FXMLMovieController.moviePicked;
import com.mysql.jdbc.StringUtils;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public static String theater1String, theater2String, theater3String, theater4String, theater5String, theater6String;
    public static String showID1String, showID2String, showID3String, showID4String, showID5String, showID6String;
    public static String showIDPicked;
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
        showIDPicked = showID1String;
    }

    @FXML
    private void timeTwo(ActionEvent event) throws Exception {
        timePicked = time2String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");
        showIDPicked = showID2String;
    }

    @FXML
    private void timeThree(ActionEvent event) throws Exception {
        timePicked = time3String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");
        showIDPicked = showID3String;
    }

    @FXML
    private void timeFour(ActionEvent event) throws Exception {
        timePicked = time4String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");
        showIDPicked = showID4String;
    }

    @FXML
    private void timeFive(ActionEvent event) throws Exception {
        timePicked = time5String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");
        showIDPicked = showID5String;
    }

    @FXML
    private void timeSix(ActionEvent event) throws Exception {
        timePicked = time6String;//set Time
        mainApp.initialLayout("/fxml/Ticket.fxml");
        showIDPicked = showID6String;
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
 //getter method for showID of show picked
    public String getshowIDString() {
        String showID = showIDPicked;

        return showID;//return the day that the user picked
    }
    
    @Override

    public void initialize(URL url, ResourceBundle rb) {

        //Populate lables
        datePicked.setText(date.getTitleDate());
        moviePicked.setText(getMovie());
        //Clean Button text in case back option was exercised
        cleanTimeButtons();
        //Read Database to get showtimes/theater and ShowID 
        databaseSourceTimeGarrett();//Load data from server
        //Populate the buttons
        setTimeTitles();

    }

    public void setTimeTitles() {
        if (!time1String.isEmpty() && time1String != null) {
            time1.setVisible(true);
            time1.setText("theater: " + theater1String + " " + time1String);
        } else {
            time1.setVisible(false);
        }

        if (!time2String.isEmpty() && time2String != null) {
            time2.setVisible(true);
            time2.setText("theater: " + theater2String + " " + time2String);
        } else {
            time2.setVisible(false);
        }
        if (!time3String.isEmpty() && time3String != null) {
            time3.setVisible(true);
            time3.setText("theater: " + theater3String + " " + time3String);
        } else {
            time3.setVisible(false);
        }

        if (!time4String.isEmpty() && time4String != null) {
            time4.setVisible(true);
            time4.setText("theater: " + theater4String + " " + time4String);
        } else {
            time4.setVisible(false);
        }

        if (!time5String.isEmpty() && time5String != null) {
            time5.setVisible(true);
            time5.setText("theater: " + theater5String + " " + time5String);
        } else {
            time5.setVisible(false);
        }

        if (!time6String.isEmpty() && time6String != null) {
            time6.setVisible(true);
            time6.setText("theater: " + theater6String + " " + time6String);
        } else {
            time6.setVisible(false);
        }
    }

    //Retrieving times Data from the database
    //Based on the previously selected Date and Movie
    //Need to also get theater as the same show could be 
    //showing in theater 1 and 2 at the same time
    public void databaseSourceTimeGarrett() {
        int count = 0;
        String showTime;
        String theater;
        String showID;
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

            SQLTORUN = "SELECT SHOW_TIME_ONLY, SHOW_ID, THEATER  FROM MOVIES,SHOWS WHERE MOVIE_ID = SHOW_MOVIE_ID AND SHOW_DATE_ONLY = ";//sq; statement with all but date
            SQLTORUN = SQLTORUN + "'" + getDate() + "'" + "  AND MOVIE_TITLE = " + "'" + movie.getMovieString() + "';"; // need to get the date selected in the DateController in dd mm yyyy format into this statement  help!!!!
            System.out.println(SQLTORUN);

            ResultSet rs = stmt.executeQuery(SQLTORUN);//compile and execute statements
            //setting the button texts with movies as it scans the database;
            while (rs.next()) {
                count += 1;
                showTime = rs.getString(1);  // SHOW_TIME_ONLY from DB
                System.out.println(showTime);
                showID = rs.getString(2);  // SHOW_ID from DB
                theater = rs.getString(3);  // THEATER from DB
                //setting text to buttons and movie texts
                if (count == 1) {
                    //set Varialble
                    time1String = showTime;
                    theater1String = theater;
                    showID1String = showID;
                } else if (count == 2) {
                    //set Varialble
                    time2String = showTime;
                    theater2String = theater;
                    showID2String = showID;
                } else if (count == 3) {
                    //set Varialble
                    time3String = showTime;
                    theater3String = theater;
                    showID3String = showID;
                } else if (count == 4) {
                    //set Varialble
                    time4String = showTime;
                    theater4String = theater;
                    showID4String = showID;
                } else if (count == 5) {
                    //set Varialble
                    time5String = showTime;
                    theater5String = theater;
                    showID5String = showID;
                } else if (count == 6) {
                    //set Varialble
                    time6String = showTime;
                    theater6String = theater;
                    showID6String = showID;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void cleanTimeButtons() {
        time1String = "";
        time2String = "";
        time3String = "";
        time4String = "";
        time5String = "";
        time6String = "";
    }
}
