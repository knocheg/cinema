/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;


import java.net.URL;
import java.sql.*;
import java.text.*;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @authorrgonz
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
        setVisible();

    }

    public void setVisible() {
        
          //Set movie 1
        if (movie1String != null && !movie1String.isEmpty()) {
            //if not do this
            movie1.setText(movie1String);
        } else {
            //if empty make disappear
            movie1.setVisible(false);
        }
          //Set movie 2
        if (movie2String != null && !movie2String.isEmpty()) {
            //if not do this
            movie2.setText(movie2String);
        } else {
            //if empty make disappear
            movie2.setVisible(false);
        }
        //Set movie 3
        if (movie3String != null && !movie3String.isEmpty()) {
            //if not do this
            movie3.setText(movie3String);
        } else {
            //if empty make disappear
            movie3.setVisible(false);
        }
           //Set movie 4
        if (movie4String != null && !movie4String.isEmpty()) {
            //if not do this
            movie4.setText(movie4String);
        } else {
            //if empty make disappear
            movie4.setVisible(false);
        }
           //Set movie 5
        if (movie5String != null && !movie5String.isEmpty()) {
            //if not do this
            movie5.setText(movie5String);
        } else {
            //if empty make disappear
            movie5.setVisible(false);
        }
           //Set movie 6
        if (movie6String != null && !movie6String.isEmpty()) {
            //if not do this
            movie6.setText(movie6String);
        } else {
            //if empty make disappear
            movie6.setVisible(false);
        }
           //Set movie 7
        if (movie7String != null && !movie7String.isEmpty()) {
            //if not do this
            movie7.setText(movie7String);
        } else {
            //if empty make disappear
            movie7.setVisible(false);
        }
           //Set movie 8
        if (movie8String != null && !movie8String.isEmpty()) {
            //if not do this
            movie8.setText(movie8String);
        } else {
            //if empty make disappear
            movie8.setVisible(false);
        }
           //Set movie 9
        if (movie9String != null && !movie9String.isEmpty()) {
            //if not do this
            movie9.setText(movie9String);
        } else {
            //if empty make disappear
            movie9.setVisible(false);
        }
        
       
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
                    //set Varialble
                   movie1String = movieTitle;
                } else if (count == 2) {
                    //set Varialble
                    movie2String = movieTitle;
                } else if (count == 3) {
                    //set Varialble
                    movie3String = movieTitle;
                } else if (count == 4) {
                    //set Varialble
                    movie4String = movieTitle;
                } else if (count == 5) {
                   //set Varialble
                    movie5String = movieTitle;
                } else if (count == 6) {
                    //set Varialble
                    movie6String = movieTitle;
                } else if (count == 7) {
                    //set Varialble
                    movie7String = movieTitle;
                } else if (count == 8) {
                    //set Varialble
                    movie8String = movieTitle;
                } else if (count == 9) {
                    //set Varialble
                    movie9String = movieTitle;

                }

            }
           
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
