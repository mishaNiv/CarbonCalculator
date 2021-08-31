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
public class Vehicle {
    protected String vType;
    protected double carbonPerMi;
    
    public Vehicle(String type, double carbonPM) {
        vType = type;
        carbonPerMi = carbonPM;
    }
    
    public double getCarbonPM() {
        return carbonPerMi;
    }
    
    public String getType() {
        return vType;
    }
    
    @Override
    public String toString() {
        return vType + ", carbon emitted per mile: " + carbonPerMi;
    }
}
