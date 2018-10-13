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
public class FXMLTicketController implements Initializable {

    //Class Communication
    MainApp mainApp = new MainApp();//LOAD
    FXMLDateController date = new FXMLDateController();//get DATE
    FXMLMovieController movie = new FXMLMovieController();//get MOVIE
    FXMLTimeController time = new FXMLTimeController();// get Time

    //Tittle Labels---------------------------------->//Quantity Labels ----------------------------------->
    public Label ticketMovie, ticketDate, ticketTime, adultNumber, seniorNumber, veteranNumber, childNumber;
    //Price Labels------------------------------------------//Total Price of quantity labels---------------------->//Total
    public Label priceOne, priceTwo, priceThree, priceFour, priceAddOne, priceAddTwo, priceAddThree, priceAddFour, priceTotal;
    //Integers
    public int adult, senior, veteran, child;
    //Price Floats
    public double adultPrice, seniorPrice, veteranPrice, childPrice, adultTotal, seniorTotal, veteranTotal, childTotal, totalPrice;
    public static double total;

    //Action Buttons---------------------------------------------------->
    @FXML
    private void startAction(ActionEvent event) throws Exception {
        mainApp.initialLayout("/fxml/Scene.fxml");
    }

    @FXML
    private void payButton(ActionEvent event) throws Exception {
        total = totalPrice;
        mainApp.initialLayout("/fxml/Payment.fxml");

    }

    //Adult------------------------------------------------------------->
    @FXML
    private void adultAdd(ActionEvent event) throws Exception {
        adult += 1;//adds One
        adultNumber.setText(Integer.toString(adult));//sets Number
        adultTotal = adult * adultPrice;//multiplies by the number
        priceAddOne.setText("$" + Double.toString(adultTotal));//set total
        totalPrice();

    }

    @FXML
    private void adultSub(ActionEvent event) throws Exception {

        adultTotal = adultTotal / adult;//Devides by the number
        priceAddOne.setText(Double.toString(adultTotal));//set total
        adult -= 1;//adds One
        if (adult <= 0) {
            adult = 0;//stays at zero
        }
        adultNumber.setText(Integer.toString(adult));
        adultTotal = adult * adultPrice;//Devides by the number
        priceAddOne.setText("$" + Double.toString(adultTotal));//set total
        totalPrice();
    }

    //Senior------------------------------------------------------------>
    @FXML
    private void seniorAdd(ActionEvent event) throws Exception {
        senior += 1;//adds One
        seniorNumber.setText(Integer.toString(senior));
        seniorTotal = senior * seniorPrice;
        priceAddTwo.setText("$" + Double.toString(seniorTotal));//set total
        totalPrice();
    }

    @FXML
    private void seniorSub(ActionEvent event) throws Exception {
        senior -= 1;//adds One
        if (senior <= 0) {
            senior = 0;//stays at zero
        }
        seniorNumber.setText(Integer.toString(senior));
        seniorTotal = senior * seniorPrice;//Devides by the number
        priceAddTwo.setText("$" + Double.toString(seniorTotal));//set total
        totalPrice();
    }

    //Veteran----------------------------------------------------------->
    @FXML
    private void veteranAdd(ActionEvent event) throws Exception {
        veteran += 1;//adds One
        veteranNumber.setText(Integer.toString(veteran));
        veteranTotal = veteran * veteranPrice;
        priceAddThree.setText("$" + Double.toString(veteranTotal));//set total
        totalPrice();
    }

    @FXML
    private void veteranSub(ActionEvent event) throws Exception {
        veteran -= 1;//adds One
        if (veteran <= 0) {
            veteran = 0;//stays at zero
        }
        veteranNumber.setText(Integer.toString(veteran));
        veteranTotal = veteran * veteranPrice;//Devides by the number
        priceAddThree.setText("$" + Double.toString(veteranTotal));//set total
        totalPrice();
    }

    //Child------------------------------------------------------------->
    @FXML
    private void childAdd(ActionEvent event) throws Exception {
        child += 1;//adds One
        childNumber.setText(Integer.toString(child));
        childTotal = child * childPrice;
        priceAddFour.setText("$" + Double.toString(childTotal));//set total
        totalPrice();
    }

    @FXML
    private void childSub(ActionEvent event) throws Exception {
        child -= 1;//adds One
        if (child <= 0) {
            child = 0;//stays at zero
        }
        childNumber.setText(Integer.toString(child));
        childTotal = child * childPrice;//Devides by the number
        priceAddFour.setText("$" + Double.toString(childTotal));//set total
        totalPrice();
    }

    //INITIALIZE------------------------------------------>
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ticketMovie.setText(getMovie());//set movie title
        ticketDate.setText(date.getTitleDate());//set date title
        ticketTime.setText(getTime());//set time title
        adult = 0;
        senior = 0;
        veteran = 0;
        child = 0;
        setDefaulPrices();

    }

    //Set Prices--------------------------------------------------->
    public void setDefaulPrices() {
        adultPrice = 12.99;
        priceOne.setText("$" + Double.toString(adultPrice));
        seniorPrice = 5.99;
        priceTwo.setText("$" + Double.toString(seniorPrice));
        veteranPrice = 8.99;
        priceThree.setText("$" + Double.toString(veteranPrice));
        childPrice = 5.99;
        priceFour.setText("$" + Double.toString(childPrice));

    }

    //update Total
    public void totalPrice() {
        totalPrice = adultTotal + veteranTotal + seniorTotal + childTotal;
        priceTotal.setText(String.format("$%.2f", totalPrice));

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

    // get total price of tickets
    public String getPriceString() {
        String price = String.format("$%.2f", total);
        return price;
    }

}
