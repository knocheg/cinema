/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import org.apache.commons.io.FileUtils;
import java.util.Random;

/**
 *
 * @author rgonz
 */
public class FXMLPaymentController implements Initializable {
    //Class Communication

    MainApp mainApp = new MainApp();//LOAD
    FXMLDateController date = new FXMLDateController();//get DATE
    FXMLMovieController movie = new FXMLMovieController();//get MOVIE
    FXMLTimeController time = new FXMLTimeController();// get Time
    FXMLTicketController price = new FXMLTicketController();

    //Labels----------------->
    @FXML
    public Label movieTitle, dateTitle, priceTitle, timeTitle, totalPrice, authorize;
    @FXML
    public TextField nameOnCard, creditCardNumber, expirationDateNumber, cardPin;

    public String nameCard, creditNumber, expirationNumber, cardPinNumber, movieTitles, movieDate, moviePrice, movieTime, credit;

    //Action Buttons---------------------------------------------------->
    @FXML
    private void startAction(ActionEvent event) throws Exception {
        mainApp.initialLayout("/fxml/Scene.fxml");
    }

    @FXML
    private void submitPayment(ActionEvent event) throws Exception {
        //get names from form
        getNames();
        //set names to variables
        setNames();
        //credit card search
        creditCardAuth();

    }

    //INITIALIZE------------------------------------------>
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        movieTitle.setText(getMovie());
        dateTitle.setText(getDate());
        timeTitle.setText(getTime());
        priceTitle.setText(getPrice());

    }

    //getting names from text fields
    public void getNames() {
        //set names
        nameCard = nameOnCard.getText();
        System.out.println(nameCard);
        creditNumber = creditCardNumber.getText();
        expirationNumber = expirationDateNumber.getText();
        cardPinNumber = cardPin.getText();

    }

    //set names for ticket info
    public void setNames() {
        movieTitles = getMovie();
        movieDate = getDate();
        movieTime = getTime();
        moviePrice = getPrice();

    }

    public void creditCardAuth() throws IOException {

        String runSQL = String.format("SELECT * FROM CREDIT_CARD WHERE CC_EXP_DATE = '%s' AND CC_NUMBER = '%s'", expirationNumber, creditNumber);
        System.out.println(expirationNumber);
        System.out.println(creditNumber);
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
            //stablish connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement(); //set statements
            ResultSet rs = stmt.executeQuery(runSQL);//compile and execute statements
            //setting the button texts with movies as it scans the database;
            while (rs.next()) {

                credit = rs.getString("CC_NUMBER");
                System.out.println(credit);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //credit card authorization
        if (Objects.equals(credit, creditNumber)) {

            //print tickets
            printTicket(movieTitles, movieDate, moviePrice, movieTime, getAuNumber(), getOrderNumber(), getTicketNumber(), nameCard);
            //go to final scene
            mainApp.initialLayout("/fxml/Thank.fxml");
            System.out.println("success");

        } else {
            authorize.setText("Credit Card Not Authorized,! Try Again");

            System.out.println("no success");
        }

    }

    //print ticket method
    public void printTicket(String title, String date, String price, String time, String auNumber, String orderNumber, String ticketNumber, String personName) throws IOException {
        //pull layout from template.html
        File htmlTemplateFile = new File("template.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);
        //set fields
        htmlString = htmlString.replace("$title", title);
        htmlString = htmlString.replace("$auNumber", auNumber);
        htmlString = htmlString.replace("$date", date);
        htmlString = htmlString.replace("$time", time);
        htmlString = htmlString.replace("$orderNumber", orderNumber);
        htmlString = htmlString.replace("$ticketNumber", ticketNumber);
        htmlString = htmlString.replace("$price", price);
        htmlString = htmlString.replace("$personName", personName);
        //set path and name for new file
        File newHtmlFile = new File("Ticket.html");
        //write file
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
    }

    //Setting random numbers for identification
    public String getTicketNumber() {
        Random ticketRandom = new Random();
        String getTicketNumber;
        int ticketNumber = ticketRandom.nextInt(1000);
        getTicketNumber = Integer.toString(ticketNumber);
        return "cinema-T " + getTicketNumber;
    }

    public String getOrderNumber() {
        Random oRandom = new Random();
        String getONumber;
        int orderNumber = oRandom.nextInt(10000000);
        getONumber = Integer.toString(orderNumber);
        return "O: " + getONumber;
    }

    public String getAuNumber() {
        Random aRandom = new Random();
        String getANumber;
        int auditoryNumber = aRandom.nextInt(20);
        getANumber = Integer.toString(auditoryNumber);
        return "A- " + getANumber;
    }

    //getters-------------------------->
    public String getDate() {
        //getDate that the customer picked   
        return date.getDateString();
    }

    //getter method for day picked
    public String getMovie() {
        //getMoviePicked the customer
        return movie.getMovieString();//return the day that the user picked
    }

    //get method for time picked
    public String getTime() {
        //get time picked
        return time.getTimeString();
    }

    //get method for total price
    public String getPrice() {
        //get totalPrice
        return price.getPriceString();
    }

}
