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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mnivota
 */
public class FlightTripCalculator {
    
    private static final ArrayList<Plane> planes = new ArrayList<Plane>();
    
    public static void calculator(Stage stage) {
        //TODO: add home button to go back to Car/Flight screen
        
        planes.add(new Plane(0.000222222, "Economy"));
        planes.add(new Plane(0.0003555560, "Premium Economy"));
        planes.add(new Plane(0.000645118, "Business"));
        planes.add(new Plane(0.000890236, "First Class"));

        //choose your car options and drop down menu
        Label chooseP = new Label("Choose your class:  ");
        ComboBox planesCB = new ComboBox();
        planes.forEach((p) -> {
            planesCB.getItems().add(p.getPClass());
        });
        HBox planeChoice = new HBox(chooseP, planesCB);

        //select the airports you travelled between
        Label pickAirport = new Label("Please select the airports to travel "
                + "between");
        ComboBox airports = new ComboBox();
        initializeAirportCB(airports);
        
        HBox airportHB = new HBox(pickAirport, airports);
        
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
            calculateFP(result, (String) airports.getValue(), 
                    (String) roundTrip.getValue(), planesCB);            
        });
        
        //setting up the scene
        VBox all = new VBox(planeChoice, airportHB, rTrip, calculate, result);
        all.setSpacing(10);
        Scene scene = new Scene(new StackPane(all), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void initializeAirportCB(ComboBox airports) {
        airports.getItems().add("Seattle - Dubai");
        airports.getItems().add("Seattle - New York");
        airports.getItems().add("Seattle - Hyderabad");
        airports.getItems().add("Seattle - Los Angeles");
        airports.getItems().add("Seattle - Miami");
        airports.getItems().add("Denver - Miami");
        airports.getItems().add("London - New York");
    }
    
    public static void calculateFP(Label result, String startAndEnd,
            String rTrip, ComboBox planesCB) {
        
        String start;
        String end;
        
        if (startAndEnd == null) {
            result.setText("Please select the airports to travel between.");
            return;
        }
        else {
            int firstIndx = startAndEnd.indexOf(" ");
            start = startAndEnd.substring(0, firstIndx);
            
            int secondIndx = startAndEnd.indexOf(" ", firstIndx + 1);
            end = startAndEnd.substring(secondIndx + 1);
        }

        if (rTrip == null) {
            result.setText("Please selected whether or not your trip was a "
                    + "roundtrip.");
            return;
        }

        Plane p = classToPlane(planesCB);
        if (p == null) {
            result.setText("Please select your flight class.");
            return;
        }
        
        //getting the boolean value from roundTrip
        boolean isRoundTrip;
        isRoundTrip = rTrip.equals("Yes");
        
        FlightTrip fTrip = new FlightTrip(p, isRoundTrip, start, end);
        
        result.setText("Your carbon footprint from this flight trip was/will be "
                + fTrip.getCarbon() + " metric tons of CO2 emissions.");
    }
    
    public static Plane classToPlane(ComboBox planesCB) {

        for (int i = 0; i < planes.size(); i++) {
            if (planes.get(i).getPClass().equals(planesCB.getValue())) {
                return planes.get(i);
            }
        }

        return null;
    }
}
