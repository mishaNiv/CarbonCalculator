/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carboncalculator;

import java.util.ArrayList;

/**
 *
 * @author mnivota
 */
public class FlightTrip extends Trip {
    
//    ArrayList<String> airports = new ArrayList<>();
//    int[] distances = new int[7];
    
    private static final ArrayList<FlightDistance> distances = initializeDistances();

    private final String startAirport;
    private final String endAirport;

    public FlightTrip(Plane p, boolean round, String start, String end) {
        super(p, round);
        startAirport = start;
        endAirport = end;
        setMiles();
    }

    //TODO: actually code this thing
    @Override
    public double getCarbon() {
        return miles * vehicle.getCarbonPM();
    }

    private void setMiles() {
        //searching for the selected flight plan in distances
        for (int i = 0; i < distances.size(); i++) {
            if (distances.get(i).getStart().equals(startAirport) && 
                    distances.get(i).getEnd().equals(endAirport)) {
                if (roundTrip) {
                    //if the trip is a roundtrip, double the footprint
                    this.miles = distances.get(i).getMiles() *2;
                }
                else {
                    //else don't
                    this.miles = distances.get(i).getMiles();
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return this.vehicle + ", miles: " + miles + ", from: " + startAirport + 
                ", to: " + endAirport + ", round trip: " + roundTrip;
    }

    /*initializing the ArrayList of flight distances to use for the options and
        drop down menu */
    public static ArrayList<FlightDistance> initializeDistances() {
        ArrayList<FlightDistance> dist = new ArrayList<>();
        dist.add(new FlightDistance("Seattle", "Dubai", 7425));
        dist.add(new FlightDistance("Seattle", "New York", 2421));
        dist.add(new FlightDistance("Seattle", "Hyderabad", 7786));
        dist.add(new FlightDistance("Seattle", "Los Angeles", 945));
        dist.add(new FlightDistance("Seattle", "Miami", 2729));
        dist.add(new FlightDistance("Denver", "Miami", 1726));
        dist.add(new FlightDistance("London", "New York", 3471));
        
        return dist;
    }
}
