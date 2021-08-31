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
public class Plane extends Vehicle {
    
    private final String pClass;
    
    public Plane(double carbonPM, String pClass) {
        super("Plane", carbonPM);
        this.pClass = pClass;
    }
    
        @Override
    public String toString() {
        return vType + ", carbon emitted per mile: " + carbonPerMi + ", class: "
                + pClass;
    }
    
    public String getPClass() {
        return pClass;
    }
    
}
