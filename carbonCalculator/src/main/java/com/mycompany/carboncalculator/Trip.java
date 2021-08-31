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
public abstract class Trip {
    protected double miles; //miles travelled
    protected Vehicle vehicle; //vehicle used
    protected boolean roundTrip; //is it a round trip or not
    
    //Constructor
    public Trip(Vehicle v, boolean round) {
        this.vehicle = v;
        roundTrip = round;
    }
    
    //will calculate carbon footprint of trip
    public abstract double getCarbon(); 
    
    protected void setMiles(double mile) {
        this.miles = mile;
    }
}
