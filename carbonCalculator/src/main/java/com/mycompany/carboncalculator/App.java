package com.mycompany.carboncalculator;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
 * JavaFX App
 */
public class App extends Application {

//    private static final ArrayList<Plane> planes = new ArrayList<Plane>();

    @Override
    public void start(Stage stage) {

        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        //creating the opening scene
        Label title = new Label("Select a type of trip to calculate the carbon "
                + "footprint of.");

        Button car = new Button("Car");
        Button flight = new Button("Flight");

        //button brings you to car calculator scene
        car.setOnAction(actionEvent -> {
            CarTripCalculator.calculator(stage);
        });
        
        //button brings you to flight calculator scene
        flight.setOnAction(actionEvent -> {
            FlightTripCalculator.calculator(stage);
        });

        //setting up the scene
        HBox h = new HBox(car, flight);
        h.setSpacing(10);
        
        VBox v = new VBox(title, h);
        v.setSpacing(10);
        
        Scene scene = new Scene(new StackPane(v), 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
