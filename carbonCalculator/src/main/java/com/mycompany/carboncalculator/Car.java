/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carboncalculator;

/**
 *
 * @author mnivota
 */
public class Car extends Vehicle {
    
    private String model;
    
    public Car(double carbonPM, String model) {
        super("Car", carbonPM);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    
    @Override
    public String toString() {
        return vType + ", carbon emitted per mile: " + carbonPerMi + ", " 
                + "model: " + model;
    }    
}
    

