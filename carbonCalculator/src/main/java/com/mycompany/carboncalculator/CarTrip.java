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
public class CarTrip extends Trip {
    
    public CarTrip(Car c, boolean round, double miles) {
        super(c, round);
        setMiles(miles);
    }
    
    @Override
    public double getCarbon() {
        if (roundTrip) { //if it is a roundtrip
            return vehicle.getCarbonPM() * miles * 2; //double the footprint
        }
        else {
            return vehicle.getCarbonPM() * miles;
        }
    }

    @Override
    public String toString() {
        return this.vehicle + ", miles: " + miles + ", round trip: " + 
                roundTrip;
    }
}
