/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carboncalculator;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mnivota
 */
public class CarTripCalculator {
    
    //arraylist of cars that will be used for the drop-down menu for the models
    private static final ArrayList<Car> cars = new ArrayList<Car>();
    
    public static void calculator(Stage stage) {

        //initializing cars with different models + their carbon-per-mile values
        cars.add(new Car(0.00029, "Lexus RX 300")); //30 miles per gallon
        cars.add(new Car(0.0000878, "Tesla Model X")); //100 miles per "gallon"
        cars.add(new Car(0.000828, "Hummer XL")); //10 miles per gallon
        cars.add(new Car(0.0001656, "Toyota Prius")); //50 miles per gallon

        //choose your car options and drop down menu
        Label chooseV = new Label("Choose your car and model:  ");
        ComboBox carCB = new ComboBox();
        cars.forEach((c) -> {
            carCB.getItems().add(c.getModel());
        });
        HBox carChoice = new HBox(chooseV, carCB);

        //enter in miles travelled text field
        Label milesLabel = new Label("How many miles you travelled:");
        TextField enterMiles = new TextField();
        HBox hb = new HBox(milesLabel, enterMiles);
        hb.setSpacing(10);

        //round trip or not button and matching a boolean with result
        Label round = new Label("Was your trip a round trip?  ");
        ComboBox roundTrip = new ComboBox();
        roundTrip.getItems().add("Yes");
        roundTrip.getItems().add("No");

        HBox rTrip = new HBox(round, roundTrip);

        //calculating carbon footprint button and actual calculation
        Button calculate = new Button("Calculate your carbon footprint");
        Label result = new Label();

        calculate.setOnAction(actionEvent -> {
            calculateFP(result, (String) enterMiles.getText(),
                    (String) roundTrip.getValue(),
                    cars, carCB);
        });

        //setting up the scene
        VBox all = new VBox(carChoice, hb, rTrip, calculate, result);
        all.setSpacing(10);
        Scene scene = new Scene(new StackPane(all), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void calculateFP(Label result, String sMiles, String rTrip,
            ArrayList<Car> cars, ComboBox carCB) {

        //making sure they entered miles
        if (sMiles == null) {
            result.setText("Please enter the number of miles travelled without "
                    + "any letters.");
            return;
        }

        //making sure they selected yes or no for roundtrip
        if (rTrip == null) {
            result.setText("Please selected whether or not your trip was a "
                    + "roundtrip.");
            return;
        }

        //making sure they picked a car model
        Car car = modelToCar(carCB);
        if (car == null) {
            result.setText("Please select your car model.");
            return;
        }

        //TODO: Make sure sMiles is a number
        //getting the entered miles from the sMiles
        double miles;
        try {
            Double.parseDouble(sMiles);
            miles = Double.parseDouble(sMiles);
        }
        catch (Exception e) {
            result.setText("Please enter the number of miles travelled without "
                    + "any letters.");
            return;
        }

        //getting the boolean value from roundTrip
        boolean isRoundTrip;
        isRoundTrip = rTrip.equals("Yes");

        //creating a car trip with the given values
        CarTrip cTrip = new CarTrip(car, isRoundTrip, miles);

        //adding the carbon footprint to the result Label
        result.setText("Your carbon footprint from this car trip was/will be "
                + cTrip.getCarbon() + " metric tons of CO2 emissions.");
    }

    public static Car modelToCar(ComboBox carCB) {

        //getting the car from the selected model from the ComboBox
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getModel().equals(carCB.getValue())) {
                return cars.get(i);
            }
        }

        return null;
    }
}
