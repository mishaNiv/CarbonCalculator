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
public class FlightDistance {
    
    private String startAir;
    private String endAir;
    private double miles;
    
    public FlightDistance(String start, String end, double miles) {
        this.startAir = start;
        this.endAir = end;
        this.miles = miles;
    }
  
    public String getStart() {
        return startAir;
    }
    
    public String getEnd() {
        return endAir;
    }
    
    public double getMiles() {
        return miles;
    }
}
